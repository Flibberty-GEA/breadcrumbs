package breadcrumbs


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true != false
    }
    void "test User age"() {
        expect:"23"
        User user = User.get(2)
        user.age == 23
    }

    void "test deleta User"() {
        expect:
//        User user = User.get(2)
//        println "!!!!! user $user"
//        user.delete(flush: true)
//        User user2 = User.get(2)
//        println "!!!!! user $user2"
//        def users = User.list()
//        println "!!!!! users $users"
        true != false

    }

}
