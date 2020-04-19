package com.joy50.buysale;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyWishListAdapter extends RecyclerView.Adapter<MyWishListAdapter.ViewHolder> {

    private List<MyWishListModel> myWishListModelList;
    private boolean wishlist;

    public MyWishListAdapter(List<MyWishListModel> myWishListModelList,boolean wishlist) {
        this.myWishListModelList = myWishListModelList;
        this.wishlist = wishlist;
    }

    @NonNull
    @Override
    public MyWishListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mywishlist_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyWishListAdapter.ViewHolder holder, int position) {

        int imageResource = myWishListModelList.get(position).getProductImage();
        String title = myWishListModelList.get(position).getProductTitle();
        int freeCupon = myWishListModelList.get(position).getFreeCuponsAvailable();
        String ratinginfo = myWishListModelList.get(position).getRating();
        String numOfRating = myWishListModelList.get(position).getTotalRating();
        String price = myWishListModelList.get(position).getProductPrice();
        String cuttedPriceInfo = myWishListModelList.get(position).getCuttedPrice();
        String paymentInfo = myWishListModelList.get(position).getPaymentMethod();

        ((ViewHolder)holder).setWishList(imageResource,title,freeCupon,ratinginfo,numOfRating,price,cuttedPriceInfo,paymentInfo);
    }

    @Override
    public int getItemCount() {
        return myWishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCuponsAvailable;
        private ImageView freeCuponIcon;
        private TextView rating;
        private TextView totalRating;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageView removeButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.wish_list_product_image);
            productTitle = itemView.findViewById(R.id.wish_list_product_title);
            freeCuponsAvailable = itemView.findViewById(R.id.wish_list_free_cupons_available);
            freeCuponIcon = itemView.findViewById(R.id.wish_list_cupon_image);
            rating = itemView.findViewById(R.id.tv_product_ratining_mini_view);
            totalRating = itemView.findViewById(R.id.wish_list_number_of_ratings);
            productPrice = itemView.findViewById(R.id.wish_list_product_price);
            cuttedPrice = itemView.findViewById(R.id.wish_list_cutted_price);
            paymentMethod = itemView.findViewById(R.id.wish_list_payment_method);
            removeButton = itemView.findViewById(R.id.wish_list_remove_button);
        }
        private void setWishList(int imageResource,String title,int freeCupon,String ratinginfo,String numOfRating,String price,
                                 String cuttedPriceInfo,String paymentInfo){
            productImage.setImageResource(imageResource);
            productTitle.setText(title);
            if (freeCupon > 0){
                freeCuponIcon.setVisibility(View.VISIBLE);
                freeCuponsAvailable.setVisibility(View.VISIBLE);
                if (freeCupon == 1){
                    freeCuponsAvailable.setText("free "+freeCupon+" Cupon");
                }else {
                    freeCuponsAvailable.setText("free "+freeCupon+"Cupons");
                }
            }else {
                freeCuponIcon.setVisibility(View.INVISIBLE);
                freeCuponsAvailable.setVisibility(View.INVISIBLE);
            }
            rating.setText(ratinginfo);
            totalRating.setText(numOfRating);
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceInfo);
            paymentMethod.setText(paymentInfo);

            if(wishlist){
                removeButton.setVisibility(View.VISIBLE);
                removeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Todo: Have to remove
                        Toast.makeText(itemView.getContext(),"On going process",Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                removeButton.setVisibility(View.GONE);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(),ProductDetailsActivity.class));
                }
            });
        }
    }
}
