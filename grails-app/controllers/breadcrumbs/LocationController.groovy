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
    protected List<Location> listRelatedResources(Map params) {
        User user = User.get(params.userId as Long)
        return user.locationId ? [Location.get(user.locationId as Long)] : []
    }

    @Override
    protected Integer countResources() {
        return params.userId ? 1 : Location.count()
    }

//    private List<Location> listResourcesByUserId(Long id) {
//        User user = User.get(params.userId as Long)
//        return user.locationId ? [Location.get(user.locationId as Long)] : []
//        //        return user.locationId ? Location.findAllByUsersInList([user], params) : []
//    }

}
