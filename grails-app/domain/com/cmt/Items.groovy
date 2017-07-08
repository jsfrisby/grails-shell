package com.cmt

/**
 * Created by Josh on 6/28/17.
 */
public class Items {
    String catNum;
    String desc;
    double price;

    static constraints = {
        // catNum probably has some associated length
        // desc might have a length requirement
        price(min: 0.0)
    }
}
