import com.goldin.gcommons.GCommons

def fileBean        = GCommons.file()
def tempDir         = fileBean.delete( fileBean.tempDirectory()).parentFile.canonicalFile
def findCleanupDirs = { tempDir.listFiles().findAll{ it.directory && it.name.contains( 'com.goldin' ) }}

if ( project.artifactId == 'cleanup-temp' )
{
    Collection<File> cleanupDirs = findCleanupDirs()

    cleanupDirs.each { File dir -> println "Deleting [$dir]"
                                   fileBean.delete( dir )
                                   println "Deleting [$dir] - done" }

    println "[${ cleanupDirs.size() }] directories cleaned up"
}

assert ! findCleanupDirs()
println "No temp directories left in [$tempDir]"