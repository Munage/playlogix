package playlogixskillstest



import grails.test.mixin.*
import spock.lang.*

@TestFor(WatchController)
@Mock(Watch)
class WatchControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.watchInstanceList
        model.watchInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.watchInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def watch = new Watch()
        watch.validate()
        controller.save(watch)

        then: "The create view is rendered again with the correct model"
        model.watchInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        watch = new Watch(params)

        controller.save(watch)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/watch/show/1'
        controller.flash.message != null
        Watch.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def watch = new Watch(params)
        controller.show(watch)

        then: "A model is populated containing the domain instance"
        model.watchInstance == watch
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def watch = new Watch(params)
        controller.edit(watch)

        then: "A model is populated containing the domain instance"
        model.watchInstance == watch
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/watch/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def watch = new Watch()
        watch.validate()
        controller.update(watch)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.watchInstance == watch

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        watch = new Watch(params).save(flush: true)
        controller.update(watch)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/watch/show/$watch.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/watch/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def watch = new Watch(params).save(flush: true)

        then: "It exists"
        Watch.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(watch)

        then: "The instance is deleted"
        Watch.count() == 0
        response.redirectedUrl == '/watch/index'
        flash.message != null
    }
}
