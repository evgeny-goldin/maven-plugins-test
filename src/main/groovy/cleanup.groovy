@GrabResolver( name='com.goldin', root='http://evgeny-goldin.org/artifactory/repo/' )
@Grab('com.goldin:gcommons:0.5.3.5-SNAPSHOT')
@GrabExclude('commons-net:commons-net')
@GrabExclude('org.codehaus.groovy:groovy-all')
import com.goldin.gcommons.GCommons

def fileBean        = GCommons.file()
def tempDir         = fileBean.tempDirectory().parentFile
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