package com.joy50.buysale;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM_LAYOUT;
            case 1:
                return CartItemModel.TOTAL_AMOUNT_LAYOUT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case CartItemModel.CART_ITEM_LAYOUT:
                View cartItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
                return new CartItemViewHolder(cartItemLayout);
            case CartItemModel.TOTAL_AMOUNT_LAYOUT:
                View totalAmountLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout, parent, false);
                return new CartTotalAmountViewHolder(totalAmountLayout);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemModelList.get(position).getType()) {
            case CartItemModel.CART_ITEM_LAYOUT:
                int imgresource = cartItemModelList.get(position).getProduct_image();
                String title = cartItemModelList.get(position).getProduct_titel();
                int freecupons = cartItemModelList.get(position).getNo_of_free_cupons();
                String productPrice = cartItemModelList.get(position).getProduct_price();
                String cuttedPrice = cartItemModelList.get(position).getCutted_price();
                int offersApplied = cartItemModelList.get(position).getOffers_applied();
                int cupponApplied = cartItemModelList.get(position).getCupon_applied();
                ((CartItemViewHolder)holder).setCartItems(imgresource,title,freecupons,productPrice,cuttedPrice,offersApplied,cupponApplied);
                break;
            case CartItemModel.TOTAL_AMOUNT_LAYOUT:
                int no_of_items = cartItemModelList.get(position).getTotal_items();
                String total_price = cartItemModelList.get(position).getTotal_Price();
                String delivery_price = cartItemModelList.get(position).getDelivery_price();
                String total_amount = cartItemModelList.get(position).getTotal_amount();
                String save = cartItemModelList.get(position).getSavedamount();
                ((CartTotalAmountViewHolder)holder).setCartTotalAmount(no_of_items,total_price,delivery_price,total_amount,save);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage, freeCuponsIcon;
        private TextView productTitle, freeCupons, productPrice, cuttedPrice, offerApplied, cupponApplied, productQuantity;

        public CartItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_cart_item_image);
            productTitle = itemView.findViewById(R.id.product_cart_item_title);
            freeCupons = itemView.findViewById(R.id.tv_free_cupon);
            productPrice = itemView.findViewById(R.id.productPrice);
            cuttedPrice = itemView.findViewById(R.id.cuttedPrice);
            offerApplied = itemView.findViewById(R.id.offersApplied);
            cupponApplied = itemView.findViewById(R.id.cupons_applied);
            productQuantity = itemView.findViewById(R.id.productquantity);
            freeCuponsIcon = itemView.findViewById(R.id.freeCuponIcon);
        }

        private void setCartItems(int imageData, String productName, int productfreecupons, String productprice,
                                  String productCuttedprice, int offerApplieddata, int cupponAppliedData) {
            productImage.setImageResource(imageData);
            productTitle.setText(productName);
            if (productfreecupons > 0) {
                freeCuponsIcon.setVisibility(View.VISIBLE);
                freeCupons.setVisibility(View.VISIBLE);
                freeCupons.setText("free " + productfreecupons + " cupons");
            } else {
                freeCuponsIcon.setVisibility(View.INVISIBLE);
                freeCupons.setVisibility(View.INVISIBLE);
            }
            productPrice.setText("$ " + productprice);
            cuttedPrice.setText("$ " + productCuttedprice);
            if (offerApplieddata > 0) {
                offerApplied.setVisibility(View.VISIBLE);
            } else {
                offerApplied.setVisibility(View.INVISIBLE);
            }
            if (cupponAppliedData > 0) {
                cupponApplied.setVisibility(View.VISIBLE);
            } else {
                cupponApplied.setVisibility(View.INVISIBLE);
            }
            productQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog quantityDialog = new Dialog(itemView.getContext());
                    quantityDialog.setContentView(R.layout.quantity_dialog);
                    quantityDialog.setCancelable(false);
                    Button cancelBtn = quantityDialog.findViewById(R.id.cancel);
                    Button okBtn = quantityDialog.findViewById(R.id.okBtn);
                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quantityDialog.dismiss();
                        }
                    });
                    okBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EditText quntityNumber = quantityDialog.findViewById(R.id.quantityfild);
                            String qunatityNo = quntityNumber.getText().toString();
                            productQuantity.setText("Qty :"+qunatityNo);
                            quantityDialog.dismiss();
                        }
                    });
                    quantityDialog.show();
                }
            });
        }
    }

    public class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {

        private TextView totalItems, totalItemPrice, deliveryPrice, totalAmount, savedAmount,productQuantity;

        public CartTotalAmountViewHolder(@NonNull final View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_items);
            totalItemPrice = itemView.findViewById(R.id.total_items_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }

        private void setCartTotalAmount(int total_items, String totalPrice, String delivery_price, String total_amount_text, String saved_amount) {
            totalItems.setText("Price (" + total_items + " Items)");
            totalItemPrice.setText(totalPrice);
            deliveryPrice.setText(delivery_price);
            totalAmount.setText(total_amount_text);
            savedAmount.setText(saved_amount);
        }
    }
}
