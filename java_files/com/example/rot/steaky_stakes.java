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

public class steaky_stakes extends AppCompatActivity {

    ImageButton sticky_steaks_back_button;
    Button steak, ribs, wings, kebabs;
    ImageView stickySteaksSteak, stickyBBQRibs, stickyBuffaloWings, stickyChickenKebabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_steaky_stakes);

        Intent intent = getIntent();
        String signin_name = intent.getStringExtra("username");
        String signin_password = intent.getStringExtra("password");

        steak = (Button) findViewById(R.id.sticky_steak);
        kebabs = (Button) findViewById(R.id.sticky_kebabs);
        wings = (Button) findViewById(R.id.sticky_wings);
        ribs = (Button) findViewById(R.id.sticky_ribs);


        sticky_steaks_back_button = (ImageButton) findViewById(R.id.sticky_steaks_back_button);

        stickySteaksSteak = (ImageView) findViewById(R.id.sticky_steaks_steak_menu);
        stickyBBQRibs = (ImageView) findViewById(R.id.sticky_bbq_ribs_menu);
        stickyBuffaloWings = (ImageView) findViewById(R.id.sticky_buffalo_wings_menu);
        stickyChickenKebabs = (ImageView) findViewById(R.id.sticky_chicken_kebabs_menu);


        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/sticky_steaks_steak.png")
                .into(stickySteaksSteak);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/sticky_steaks_ribs.png")
                .into(stickyBBQRibs);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/sticky_steaks_wings.png")
                .into(stickyBuffaloWings);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/sticky_steaks_kebabs.png")
                .into(stickyChickenKebabs);

        sticky_steaks_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getApplicationContext(), customer_home.class);
                i.putExtras(getIntent());
                startActivity(i);
                finish();
            }
        });

        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Sticky Steaks' Steak";
                String restuarant = (String) "Sticky Steaks";
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

        wings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Sticky Buffalo Wings";
                String restuarant = "Sticky Steaks";
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

        ribs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Sticky BBQ Ribs";
                String restuarant = (String) "Sticky Steaks";
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

        kebabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Sticky Chicken Kebabs";
                String restuarant = (String) "Sticky Steaks";
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