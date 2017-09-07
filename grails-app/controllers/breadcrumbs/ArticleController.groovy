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
    protected List<Article> listAllResources(Map params) {
        Article.createCriteria().list{
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources(){
        Article.createCriteria().get{
            projections {
                rowCount()
            }
            selectRestrictions(delegate)
        }
    }

    Closure selectRestrictions = { delegate ->
        switch (params) {
            case {params.userId}: delegate.author{eq("id", params.userId as Long)}; break
            case {params.tagId}: delegate.tags{eq("id", params.tagId as Long)}; break
        }
    }

    @Override
    @Transactional
    def delete(){
        articleService.deleteArticleComments(params.id as Long)
        super.delete()
    }

}
