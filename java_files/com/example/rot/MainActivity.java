package com.example.rot;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText textInputEditTextFullname, textInputEditTextUsername, textInputEditTextEmail, textInputEditTextPassword;
    Button buttonSignUp;
    Button goTosplash;
    CardView card_up;
    List<String> attributes;
    List<String> data;
    ProgressBar progressBar2;
    LottieAnimationView smiley;
    AutoCompleteTextView signup_userlist;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(getApplicationContext(), customer_home.class);
                startActivity(intent);
                finish();
            }
        };
        //requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);

//        signup_userlist = (AutoCompleteTextView) findViewById(R.id.signup_userlist);
//
//        String [] users_options = {"Customer", "Store Staff"};
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.sign_inup, users_options);
//        signup_userlist.setText(arrayAdapter.getItem(0).toString(), false);
//        signup_userlist.setAdapter(arrayAdapter);


        card_up = (CardView) findViewById(R.id.signup_card);
        goTosplash = (Button) findViewById(R.id.goToSplash);
        textInputEditTextUsername = (EditText) findViewById(R.id.username_signup);
        card_up.animate().translationY(-90).setDuration(1500).setStartDelay(0);
        textInputEditTextFullname = (EditText) findViewById(R.id.fullname_signup);
        textInputEditTextEmail = (EditText) findViewById(R.id.email_signup);
        textInputEditTextPassword = (EditText) findViewById(R.id.password_signup);
        buttonSignUp = (Button) findViewById(R.id.button_signup);
        goTosplash = (Button) findViewById(R.id.goToSplash);
        progressBar2 = (ProgressBar) findViewById(R.id.progress_signup);

        goTosplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Splash.class);
                startActivity(intent);
            }
        });



        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname, username, password, email;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                email = String.valueOf(textInputEditTextEmail.getText());

                if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {

                    if(!emailValidator(textInputEditTextEmail)){
                        Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    progressBar2.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
//                            attributes = Arrays.asList("username", "fullname", "email", "password");
                            String[] attributes = new String[4];
                            attributes[0] = "username";
                            attributes[1] = "fullname";
                            attributes[2] = "email";
                            attributes[3] = "password";
                            String[] data = new String[4];
                            data[0] = username;
                            data[1] = fullname;
                            data[2] = email;
                            data[3] = password;

//                            data = Arrays.asList(username, fullname, email, password);
                            PutData putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/signup.php", "POST", attributes, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar2.setVisibility(View.INVISIBLE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                        startActivity(intent);

                                    } else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                } else Toast.makeText(getApplicationContext(), "All fields are required! ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean emailValidator(EditText etMail) {
        String emailToText = etMail.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            return true;
            //Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
        } else {
            return false;
            //Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed(){
        startActivity(new Intent(this, Splash.class));
    }
}
