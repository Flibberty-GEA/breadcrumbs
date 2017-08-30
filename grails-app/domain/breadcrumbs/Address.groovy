package breadcrumbs


class Address {

    String country
    String city

    static hasMany = [users: User]

    static mapping = {
//        users column: 'address_id' // default 'address_id'
    }

    static constraints = {
        country nullable: false
    }
}
