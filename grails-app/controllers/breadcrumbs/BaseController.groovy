package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.util.GrailsNameUtils
import org.hibernate.criterion.CriteriaSpecification

import java.text.DateFormat
import java.text.SimpleDateFormat

abstract class BaseController<T> extends RestfulController {
	static responseFormats = ['json']
    def domainClass
//    def service = new BaseService()

//    BaseController() {
//        super(domainClass)
//    }

    BaseController(Class resource) {
        super(resource)
    }

    BaseController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    /**
     * Lists all resources up to the given maximum
     *
     * @param max The maximum
     * @return A list of resources
     */
//    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
//        def relatedResourceId = params.keySet().find{it.matches('.*Id$')}
//        !relatedResourceId ?
//                respond(listAllResources(params), model: [("${resourceName}Count".toString()): User.count()]):
//                respond(listRelatedResources(params), model: [("${resourceName}Count".toString()): countResources()])
//    }
//
//    /**
//     * List all of resource based on parameters
//     *
//     * @return List of resources or empty if it doesn't exist
//     */
//    @Override
//    protected List<T> listAllResources(Map params) {
//        def relatedResourceId = params.keySet().find{it.matches('.*Id$')}
//        relatedResourceId ? listRelatedResources(params) : resource.list(params)
//    }

    /**
     * List related resource...
     *
     * @return List of resources or empty if it doesn't exist
     */
//    protected List<T> listRelatedResources(Map params) {
//        def criteria = resource.createCriteria()
//        def resultList = criteria.list{
//            service.selectRestrictions(delegate)
//        }
////        println "!!!!!!!!!!!11 resultList: $resultList"
//        resultList
//    }
}
