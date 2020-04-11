package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatagoryActivity extends AppCompatActivity {

    private RecyclerView catagoryRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        String title = getIntent().getStringExtra("CatagoryName");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        catagoryRecyclerview = findViewById(R.id.catagoryRecyclerView);

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));

        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));

        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));

        List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list = new ArrayList<>();
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));
        horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(R.drawable.iphone11pro,"I Phone","A2215 (Global market)","$1099"));

        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(this);
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        catagoryRecyclerview.setLayoutManager(testingLinearLayout);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day",horizontal_product_scroll_models_list));
        homePageModelList.add(new HomePageModel(3,"New Collction",horizontal_product_scroll_models_list));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);

        catagoryRecyclerview.setAdapter(homePageAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.main_search_icon){
            //todo:Need a search Activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
