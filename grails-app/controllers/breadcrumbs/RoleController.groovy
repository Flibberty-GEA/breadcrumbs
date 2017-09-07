package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class RoleController extends BaseController<Role> {
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
    protected List<Role> listAllResources(Map params){
        Role.createCriteria().list{
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources() {
        return params.userId ? 1 : Role.count()
    }

//    @Override
//    protected Integer countResources(){
//        Role.createCriteria().get{
//            projections {
//                rowCount()
//            }
//            selectRestrictions(delegate)
//        }
//    }

    Closure selectRestrictions = { delegate ->
        switch (params) {
            case {params.userId}: delegate.users{ eq("id", params.userId as Long) }; break
        }
    }

}
