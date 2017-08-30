package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

class TagController extends RestfulController {
	static responseFormats = ['json']
    def tagService

    TagController() {
        super(Tag)
    }

    TagController(Class resource) {
        super(resource)
    }

    TagController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    def index() {
        respond params.articleId ?
                tagService.tagByArticle(params.articleId) :
                Tag.getAll()
    }
}
