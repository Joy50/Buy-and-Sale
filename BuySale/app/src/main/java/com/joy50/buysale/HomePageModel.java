package com.joy50.buysale;

import java.util.List;

public class HomePageModel {

    public static final int BannerSlider = 0;
    public static final int StripAddBanner = 1;
    public static final int HorizontalProductView = 2;
    public static final int GridProductView = 3;
    private int type;
    /*Banner Slider*/
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    /*Banner Slider*/

    /*Strip Add Layout*/
    private int resource;
    private String bgColor;

    public HomePageModel(int type, int resource, String bgColor) {
        this.type = type;
        this.resource = resource;
        this.bgColor = bgColor;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    /*Strip Add Layout*/

    /*Horizontal Scroll Layout*/
    private String title;
    private List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList;

    public HomePageModel(int type, String title, List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Horizontal_Product_Scroll_Model> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }

    public void setHorizontalProductScrollModelList(List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    /*Horizontal Scroll Layout*/

    /*Grid Product View*/
    //Todo:Same as Horizontal Scroll Layout
}
