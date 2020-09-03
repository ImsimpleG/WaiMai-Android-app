package com.example.imsimplegary.waimaiapp.ClassOrAdapter;


/**
 * Created by IMSIMPLEGARY on 2018/10/25.
 */


public class Shop {
    int shop_pic;
    String shop_name,shop_money,shop_sale,shop_distance,shop_minute;
    float shop_shippingFee;

    public Shop(int shop_pic, String shop_name, String shop_money, String shop_sale, String shop_distance, String shop_minute, float shop_shippingFee) {
        this.shop_pic = shop_pic;
        this.shop_name = shop_name;
        this.shop_money = shop_money;
        this.shop_sale = shop_sale;
        this.shop_distance = shop_distance;
        this.shop_minute = shop_minute;
        this.shop_shippingFee = shop_shippingFee;
    }

    public int getShop_pic() {
        return shop_pic;
    }
    public String getShop_name() {
        return shop_name;
    }
    public String getShop_money() {
        return shop_money;
    }
    public String getShop_sale() {
        return shop_sale;
    }
    public String getShop_distance() {
        return shop_distance;
    }
    public String getShop_minute() {
        return shop_minute;
    }
    public float getShop_shippingFee() {
        return shop_shippingFee;
    }

    public void setShop_shippingFee(float shop_shippingFee) {
        this.shop_shippingFee = shop_shippingFee;
    }
    public void setShop_pic(int shop_pic) {
        this.shop_pic = shop_pic;
    }
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
    public void setShop_money(String shop_money) {
        this.shop_money = shop_money;
    }
    public void setShop_sale(String shop_sale) {
        this.shop_sale = shop_sale;
    }
    public void setShop_distance(String shop_distance) {
        this.shop_distance = shop_distance;
    }
    public void setShop_minute(String shop_minute) {
        this.shop_minute = shop_minute;
    }
}
