package com.joy50.buysale;

public class MyOrderItemModel {

    private int productImage;
    private  int rating;
    private String productTitel;
    private String deliveryStatus;

    public MyOrderItemModel(int productImage, int rating, String productTitel, String deliveryStatus) {
        this.productImage = productImage;
        this.rating = rating;
        this.productTitel = productTitel;
        this.deliveryStatus = deliveryStatus;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitel() {
        return productTitel;
    }

    public void setProductTitel(String productTitel) {
        this.productTitel = productTitel;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
