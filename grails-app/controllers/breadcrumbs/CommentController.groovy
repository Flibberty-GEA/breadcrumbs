package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class CommentController extends BaseController<Comment> {
	static responseFormats = ['json']
    def commentService

    CommentController() {
        super(Comment)
    }

    CommentController(Class resource) {
        super(resource)
    }

    CommentController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    @Override
    protected List<Comment> listAllResources(Map params) {
        Comment.createCriteria().list{
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources(){
        Comment.createCriteria().get{
            projections {
                rowCount()
            }
            selectRestrictions(delegate)
        }
    }

    Closure selectRestrictions = { delegate ->
        switch (params) {
            case {params.articleId}: delegate.article{eq("id", params.articleId as Long)}; break
        }
    }

}
