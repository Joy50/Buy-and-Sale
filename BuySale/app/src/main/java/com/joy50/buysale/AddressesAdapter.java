package com.joy50.buysale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.joy50.buysale.DeliveryActivity.SELECT_ADDRESS;
import static com.joy50.buysale.MyAccountFragment.MANAGE_ADDRESS;
import static com.joy50.buysale.MyAddressesActivity.refreshItem;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    List<AddressesModel> addressesModelList;
    private int TYPE;
    private int preSelectedPosition = -1;

    public AddressesAdapter(List<AddressesModel> addressesModelList, int TYPE) {
        this.addressesModelList = addressesModelList;
        this.TYPE = TYPE;
    }

    @NonNull
    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addresses_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.ViewHolder holder, int position) {

        String name = addressesModelList.get(position).getFullName();
        String address = addressesModelList.get(position).getAddress();
        String pin = addressesModelList.get(position).getPincode();
        boolean selecteddata = addressesModelList.get(position).isSelected();
        ((ViewHolder) holder).setInfo(name, address, pin, selecteddata, position);
    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private TextView userAddress;
        private TextView userPincode;
        private ImageView icon;
        private LinearLayout opTionsContainerLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.full_name);
            userAddress = itemView.findViewById(R.id.address);
            userPincode = itemView.findViewById(R.id.pincode);
            icon = itemView.findViewById(R.id.iconview);
            opTionsContainerLayout = itemView.findViewById(R.id.option_container);
        }

        private void setInfo(String name, String address, final String pin, boolean selectedStatus, final int position) {
            userName.setText(name);
            userAddress.setText(address);
            userPincode.setText(pin);

            if (TYPE == SELECT_ADDRESS) {
                icon.setImageResource(R.drawable.yes_foreground);
                if (selectedStatus) {
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPosition = position;
                } else {
                    icon.setVisibility(View.GONE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (preSelectedPosition != position) {
                            addressesModelList.get(position).setSelected(true);
                            addressesModelList.get(preSelectedPosition).setSelected(false);
                            refreshItem(preSelectedPosition, position);
                            preSelectedPosition = position;
                        }
                    }
                });
            } else if (TYPE == MANAGE_ADDRESS) {
                opTionsContainerLayout.setVisibility(View.GONE);
                icon.setImageResource(R.drawable.vdot_foreground);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opTionsContainerLayout.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPosition, preSelectedPosition);
                        preSelectedPosition = position;
                    }
                });
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshItem(preSelectedPosition, preSelectedPosition);
                        preSelectedPosition = -1;
                    }
                });
            }
        }
    }
}
