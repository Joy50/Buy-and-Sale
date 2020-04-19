package com.joy50.buysale;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> modelList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> modelList) {
        this.modelList = modelList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
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
                ((StripAddViewHolder) holder).SetStripAdd(resource, bgcolor);
                break;
            case HomePageModel.HorizontalProductView:
                //Todo:abc
                String Title = modelList.get(position).getTitle();
                List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList = modelList.get(position).getHorizontalProductScrollModelList();
                ((HorizontalProductViewHolder) holder).setHorizontalProductLayout(horizontalProductScrollModelList, Title);
                break;
            case HomePageModel.GridProductView:
                String gridTitle = modelList.get(position).getTitle();
                List<Horizontal_Product_Scroll_Model> gridProductScrollModelList = modelList.get(position).getHorizontalProductScrollModelList();
                ((GridProductViewHolder) holder).setGridProductLayout(gridProductScrollModelList, gridTitle);
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
        private int currentPage;
        private Timer timer;
        private final long DELAY_TIME = 3000;
        private final long PERIOD_TIME = 3000;
        private List<SliderModel> arrangedList;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderviewPager = itemView.findViewById(R.id.banerSliderViewPager);

        }

        private void setBannerSliderviewPager(final List<SliderModel> sliderModelList) {

            currentPage = 2;
            if (timer != null) {
                timer.cancel();
            }

            arrangedList = new ArrayList<>();
            for (int x = 0; x < sliderModelList.size(); x++) {
                arrangedList.add(x, sliderModelList.get(x));
            }

            arrangedList.add(0,sliderModelList.get(sliderModelList.size()-2));
            arrangedList.add(1,sliderModelList.get(sliderModelList.size()-1));

            arrangedList.add(sliderModelList.get(0));
            arrangedList.add(sliderModelList.get(1));

            SliderAdapter sliderAdapter = new SliderAdapter(arrangedList);
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
                        PageLooper(arrangedList);
                    }
                }
            };

            startbannerSliderShow(sliderModelList);

            bannerSliderviewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    PageLooper(arrangedList);
                    stopbannerSlideShow();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerSliderShow(arrangedList);
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
                    if (currentPage >= arrangedList.size()) {
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

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {

        private TextView horizontalLayoutTitle;
        private Button horizontalViewAll;
        private RecyclerView horizontalProductRecyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalViewAll = itemView.findViewById(R.id.horizontal_scroll_layout_button);
            horizontalProductRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recyclerView);
            horizontalProductRecyclerView.setRecycledViewPool(recycledViewPool);
        }

        private void setHorizontalProductLayout(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list, String title) {

            horizontalLayoutTitle.setText(title);
            if (horizontal_product_scroll_models_list.size() > 8) {
                horizontalViewAll.setVisibility(View.VISIBLE);
                horizontalViewAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent viewAllIntent = new Intent(itemView.getContext(), ViewAllActivity.class);
                        viewAllIntent.putExtra("Type", 0);
                        itemView.getContext().startActivity(viewAllIntent);
                    }
                });
            } else {
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

    public class GridProductViewHolder extends RecyclerView.ViewHolder {

        private TextView gridProductTitle;
        private Button gridProductViewAllButton;
        private GridLayout gridLayout;

        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
            gridProductTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridProductViewAllButton = itemView.findViewById(R.id.grid_product_layout_view_all_button);
            gridLayout = itemView.findViewById(R.id.gridLayout);
        }

        private void setGridProductLayout(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list, String title) {
            gridProductTitle.setText(title);

            for (int x = 0; x < 4; x++) {
                ImageView productImage = gridLayout.getChildAt(x).findViewById(R.id.h_s_product_image);
                TextView producttitle = gridLayout.getChildAt(x).findViewById(R.id.h_s_product_title);
                TextView productDes = gridLayout.getChildAt(x).findViewById(R.id.h_s_product_description);
                TextView productPrice = gridLayout.getChildAt(x).findViewById(R.id.h_s_product_price);

                productImage.setImageResource(horizontal_product_scroll_models_list.get(x).getProductImage());
                producttitle.setText(horizontal_product_scroll_models_list.get(x).getProductTitle());
                productPrice.setText(horizontal_product_scroll_models_list.get(x).getPrductPrice());
                productDes.setText(horizontal_product_scroll_models_list.get(x).getProductDes());

                gridLayout.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), DeliveryActivity.class));
                    }
                });
            }

            gridProductViewAllButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewAllIntent = new Intent(itemView.getContext(), ViewAllActivity.class);
                    viewAllIntent.putExtra("Type", 1);
                    itemView.getContext().startActivity(viewAllIntent);
                }
            });
        }
    }
}
