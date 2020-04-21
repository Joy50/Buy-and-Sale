package com.joy50.buysale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.joy50.buysale.ProductDetailsActivity.infoReward;
import static com.joy50.buysale.ProductDetailsActivity.titleReward;
import static com.joy50.buysale.ProductDetailsActivity.validityDateReward;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.ViewHolder> {

    private List<MyRewardsModel> myRewardsModelList;
    private Boolean useMiniLayout = false;

    public MyRewardsAdapter(List<MyRewardsModel> myRewardsModelList, Boolean useMiniLayout) {
        this.myRewardsModelList = myRewardsModelList;
        this.useMiniLayout = useMiniLayout;
    }

    @NonNull
    @Override
    public MyRewardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (useMiniLayout) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_rewards_item_layout, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_rewards_item_layout, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRewardsAdapter.ViewHolder holder, int position) {
        String rewardTitle = myRewardsModelList.get(position).getRewardTitle();
        String rewardType = myRewardsModelList.get(position).getRewardType();
        String validDate = myRewardsModelList.get(position).getRewardVaildDate();
        ((ViewHolder) holder).setReward(rewardTitle, rewardType, validDate);
    }

    @Override
    public int getItemCount() {
        return myRewardsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView rewardTitletext;
        private TextView rewardType;
        private TextView rewardvalidDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rewardTitletext = itemView.findViewById(R.id.reward_title);
            rewardType = itemView.findViewById(R.id.reward_information);
            rewardvalidDate = itemView.findViewById(R.id.reward_valid_date);
        }

        private void setReward(String rewardTitle, String rewardtext, String validDate) {
            rewardType.setText(rewardtext);
            rewardvalidDate.setText(validDate);
            rewardTitletext.setText(rewardTitle);

            final String title = rewardTitle;
            final String reward = rewardtext;
            final String vDate = validDate;
            /*if (useMiniLayout) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        titleReward.setText("ABC");
                        infoReward.setText("reward");
                        validityDateReward.setText("vDate");
                        ProductDetailsActivity.showDialogRecyclerView();
                    }
                });
            }*/
        }
    }
}
