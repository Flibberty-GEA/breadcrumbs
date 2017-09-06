package breadcrumbs

import grails.gorm.transactions.Transactional
import org.hibernate.criterion.CriteriaSpecification

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
class BaseService {


//    Closure selectRestrictions = { delegate, params ->
//        if (params.locationId) {
//            delegate.location {
//                eq("id", params.locationId as Long)
//            }
//        } else if (params.commentId) {
//            delegate.comments {
//                eq("id", params.commentId as Long)
//            }
//        } else if (params.articleId) {
//            delegate.articles {
//                eq("id", params.articleId as Long)
//            }
//        }
//    }

}
