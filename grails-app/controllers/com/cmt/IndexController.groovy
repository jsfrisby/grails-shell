package com.cmt

import grails.converters.JSON
//import Orders
//import Customers

class IndexController {

    def index() {
        redirect(uri: "/")
    }

    def updateMiniDashOrders() {
        def result = Orders.get(params.id)
        render result as JSON
    }

    def updateMiniDashCustomers() {
        def result = Customer.get(params.id)
        render result as JSON
    }

    def updateMiniDashItems() {
//        def result = Items.get(params.id)
//        def result = "Items"
//        render result as JSON
        def items = Items.get(params.id)
        [items:items]
    }
}
