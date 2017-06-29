package com.cmt

/**
 * Created by Josh on 6/28/17.
 */
public class Item {
    private String catNum;
    private String desc;
    private double price;

    static constraints = {
        // catNum probably has some associated length
        // desc might have a length requirement
        price(min: 0)
    }

    public String getCatNum() {
        return catNum
    }

    public void setCatNum(String catNum) {
        this.catNum = catNum
    }

    public String getDesc() {
        return desc
    }

    public void setDesc(String desc) {
        this.desc = desc
    }

    public double getPrice() {
        return price
    }

    public void setPrice(double price) {
        this.price = price
    }
}
