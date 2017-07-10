package com.cmt

class Customers {
    String name;
    String address;
    String city;
    String state;
    String zip;
    String phoneNum;
    Date birthdate;

    static constraints = {
        address(matches: "[0-9a-zA-Z,. #]+")
        city(matches: "[a-zA-Z]+")
        state(matches: "[A-Z]+")//, size: 2)
        zip(matches: "[0-9]+")//, size: 5)
        phoneNum(matches: "[0-9]+")//, size: 10)
    }
}
