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

import static com.joy50.buysale.DatabaseQuary.catagoryModelsList;
import static com.joy50.buysale.DatabaseQuary.firebaseFirestore;
import static com.joy50.buysale.DatabaseQuary.homePageModelList;
import static com.joy50.buysale.DatabaseQuary.loadCatagories;
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
        homePageAdapter = new HomePageAdapter(homePageModelList);
        if (homePageModelList.size()==0){
            setFragmentData(homePageAdapter,getContext());
        }else {
            homePageAdapter.notifyDataSetChanged();
        }
        homePageRecyclerView.setAdapter(homePageAdapter);
        /*RecyclerView Testing*/
        return view;
    }
}
