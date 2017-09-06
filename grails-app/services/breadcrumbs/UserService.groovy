package breadcrumbs

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional



@Transactional
@GrailsCompileStatic
class UserService {

    void deleteRelationshipsWithComments(Long id) {
        Comment.findAllWhere([auth:User.get(id)]).each{
            it.auth = null
            it.save(flush: true)
        }
    }

//    Closure selectRestrictions = {Criteria delegate, Map params ->
////        println "!################## => ${delegate.getClass()}"
//        if (params.locationId) {
//            delegate.location {
//                delegate.eq("id", params.locationId as Long)
//            }
//        } else if (params.commentId) {
//            delegate.comments {
//                delegate.eq("id", params.commentId as Long)
//            }
//        } else if (params.articleId) {
//            delegate.articles {
//                delegate.eq("id", params.articleId as Long)
//            }
//        }
//    }
}
