package com.example.rot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class customer_home extends AppCompatActivity {

    CardView mos_card, italiano_card, sticky_steak_card, cake_factory_card;
    LinearLayout mos_layout, italiano_layout, sticky_steak_layout, cake_factory_layout;
    private String signin_name, signin_password;
    String item, res_name, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_customer_home);

        Intent intent = getIntent();

        signin_password = intent.getStringExtra("password");
        signin_name = (String)  intent.getStringExtra("username");

//        Bundle bundle = new Bundle();
//        bundle.putString("user",signin_name);
//        user_navigation__status_of_order_container_class test = new user_navigation__status_of_order_container_class();
//        test.setArguments(bundle);



//        signin_name = (String) intent.getSerializableExtra("username");
        //signin_password = (String) intent.getSerializableExtra("password");

        BottomNavigationView customer_nav = (BottomNavigationView) findViewById(R.id.customer_navigation);
        customer_nav.setOnNavigationItemSelectedListener(navListener1);

//        mos_card = (CardView) findViewById(R.id.mos_card);
//        italiano_card = (CardView) findViewById(R.id.italiano_card);
//        sticky_steak_card = (CardView) findViewById(R.id.sticky_steak_card);
//        cake_factory_card = (CardView) findViewById(R.id.cake_factory_card);
//        mos_layout = (LinearLayout) findViewById(R.id.mos_layout);
//        italiano_layout = (LinearLayout) findViewById(R.id.italiano_layout);
//        sticky_steak_layout = (LinearLayout) findViewById(R.id.sticky_steak_layout);
//        cake_factory_layout = (LinearLayout) findViewById(R.id.cake_factory_layout);

//        mos_card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Splash.class);startActivity(intent);
//                finish();
//            }
//        });

        getSupportFragmentManager().beginTransaction().replace(R.id.user_navigation_order_container, new user_past_orders_class()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_navigation_order_container, new user_navigation__status_of_order_container_class()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_navigation_order_container, new user_navigation_order_container_class()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener1 = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment1 = null;

            switch (item.getItemId()){
                case R.id.order_page:
                    selectedFragment1 = new user_navigation_order_container_class();
                    break;
            }

            switch (item.getItemId()){
                case R.id.order_status_page:
                    selectedFragment1 = new user_navigation__status_of_order_container_class();
                    break;
            }
            switch (item.getItemId()){
                case R.id.order_past_page:
                    selectedFragment1 = new user_past_orders_class();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.user_navigation_order_container, selectedFragment1).commit();
            return false;
        }
    };


    @Override
    public void onBackPressed(){
        Intent i  = new Intent(this, MainActivity2.class);
        i.putExtras(getIntent());
        startActivity(i);
        finish();
    }

    public String sign_name(){
        return this.signin_name;
    }

    public String sign_password(){
        return signin_password;
    }
}