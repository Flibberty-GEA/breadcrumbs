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

    @Override
    protected List<Role> listAllResources(Map params) {
        return params.userId ?
                [Role.get(User.get(params.userId).roleId)] :
                Role.list(params)
    }

    @Override
    protected Integer countResources() {
        return params.userId ? 1 : Role.count()
    }
}
