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
public class MyCartFragment extends Fragment {

    private RecyclerView carts;

    public MyCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        carts = view.findViewById(R.id.cart_items_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        carts.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        carts.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return view;
    }
}
