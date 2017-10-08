package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/location', formats = ["json"])
class Location {

    String country
    String city

    static hasMany = [users: User]

    static mapping = {
//        users column: 'location_id' // default 'location_id'
    }

    static constraints = {
        country nullable: false
    }
}
