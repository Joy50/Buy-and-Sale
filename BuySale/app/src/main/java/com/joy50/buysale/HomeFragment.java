package com.joy50.buysale;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


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
    private List<CatagoryModel> catagoryModelsList;
    private FirebaseFirestore imageCatagoryFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        catagoryRecyclerView = view.findViewById(R.id.catagory_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        catagoryRecyclerView.setLayoutManager(layoutManager);

        catagoryModelsList = new ArrayList<CatagoryModel>();
        catagoryAdapter = new CatagoryAdapter(catagoryModelsList);
        catagoryRecyclerView.setAdapter(catagoryAdapter);
        imageCatagoryFirestore = FirebaseFirestore.getInstance();
        imageCatagoryFirestore.collection("catagories").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
                        String link = documentSnapshots.get("icon").toString();
                        String name = documentSnapshots.get("catagoryName").toString();
                        catagoryModelsList.add(new CatagoryModel(link,name));
                        Toast.makeText(getContext(),"Working",Toast.LENGTH_SHORT).show();
                    }
                    catagoryAdapter.notifyDataSetChanged();
                } else {
                    String error = task.getException().getMessage();
                    Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*bannerSlider*/
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#000000"));

        /*Banner Add layout*/

        /*Horizontal Product View*/
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
        /*Horizontal Product View*/

        /*RecyclerView Testing*/
        homePageRecyclerView = view.findViewById(R.id.homePageRecyclerview);
        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(getContext());
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLinearLayout);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.banner, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontal_product_scroll_models_list));
        homePageModelList.add(new HomePageModel(3, "New Collction", horizontal_product_scroll_models_list));
        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);

        homePageRecyclerView.setAdapter(homePageAdapter);
        /*RecyclerView Testing*/
        return view;
    }
}
