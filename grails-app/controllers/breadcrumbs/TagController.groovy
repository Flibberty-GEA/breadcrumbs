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

    @Override
    protected List<Tag> listAllResources(Map params) {
        return params.articleId ?
                Article.get(params.articleId).tags as List:
                Tag.list(params)
    }

    @Override
    protected Integer countResources() {
        return params.articleId ?
                Article.get(params.articleId).tags.size() :
                Tag.count()
    }

}
