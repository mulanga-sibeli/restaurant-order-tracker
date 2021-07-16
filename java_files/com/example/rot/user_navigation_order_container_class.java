package com.example.rot;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;




public class user_navigation_order_container_class extends Fragment {
    CardView mos_card, italiano_card, sticky_steak_card, cake_factory_card;
    LinearLayout mos_layout, italiano_layout, sticky_steak_layout, cake_factory_layout;
    ImageView mos_burgers_image, italiano_image, sticky_steak_image, cake_factory_image;
    ImageButton user_navigation_back_button;
    String sign_password_navi;
    String sign_name_navi;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        customer_home activity = (customer_home) getActivity();
        sign_password_navi = activity.sign_password();
        sign_name_navi = activity.sign_name();
        View view =  inflater.inflate(R.layout.user_navigation_order_container_file, container, false);
        mos_card = (CardView) view.findViewById(R.id.mos_card);
        italiano_card = (CardView) view.findViewById(R.id.italiano_card);
        sticky_steak_card  = (CardView) view.findViewById(R.id.sticky_steak_card);
        cake_factory_card = (CardView) view.findViewById(R.id.cake_factory_card);

        mos_layout = (LinearLayout) view.findViewById(R.id.mos_layout);
        italiano_layout = (LinearLayout) view.findViewById(R.id.italiano_layout);
        sticky_steak_layout = (LinearLayout) view.findViewById(R.id.sticky_steak_layout);
        cake_factory_layout = (LinearLayout) view.findViewById(R.id.cake_factory_layout);

        mos_burgers_image = (ImageView) view.findViewById(R.id.mos_burger_image);
        italiano_image = (ImageView) view.findViewById(R.id.italiano_image);
        sticky_steak_image = (ImageView) view.findViewById(R.id.sticky_steak_image);
        cake_factory_image = (ImageView) view.findViewById(R.id.cake_factory_image);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/burger_waiter.png")
                .into(mos_burgers_image);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/pizza3.png")
                .into(italiano_image);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/steak.png")
                .into(sticky_steak_image);

        Glide.with(this)
                .asBitmap()
                .load("https://lamp.ms.wits.ac.za/~s2150723/pictures/cake2.png")
                .into(cake_factory_image);

        user_navigation_back_button = (ImageButton) view.findViewById(R.id.user_navigation_order_back_button);

        user_navigation_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                getActivity().startActivity(intent);
            }
        });

        mos_layout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mos_burgers.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        mos_burgers_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mos_burgers.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        italiano_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), italiano.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        sticky_steak_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), steaky_stakes.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        cake_factory_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), cake_factory.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        italiano_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), italiano.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        sticky_steak_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), steaky_stakes.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        cake_factory_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), cake_factory.class);
                intent.putExtra("username",sign_name_navi);
                intent.putExtra("password",sign_password_navi);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);





//        mos_card = (CardView) view.findViewById(R.id.mos_card);
//        italiano_card = (CardView) view.findViewById(R.id.italiano_card);
//        sticky_steak_card  = (CardView) view.findViewById(R.id.sticky_steak_card);
//        cake_factory_card = (CardView) view.findViewById(R.id.cake_factory_card);
//
//        mos_layout = (LinearLayout) view.findViewById(R.id.mos_layout);
//        italiano_layout = (LinearLayout) view.findViewById(R.id.italiano_layout);
//        sticky_steak_layout = (LinearLayout) view.findViewById(R.id.sticky_steak_layout);
//        cake_factory_layout = (LinearLayout) view.findViewById(R.id.cake_factory_layout);
//
//        mos_burgers_image = (ImageView) view.findViewById(R.id.mos_burger_image);
//        italiano_image = (ImageView) view.findViewById(R.id.italiano_image);
//        sticky_steak_image = (ImageView) view.findViewById(R.id.sticky_steak_image);
//        cake_factory_image = (ImageView) view.findViewById(R.id.cake_factory_image);
//
//        user_navigation_back_button = (ImageButton) view.findViewById(R.id.user_navigation_order_back_button);
//
//        user_navigation_back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), MainActivity2.class);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        mos_layout.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), mos_burgers.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        mos_burgers_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), mos_burgers.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        italiano_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), italiano.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        sticky_steak_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), steaky_stakes.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        cake_factory_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), cake_factory.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        italiano_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), italiano.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        sticky_steak_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), steaky_stakes.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });
//
//        cake_factory_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), cake_factory.class);
//                intent.putExtra("username",sign_name_navi);
//                intent.putExtra("password",sign_password_navi);
//                getActivity().startActivity(intent);
//            }
//        });

    }

    public void onBackPressed(){
        Intent i  = new Intent(getActivity(), MainActivity2.class);
        startActivity(i);
    }

}