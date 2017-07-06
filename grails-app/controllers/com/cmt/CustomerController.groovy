package com.cmt

class CustomerController {

    def index() {
//        render "This is the customer page."
        def customer = new Customer(name: 'TestName', address: 'testAddress', city: 'Tempe', state: 'AZ', zip: '85283', phoneNum: '6235555555', birthdate: new Date())
        [customer: customer]
//        customer.save()
    }

//    def list(Integer max) {
////        params.max = Math.min(max ?:10, 100)
////        [customerInstanceList: Customer.list(params), customerInstanceTotal: Customer.count()]
//    }

    def create() {
//        def customer = new Customer(name: 'TestName', address: 'testAddress', city: 'Tempe', state: 'AZ', zip: '85283', phoneNum: '6235555555', birthdate: new Date())
//        customer.save()
    }

    def update() {

    }

    def delete() {

    }

    def show(Long id) {
        def customer = Customer.get(id)

        if (!customer) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "index")
            return
        }

        [customer: customer]
    }

    def edit() {

    }
}
