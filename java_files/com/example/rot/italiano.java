package com.example.rot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class italiano extends AppCompatActivity {

    ImageButton italiano_back_button;
    Button seafood, vegetarian, margherita, pepperoni;

    ImageView pepperoniPizza, Margherita, Vegetarian, seafoodSpaghetti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_italiano);

        Intent intent = getIntent();
        String signin_name = intent.getStringExtra("username");
        String signin_password = intent.getStringExtra("password");


        margherita = (Button) findViewById(R.id.italiano_margherita);
        pepperoni = (Button) findViewById(R.id.italiano_pepperoni);
        seafood = (Button) findViewById(R.id.italiano_seafood);
        vegetarian = (Button) findViewById(R.id.italiano_vegetarian);

        italiano_back_button = (ImageButton) findViewById(R.id.italiano_back_button);

        pepperoniPizza = (ImageView) findViewById(R.id.pepperoni_pizza_menu);
        Margherita = (ImageView) findViewById(R.id.margherita_pizza_menu);
        Vegetarian = (ImageView) findViewById(R.id.vegetarian_pizza_menu);
        seafoodSpaghetti = (ImageView) findViewById(R.id.seafood_spaghetti_menu);


        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/italiano_pepe.png")
                .into(pepperoniPizza);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/italiano_marg.png")
                .into(Margherita);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/italiano_veg_2.png")
                .into(Vegetarian);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/italiano_pasta.png")
                .into(seafoodSpaghetti);

        italiano_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getApplicationContext(), customer_home.class);
                i.putExtras(getIntent());
                startActivity(i);
                finish();
            }
        });

        margherita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Margherita Pizza";
                String restuarant = (String) "Italiano";
                String status = "Pending";
                Toast.makeText(getApplicationContext(), signin_name, Toast.LENGTH_SHORT).show();

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                            attributes = Arrays.asList("username", "fullname", "email", "password");
                        String[] attributes = new String[5];
                        attributes[0] = "username";
                        attributes[1] = "item_name";
                        attributes[2] = "status";
                        attributes[3] = "rating";
                        attributes[4] = "res_name";
                        String[] data = new String[5];
                        data[0] = signin_name;
                        data[1] = item;
                        data[2] = status;
                        data[3] = rating;
                        data[4] = restuarant;

//                            data = Arrays.asList(username, fullname, email, password);
                        PutData putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/addToorder.php", "POST", attributes, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Success")) {
                                    Toast.makeText(getApplicationContext(), "Order added, check your orders to track status :).", Toast.LENGTH_SHORT).show();
                                } else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

            }
        });

        pepperoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Pepperoni Pizza";
                String restuarant = "Italiano";
                String status = "Pending";

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                            attributes = Arrays.asList("username", "fullname", "email", "password");
                        String[] attributes = new String[5];
                        attributes[0] = "username";
                        attributes[1] = "item_name";
                        attributes[2] = "status";
                        attributes[3] = "rating";
                        attributes[4] = "res_name";
                        String[] data = new String[5];
                        data[0] = signin_name;
                        data[1] = item;
                        data[2] = status;
                        data[3] = rating;
                        data[4] = restuarant;

//                            data = Arrays.asList(username, fullname, email, password);
                        PutData putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/addToorder.php", "POST", attributes, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Success")) {
                                    Toast.makeText(getApplicationContext(), "Order added, check your orders to track status :).", Toast.LENGTH_SHORT).show();
                                } else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Seafood Spaghetti";
                String restuarant = (String) "Italiano";
                String status = "Pending";

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                            attributes = Arrays.asList("username", "fullname", "email", "password");
                        String[] attributes = new String[5];
                        attributes[0] = "username";
                        attributes[1] = "item_name";
                        attributes[2] = "status";
                        attributes[3] = "rating";
                        attributes[4] = "res_name";
                        String[] data = new String[5];
                        data[0] = signin_name;
                        data[1] = item;
                        data[2] = status;
                        data[3] = rating;
                        data[4] = restuarant;

//                            data = Arrays.asList(username, fullname, email, password);
                        PutData putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/addToorder.php", "POST", attributes, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Success")) {
                                    Toast.makeText(getApplicationContext(), "Order added, check your orders to track status :).", Toast.LENGTH_SHORT).show();
                                } else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        vegetarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Vegetarian Pizza";
                String restuarant = (String) "Italiano";
                String status = "Pending";

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                            attributes = Arrays.asList("username", "fullname", "email", "password");
                        String[] attributes = new String[5];
                        attributes[0] = "username";
                        attributes[1] = "item_name";
                        attributes[2] = "status";
                        attributes[3] = "rating";
                        attributes[4] = "res_name";
                        String[] data = new String[5];
                        data[0] = signin_name;
                        data[1] = item;
                        data[2] = status;
                        data[3] = rating;
                        data[4] = restuarant;

//                            data = Arrays.asList(username, fullname, email, password);
                        PutData putData = new PutData("https://lamp.ms.wits.ac.za/home/s2150723/addToorder.php", "POST", attributes, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Success")) {
                                    Toast.makeText(getApplicationContext(), "Order added, check your orders to track status :).", Toast.LENGTH_SHORT).show();
                                } else Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

    }
    @Override
    public void onBackPressed(){
        Intent i  = new Intent(this, customer_home.class);
        i.putExtras(getIntent());
        startActivity(i);
        finish();
    }

}