package breadcrumbs

import grails.rest.Resource


@Resource(uri = '/tag', formats = ["json"])
class Tag {

    String name

    static belongsTo = Article
    static hasMany = [articles: Article]

    static mapping = {
        articles joinTable: 'TAGS_ARTICLES_ASSOCIATIONS'
    }

    static constraints = {
        name nullable: false
    }
}
