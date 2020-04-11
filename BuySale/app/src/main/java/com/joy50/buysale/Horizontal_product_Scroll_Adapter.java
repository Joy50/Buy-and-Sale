package com.joy50.buysale;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Horizontal_product_Scroll_Adapter extends RecyclerView.Adapter<Horizontal_product_Scroll_Adapter.ViewHolder> {

    private List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models;

    public Horizontal_product_Scroll_Adapter(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models) {
        this.horizontal_product_scroll_models = horizontal_product_scroll_models;
    }
    @NonNull
    @Override
    public Horizontal_product_Scroll_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Horizontal_product_Scroll_Adapter.ViewHolder holder, int position) {
        int resource = horizontal_product_scroll_models.get(position).getProductImage();
        String title = horizontal_product_scroll_models.get(position).getProductTitle();
        String des = horizontal_product_scroll_models.get(position).getProductDes();
        String price = horizontal_product_scroll_models.get(position).getPrductPrice();
        holder.setProductImage(resource);
        holder.setProductName(title);
        holder.setProductDes(des);
        holder.setProductPrice(price);
    }

    @Override
    public int getItemCount() {

        if (horizontal_product_scroll_models.size()>8){
            return 8;
        }else {
            return horizontal_product_scroll_models.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productName,productDes,productPrice;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productName = itemView.findViewById(R.id.h_s_product_title);
            productDes = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),ProductDetailsActivity.class));
                }
            });
        }
        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductName(String name){
            productName.setText(name);
        }
        private void setProductDes(String des){
            productDes.setText(des);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
