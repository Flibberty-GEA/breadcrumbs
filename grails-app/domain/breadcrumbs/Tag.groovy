package breadcrumbs

import grails.rest.Resource


@Resource(uri = '/tag', formats = ["json"])
class Tag {

    String name

    static hasMany = [articles: Article]

    static mapping = {
//        articles column: 'Article_Id'
    }

    static constraints = {
        name nullable: false
    }
}
