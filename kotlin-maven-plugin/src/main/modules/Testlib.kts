import kotlin.modules.*

val homeDir = "../testlib"

fun project() {
    module("Testlib") {
        sources += homeDir
    }
}
