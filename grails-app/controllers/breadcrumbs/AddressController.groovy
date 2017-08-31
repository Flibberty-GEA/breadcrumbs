package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class AddressController extends RestfulController {
	static responseFormats = ['json']
    def addressService

    AddressController() {
        super(Address)
    }

    AddressController(Class resource) {
        super(resource)
    }

    AddressController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    @Override
    protected List<Address> listAllResources(Map params) {
        return params.userId ?
            addressService.findByUserId(params.userId as Long) :
            Address.list(params)
    }

}
