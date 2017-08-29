package breadcrumbs

class BasePost {

    String text
    Date dateCreated
    Date lastUpdated

    static mapping = {
//        autoTimestamp true // default true
        text type: "text"
    }

    static constraints = {
        text nullable: false
    }
}
