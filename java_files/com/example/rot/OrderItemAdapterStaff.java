package com.example.rot;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OrderItemAdapterStaff extends RecyclerView.Adapter<OrderItemAdapterStaff.ItemViewolder> {

    private ArrayList<Item> items = new ArrayList<>();

    String newStatus;
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private Context context;

    public OrderItemAdapterStaff(Context context) { this.context = context; }

    public static class ItemViewolder extends RecyclerView.ViewHolder {
        private final CardView containerView;
        private final TextView item_name;
        private final TextView status;
        private final ImageView imageView;
        private final TextView res_name;
        private final TextView user;
        private final Button updateStatus;
        private final TextView timer;

        ItemViewolder(View view) {
            super(view);
            containerView = (CardView) view.findViewById(R.id.list_row);
            item_name = (TextView) view.findViewById(R.id.item_name);
            status = (TextView) view.findViewById(R.id.status);
            res_name = (TextView) view.findViewById(R.id.res_name);
            updateStatus = (Button) view.findViewById(R.id.updateStaff);
            user = (TextView) view.findViewById(R.id.staff_user_id);
            timer = (TextView) view.findViewById(R.id.order_time);
            imageView = (ImageView) view.findViewById(R.id.image_staff_recent);
        }
    }

    @NonNull
    @Override
    public ItemViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_row_staff, parent, false);
        return new ItemViewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewolder holder, int position) {
        Item current = items.get(position);
        holder.item_name.setText(current.getItem_name());
        holder.user.setText(current.getUser());
        holder.status.setText(current.getStatus());
        holder.res_name.setText(current.getRes_name());
        holder.timer.setText(current.getTimeStarted());

        Glide.with(context)
                .asBitmap()
                .load(current.getImageUrl())
                .into(holder.imageView);

        holder.updateStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime1 = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                formatter = new SimpleDateFormat("dd MMM HH:mm");
                String currentTime = formatter.format(currentTime1);
                currentTime = formatter.format(currentTime1);
//                Da currentTime = Calendar.getInstance().getTime();
//                DateandTime
                if (current.getStatus().equals("Pending")) {
                    System.out.println("if works");
                    newStatus = "Preparing";
                    current.setStatus(newStatus);
                    current.setTimeStarted(String.valueOf(currentTime));
                    holder.timer.setText(String.valueOf(currentTime));
                    System.out.println("set status works");
                    holder.status.setText(current.getStatus());
                    System.out.println("set text works");
                }
                else if (current.getStatus().equals("Preparing")) {
                    newStatus = "Collected";
                    current.setStatus(newStatus);
                    holder.status.setText(current.getStatus());
                }
                else if (current.getStatus().equals("Collected")) {
                    return;
                }
                ContentValues params = new ContentValues();
                params.put("status", newStatus);
                params.put("pos", current.getOrder_num());
                params.put("timeOrder", (currentTime).toString());

                //params.put("brand", username);
                AsyncHttpPost asyncHttpPost = new AsyncHttpPost(
                        "https://lamp.ms.wits.ac.za/home/s2150723/updateStatus.php", params) {
                    @Override
                    protected void onPostExecute(String output) {
                        Toast.makeText(v.getContext().getApplicationContext(), output, Toast.LENGTH_SHORT ).show();
                    }
                };
                asyncHttpPost.execute();
            }
        });

//        holder.updateStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Handler handler = new Handler();
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("got to function");
//                        if (current.getStatus().equals("Pending")) {
//                            System.out.println("if works");
//                            newStatus = "Preparing";
//                            current.setStatus(newStatus);
//                            System.out.println("set status works");
//                            holder.status.setText(current.getStatus());
//                            System.out.println("set text works");
//                        }
//                        else if (current.getStatus().equals("Preparing")) {
//                            Toast.makeText(v.getContext().getApplicationContext(), "hah", Toast.LENGTH_SHORT ).show();
//                            newStatus = "Collected";
//                            current.setStatus(newStatus);
//                            holder.status.setText(current.getStatus());
//                        }
//                        else if (current.getStatus().equals("Collected")) {
//                            return;
//                        }
//                        List<ForStatusChange> nameValuePairs = new ArrayList<>();
//                        nameValuePairs.add(new ForStatusChange(newStatus, position));
//
//                        String json = new Gson().toJson(nameValuePairs);
//
//                        try {
//                            String res = post("https://lamp.ms.wits.ac.za/home/s2150723/updateStatus.php", json);
//                            Toast.makeText(v.getContext().getApplicationContext(), res, Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "No Success";
        }
    }
}