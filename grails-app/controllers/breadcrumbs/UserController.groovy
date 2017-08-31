package breadcrumbs


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
    def delete(){
        userService.deleteRelationshipsWithComments(params.id as Long)
        super.delete()
    }

    @Override
    protected Integer countResources() {
        params.keySet().find{it.matches('.*Id$')}?
                listRelatedResources(params).size() :
                User.count()
    }

}
