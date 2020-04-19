package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton addToWishListButton;
    private boolean alreadyAddedToWishList = false;

    private ViewPager productDetailsViewPager;
    private TabLayout productDetailsTabLayout;
    private Button buyNow;

    /*Rating Layout*/
    private LinearLayout rateNowContainer;
    /*Rating Layout*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewPagerIndicator = findViewById(R.id.viewpagerindicator);
        addToWishListButton = findViewById(R.id.addtowishlistbutton);
        productDetailsViewPager = findViewById(R.id.product_details_viewpager);
        productDetailsTabLayout = findViewById(R.id.product_details_tab_layout);
        buyNow = findViewById(R.id.buy_now_button);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.iphone11pro);
        productImages.add(R.drawable.iphone11pro);
        productImages.add(R.drawable.iphone11pro);
        productImages.add(R.drawable.iphone11pro);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewPagerIndicator.setupWithViewPager(productImagesViewPager,true);

        addToWishListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (alreadyAddedToWishList){
                    //Todo:change color & remove from wishlist
                    alreadyAddedToWishList = false;
                    addToWishListButton.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else {
                    //Todo:
                    alreadyAddedToWishList = true;
                    addToWishListButton.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
                }
            }
        });

        ProductDetailsAdapter adapter = new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTabLayout.getTabCount());
        productDetailsViewPager.setAdapter(adapter);
        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*Rating Layout*/
        rateNowContainer = findViewById(R.id.rate_now_container);

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

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DeliveryActivity.class));
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.productdetailsmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id  = item.getItemId();

        if(id==R.id.product_search_icon){
            //Todo:Search
            return true;
        }else if (id==R.id.product_add_cart){
            //Todo:Add to Cart
            return true;
        }else if (id == android.R.id.home){
            //Todo: returen to home
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
