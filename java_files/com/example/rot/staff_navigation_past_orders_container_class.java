package com.example.rot;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class staff_navigation_past_orders_container_class extends Fragment {
    ImageButton staff_navigation_past_orders_back_button;

    private RecyclerView recyclerView;
    public static double ave;
    private TextView aveRating;
    static ArrayList<Item> item;
    OrderItemAdapterStaffPastOrders adapter3;

    //    staff_navigation_past_orders_container_class (double ave) { this.ave = ave; }
//
//    staff_navigation_past_orders_container_class () { }
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.staff_navigation_past_orders_container_file, container, false);

        adapter3 = new OrderItemAdapterStaffPastOrders(view.getContext());

        staff_home test = (staff_home) getActivity();
        String res_name = test.sign_res_name();

        aveRating = (TextView) view.findViewById(R.id.ave_rating);
        item = new ArrayList<>();
        getData(res_name);
        getAve(res_name);
        adapter3.setItems(item);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_past_orders_staff);
        recyclerView.setAdapter(adapter3);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        aveRating.setText("Average Rating: " + ave);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        staff_navigation_past_orders_back_button = (ImageButton) view.findViewById(R.id.staff_navigation_past_orders_back_button);

        staff_navigation_past_orders_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                getActivity().startActivity(intent);
            }
        });
    }

    public void getAve(String user){

        ContentValues params = new ContentValues();
        params.put("res_name", user);

        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(
                "https://lamp.ms.wits.ac.za/home/s2150723/sendAve.php", params) {
            @Override
            protected void onPostExecute(String output) {
                aveRating.setText("Average Rating: "+Math.round(Float.parseFloat(output) * 100.0)/100.0);
//                Toast.makeText(v.getContext().getApplicationContext(), output, Toast.LENGTH_SHORT ).show();
            }
        };
        asyncHttpPost.execute();
    }


    public void getData(String user){
        String url = "https://lamp.ms.wits.ac.za/home/s2150723/sendData.php";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @SuppressLint("SetTextI18n")
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
                        if(jsonObject.getString("res_name").equals(user) && (jsonObject.getString("status").equals("Collected"))) {
                            try {
                                data.setUser(jsonObject.getString("username"));
                            } catch(JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setItem_name(jsonObject.getString("item_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                if (jsonObject.getString("time").equals("NULL")) {
                                    data.setTimeStarted("    ");
                                }else data.setTimeStarted(jsonObject.getString("time"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setRating(jsonObject.getString("rating"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setRes_name(jsonObject.getString("res_name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setImageUrl(jsonObject.getString("img_src"));
                            } catch (JsonIOException e) {
                                e.printStackTrace();
                            }
//                            try {
//                                data.setOrder_num(jsonObject.getInt("order_no"));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                            item.add(data);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter3.setItems(item);
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

    public void onBackPressed(){
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        getActivity().startActivity(intent);
    }

}