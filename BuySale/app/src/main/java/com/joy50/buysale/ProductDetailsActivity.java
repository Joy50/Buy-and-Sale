package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton addToWishListButton;
    private boolean alreadyAddedToWishList = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewPagerIndicator = findViewById(R.id.viewpagerindicator);
        addToWishListButton = findViewById(R.id.addtowishlistbutton);

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
