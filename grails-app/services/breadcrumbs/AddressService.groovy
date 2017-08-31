package breadcrumbs

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class AddressService {

    List<Address> findByUserId(Long id) {
        User user = User.get(id)
        return user.addressId ? [Address.get(user.addressId as Long)] : []
    }

}
