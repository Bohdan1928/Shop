package com.example.shop;

public class Order {
    private String userName;
    private String instrumentName;
    private int orderQuantity;
    private int price;

    public Order() {
    }

    public Order(String userName, String instrumentName, int orderQuantity, int price) {
        this.userName = userName;
        this.instrumentName = instrumentName;
        this.orderQuantity = orderQuantity;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", price=" + price +
                '}';
    }
}
