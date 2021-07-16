package com.example.rot;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonIOException;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.Inflater;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class user_navigation__status_of_order_container_class extends Fragment {

    //    ScrollView requests_scroll;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView item_name;
    private TextView status;
    private TextView res_name;
    private TextView haha1;
    private ImageView imageView;
    LayoutInflater inflator;
    String reser;
    ViewGroup containor;
    ArrayList<Item> item;
    OrderItemAdapter adapter1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_navigation_status_of_order_container_file, container, false);

        adapter1 = new OrderItemAdapter(view.getContext());

        haha1 = (TextView) view.findViewById(R.id.haha1);
//        item_name = (TextView) view.findViewById(R.id.item_name);
//        status = (TextView) view.findViewById(R.id.status);
//        res_name = (TextView) view.findViewById(R.id.res_name);
//        OrderItemAdapter adapter1 = new OrderItemAdapter();
//
//
//        item.add(new Item("Margaritta", "Pending", "Italiano"));

        customer_home test = (customer_home) getActivity();
        String username = test.sign_name();

        System.out.println(username);

        item = new ArrayList<Item>();
        getData(username);
        adapter1.setItems(item);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public void onBackPressed(){
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        getActivity().startActivity(intent);
    }



    public void getData(String user){
        String url = "https://lamp.ms.wits.ac.za/home/s2150723/sendData.php";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0;i < jsonArray.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = jsonArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Item data = new Item();
                    try {
                        if(jsonObject.getString("username").equals(user) && !(jsonObject.getString("status").equals("Collected"))) {
                            try {
                                data.setItem_name(jsonObject.getString("item_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setStatus(jsonObject.getString("status"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setRes_name(jsonObject.getString("res_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setOrder_num(jsonObject.getInt("order_no"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setImageUrl(jsonObject.getString("img_src"));
                            } catch (JsonIOException e) {
                                e.printStackTrace();
                            }
                            item.add(data);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter1.setItems(item);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "aha", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

}