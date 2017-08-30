package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class RoleController extends RestfulController {
	static responseFormats = ['json']
    def roleService

    RoleController() {
        super(Role)
    }

    RoleController(Class resource) {
        super(resource)
    }

    RoleController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    def index() {
        respond params.userId ?
                roleService.roleByUser(params.userId) :
                Role.getAll()
    }
}
