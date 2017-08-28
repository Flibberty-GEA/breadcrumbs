package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article extends BasePost {

    String title
//    String content
    static hasMany = [tags: Tag,
                      comments: Comment]

    static mapping = {
//        content type: "text"


        tags joinTable: 'TAGS_ARTICLES_ASSOCIATIONS'
    }

    static constraints = {
        title nullable: false
//        content nullable: false
    }
}
