package com.cmt

class CustomerController {

    def index() {
//        render "This is the customer page."
        def customer = new Customer(name: 'TestName', address: 'testAddress', city: 'Tempe', state: 'AZ', zip: '85283', phoneNum: '6235555555', birthdate: Date(1980-01-01))
        [customer: customer]
    }

    def create() {

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
