package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class LocationController extends BaseController<Location> {
	static responseFormats = ['json']
    def locationService

    LocationController() {
        super(Location)
    }

    LocationController(Class resource) {
        super(resource)
    }

    LocationController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }


    @Override
    protected List<Location> listAllResources(Map params){
        Location.createCriteria().list{
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources() {
        return params.userId ? 1 : Location.count()
    }

//    @Override
//    protected Integer countResources(){
//        Location.createCriteria().get{
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
