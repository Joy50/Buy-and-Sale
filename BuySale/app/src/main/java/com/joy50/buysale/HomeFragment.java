package com.joy50.buysale;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView catagoryRecyclerView;
    private CatagoryAdapter catagoryAdapter;
    private RecyclerView homePageRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        catagoryRecyclerView = view.findViewById(R.id.catagory_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        catagoryRecyclerView.setLayoutManager(layoutManager);
        List<CatagoryModel> catagoryModelsList = new ArrayList<CatagoryModel>();
        catagoryModelsList.add(new CatagoryModel("link","Home"));
        catagoryModelsList.add(new CatagoryModel("link","Electronics"));
        catagoryModelsList.add(new CatagoryModel("link","Appliances"));
        catagoryModelsList.add(new CatagoryModel("link","Furniture"));
        catagoryModelsList.add(new CatagoryModel("link","Fashion"));
        catagoryModelsList.add(new CatagoryModel("link","Toys"));
        catagoryModelsList.add(new CatagoryModel("link","Sports"));
        catagoryModelsList.add(new CatagoryModel("link","Wall Arts"));
        catagoryModelsList.add(new CatagoryModel("link","Books"));
        catagoryModelsList.add(new CatagoryModel("link","Shoes"));

        catagoryAdapter = new CatagoryAdapter(catagoryModelsList);
        catagoryAdapter.notifyDataSetChanged();
        catagoryRecyclerView.setAdapter(catagoryAdapter);

        /*bannerSlider*/
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#000000"));

        /*Banner Add layout*/

        /*Horizontal Product View*/
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
        /*Horizontal Product View*/

        /*RecyclerView Testing*/
        homePageRecyclerView = view.findViewById(R.id.homePageRecyclerview);
        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(getContext());
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLinearLayout);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day",horizontal_product_scroll_models_list));
        homePageModelList.add(new HomePageModel(3,"New Collction",horizontal_product_scroll_models_list));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);

        homePageRecyclerView.setAdapter(homePageAdapter);
        /*RecyclerView Testing*/
        return view;
    }
}
