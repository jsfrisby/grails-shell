package com.cmt

/**
 * Created by Josh on 6/28/17.
 */
class Store {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNum;
    private String itemType;

    static constraints = {
        name(matches: "a-zA-z]+")
        address(matches: "[0-9a-zA-Z,. #]+")
        city(matches: "[a-zA-Z}+")
        state(matches: "[A-Z]+", size: 2)
        zip(matches: "[0-9]+", size: 5)
        phoneNum(matches: "[0-9]+", size: 10)
    }

    // based on research; encapsulation doesn't seem to matter with Groovy

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getAddress() {
        return address
    }

    void setAddress(String address) {
        this.address = address
    }

    String getCity() {
        return city
    }

    void setCity(String city) {
        this.city = city
    }

    String getState() {
        return state
    }

    void setState(String state) {
        this.state = state
    }

    String getZip() {
        return zip
    }

    void setZip(String zip) {
        this.zip = zip
    }

    String getPhoneNum() {
        return phoneNum
    }

    void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum
    }

    String getItemType() {
        return itemType
    }

    void setItemType(String itemType) {
        this.itemType = itemType
    }
}
