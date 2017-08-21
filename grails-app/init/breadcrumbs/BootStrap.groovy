package breadcrumbs

import groovy.json.JsonSlurper

class BootStrap {
    def init = { servletContext ->
        def data = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("grails-app\\assets\\resources\\Articles.json")))
        data.each{
            Article article = new Article(it)
            article.save(failOnError:true, flush: true)
        }
    }
    def destroy = {
    }
}
