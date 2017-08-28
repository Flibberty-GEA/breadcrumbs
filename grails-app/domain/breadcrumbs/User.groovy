package breadcrumbs

import grails.rest.Resource

import java.time.LocalDate

import java.time.*

@Resource(uri = '/user', formats = ["json"])
class User {

    static transients = ['age']

    String username
    String password
    String name
    String surname
    String email
    Date birthday
    Role role

    Address address
    static hasMany = [subs: Article, articles: Article, comments: Comment]

    static mapping = {
        email email: true
        articles column: 'author_id'

        subs joinTable: [name: 'SUB_ASSOCIATIONS', key: 'user_id', column: 'article_id']
        comments column: 'author_id'
//        address column: 'address_id' // default 'address_id'
    }

    static constraints = {
        username nullable: false
        password nullable: false
        email nullable: false
        role nullable: false
    }

    public int getAge() {
        ZoneId defaultZoneId = ZoneId.systemDefault()
        Instant instant = birthday.toInstant()
        LocalDate birthday = instant.atZone(defaultZoneId).toLocalDate()

        LocalDate currentDate = LocalDate.now()

        return Period.between(birthday, currentDate).getYears()
    }

    public void setAge(int age) {
        // nothing.  Don't want it set.
    }
}
