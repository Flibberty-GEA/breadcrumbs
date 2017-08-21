import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProjectUtils {
    static String getCorrectPathOS(String path){
        isWin()? path.replaceAll("/", "\\\\") : path.replaceAll("\\\\", "/")

    }

    private static boolean isWin(){
        if (System.properties['os.name'].toString().toLowerCase().contains('windows')) {
            println "it's Windows"
            return true
        } else {
            println "it's not Windows"
            return false
        }
    }
}
