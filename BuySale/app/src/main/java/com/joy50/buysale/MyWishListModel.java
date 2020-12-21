package com.joy50.buysale;

public class MyWishListModel {

    private String productImage;
    private String productTitle;
    private long freeCuponsAvailable;
    private String rating;
    private long totalRating;
    private String productPrice;
    private String cuttedPrice;
    private Boolean COD;

    public MyWishListModel(String productImage, String productTitle, long freeCuponsAvailable, String rating, long totalRating, String productPrice, String cuttedPrice, Boolean COD) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCuponsAvailable = freeCuponsAvailable;
        this.rating = rating;
        this.totalRating = totalRating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.COD = COD;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public long getFreeCuponsAvailable() {
        return freeCuponsAvailable;
    }

    public void setFreeCuponsAvailable(long freeCuponsAvailable) {
        this.freeCuponsAvailable = freeCuponsAvailable;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public long getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(long totalRating) {
        this.totalRating = totalRating;
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

    public Boolean getCOD() {
        return COD;
    }

    public void setCOD(Boolean COD) {
        this.COD = COD;
    }
}
