package com.joy50.buysale;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuary {

    public static FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    public static List<CatagoryModel> catagoryModelsList = new ArrayList<>();
    //public static List<HomePageModel> homePageModelList = new ArrayList<>();
    public static List<List<HomePageModel>> lists = new ArrayList<>();
    public static List<String> loadedCatagoryNames = new ArrayList<>();

    public static void loadCatagories(final CatagoryAdapter catagoryAdapter, final Context context){
        firebaseFirestore.collection("catagories").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
                        String link = documentSnapshots.get("icon").toString();
                        String name = documentSnapshots.get("catagoryName").toString();
                        catagoryModelsList.add(new CatagoryModel(link,name));
                    }
                    catagoryAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void setFragmentData(final HomePageAdapter homePageAdapter, final Context context,final int index,String catagoryName){
        firebaseFirestore.collection("catagories").document(catagoryName.toUpperCase()).
                collection("TOP_DEALS").orderBy("index").
                get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
                        if(Integer.parseInt(documentSnapshots.get("view_type").toString())==0){
                            int no_of_banners = Integer.valueOf(documentSnapshots.get("num_of_banners").toString());
                            List<SliderModel> sliderModelList = new ArrayList<>();
                            for (int i = 1;i<=no_of_banners;i++){
                                sliderModelList.add(new SliderModel(documentSnapshots.get("banner_"+i).toString(),
                                        documentSnapshots.get("banner_"+i+"_background").toString()));
                            }
                            lists.get(index).add(new HomePageModel(0,sliderModelList));

                        }else if(Integer.parseInt(documentSnapshots.get("view_type").toString())==1){
                            lists.get(index).add(new HomePageModel(1,documentSnapshots.get("strip_ad_banner").toString(),
                                    documentSnapshots.get("background").toString()));
                        }else if(Integer.parseInt(documentSnapshots.get("view_type").toString())==2){
                            List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_models_list = new ArrayList<>();
                            ViewAllActivity.wishlistModelList = new ArrayList<>();
                            int no_of_products = Integer.valueOf(documentSnapshots.get("num_of_product").toString());
                            String title = documentSnapshots.get("layout_title").toString();
                            for (int i = 1;i<=no_of_products;i++){
                                horizontal_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(
                                        String.valueOf(i),
                                        documentSnapshots.get("product_"+i).toString(),
                                        documentSnapshots.get("product_title_"+i).toString(),
                                        documentSnapshots.get("product_subtitle_"+i).toString(),
                                        documentSnapshots.get("product_price_"+i).toString()
                                ));
                                ViewAllActivity.wishlistModelList.add(new MyWishListModel(
                                        documentSnapshots.get("product_"+i).toString(),
                                        documentSnapshots.get("product_full_title_"+i).toString(),
                                        Long.parseLong(documentSnapshots.get("free_cupons_"+i).toString()),
                                        documentSnapshots.get("average_rating_"+i).toString(),
                                        Long.parseLong(documentSnapshots.get("total_rating_"+i).toString()),
                                        documentSnapshots.get("product_price_"+i).toString(),
                                        documentSnapshots.get("cutted_price_"+i).toString(),
                                        Boolean.parseBoolean(documentSnapshots.get("COD_"+i).toString())
                                ));
                            }
                            lists.get(index).add(new HomePageModel(2,title,horizontal_product_scroll_models_list,ViewAllActivity.wishlistModelList));
                        }else if(Integer.parseInt(documentSnapshots.get("view_type").toString())==3){
                            List<Horizontal_Product_Scroll_Model> grid_product_scroll_models_list = new ArrayList<>();
                            int no_of_products = Integer.valueOf(documentSnapshots.get("num_of_product").toString());
                            String title = documentSnapshots.get("layout_title").toString();
                            for (int i = 1;i<=no_of_products;i++){
                                grid_product_scroll_models_list.add(new Horizontal_Product_Scroll_Model(
                                        String.valueOf(i),
                                        documentSnapshots.get("product_"+i).toString(),
                                        documentSnapshots.get("product_title_"+i).toString(),
                                        documentSnapshots.get("product_subtitle_"+i).toString(),
                                        documentSnapshots.get("product_price_"+i).toString()
                                ));
                            }
                            lists.get(index).add(new HomePageModel(3,title,grid_product_scroll_models_list));
                        }
                    }
                    homePageAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
