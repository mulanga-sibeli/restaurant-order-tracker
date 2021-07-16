package com.example.rot;

import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Item {
    private String status;
    private String res_name;
    private String item_name;
    private String rating;
    private String imageUrl;
    public Button updateStatus;
    private String timeStarted;
    private String user;
    public int order_num;

    Item(String item_name, String status, String res_name, int odrer_num, String rating, String user, String timeStarted, String imageUrl) {
        this.item_name = item_name;
        this.status = status;
        this.res_name = res_name;
        this.order_num = odrer_num;
        this.rating = rating;
        this.user = user;
        this.timeStarted = timeStarted;
        this.imageUrl = imageUrl;
    }

    Item() {}

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageUrl() { return imageUrl; }

    public String getTimeStarted() { return this.timeStarted; }
    public void setTimeStarted(String timeStarted) { this.timeStarted = timeStarted; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = "Order for "+ user; }

    public String getRating() {
        return this.rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }
    public int getOrder_num() {
        return order_num;
    }


    public String getItem_name() {
        return this.item_name;
    }
    public void setItem_name(String item_name) { this.item_name = item_name; }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) { this.status = status; }

    public String getRes_name() {
        return this.res_name;
    }
    public void setRes_name(String res_name) { this.res_name = res_name; }

}
