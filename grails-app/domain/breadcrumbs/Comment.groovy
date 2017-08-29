package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/comment', formats = ["json"])
class Comment extends BasePost{

    Long targetCommentId
}
