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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the day");
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

            List<MyWishListModel> listModelList = new ArrayList<>();
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));
            listModelList.add(new MyWishListModel(R.drawable.iphone11pro, "Iphone 11 S pro", 2, "4.5", "5200", "$ 1099", "$ 2000", "Cash On Delivery Available"));

            MyWishListAdapter wishListAdapter = new MyWishListAdapter(listModelList, false);
            viewAllRecyclerView.setAdapter(wishListAdapter);
            wishListAdapter.notifyDataSetChanged();
        } else if (getType == 1) {
            viewAllGridView.setVisibility(View.VISIBLE);

            List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list = new ArrayList<>();
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));
            horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro, "I Phone", "A2215 (Global market)", "$1099"));

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
