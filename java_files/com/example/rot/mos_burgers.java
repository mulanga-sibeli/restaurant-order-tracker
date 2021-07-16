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

public class mos_burgers extends AppCompatActivity {


    ImageButton mos_back_button;
    Button mofries, mowings, juicymo, bigmo;
    ImageView juicyMo, bigMo, moDucrkyWings, moFries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_mos_burgers);

        Intent intent = getIntent();
        String signin_name = intent.getStringExtra("username");
        String signin_password = intent.getStringExtra("password");

        bigmo = (Button) findViewById(R.id.mos_big);
        juicymo = (Button) findViewById(R.id.mos_juicy);
        mofries = (Button) findViewById(R.id.mos_fries);
        mowings = (Button) findViewById(R.id.mos_wings);

        mos_back_button = (ImageButton) findViewById(R.id.mos_back_button);

        juicyMo = (ImageView) findViewById(R.id.juicy_mo_menu);
        bigMo = (ImageView) findViewById(R.id.big_mo_menu);
        moDucrkyWings = (ImageView) findViewById(R.id.mo_durky_wings_menu);
        moFries = (ImageView) findViewById(R.id.mo_fries_menu);


        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/juciy_mo.png")
                .into(juicyMo);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/big_mo.png")
                .into(bigMo);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/mod_wings.png")
                .into(moDucrkyWings);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/mos_fries.png")
                .into(moFries);


        mos_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(getApplicationContext(), customer_home.class);
                i.putExtras(getIntent());
                startActivity(i);
                finish();
            }
        });

        mofries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Mo Fries";
                String restuarant = "Mo's Burgers";
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
//                        user_navigation__status_of_order_container_class
//                        user_navigation__status_of_order_container_class fragment = getFragmentManager().findFragmentById(R.layout.user_navigation__status_of_order_container_file);

                    }
                });

            }
        });

        mowings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Mo Durky Wings";
                String restuarant = "Mo's Burgers";
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

        bigmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Big Mo";
                String restuarant = (String) "Mo's Burgers";
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

        juicymo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating = "N/A";
                String item = "Juicy Mo";
                String restuarant = (String) "Mo's Burgers";
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
                                    Intent i  = new Intent(getApplicationContext(), customer_home.class);
                                    //startActivity(i);
                                    //finish();
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