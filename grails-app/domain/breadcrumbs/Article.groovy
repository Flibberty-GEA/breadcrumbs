package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article {
    String title
    String content
    String publicationDate
    String author

    static mapping = {
        content type: "text"
    }

    static constraints = {
        title nullable: false
        content nullable: false
        publicationDate nullable: false
        author nullable: false
    }
}
