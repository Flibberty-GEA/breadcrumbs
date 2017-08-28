package breadcrumbs

import groovy.json.JsonSlurper
import org.springframework.jdbc.core.JdbcTemplate

import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource
import java.util.*

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        Object roles = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Roles.json")))
        roles.each{
            Role role = new Role(it)
            role.save(failOnError:true, flush: true)
        }

        Object addresses = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Addresses.json")))
        addresses.each{
            Address address = new Address(it)
            address.save(failOnError:true, flush: true)
        }

        Object users = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Users.json")))
        users.each{
            User user = new User(it)
            Role role = Role.get(it.role)
            user.role = role
            user.birthday = ProjectUtils.parseDate(it.birth)

            user.address = Address.get(it.addressId)
            user.save(failOnError:true, flush: true)
        }

        Object tags = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Tags.json")))
        tags.each{
            Tag tag = new Tag(it)
            tag.save(failOnError:true, flush: true)
        }

        Object articles = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Articles.json")))
        articles.each{
            Article article = new Article(it)
            User author = User.get(it.authorId)
            article.author = author
            article.save(failOnError:true, flush: true)
            article.dateCreated = ProjectUtils.parseDateTime(it.publicationDate)
            article.save(failOnError:true, flush: true)
        }

        Object articleTags = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\ArticlesTags.json")))
        articleTags.each{
            Tag tag = Tag.get(it.tagId)
            Article article = Article.get(it.articleId)
            article.addToTags(tag)
            article.save()
        }

        Object subscriptions = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Subscriptions.json")))
        subscriptions.each{
            User user = User.get(it.subscripters)
            Article article = Article.get(it.subscriptions)
            user.addToSubs(article)
            user.save()
        }


        Object comments = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Comments.json")))
        comments.each{
            Comment comment = new Comment(it)
            Article article = Article.get(it.articleId)
            comment.article = article
            User author = User.get(it.authorId)
            comment.author = author
            comment.save(failOnError:true, flush: true)
            comment.dateCreated = ProjectUtils.parseDateTime(it.postedDate)
            comment.save(failOnError:true, flush: true)
        }
    }

    def destroy = {
    }

    static DriverManagerDataSource getDataSource(Map params) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource()
        dataSource.setDriverClassName(params.driverClassName)
        dataSource.setUrl(params.url)
        dataSource.setUsername(params.username)
        dataSource.setPassword(params.password)
        return dataSource
    }
}
