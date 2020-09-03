package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

/**
 * Created by IMSIMPLEGARY on 2018/12/31.
 */

public class Bill {
    int bill_pic,bill_ordernum;
    String bill_food_name;
    float bill_food_price;

    public Bill(int bill_pic, int bill_ordernum, String bill_food_name, float bill_food_price) {
        this.bill_pic = bill_pic;
        this.bill_ordernum = bill_ordernum;
        this.bill_food_name = bill_food_name;
        this.bill_food_price = bill_food_price;
    }

    public int getBill_pic() {
        return bill_pic;
    }

    public int getBill_ordernum() {
        return bill_ordernum;
    }

    public String getBill_food_name() {
        return bill_food_name;
    }

    public float getBill_food_price() {
        return bill_food_price;
    }

    public void setBill_pic(int bill_pic) {
        this.bill_pic = bill_pic;
    }

    public void setBill_ordernum(int bill_ordernum) {
        this.bill_ordernum = bill_ordernum;
    }

    public void setBill_food_name(String bill_food_name) {
        this.bill_food_name = bill_food_name;
    }

    public void setBill_food_price(float bill_food_price) {
        this.bill_food_price = bill_food_price;
    }
}
