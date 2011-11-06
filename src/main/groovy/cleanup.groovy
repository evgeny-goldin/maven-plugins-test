import com.goldin.gcommons.GCommons

def fileBean        = GCommons.file()
def tempDir         = fileBean.delete( fileBean.tempDirectory()).parentFile
def findCleanupDirs = { tempDir.listFiles().findAll{ it.directory && it.name.contains( 'com.goldin' ) }}

if ( project.artifactId == 'cleanup-temp' )
{
    findCleanupDirs().each { File dir ->
                             println "Deleting [$dir]"
                             fileBean.delete( dir )
                             println "Deleting [$dir] - done"
    }
}

assert ! findCleanupDirs()