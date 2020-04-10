package com.joy50.buysale;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductViewAdapter extends BaseAdapter {
    List<Horizontal_Product_Scroll_Model> modelList;

    public GridProductViewAdapter(List<Horizontal_Product_Scroll_Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));

            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDes = view.findViewById(R.id.h_s_product_description);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            productImage.setImageResource(modelList.get(position).getProductImage());
            productTitle.setText(modelList.get(position).getProductTitle());
            productDes.setText(modelList.get(position).getProductDes());
            productPrice.setText(modelList.get(position).getPrductPrice());
        }else {
            view = convertView;
        }

        return view;
    }
}
