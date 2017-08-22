package breadcrumbs

import groovy.json.JsonSlurper

class BootStrap {
    def init = { servletContext ->
        def articles = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Articles.json")))
        articles.each{
            Article article = new Article(it)
            article.save(failOnError:true, flush: true)
        }
        def users = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Users.json")))
        users.each{
            User user = new User(it)
            user.save(failOnError:true, flush: true)
        }
    }
    def destroy = {
    }
}
