package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class AddressService {

    def adressByUser(id) {
        User user = User.get(id)
        return user.addressId ? [Address.get(user.addressId)] : []
    }
}
