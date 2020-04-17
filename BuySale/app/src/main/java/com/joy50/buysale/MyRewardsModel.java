package com.joy50.buysale;

public class MyRewardsModel {

    private String rewardType;
    private String rewardVaildDate;

    public MyRewardsModel(String rewardType, String rewardVaildDate) {
        this.rewardType = rewardType;
        this.rewardVaildDate = rewardVaildDate;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getRewardVaildDate() {
        return rewardVaildDate;
    }

    public void setRewardVaildDate(String rewardVaildDate) {
        this.rewardVaildDate = rewardVaildDate;
    }
}
