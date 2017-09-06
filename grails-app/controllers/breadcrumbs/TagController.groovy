package breadcrumbs


import grails.rest.*
import grails.converters.*
import grails.rest.RestfulController
import org.apache.catalina.util.ResourceSet

import java.sql.ResultSet

class TagController extends BaseController<Tag> {
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
    protected List<Tag> listRelatedResources(Map params) {
                Article.get(params.articleId).tags as List
    }

    @Override
    protected Integer countResources() {
        return params.articleId ? countTagsByArticle() : Tag.count()
//        return params.articleId ?
//                Tag.executeQuery("select count(*) from Tag as t join t.articles as a " +
//                        "where a = :b", [b: Article.get(params.articleId)])[0]:
//                Tag.count()
    }

    private Integer countTagsByArticle(){
        def criteria = Tag.createCriteria()
        criteria.get{
            projections {
                rowCount()
            }
            articles{
                eq("id", params.articleId as Long)
            }
        }
    }
}
