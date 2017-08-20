package breadcrumbs

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ArticleSpec extends Specification implements DomainUnitTest<Article> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fixed"
            true != false
    }
}
