package com.joy50.buysale;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static com.joy50.buysale.DatabaseQuary.catagoryModelsList;
import static com.joy50.buysale.DatabaseQuary.lists;
import static com.joy50.buysale.DatabaseQuary.loadCatagories;
import static com.joy50.buysale.DatabaseQuary.loadedCatagoryNames;
import static com.joy50.buysale.DatabaseQuary.setFragmentData;


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
    private HomePageAdapter homePageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        catagoryRecyclerView = view.findViewById(R.id.catagory_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        catagoryRecyclerView.setLayoutManager(layoutManager);
        catagoryAdapter = new CatagoryAdapter(catagoryModelsList);
        if (catagoryModelsList.size() == 0){
            loadCatagories(catagoryAdapter,getContext());
        }else {
            catagoryAdapter.notifyDataSetChanged();
        }
        catagoryRecyclerView.setAdapter(catagoryAdapter);
        /*RecyclerView Testing*/
        homePageRecyclerView = view.findViewById(R.id.homePageRecyclerview);
        LinearLayoutManager testingLinearLayout = new LinearLayoutManager(getContext());
        testingLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLinearLayout);
        if (lists.size()==0){
            loadedCatagoryNames.add("Home");
            lists.add(new ArrayList<HomePageModel>());
            homePageAdapter = new HomePageAdapter(lists.get(0));
            DatabaseQuary.setFragmentData(homePageAdapter,getContext(),0,"HOME");
        }else {
            homePageAdapter = new HomePageAdapter(lists.get(0));
            homePageAdapter.notifyDataSetChanged();
        }
        homePageRecyclerView.setAdapter(homePageAdapter);
        /*RecyclerView Testing*/
        return view;
    }
}
