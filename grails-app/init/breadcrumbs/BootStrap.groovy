package breadcrumbs

import groovy.json.JsonSlurper

class BootStrap {
    def init = { servletContext ->
//        def data = new JsonSlurper().parse(new File("/grails-app/assets/resources/Articles.json")) //Ubuntu
        def data = new JsonSlurper().parse(new File("grails-app\\assets\\resources\\Articles.json")) //Windows
        data.each{
            Article article = new breadcrumbs.Article(it)
            article.save(failOnError:true, flush: true)
        }
    }
    def destroy = {
    }
}
