package breadcrumbs


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class ArticleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true != false
    }

    void "test tags of article"() {
        setup:
        Article article = Article.get(2)
        Integer amountOfTags = Tag.count()
        println "!!!!!!!!! current tag of article (id: 2) is $article.tags"

        when:
        article.addToTags(name:"new tag").save(flush:true)
        article = Article.get(2)
        println "!!!!!!!!! add new tag to article (id: 2) -> $article.tags"
        then:
        amountOfTags + 1 == Tag.count()
        Tag.get(amountOfTags + 1).name == "new tag"

        when:
        Tag tag = article.tags.find {it.id == 7}
        println "!!!!!!!!! current tag's name is '$tag.name'"
        tag.name = "new name"
        tag.save(flush:true)
        tag = article.tags.find {it.id == 7}
        println "!!!!!!!!! changed name to '$tag.name'"
        then:
        tag.name == 'new name'

    }

    void "test delete Article"() {
        expect:"fix me"
        true != false
    }

}
