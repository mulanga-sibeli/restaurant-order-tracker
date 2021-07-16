package com.example.rot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class user_past_orders_class extends Fragment {

    private RecyclerView recyclerView;
    private RatingBar ratingBar;
    private ImageButton rating_done;
    ArrayList<Item> item;
    //    OrderItemAdapter adapter1 = new OrderItemAdapter();
    OrderItemAdapterPastOrders adapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user_past_orders_container_file, container, false);

//        System.out.println(adapter1.itemsPastOrders.size());

        adapter2 = new OrderItemAdapterPastOrders(view.getContext());
        customer_home test = (customer_home) getActivity();
        String username = test.sign_name();

        item = new ArrayList<>();

        ratingBar = (RatingBar) view.findViewById(R.id.user_rating);

        getDatapast(username);
        adapter2.setItems(item);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_past_orders_users);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public void getDatapast(String user){
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
                JSONObject jsonObject = null;
                for (int i = 0;i < jsonArray.length(); i++) {
                    try {
                        jsonObject = jsonArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Item data = new Item();
                    try {
                        assert jsonObject != null;
                        if(jsonObject.getString("username").equals(user) && jsonObject.getString("status").equals("Collected")) {
                            try {
                                data.setItem_name(jsonObject.getString("item_name"));
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
                                data.setRating(jsonObject.getString("rating"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                data.setImageUrl(jsonObject.getString("img_src"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            item.add(data);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter2.setItems(item);
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