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


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRewardsFragment extends Fragment {

    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView myRewardRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);
        myRewardRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRewardRecyclerView.setLayoutManager(layoutManager);

        List<MyRewardsModel> myRewardsModelList = new ArrayList<>();
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));
        myRewardsModelList.add(new MyRewardsModel("Get 20% OFF on any product above $ 100 below $ 1000.","1 May 2020"));

        MyRewardsAdapter rewardsAdapter = new MyRewardsAdapter(myRewardsModelList);
        myRewardRecyclerView.setAdapter(rewardsAdapter);
        rewardsAdapter.notifyDataSetChanged();
        return view;
    }
}
