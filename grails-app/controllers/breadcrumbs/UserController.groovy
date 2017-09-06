package breadcrumbs

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController
import org.hibernate.Criteria

class UserController extends BaseController<User> {
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

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def relatedResourceId = params.keySet().find{it.matches('.*Id$')}

        if(!relatedResourceId){
            respond(listAllResources(params), model: [("${resourceName}Count".toString()): countResources()])
        } else {
            String keyName = "${resourceName}Count".toString()
            switch (params) {
                case {params.locationId}: respond(listUsersByLocation(params),
                                        model: [(keyName): countUserByLocation()]); break
                case {params.commentId}: respond([findAuthor()],
                                        model: [(keyName): 1]); break
                case {params.articleId}: respond([findAuthor()],
                                        model: [(keyName): 1]); break
                default: throw new Exception("There is no case with ${relatedResourceId} in ${this.class.name}. " +
                        "It should be added into switch.")
            }
        }
    }

    protected Integer countUserByLocation() {
        def criteria = User.createCriteria()
        criteria.get{
            projections {
                rowCount()
            }
            location{
                eq("id", params.locationId as Long)
            }
        }
    }

    private List<User> listUsersByLocation(Map params){
        def criteria = User.createCriteria()
        criteria.list{
            selectRestrictions(delegate)
        }
    }

    private User findAuthor(){
        def criteria = User.createCriteria()
        criteria.get{
            selectRestrictions(delegate)
        }
    }

    @Override
    @Transactional
    def delete(){
        userService.deleteRelationshipsWithComments(params.id as Long)
        super.delete()
    }

    Closure selectRestrictions = { delegate ->
        if (params.locationId) {
            delegate.location {
                eq("id", params.locationId as Long)
            }
        } else if (params.commentId) {
            delegate.comments {
                eq("id", params.commentId as Long)
            }
        } else if (params.articleId) {
            delegate.articles {
                eq("id", params.articleId as Long)
            }
        }
    }

}

