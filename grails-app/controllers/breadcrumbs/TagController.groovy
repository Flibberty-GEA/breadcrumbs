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
    protected List<Tag> listAllResources(Map params){
        Tag.createCriteria().list(max: params.max, offset: params.offset){
            selectRestrictions(delegate)
        }
    }

    @Override
    protected Integer countResources(){
        Tag.createCriteria().get{
            projections {
                rowCount()
            }
            selectRestrictions(delegate)
        }
    }


    Closure selectRestrictions = { delegate ->
        switch (params) {
            case {params.articleId}: delegate.articles{ eq("id", params.articleId as Long) }; break
        }
    }
}
