import kotlin.modules.*

fun project() {
    module("testlib") {
        classpath += "src/test/resources/junit-4.9.jar"
        addSourceFiles( "testlib" )
    }
}
