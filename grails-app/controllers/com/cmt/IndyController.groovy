package com.cmt

class IndyController {

    def index() { }

    def updateMiniDashOrders() {
        def result = Order.get(params.id)
        render result as JSON
    }

    def updateMiniDashCustomers() {
        def result = Customer.get(params.id)
        render result as JSON
    }
}
