package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerview;
    private Button changeOrAddNewAddressButton;
    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerview = findViewById(R.id.deliverey_recyclerview);
        changeOrAddNewAddressButton = findViewById(R.id.change_or_add_address_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        deliveryRecyclerview.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));
        cartItemModelList.add(new CartItemModel(0,R.drawable.iphone11pro,"Iphone 11 Pro",1,"1099","2000",2,1,1));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        changeOrAddNewAddressButton.setVisibility(View.VISIBLE);
        cartAdapter.notifyDataSetChanged();

        changeOrAddNewAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo:
                Intent addressesIntent = new Intent(getApplicationContext(),MyAddressesActivity.class);
                addressesIntent.putExtra("Type",SELECT_ADDRESS);
                startActivity(addressesIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
