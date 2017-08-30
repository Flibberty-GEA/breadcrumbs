package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def selectUsers(params){
        if (params.addressId) {
            userByAddress(params.addressId)
        } else if (params.commentId){
            userByComment(params.commentId)
        } else if (params.articleId){
            userByArticle(params.articleId)
        }  else {
            return User.getAll()
        }
    }

    def userByAddress(id){
        return Address.get(id).users
    }

    def userByArticle(id){
        return Article.get(id).author
    }

    def userByComment(id){
        return Comment.get(id).auth
    }

    def deleteRelationshipsWithComments(id) {
        Comment.findAllWhere([auth:User.get(id)]).each{
            it.auth = null
            it.save(flush: true)
        }

    }

}
