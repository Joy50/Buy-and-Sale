package com.joy50.buysale;

public class CartItemModel {

    public static final int CART_ITEM_LAYOUT = 0;
    public static final int TOTAL_AMOUNT_LAYOUT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /*Cart Item*/

    private int product_image;
    private String product_titel;
    private int no_of_free_cupons;
    private String product_price;
    private String cutted_price;
    private int product_quantity;
    private int offers_applied;
    private int cupon_applied;

    public CartItemModel(int type, int product_image, String product_titel, int no_of_free_cupons, String product_price,
                         String cutted_price, int product_quantity, int offers_applied, int cupon_applied) {
        this.type = type;
        this.product_image = product_image;
        this.product_titel = product_titel;
        this.no_of_free_cupons = no_of_free_cupons;
        this.product_price = product_price;
        this.cutted_price = cutted_price;
        this.product_quantity = product_quantity;
        this.offers_applied = offers_applied;
        this.cupon_applied = cupon_applied;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_titel() {
        return product_titel;
    }

    public void setProduct_titel(String product_titel) {
        this.product_titel = product_titel;
    }

    public int getNo_of_free_cupons() {
        return no_of_free_cupons;
    }

    public void setNo_of_free_cupons(int no_of_free_cupons) {
        this.no_of_free_cupons = no_of_free_cupons;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getCutted_price() {
        return cutted_price;
    }

    public void setCutted_price(String cutted_price) {
        this.cutted_price = cutted_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public int getOffers_applied() {
        return offers_applied;
    }

    public void setOffers_applied(int offers_applied) {
        this.offers_applied = offers_applied;
    }

    public int getCupon_applied() {
        return cupon_applied;
    }

    public void setCupon_applied(int cupon_applied) {
        this.cupon_applied = cupon_applied;
    }

    /*Cart Item*/
    /*Cart Total*/
    private int total_items;
    private String total_Price;
    private String delivery_price;
    private String total_amount;
    private String savedamount;

    public CartItemModel(int type, int total_items, String total_Price, String delivery_price, String total_amount, String savedamount) {
        this.type = type;
        this.total_items = total_items;
        this.total_Price = total_Price;
        this.delivery_price = delivery_price;
        this.total_amount = total_amount;
        this.savedamount = savedamount;
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    public String getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(String total_Price) {
        this.total_Price = total_Price;
    }

    public String getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(String delivery_price) {
        this.delivery_price = delivery_price;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSavedamount() {
        return savedamount;
    }

    public void setSavedamount(String savedamount) {
        this.savedamount = savedamount;
    }

    /*Cart Total*/
}
