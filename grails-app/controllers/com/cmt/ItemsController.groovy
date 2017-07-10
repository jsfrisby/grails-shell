package com.cmt

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Items.list(params), model:[itemsCount: Items.count()]
    }

    def show(Items items) {
        respond items
    }

    def create() {
        respond new Items(params)
    }

    @Transactional
    def save(Items items) {
        if (items == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (items.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond items.errors, view:'create'
            return
        }

        items.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'items.label', default: 'Items'), items.id])
                redirect items
            }
            '*' { respond items, [status: CREATED] }
        }
    }

    def edit(Items items) {
        respond items
    }

    @Transactional
    def update(Items items) {
        if (items == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (items.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond items.errors, view:'edit'
            return
        }

        items.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'items.label', default: 'Items'), items.id])
                redirect items
            }
            '*'{ respond items, [status: OK] }
        }
    }

    @Transactional
    def delete(Items items) {

        if (items == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        items.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'items.label', default: 'Items'), items.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'items.label', default: 'Items'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def updateMiniDashItems(Integer max) {
//        def result = Items.get(params.id)
//        def result = "Items"
//        render result as JSON

        params.max = Math.min(max ?: 10, 100)
        render Items.list(params) as JSON
    }
}
