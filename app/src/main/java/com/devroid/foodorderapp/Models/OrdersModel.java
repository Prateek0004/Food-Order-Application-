package com.devroid.foodorderapp.Models;


public class OrdersModel {
    int orderImage;
    String SoldItemName,price,orderNumber;

    public OrdersModel() {
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return SoldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        SoldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrdersModel(int orderImage, String soldItemName, String price, String orderNumber) {
        this.orderImage = orderImage;
        this.SoldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;


    }
}
