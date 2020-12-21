package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView viewAllRecyclerView;
    private GridView viewAllGridView;
    public static List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list;
    public static List<MyWishListModel> wishlistModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewAllRecyclerView = findViewById(R.id.recyclerview);
        viewAllGridView = findViewById(R.id.gridview);

        int getType = getIntent().getIntExtra("Type", -1);

        if (getType == 0) {
            viewAllRecyclerView.setVisibility(View.VISIBLE);
            viewAllGridView.setVisibility(View.GONE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            viewAllRecyclerView.setLayoutManager(layoutManager);
            MyWishListAdapter wishListAdapter = new MyWishListAdapter(wishlistModelList, false);
            viewAllRecyclerView.setAdapter(wishListAdapter);
            wishListAdapter.notifyDataSetChanged();
        } else if (getType == 1) {
            viewAllGridView.setVisibility(View.VISIBLE);
            GridProductViewAdapter gridProductViewAdapter = new GridProductViewAdapter(horizontal_product_scroll_models_list);
            viewAllGridView.setAdapter(gridProductViewAdapter);
            gridProductViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
