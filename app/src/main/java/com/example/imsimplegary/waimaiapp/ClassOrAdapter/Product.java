package com.example.imsimplegary.waimaiapp.ClassOrAdapter;

/**
 * Created by IMSIMPLEGARY on 2018/12/26.
 */

public class Product {
    int imagePath,orderNum,id;
    String name,content,sale,zan,tag;
    float price;
    boolean isTitle;

    public Product(String tag, boolean isTitle) {
        this.tag = tag;
        this.isTitle = isTitle;
    }

    public Product(int imagePath, String name, String content, String sale, String zan, float price,int orderNum,boolean isTitle) {
        this.imagePath = imagePath;
        this.orderNum = orderNum;
        this.name = name;
        this.content = content;
        this.sale = sale;
        this.zan = zan;
        this.price = price;
        this.isTitle = isTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagePath() {
        return imagePath;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getSale() {
        return sale;
    }

    public String getZan() {
        return zan;
    }

    public String getTag() {
        return tag;
    }

    public float getPrice() {
        return price;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }
}
