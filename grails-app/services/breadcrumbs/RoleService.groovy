package breadcrumbs

import grails.gorm.transactions.Transactional

@Transactional
class RoleService {

    def roleByUser(id) {
        User user = User.get(id)
        return user.roleId ? [Role.get(user.roleId)] : []
    }
}
