package com.example.rot;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class OrderItemAdapterPastOrders extends RecyclerView.Adapter<OrderItemAdapterPastOrders.ItemViewolder> {

    private ArrayList<Item> itemsPastOrders = new ArrayList<>();

    View view;
    private Context context;


    public OrderItemAdapterPastOrders(Context context) { this.context = context; }

    public static class ItemViewolder extends RecyclerView.ViewHolder {
        private final CardView containerView;
        private final TextView item_name;
        private final TextView status;
        private final TextView res_name;
        private final RatingBar ratingBar;
        private final ImageView imageView;
//        private final TextView rating_text;

        ItemViewolder(View view) {
            super(view);
            containerView = (CardView) view.findViewById(R.id.list_row);
            item_name = (TextView) view.findViewById(R.id.item_name);
            status = (TextView) view.findViewById(R.id.status);
            res_name = (TextView) view.findViewById(R.id.res_name);
            ratingBar = (RatingBar) view.findViewById(R.id.user_rating);
            imageView = (ImageView) view.findViewById(R.id.image_user_past);
            Button button = view.findViewById(R.id.updateStaff);
        }
    }

    @NonNull
    @Override
    public ItemViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_order_list_row_user, parent, false);
        return new ItemViewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewolder holder, int position) {
        Item current = itemsPastOrders.get(position);
        holder.item_name.setText(current.getItem_name());

        Glide.with(context)
                .asBitmap()
                .load(current.getImageUrl())
                .into(holder.imageView);

        if(!(current.getRating().equals("N/A"))) holder.ratingBar.setRating(Float.parseFloat(current.getRating()));
//        holder.status.setText(current.getStatus());
        holder.res_name.setText(current.getRes_name());
        if (!(current.getRating().equals("N/A"))) {
            holder.ratingBar.setEnabled(false);
        }
        holder.ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            current.setRating(ratingBar.getRating()+"");

            ContentValues params = new ContentValues();
            params.put("rating", current.getRating()+"");
            params.put("pos", current.getOrder_num());
            AsyncHttpPost asyncHttpPost = new AsyncHttpPost(
                    "https://lamp.ms.wits.ac.za/home/s2150723/updateRating.php", params) {
                @Override
                protected void onPostExecute(String output) {
                    Toast.makeText(view.getContext().getApplicationContext(), output, Toast.LENGTH_SHORT ).show();
                    if(output.equals("Success")){
                        ratingBar.setEnabled(false);
                        ratingBar.setClickable(false);
                        ratingBar.setFocusable(false);
                        ratingBar.clearFocus();
//                            rating_done.animate().translationY(-90).setDuration(5).setStartDelay(0);
//                            rating_done.setVisibility(View.VISIBLE);
                    }
                }
            };
            asyncHttpPost.execute();
        });
    }

    @Override
    public int getItemCount() {
        return itemsPastOrders.size();
    }

    public void setItems(ArrayList<Item> itemsPastOrders) {
        this.itemsPastOrders = itemsPastOrders;
        notifyDataSetChanged();
    }
}