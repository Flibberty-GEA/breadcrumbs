package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article extends BasePost {

    String title
//    String content

    static belongsTo = Tag
    static hasMany = [tags: Tag, comments: Comment]

    static mapping = {
//        content type: "text"
        comments column: 'Article_Id'
    }

    static constraints = {
        title nullable: false
//        content nullable: false
    }
}
