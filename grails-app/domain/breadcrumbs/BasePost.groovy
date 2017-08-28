package breadcrumbs

class BasePost {

    String text
    User author
    Date dateCreated
    Date lastUpdated
    static belongsTo = [author: User]

    static mapping = {
//        autoTimestamp true // default true
        text type: "text"
    }

    static constraints = {
        text nullable: false
    }
}
