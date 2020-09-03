package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

import android.graphics.Bitmap;

/**
 * Created by IMSIMPLEGARY on 2019/1/2.
 */

public class Order {
    Bitmap order_pic;
    String order_time,order_shop_name;
    float order_sumPrice;

    public Order(Bitmap order_pic, String order_time, String order_shop_name, float order_sumPrice) {
        this.order_pic = order_pic;
        this.order_time = order_time;
        this.order_shop_name = order_shop_name;
        this.order_sumPrice = order_sumPrice;
    }

    public Bitmap getOrder_pic() {
        return order_pic;
    }

    public String getOrder_time() {
        return order_time;
    }

    public String getOrder_shop_name() {
        return order_shop_name;
    }

    public float getOrder_sumPrice() {
        return order_sumPrice;
    }

    public void setOrder_pic(Bitmap order_pic) {
        this.order_pic = order_pic;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public void setOrder_shop_name(String order_shop_name) {
        this.order_shop_name = order_shop_name;
    }

    public void setOrder_sumPrice(float order_sumPrice) {
        this.order_sumPrice = order_sumPrice;
    }
}
