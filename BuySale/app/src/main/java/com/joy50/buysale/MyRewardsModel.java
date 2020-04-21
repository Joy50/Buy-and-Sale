package com.joy50.buysale;

public class MyRewardsModel {

    private String rewardTitle;
    private String rewardType;
    private String rewardVaildDate;

    public MyRewardsModel(String rewardTitle, String rewardType, String rewardVaildDate) {
        this.rewardTitle = rewardTitle;
        this.rewardType = rewardType;
        this.rewardVaildDate = rewardVaildDate;
    }

    public String getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(String rewardTitle) {
        this.rewardTitle = rewardTitle;
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
