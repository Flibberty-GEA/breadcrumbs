package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class TagService {

    def tagByArticle(id) {
        return Article.get(id).tags
    }
}
