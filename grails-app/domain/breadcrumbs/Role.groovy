package breadcrumbs


class Role {

    String name
    String description
    boolean isFullPowers
    static hasMany = [users: User]

    static constraints = {
        name nullable: false
    }
}
