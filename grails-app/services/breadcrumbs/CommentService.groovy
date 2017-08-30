package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class CommentService {

    def commentByArticle(id) {
        return Article.get(id).comments
    }
}
