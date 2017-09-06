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

    @Override
    protected List<User> listAllResources(Map params){
        User.createCriteria().list{
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources(){
        User.createCriteria().get{
            projections {
                rowCount()
            }
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
        switch (params) {
            case {params.locationId}: delegate.location { eq("id", params.locationId as Long) }; break
            case {params.commentId}: delegate.comments { eq("id", params.commentId as Long) }; break
            case {params.articleId}: delegate.articles { eq("id", params.articleId as Long) }; break
        }
    }

}

