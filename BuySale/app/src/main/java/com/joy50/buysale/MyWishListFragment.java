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
public class MyWishListFragment extends Fragment {

    public MyWishListFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishListRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wish_list, container, false);
        wishListRecyclerView = view.findViewById(R.id.mywish_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        wishListRecyclerView.setLayoutManager(layoutManager);

        List<MyWishListModel> listModelList = new ArrayList<>();
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));
        listModelList.add(new MyWishListModel(R.drawable.iphone11pro,"Iphone 11 S pro",2,"4.5","5200", "$ 1099","$ 2000","Cash On Delivery Available"));

        MyWishListAdapter wishListAdapter = new MyWishListAdapter(listModelList,true);
        wishListRecyclerView.setAdapter(wishListAdapter);
        wishListAdapter.notifyDataSetChanged();
        return view;
    }
}
