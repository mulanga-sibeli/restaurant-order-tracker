package com.example.rot;

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

import java.util.ArrayList;

public class cake_factory extends AppCompatActivity {

    ImageButton cake_factory_back_button;
    Button cake_factory_raspberry_cake, cake_factory_carrot_cake, cake_factory_chocolate, doughnuts;
    ImageView raspberryCheeseCake, carrotCake, chocolateTiramisuCake, Doughnuts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_cake_factory);

        Intent sign_in_details = getIntent();

        final String signin_name = sign_in_details.getStringExtra("username");
        final String signin_password = sign_in_details.getStringExtra("password");


        cake_factory_back_button = (ImageButton) findViewById(R.id.cake_factory_back_button);
        cake_factory_raspberry_cake = (Button) findViewById(R.id.cake_factory_cheese_cake);
        cake_factory_chocolate = (Button) findViewById(R.id.cake_factory_chocolate_cake);
        doughnuts = (Button) findViewById(R.id.cake_factory_doughnuts);
        cake_factory_carrot_cake = (Button) findViewById(R.id.cake_factory_carrot_cake);

        raspberryCheeseCake = (ImageView) findViewById(R.id.raspberry_cheese_cake_menu);
        carrotCake = (ImageView) findViewById(R.id.carrot_cake_menu);
        chocolateTiramisuCake = (ImageView) findViewById(R.id.chocolate_tiramisu_cake_menu);
        Doughnuts = (ImageView) findViewById(R.id.doughnuts_menu);


        Glide.with(this)
                .asDrawable().thumbnail()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/cheese_cake.png")
                .into(raspberryCheeseCake);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/carrot_cake.png")
                .into(carrotCake);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/chocolate_cake.png")
                .into(chocolateTiramisuCake);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/doughnuts.png")
                .into(Doughnuts);

        cake_factory_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getApplicationContext(), customer_home.class);
                i.putExtras(getIntent());
                startActivity(i);
                finish();
            }
        });

        cake_factory_carrot_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Carrot Cake";
                String restuarant = (String) "The Cake Factory";
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

        doughnuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Doughnuts";
                String restuarant = "The Cake Factory";
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

        cake_factory_raspberry_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Raspberry Cheese Cake";
                String restuarant = (String) "The Cake Factory";
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

        cake_factory_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Chocolate Tiramisu Cake";
                String restuarant = (String) "The Cake Factory";
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