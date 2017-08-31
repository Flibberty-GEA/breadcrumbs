package breadcrumbs

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class UserService {

    List<User> selectUsers(Map params){
        switch (params) {
            case {params.addressId}: Address.get(params.addressId as Long).users as List; break
            case {params.commentId}: [Comment.get(params.commentId as Long).auth]; break
            case {params.articleId}: [Article.get(params.articleId as Long).author]; break
            default: User.list(params)
        }
    }

    void deleteRelationshipsWithComments(Long id) {
        Comment.findAllWhere([auth:User.get(id)]).each{
            it.auth = null
            it.save(flush: true)
        }
    }
}
