package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class ArticleService {

    def articleByUser(id) {
        return User.get(id).articles
    }

    def deleteArticlesComments(id) {
        def article = Article.get(id)
        def comments = []
        comments += article.comments
        comments.each{
            article.removeFromComments(it)
        }
    }
}
