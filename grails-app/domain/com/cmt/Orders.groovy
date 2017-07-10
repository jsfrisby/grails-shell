package com.cmt

class Orders {
    Date created;
    String storeUsed;
    String customerName;

    static constraints = {
        storeUsed(matches: "a-zA-Z]+")
        customerName(matches: "a-zA-Z ,.]+")
    }
}
