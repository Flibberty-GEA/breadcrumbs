package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class CommentController extends RestfulController {
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
        return params.articleId ?
                Article.get(params.articleId).comments as List:
                Comment.list(params)
    }

    @Override
    protected Integer countResources() {
        return params.articleId ?
                Comment.countByArticle(Article.get(params.articleId)) :
                Comment.count()
    }

}
