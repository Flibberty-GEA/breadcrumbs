package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article extends BasePost {

    String title
    User author

    static belongsTo = [author: User]

    static hasMany = [tags: Tag, comments: Comment]

    static mapping = {
//        content type: "text"
        tags joinTable: 'TAGS_ARTICLES_ASSOCIATIONS'
    }

    static constraints = {
        title nullable: false, blank: false
//        content nullable: false
    }
}
