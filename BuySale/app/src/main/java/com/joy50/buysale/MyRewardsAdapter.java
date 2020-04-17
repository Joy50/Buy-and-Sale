package com.joy50.buysale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.ViewHolder> {

    List<MyRewardsModel> myRewardsModelList;

    public MyRewardsAdapter(List<MyRewardsModel> myRewardsModelList) {
        this.myRewardsModelList = myRewardsModelList;
    }

    @NonNull
    @Override
    public MyRewardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_rewards_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRewardsAdapter.ViewHolder holder, int position) {
        String rewardType = myRewardsModelList.get(position).getRewardType();
        String validDate = myRewardsModelList.get(position).getRewardVaildDate();
        ((ViewHolder)holder).setReward(rewardType,validDate);
    }

    @Override
    public int getItemCount() {
        return myRewardsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView rewardType;
        private TextView rewardvalidDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rewardType = itemView.findViewById(R.id.rewardtype);
            rewardvalidDate = itemView.findViewById(R.id.rewarddate);
        }
        private void setReward(String rewardtext,String validDate){
            rewardType.setText(rewardtext);
            rewardvalidDate.setText(validDate);
        }
    }
}
