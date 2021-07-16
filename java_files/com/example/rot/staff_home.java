package com.example.rot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class staff_home extends AppCompatActivity {

    private String res_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_staff_home);

        Intent intent = getIntent();
        res_name = (String)  intent.getStringExtra("res_name");

        BottomNavigationView customer_nav1 = (BottomNavigationView) findViewById(R.id.staff_navigation);
        customer_nav1.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.staff_navigation_order_container, new staff_navigation_past_orders_container_class()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.staff_navigation_order_container , new staff_navigation_add_order_class()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.staff_add_order_page:
                    selectedFragment = new staff_navigation_add_order_class();
                    break;
            }

            switch (item.getItemId()){
                case R.id.staff_past_orders_page:
                    selectedFragment = new staff_navigation_past_orders_container_class();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.staff_navigation_order_container, selectedFragment).commit();
            return false;
        }
    };

    public void onBackPressed(){
        Intent i  = new Intent(this, MainActivity2.class);
        i.putExtras(getIntent());
        startActivity(i);
        finish();
    }
    public String sign_res_name(){
        return this.res_name;
    }
}