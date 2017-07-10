package com.cmt

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StoresController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Stores.list(params), model:[storesCount: Stores.count()]
    }

    def show(Stores stores) {
        respond stores
    }

    def create() {
        respond new Stores(params)
    }

    @Transactional
    def save(Stores stores) {
        if (stores == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (stores.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond stores.errors, view:'create'
            return
        }

        stores.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'stores.label', default: 'Stores'), stores.id])
                redirect stores
            }
            '*' { respond stores, [status: CREATED] }
        }
    }

    def edit(Stores stores) {
        respond stores
    }

    @Transactional
    def update(Stores stores) {
        if (stores == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (stores.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond stores.errors, view:'edit'
            return
        }

        stores.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'stores.label', default: 'Stores'), stores.id])
                redirect stores
            }
            '*'{ respond stores, [status: OK] }
        }
    }

    @Transactional
    def delete(Stores stores) {

        if (stores == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        stores.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'stores.label', default: 'Stores'), stores.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'stores.label', default: 'Stores'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
