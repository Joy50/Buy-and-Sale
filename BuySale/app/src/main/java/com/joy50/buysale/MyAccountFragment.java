package com.joy50.buysale;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {

    public MyAccountFragment() {
        // Required empty public constructor
    }

    public static final int MANAGE_ADDRESS = 1;
    private Button viewAllBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        viewAllBtn = view.findViewById(R.id.my_address_view_all);
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressIntent = new Intent(view.getContext(),MyAddressesActivity.class);
                myAddressIntent.putExtra("Type",MANAGE_ADDRESS);
                startActivity(myAddressIntent);
            }
        });
        return view;
    }
}
