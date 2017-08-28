package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article extends BasePost {

    String title
//    String content
    static belongsTo = [subs: User]
    static hasMany = [subs: User, tags: Tag, comments: Comment]

    static mapping = {
//        content type: "text"
        comments column: 'article_id'
        subs joinTable: 'SUB_ASSOCIATIONS'
        tags joinTable: 'TAGS_ARTICLES_ASSOCIATIONS'
    }

    static constraints = {
        title nullable: false
//        content nullable: false
    }
}
