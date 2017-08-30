package breadcrumbs


import java.time.LocalDate
import java.time.*

class User {

    static transients = ['age']

    String username
    String password
    String name
    String surname
    String email
    Date birthday
    Role role
    Address address

    static hasMany = [articles: Article]

    static mapping = {
        email email: true
    }

    static constraints = {
        username nullable: false
        password nullable: false
        email nullable: false
        role nullable: false
    }

    public int getAge() {
        ZoneId defaultZoneId = ZoneId.systemDefault()
        Instant instant = birthday.toInstant()
        LocalDate birthday = instant.atZone(defaultZoneId).toLocalDate()
        LocalDate currentDate = LocalDate.now()
        return Period.between(birthday, currentDate).getYears()
    }

    public void setAge(int age) {
        // nothing.  Don't want it set.
    }
}
