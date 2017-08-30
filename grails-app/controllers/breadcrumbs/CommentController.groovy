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

    def index() {
        respond params.articleId ?
                commentService.commentByArticle(params.articleId) :
                Comment.getAll()
    }
}
