package com.example.rot;

public class ItemStaff {
    private String status;
    private String res_name;
    private String item_name;

    ItemStaff(String item_name, String status, String res_name) {
        this.item_name = item_name;
        this.status = status;
        this.res_name = res_name;
    }

    ItemStaff() {}

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