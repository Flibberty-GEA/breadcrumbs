package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/article', formats = ["json"])
class Article {
    String title
    String content
    String publicationDate
    String author

    static constraints = {
        title nullable: false
        content bindable: false
        publicationDate nullable: false
        author bindable: false
    }
}
