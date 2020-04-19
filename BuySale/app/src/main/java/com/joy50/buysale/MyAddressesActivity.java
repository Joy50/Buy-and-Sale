package com.joy50.buysale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.joy50.buysale.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    RecyclerView addressRecyclerview;
    private static AddressesAdapter addressesAdapter;
    private Button deliverHereBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addressRecyclerview = findViewById(R.id.addresses_recycler_view);
        deliverHereBtn = findViewById(R.id.deliver_here_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        addressRecyclerview.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",true));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));
        addressesModelList.add(new AddressesModel("MD MAHMUDUL HAQUE JOY", "994 Dhap kotkipara Rangpur", "5400",false));

        int TYPE_DATA = getIntent().getIntExtra("Type",-1);

        if(TYPE_DATA == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else {
            deliverHereBtn.setVisibility(View.GONE);
        }

        addressesAdapter = new AddressesAdapter(addressesModelList,TYPE_DATA);
        addressRecyclerview.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)addressRecyclerview.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect, int select) {
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
