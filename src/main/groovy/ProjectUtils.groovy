import grails.compiler.GrailsCompileStatic

import java.text.SimpleDateFormat

@GrailsCompileStatic
class ProjectUtils {

    static SimpleDateFormat dateFormats = new SimpleDateFormat ("yyyy-MM-dd");
    static SimpleDateFormat dateTimeFormats = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss")

    static Date parseDate(String date) {
        return dateFormats.parse(date)
    }

    static Date parseDateTime(String dateTime) {
        return dateTimeFormats.parse(dateTime)
    }

    static String getCorrectPathOS(String path){
        isWin()? path.replaceAll("/", "\\\\") : path.replaceAll("\\\\", "/")

    }

    private static boolean isWin(){
        if (System.properties['os.name'].toString().toLowerCase().contains('windows')) {
//            println "it's Windows"
            return true
        } else {
//            println "it's not Windows"
            return false
        }
    }
}
