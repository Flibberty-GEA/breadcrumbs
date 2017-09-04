package breadcrumbs

class Article extends BasePost {

    String title
    User author

    static belongsTo = [author: User]

    static hasMany = [tags: Tag, comments: Comment]

    static mapping = {
//        content type: "text"
        comments cascade: "all-delete-orphan"
        tags joinTable: 'TAGS_ARTICLES_ASSOCIATIONS'
        author updateable: false
    }

    static constraints = {
        title nullable: false, blank: false
//        content nullable: false
    }
}
