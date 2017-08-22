package breadcrumbs

import grails.rest.Resource
import java.time.LocalDate
import java.time.LocalDateTime

@Resource(uri = '/user', formats = ["json"])
class User {
    String username
    String password
    String name
    String surname
    String email
    Date birthday
    boolean role
    LocalDateTime createdDate

    static constraints = {
        username nullable: false
        password nullable: false
        email nullable: false
        role nullable: false
        createdDate nullable: false
    }
}
