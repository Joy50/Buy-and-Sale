package com.joy50.buysale;

public class AddressesModel {

    private String fullName;
    private String address;
    private String pincode;
    private boolean isSelected;

    public AddressesModel(String fullName, String address, String pincode, boolean isSelected) {
        this.fullName = fullName;
        this.address = address;
        this.pincode = pincode;
        this.isSelected = isSelected;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
