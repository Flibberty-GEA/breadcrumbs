package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.util.GrailsNameUtils
import org.hibernate.criterion.CriteriaSpecification

import java.text.DateFormat
import java.text.SimpleDateFormat

abstract class BaseController<T> extends RestfulController {
	static responseFormats = ['json']
    def domainClass = T

    BaseController() {
        super(T)
    }

    BaseController(Class resource) {
        super(resource)
    }

    BaseController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    void someMethod() {
        // to do nothing
    }

}
