package com.joy50.buysale;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.ViewHolder> {
    private List<CatagoryModel> catagoryModelList;

    public CatagoryAdapter(List<CatagoryModel> catagoryModelList) {
        this.catagoryModelList = catagoryModelList;
    }


    @NonNull
    @Override
    public CatagoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryAdapter.ViewHolder holder, int position) {

        String icon = catagoryModelList.get(position).getCatagoryIconLink();
        String name = catagoryModelList.get(position).getCatagoryName();
        holder.setCatagoryName(name);
        holder.setCatagoryIcon(icon);
    }

    @Override
    public int getItemCount() {
        return catagoryModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView catagoryIcon;
        private TextView catagoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryIcon = itemView.findViewById(R.id.catagory_icon);
            catagoryName = itemView.findViewById(R.id.catagory_name);
        }

        private void setCatagoryIcon(String iconURL) {
            if (!iconURL.equals(null)) {
                Glide.with(itemView.getContext()).load(iconURL).apply(new RequestOptions().placeholder(R.drawable.home)).into(catagoryIcon);
            }
        }

        private void setCatagoryName(final String name) {
            catagoryName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent catagoryIntent = new Intent(itemView.getContext(), CatagoryActivity.class);
                    catagoryIntent.putExtra("CatagoryName", name);
                    itemView.getContext().startActivity(catagoryIntent);
                }
            });
        }
    }
}
