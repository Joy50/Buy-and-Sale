package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity {

    RecyclerView addressRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addressRecyclerview = findViewById(R.id.addresses_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        addressRecyclerview.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY","994 Dhap kotkipara Rangpur","5400"));

        AddressesAdapter addressesAdapter = new AddressesAdapter(addressesModelList);
        addressRecyclerview.setAdapter(addressesAdapter);
        addressesAdapter.notifyDataSetChanged();
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
