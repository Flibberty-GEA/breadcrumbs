package breadcrumbs

import grails.rest.Resource

@Resource(uri = '/role', formats = ["json"])
class Role {

    String name
    String description
    boolean isFullPowers

    static constraints = {
        name nullable: false
    }
}
