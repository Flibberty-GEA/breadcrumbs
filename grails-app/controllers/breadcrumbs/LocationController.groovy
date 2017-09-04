package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class LocationController extends RestfulController {
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
    protected List<Location> listAllResources(Map params) {
        return params.userId ?
                listResourcesByUserId(params.userId as Long):
                Location.list(params)
    }

    @Override
    protected Integer countResources() {
        return params.userId ? 1 : Location.count()
    }

    private List<Location> listResourcesByUserId(Long id) {
        User user = User.get(id)
        return user.locationId ? [Location.get(user.locationId as Long)] : []
        //        return user.locationId ? Location.findAllByUsersInList([user], params) : []
    }

}
