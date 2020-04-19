package com.joy50.buysale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    List<AddressesModel> addressesModelList;

    public AddressesAdapter(List<AddressesModel> addressesModelList) {
        this.addressesModelList = addressesModelList;
    }

    @NonNull
    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addresses_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.ViewHolder holder, int position) {

        String name = addressesModelList.get(position).getFullName();
        String address = addressesModelList.get(position).getAddress();
        String pin = addressesModelList.get(position).getPincode();
        ((ViewHolder)holder).setInfo(name,address,pin);
    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView userAddress;
        TextView userPincode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.full_name);
            userAddress = itemView.findViewById(R.id.address);
            userPincode = itemView.findViewById(R.id.pincode);
        }
        private void setInfo(String name,String address,String pin){
            userName.setText(name);
            userAddress.setText(address);
            userPincode.setText(pin);
        }
    }
}
