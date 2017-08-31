package breadcrumbs

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class ArticleService {

    void deleteArticleComments(Long id) {
        Article article = Article.get(id)
        if (article != null) {
            List<Comment> comments = []
            comments += article.comments as List
            comments.each{
                article.removeFromComments(it)
            }
        }
    }
}
