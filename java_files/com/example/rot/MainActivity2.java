package com.example.rot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText textInputEditTextUsername, textInputEditTextPassword;
    LottieAnimationView signin_anim;
    ProgressBar potload;
    Button buttonLogin;
    Button goToSplash;
    ProgressBar progressBar;
    CardView signin_card;
    String user_type;
    AutoCompleteTextView signin_userlist;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main2);

        signin_userlist = (AutoCompleteTextView) findViewById(R.id.signin_userlist);


        ArrayList<String> user_options =  new ArrayList<>();
        user_options.add("Customer");
        user_options.add("Store Staff");
        user_type = "Customer";
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.sign_inup, user_options);
        signin_userlist.setText(arrayAdapter.getItem(0).toString(), false);
        signin_userlist.setAdapter(arrayAdapter);
        

        textInputEditTextUsername = (EditText) findViewById(R.id.email_signin);
        textInputEditTextPassword = (EditText) findViewById(R.id.password_signin);
        signin_userlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user_type = (String) parent.getItemAtPosition(position);
                if(user_type.equals("Store Staff")){
                    textInputEditTextPassword.setHint("Store Password");
                    textInputEditTextUsername.setHint("Store Name");
                }
                else{
                    textInputEditTextPassword.setHint("Password");
                    textInputEditTextUsername.setHint("Username");
                }
            }
        });

        potload = (ProgressBar) findViewById(R.id.potload);

        signin_card = (CardView) findViewById(R.id.signin_card);
        signin_card.animate().translationY(-70).setDuration(1500).setStartDelay(0);


        buttonLogin = (Button) findViewById(R.id.buttonLogin);
//        progressBar = (ProgressBar) findViewById(R.id.progress_sign);
        goToSplash = (Button)findViewById(R.id.goToSplash2);

        goToSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Splash.class);
                startActivity(intent);
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username, password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if (!username.equals("") && !password.equals("")) {
                    potload.setVisibility(View.VISIBLE);

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] attributes = new String[2];
                            attributes[0] = "username";
                            attributes[1] = "password";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            
                            PutData putData = null;
                            if(user_type.equals("Customer")){
                                putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/login.php", "POST", attributes, data);
                            }
                            else if(user_type.equals("Store Staff")){
                                putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/stafflogin.php", "POST", attributes, data);
                            }
                               
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    potload.setVisibility(View.INVISIBLE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success") && user_type.equals("Customer")) {
                                        Toast.makeText(getApplicationContext(), "Sign In Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), customer_home.class);
                                        intent.putExtra("username", username);
                                        intent.putExtra("password", password);
                                        startActivity(intent);

                                    }
                                    else if (result.equals("Login Success") && user_type.equals("Store Staff")){
                                        Toast.makeText(getApplicationContext(), "Sign In Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent1 = new Intent(getApplicationContext(), staff_home.class);
                                        intent1.putExtra("res_name", username);
                                        startActivity(intent1);
                                    }
                                    else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                } else Toast.makeText(getApplicationContext(), "All fields are required! ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onBackPressed(){
        startActivity(new Intent(this, Splash.class));
    }



}