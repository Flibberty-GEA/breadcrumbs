package breadcrumbs


class Role {

    String name
    String description
    boolean isFullPowers

    static constraints = {
        name nullable: false
    }
}
