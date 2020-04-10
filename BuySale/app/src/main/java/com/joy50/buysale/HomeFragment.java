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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    /*bannerSlider*/
    private ViewPager bannerSliderviewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    private final long DELAY_TIME = 3000;
    private final long PERIOD_TIME = 3000;

    /*Strip Add Layout*/
    private ImageView stripImage;
    private ConstraintLayout stripAddContainer;

    /*Horizontal Scroll Layout*/
    private TextView horizontalLayoutTitle;
    private Button horizontalViewAll;
    private RecyclerView horizontalProductRecyclerView;


    /*Grid Product Layout*/
    private TextView gridProductTitle;
    private Button gridProductViewAllButton;
    private GridView gridProductView;


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
        bannerSliderviewPager = view.findViewById(R.id.banerSliderViewPager);
        sliderModelList = new ArrayList<SliderModel>();

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

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderviewPager.setClipToPadding(false);
        bannerSliderviewPager.setPageMargin(20);
        bannerSliderviewPager.setCurrentItem(currentPage);
        bannerSliderviewPager.setAdapter(sliderAdapter);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    PageLooper();
                }
            }
        };

        startbannerSliderShow();

        bannerSliderviewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                PageLooper();
                stopbannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startbannerSliderShow();
                }
                return false;
            }
        });
        /*Banner Add layout*/
        /*Strip Add Layout*/
        stripImage = view.findViewById(R.id.strip_add_image);
        stripAddContainer = view.findViewById(R.id.strip_add_container);
        stripImage.setImageResource(R.drawable.banner);
        stripAddContainer.setBackgroundColor(Color.parseColor("#000000"));
        /*Strip Add Layout*/


        /*Horizontal Product View*/
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalViewAll = view.findViewById(R.id.horizontal_scroll_layout_button);
        horizontalProductRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerView);

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

        Horizontal_product_Scroll_Adapter horizontal_product_scroll_adapter = new Horizontal_product_Scroll_Adapter(horizontal_product_scroll_models_list);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalProductRecyclerView.setLayoutManager(layoutManager1);
        horizontalProductRecyclerView.setAdapter(horizontal_product_scroll_adapter);
        horizontal_product_scroll_adapter.notifyDataSetChanged();
        /*Horizontal Product View*/

        /*Grid Product Layout*/

        gridProductTitle = view.findViewById(R.id.grid_product_layout_title);
        gridProductViewAllButton = view.findViewById(R.id.grid_product_layout_view_all_button);
        gridProductView = view.findViewById(R.id.grid_product_layout_gridview);

        gridProductView.setAdapter(new GridProductViewAdapter(horizontal_product_scroll_models_list));
        /*Grid Product Layout*/

        /*RecyclerView Testing*/
        RecyclerView testingRecyclerView = view.findViewById(R.id.testing);
        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(getContext());
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        testingRecyclerView.setLayoutManager(testingLinearLayout);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day",horizontal_product_scroll_models_list));
        homePageModelList.add(new HomePageModel(3,"New Collction",horizontal_product_scroll_models_list));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);

        testingRecyclerView.setAdapter(homePageAdapter);
        /*RecyclerView Testing*/
        return view;
    }

    /*Banner Add Layout*/
    private void PageLooper(){
        if (currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderviewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderviewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startbannerSliderShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderviewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopbannerSlideShow(){
        timer.cancel();
    }
    /*Banner Add Layout*/
}
