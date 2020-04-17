package com.joy50.buysale;

public class MyWishListModel {

    private int productImage;
    private String productTitle;
    private int freeCuponsAvailable;
    private String rating;
    private String totalRating;
    private String productPrice;
    private String cuttedPrice;
    private String paymentMethod;

    public MyWishListModel(int productImage, String productTitle, int freeCuponsAvailable, String rating, String totalRating ,String productPrice, String cuttedPrice, String paymentMethod) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCuponsAvailable = freeCuponsAvailable;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCuponsAvailable() {
        return freeCuponsAvailable;
    }

    public void setFreeCuponsAvailable(int freeCuponsAvailable) {
        this.freeCuponsAvailable = freeCuponsAvailable;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }
}
