package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/comment', formats = ["json"])
class Comment extends BasePost{

    Article article
    Long commentId

    static constraints = {
        article column: 'Article_Id'
    }
}
