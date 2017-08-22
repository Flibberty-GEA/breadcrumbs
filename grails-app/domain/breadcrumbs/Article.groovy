package breadcrumbs

import grails.rest.Resource
import java.time.LocalDateTime

@Resource(uri = '/article', formats = ["json"])
class Article {
    String title
    String description
    String content
    Long authorId
    LocalDateTime publicationDate
    LocalDateTime editedDate
    Long editedBy

    static mapping = {
        content type: "text"
        description type: "text"
    }

    static constraints = {
        title nullable: false
        description nullable: false
        content nullable: false
        authorId nullable: false
    }
}
