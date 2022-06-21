package backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SegmentController {

    SegmentService segmentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond segmentService.list(params), model:[segmentCount: segmentService.count()]
    }

    def show(Long id) {
        respond segmentService.get(id)
    }

    def create() {
        respond new Segment(params)
    }

    def save(Segment segment) {
        if (segment == null) {
            notFound()
            return
        }

        try {
            segmentService.save(segment)
        } catch (ValidationException e) {
            respond segment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'segment.label', default: 'Segment'), segment.id])
                redirect segment
            }
            '*' { respond segment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond segmentService.get(id)
    }

    def update(Segment segment) {
        if (segment == null) {
            notFound()
            return
        }

        try {
            segmentService.save(segment)
        } catch (ValidationException e) {
            respond segment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'segment.label', default: 'Segment'), segment.id])
                redirect segment
            }
            '*'{ respond segment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        segmentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'segment.label', default: 'Segment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'segment.label', default: 'Segment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
