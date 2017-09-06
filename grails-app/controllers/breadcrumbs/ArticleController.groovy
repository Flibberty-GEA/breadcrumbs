package breadcrumbs

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.NO_CONTENT

class ArticleController extends BaseController<Article> {
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
    protected List<Article> listRelatedResources(Map params) {
                User.get(params.userId).articles as List
    }


    @Override
    protected Integer countResources() {
        return params.userId ?
                Article.countByAuthor(User.get(params.userId)) :
                Article.count()
    }

    @Override
    @Transactional
    def delete(){
        articleService.deleteArticleComments(params.id as Long)
        super.delete()
    }


}
