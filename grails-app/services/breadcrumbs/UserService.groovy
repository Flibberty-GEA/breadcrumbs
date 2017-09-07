package breadcrumbs

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional



@Transactional
@GrailsCompileStatic
class UserService extends BaseService {

    void deleteRelationshipsWithComments(Long id) {
        Comment.findAllWhere([auth:User.get(id)]).each{
            it.auth = null
            it.save(flush: true)
        }
    }

}
