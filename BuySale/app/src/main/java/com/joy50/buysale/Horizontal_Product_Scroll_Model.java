package com.joy50.buysale;

public class Horizontal_Product_Scroll_Model {

    private int productImage;
    private String productTitle;
    private String productDes;
    private String prductPrice;

    public Horizontal_Product_Scroll_Model(int productImage, String productTitle, String productDes, String prductPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productDes = productDes;
        this.prductPrice = prductPrice;
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

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public String getPrductPrice() {
        return prductPrice;
    }

    public void setPrductPrice(String prductPrice) {
        this.prductPrice = prductPrice;
    }
}
