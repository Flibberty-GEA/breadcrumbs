package breadcrumbs

import groovy.json.JsonSlurper

class BootStrap {

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
            User author = User.get(it.userId)
            article.save(failOnError:true, flush: true)
            article.dateCreated = ProjectUtils.parseDateTime(it.publicationDate)
            author.addToArticles(article)
        }

        Object articleTags = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\ArticlesTags.json")))
        articleTags.each{
            Tag tag = Tag.get(it.tagId)
            Article article = Article.get(it.articleId)
            article.addToTags(tag)
        }

        Object comments = new JsonSlurper().parse(new File(ProjectUtils.getCorrectPathOS("src\\main\\resources\\Comments.json")))
        comments.each{
            Comment comment = new Comment(it)
            User author = User.get(it.userId)
            comment.save(failOnError:true, flush: true)
            comment.dateCreated = ProjectUtils.parseDateTime(it.postedDate)
            author.addToComments(comment)
            Article article = Article.get(it.articleId)
            article.addToComments(comment)
        }
    }

    def destroy = {
    }
}
