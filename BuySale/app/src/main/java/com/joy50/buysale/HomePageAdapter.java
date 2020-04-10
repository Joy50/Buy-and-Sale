package com.joy50.buysale;

import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> modelList;

    public HomePageAdapter(List<HomePageModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modelList.get(position).getType()) {
            case 0:
                return HomePageModel.BannerSlider;
            case 1:
                return HomePageModel.StripAddBanner;
            case 2:
                return HomePageModel.HorizontalProductView;
            case 3:
                return HomePageModel.GridProductView;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case HomePageModel.BannerSlider:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_add_banner, parent, false);
                return new BannerSliderViewHolder(bannerSliderView);
            case HomePageModel.StripAddBanner:
                View stripAddView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_add_layout, parent, false);
                return new StripAddViewHolder(stripAddView);
            case HomePageModel.HorizontalProductView:
                View horizontalProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_layout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            case HomePageModel.GridProductView:
                View gridProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout, parent, false);
                return new GridProductViewHolder(gridProductView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (modelList.get(position).getType()) {
            case HomePageModel.BannerSlider:
                List<SliderModel> sliderModelList = modelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) holder).setBannerSliderviewPager(sliderModelList);
                break;
            case HomePageModel.StripAddBanner:
                int resource = modelList.get(position).getResource();
                String bgcolor = modelList.get(position).getBgColor();
                ((StripAddViewHolder)holder).SetStripAdd(resource,bgcolor);
                break;
            case HomePageModel.HorizontalProductView:
                //Todo:abc
                String Title = modelList.get(position).getTitle();
                List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList = modelList.get(position).getHorizontalProductScrollModelList();
                ((HorizontalProductViewHolder)holder).setHorizontalProductLayout(horizontalProductScrollModelList,Title );
                break;
            case HomePageModel.GridProductView:
                String gridTitle = modelList.get(position).getTitle();
                List<Horizontal_Product_Scroll_Model> gridProductScrollModelList = modelList.get(position).getHorizontalProductScrollModelList();
                ((GridProductViewHolder)holder).setGridProductLayout(gridProductScrollModelList,gridTitle );
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderviewPager;
        private int currentPage = 2;
        private Timer timer;
        private final long DELAY_TIME = 3000;
        private final long PERIOD_TIME = 3000;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderviewPager = itemView.findViewById(R.id.banerSliderViewPager);

        }

        private void setBannerSliderviewPager(final List<SliderModel> sliderModelList) {
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
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        PageLooper(sliderModelList);
                    }
                }
            };

            startbannerSliderShow(sliderModelList);

            bannerSliderviewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    PageLooper(sliderModelList);
                    stopbannerSlideShow();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerSliderShow(sliderModelList);
                    }
                    return false;
                }
            });
        }

        private void PageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannerSliderviewPager.setCurrentItem(currentPage, false);
            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannerSliderviewPager.setCurrentItem(currentPage, false);
            }
        }

        private void startbannerSliderShow(final List<SliderModel> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannerSliderviewPager.setCurrentItem(currentPage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopbannerSlideShow() {
            timer.cancel();
        }
    }

    public class StripAddViewHolder extends RecyclerView.ViewHolder {

        private ImageView stripImage;
        private ConstraintLayout stripAddContainer;

        public StripAddViewHolder(@NonNull View itemView) {
            super(itemView);
            stripImage = itemView.findViewById(R.id.strip_add_image);
            stripAddContainer = itemView.findViewById(R.id.strip_add_container);
        }

        private void SetStripAdd(int resource, String color) {
            stripImage.setImageResource(resource);
            stripAddContainer.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder{

        private TextView horizontalLayoutTitle;
        private Button horizontalViewAll;
        private RecyclerView horizontalProductRecyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalViewAll = itemView.findViewById(R.id.horizontal_scroll_layout_button);
            horizontalProductRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recyclerView);
        }
        private void setHorizontalProductLayout(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list,String title){

            horizontalLayoutTitle.setText(title);
            if (horizontal_product_scroll_models_list.size()>8){
                horizontalViewAll.setVisibility(View.VISIBLE);
            }else {
                horizontalViewAll.setVisibility(View.INVISIBLE);
            }

            Horizontal_product_Scroll_Adapter horizontal_product_scroll_adapter = new Horizontal_product_Scroll_Adapter(horizontal_product_scroll_models_list);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(itemView.getContext());
            layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalProductRecyclerView.setLayoutManager(layoutManager1);
            horizontalProductRecyclerView.setAdapter(horizontal_product_scroll_adapter);
            horizontal_product_scroll_adapter.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder{

        private TextView gridProductTitle;
        private Button gridProductViewAllButton;
        private GridView gridProductView;

        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridProductTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridProductViewAllButton = itemView.findViewById(R.id.grid_product_layout_view_all_button);
            gridProductView = itemView.findViewById(R.id.grid_product_layout_gridview);
        }
        private void setGridProductLayout(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list,String title){
            gridProductTitle.setText(title);
            gridProductView.setAdapter(new GridProductViewAdapter(horizontal_product_scroll_models_list));
        }
    }
}
