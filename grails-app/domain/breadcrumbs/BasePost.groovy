package breadcrumbs

class BasePost {

    String text
    User author
    Date dateCreated
    User updatedBy
    Date lastUpdated

    static mapping = {
//        autoTimestamp true // default true
        text type: "text"
        author column: 'author_id'
    }

    static constraints = {
        text nullable: false
    }
}
