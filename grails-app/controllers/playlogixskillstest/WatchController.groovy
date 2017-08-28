package playlogixskillstest

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class WatchController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def watchSearchService

    /*
        Handles API queries for watch searches
    */
    def search(){
        def results = watchSearchService.search(params.list("brand"), params.price ? params.price as Double: 0.0,
                params.warranty ? params.warranty as int : 0)

        flash.message = "Found ${results.size()} matching result(s)"

        render (view: "index", model: [watchInstanceList:results])
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Watch.list(params), model:[watchInstanceCount: Watch.count()]
    }

    def show(Watch watchInstance) {
        respond watchInstance
    }

    def create() {
        respond new Watch(params)
    }

    def save(Watch watchInstance) {
        if (watchInstance == null) {
            notFound()
            return
        }

        if (watchInstance.hasErrors()) {
            respond watchInstance.errors, view:'create'
            return
        }

        watchInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'watch.label', default: 'Watch'), watchInstance.id])
                redirect watchInstance
            }
            '*' { respond watchInstance, [status: CREATED] }
        }
    }

    def edit(Watch watchInstance) {
        respond watchInstance
    }

    def update(Watch watchInstance) {
        if (watchInstance == null) {
            notFound()
            return
        }

        if (watchInstance.hasErrors()) {
            respond watchInstance.errors, view:'edit'
            return
        }

        watchInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Watch.label', default: 'Watch'), watchInstance.id])
                redirect watchInstance
            }
            '*'{ respond watchInstance, [status: OK] }
        }
    }

    def delete(Watch watchInstance) {

        if (watchInstance == null) {
            notFound()
            return
        }

        watchInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Watch.label', default: 'Watch'), watchInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'watch.label', default: 'Watch'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
