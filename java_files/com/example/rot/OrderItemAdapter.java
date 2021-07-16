package com.example.rot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ItemViewolder> {

    private ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Item> itemsPastOrders = new ArrayList<>();

    private Context context;

    public OrderItemAdapter(Context context) { this.context = context; }

    public static class ItemViewolder extends RecyclerView.ViewHolder {
        private final CardView containerView;
        private final TextView item_name;
        private final TextView status;
        private final TextView res_name;
        private final ImageView imageView;

        ItemViewolder(View view) {
            super(view);
            containerView = (CardView) view.findViewById(R.id.list_row);
            item_name = (TextView) view.findViewById(R.id.item_name);
            status = (TextView) view.findViewById(R.id.status);
            res_name = (TextView) view.findViewById(R.id.res_name);
            imageView = (ImageView) view.findViewById(R.id.image_user_recent);
        }
    }

    @NonNull
    @Override
    public ItemViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_row_user, parent, false);
        return new ItemViewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewolder holder, int position) {
        Item current = items.get(position);
        holder.item_name.setText(current.getItem_name());
        holder.status.setText(current.getStatus());
        holder.res_name.setText(current.getRes_name());

        Glide.with(context)
                .asBitmap()
                .load(current.getImageUrl())
                .into(holder.imageView);

        if (current.getStatus().equals("Collected")) {
            itemsPastOrders.add(current);
//            items.remove(position);
//            setItems(items);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

//    public void removeItem(int position) {
//        items.remove(position);
//        notifyItemRemoved(position);
//    }
}