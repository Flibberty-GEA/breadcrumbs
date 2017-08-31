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

    @Override
    protected List<User> listAllResources(Map params) {
        userService.selectUsers(params)
    }

    @Override
    def delete(){
        userService.deleteRelationshipsWithComments(params.id as Long)
        super.delete()
    }

}
