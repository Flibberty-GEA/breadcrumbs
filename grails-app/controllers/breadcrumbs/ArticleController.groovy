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

    @Override
    protected List<Article> listAllResources(Map params) {
        return params.userId ?
                User.get(params.userId).articles as List:
                Article.list(params)
    }

    @Override
    protected Integer countResources() {
        return params.userId ?
                User.get(params.userId).articles.size() :
                Article.count()
    }

    @Override
    def delete(){
        articleService.deleteArticleComments(params.id as Long)
        super.delete()
    }


}
