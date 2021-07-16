package com.example.rot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class staff_navigation_add_order_class extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //    private TextView item_name;
//    private TextView status;
//    private TextView res_name;
    private TextView haha1;
    private ImageView imageView;
    private Button updateStatus;
    ArrayList<Item> item;
    OrderItemAdapterStaff adapter2;


    ImageButton staff_navigation_add_order_back_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.staff_navigation_add_order_container_file, container, false);

        adapter2 = new OrderItemAdapterStaff(view.getContext());

        staff_home test = (staff_home) getActivity();
        String res_name = test.sign_res_name();

        item = new ArrayList<Item>();
        updateStatus = (Button) view.findViewById(R.id.updateStaff);
        //item.add(new Item("Big Mo", "Pending", "Mo's Burgers"));
        getData(res_name);
        //item.add(new Item("Margaritta", "Pending", "Italiano"));
        adapter2.setItems(item);
        recyclerView = (RecyclerView) view.findViewById(R.id.staff_recycler_view);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        staff_navigation_add_order_back_button = (ImageButton) view.findViewById(R.id.staff_navigation_add_order_back_button);

        staff_navigation_add_order_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                getActivity().startActivity(intent);
            }
        });
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
                        if(jsonObject.getString("res_name").equals(user) && !(jsonObject.getString("status").equals("Collected"))) {
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
                                    data.setTimeStarted("N/A");
                                }else data.setTimeStarted(jsonObject.getString("time"));
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
                adapter2.setItems(item);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}