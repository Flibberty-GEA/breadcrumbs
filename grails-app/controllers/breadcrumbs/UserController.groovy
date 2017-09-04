package breadcrumbs

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class UserController extends RestfulController {
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
    protected List<User> listAllResources(Map params) {
        listRelatedResources(params)
    }

    private List<User> listRelatedResources(Map params){
        switch (params) {
            case {params.locationId}: Location.get(params.locationId as Long).users as List; break
            case {params.commentId}: [Comment.get(params.commentId as Long).auth]; break
            case {params.articleId}: [Article.get(params.articleId as Long).author]; break
            default: User.list(params)
        }
    }

    @Override
    @Transactional
    def delete(){
        userService.deleteRelationshipsWithComments(params.id as Long)
        super.delete()
    }

    @Override
    protected Integer countResources() {
        if(params.keySet().find{it.matches('.*Id$')}) {
            switch (params) {
                case { params.locationId }: return User.countByLocation(Location.get(params.locationId as Long)); break
                case { params.commentId }: return 1; break
                case { params.articleId }: return 1; break
                default: User.count()
            }
        } else {
            User.count()
        }
    }

}
