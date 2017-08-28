package breadcrumbs

import grails.rest.Resource
import grails.util.Holders

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
}
