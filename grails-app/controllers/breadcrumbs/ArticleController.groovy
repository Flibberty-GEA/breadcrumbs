package breadcrumbs

import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.NO_CONTENT

class ArticleController extends RestfulController {
	static responseFormats = ['json']
    def articleService

    ArticleController() {
        super(Article)
    }

    ArticleController(Class resource) {
        super(resource)
    }

    ArticleController(Class resource, boolean readOnly) {
        super(resource, readOnly)
    }

    def index() {
        respond params.userId ?
                articleService.articleByUser(params.userId) :
                Article.getAll()
    }

    def delete(){
        articleService.deleteArticlesComments(params.id)
        super.delete()
    }
}
