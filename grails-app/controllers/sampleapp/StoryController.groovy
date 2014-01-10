package sampleapp

import grails.converters.JSON
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class StoryController {

    static allowedMethods = [save: "POST"]

    @org.grails.plugins.metrics.groovy.Timed
    @Transactional(readOnly = true)
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render Story.list(params) as  JSON
    }

    @org.grails.plugins.metrics.groovy.Timed
    @Transactional(readOnly = true)
    def show(Story storyInstance) {
        render storyInstance as JSON
    }

    @org.grails.plugins.metrics.groovy.Timed
    @Transactional
    def save(Story storyInstance) {
        if (storyInstance == null) {
            notFound()
            return
        }

        storyInstance.save flush:true

        render(contentType: "application/json",status: HttpStatus.CREATED,model: storyInstance)
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'storyInstance.label', default: 'Story'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
