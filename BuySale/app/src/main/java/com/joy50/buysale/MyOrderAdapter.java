package com.joy50.buysale;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private List<MyOrderItemModel> myOrderItemModelList;

    public MyOrderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
        int imageResource = myOrderItemModelList.get(position).getProductImage();
        String productName = myOrderItemModelList.get(position).getProductTitel();
        String indicatorDelivery = myOrderItemModelList.get(position).getDeliveryStatus();
        int ratingOfProduct = myOrderItemModelList.get(position).getRating();
        ((ViewHolder)holder).setDeliveredProductsDetail(imageResource,productName,indicatorDelivery,ratingOfProduct);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView deliveryIndicator;
        private TextView productTitle;
        private TextView deliveryStatus;
        private LinearLayout rateNowContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            deliveryIndicator = itemView.findViewById(R.id.order_indicator);
            productTitle = itemView.findViewById(R.id.product_title);
            deliveryStatus = itemView.findViewById(R.id.order_delivered_date);
            rateNowContainer = itemView.findViewById(R.id.rate_now_container);
        }
        private void setDeliveredProductsDetail(int productImageData,String productTitleData,String deliveryStatusData,int rating){
            productImage.setImageResource(productImageData);
            productTitle.setText(productTitleData);
            deliveryStatus.setText(deliveryStatusData);
            if (deliveryStatusData.equals("cancelled")){
                deliveryIndicator.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF0000")));
            }else {
                deliveryIndicator.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3EB255")));
            }

            /*Rating Layout*/

            setRating(rating);

            for (int x = 0;x<rateNowContainer.getChildCount();x++){
                final int startPosition = x;
                rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(startPosition);
                    }
                });
            }
            /*Rating Layout*/
        }
        private void setRating(int startPosition) {
            for (int x = 0;x<rateNowContainer.getChildCount();x++){
                ImageView startBtn = (ImageView)rateNowContainer.getChildAt(x);
                startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                if (x <= startPosition){
                    startBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
                }
            }
        }
    }
}
