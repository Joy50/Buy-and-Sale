package com.joy50.buysale;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class GridProductViewAdapter extends BaseAdapter {
    List<Horizontal_Product_Scroll_Model> modelList;

    public GridProductViewAdapter(List<Horizontal_Product_Scroll_Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        final View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    parent.getContext().startActivity(new Intent(parent.getContext(),ProductDetailsActivity.class));
                }
            });

            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDes = view.findViewById(R.id.h_s_product_description);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            //productImage.setImageResource();
            Glide.with(parent.getContext()).load(modelList.get(position).getProductImage()).apply(new RequestOptions().placeholder(R.drawable.iphone11pro)).into(productImage);
            productTitle.setText(modelList.get(position).getProductTitle());
            productDes.setText(modelList.get(position).getProductDes());
            productPrice.setText(modelList.get(position).getPrductPrice());
        }else {
            view = convertView;
        }

        return view;
    }
}
