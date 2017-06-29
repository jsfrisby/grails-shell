package com.cmt

/**
 * Created by Josh on 6/28/17.
 */
class Order {
    Date created;
    String storeUsed;
    String customerName;

    static constraints = {
        storeUsed(matches: "a-zA-z]+")
        customerName(matches: "a-zA-z ,.]+")
    }

    Date getCreated() {
        return created
    }

    void setCreated(Date created) {
        this.created = created
    }

    String getStoreUsed() {
        return storeUsed
    }

    void setStoreUsed(String storeUsed) {
        this.storeUsed = storeUsed
    }

    String getCustomerName() {
        return customerName
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName
    }

    List<Item> getItemList() {
        return itemList
    }

    void setItemList(List<Item> itemList) {
        this.itemList = itemList
    }
    List<Item> itemList;

}
