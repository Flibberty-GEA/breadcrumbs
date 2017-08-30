package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class UserController extends RestfulController {
	static responseFormats = ['json']
    def userService

    UserController() {
        super(User)
    }

    UserController(Class resource) {
        super(resource)
    }

    UserController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    def index() {
        respond userService.selectUsers(params)
    }

    def delete(){
        userService.deleteRelationshipsWithComments(params.id)
        super.delete()
    }
}
