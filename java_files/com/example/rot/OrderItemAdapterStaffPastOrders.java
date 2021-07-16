package com.example.rot;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rot.Item;
import com.example.rot.R;

import java.util.ArrayList;

public class OrderItemAdapterStaffPastOrders extends RecyclerView.Adapter<OrderItemAdapterStaffPastOrders.ItemViewolder> {

    public ArrayList<Item> itemsPastOrders = new ArrayList<>();

    private Context context;

    public OrderItemAdapterStaffPastOrders(Context context) { this.context = context; }

    public static class ItemViewolder extends RecyclerView.ViewHolder {
        private final CardView containerView;
        private final TextView item_name;
        private final TextView res_name;
        private final TextView rating;
        private final TextView timer;
        private final TextView user;
        private ImageView imageView;

        ItemViewolder(View view) {
            super(view);
            containerView = (CardView) view.findViewById(R.id.list_row);
            item_name = (TextView) view.findViewById(R.id.item_name_staff);
            res_name = (TextView) view.findViewById(R.id.res_name_staff);
            rating = (TextView) view.findViewById(R.id.rate);
            timer = (TextView) view.findViewById(R.id.order_time_staff);
            user = (TextView) view.findViewById(R.id.staff_user_id_past);
            imageView = (ImageView) view.findViewById(R.id.image_staff_past);
        }
    }

    @NonNull
    @Override
    public ItemViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_order_list_row_staff, parent, false);
        return new ItemViewolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemViewolder holder, int position) {
        Item current = itemsPastOrders.get(position);
        holder.item_name.setText(current.getItem_name());
        holder.timer.setText(current.getTimeStarted());
        holder.rating.setText(current.getRating());
        holder.user.setText(current.getUser());
        holder.res_name.setText(current.getRes_name());

        Glide.with(context)
                .asBitmap()
                .load(current.getImageUrl())
                .into(holder.imageView);

//        staff_navigation_past_orders_container_class s = new staff_navigation_past_orders_container_class(getAveRating(itemsPastOrders));
//        s.ave = getAveRating(itemsPastOrders);
    }

    @Override
    public int getItemCount() {
        return itemsPastOrders.size();
    }

    public void setItems(ArrayList<Item> itemsPastOrders) {
        this.itemsPastOrders = itemsPastOrders;
        notifyDataSetChanged();
    }

    public double getAveRating(ArrayList<Item> itemsPastOrders) {
        double sum = 0;
        for (int i = 0; i < itemsPastOrders.size(); i++) {
            sum += Float.parseFloat(itemsPastOrders.get(i).getRating());
        }
        return sum/itemsPastOrders.size();
    }
}