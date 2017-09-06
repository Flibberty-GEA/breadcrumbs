package breadcrumbs


class Comment extends BasePost{

    User auth
    Article article
    static belongsTo = [auth: User]
//    Long targetCommentId

}
