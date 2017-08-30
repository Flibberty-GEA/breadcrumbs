package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class ArticleService {

    def deleteArticlesComments(id) {
        def article = Article.get(id)
        def comments = []
        comments += article.comments
        comments.each{
            article.removeFromComments(it)
        }
    }
}
