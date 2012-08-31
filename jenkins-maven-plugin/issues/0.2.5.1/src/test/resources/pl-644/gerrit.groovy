node.scm.buildChooser[0].attributes().class =
  'com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger.GerritTriggerBuildChooser'
def name = node.scm.userRemoteConfigs[0].children()[0].url.text()
name = name.substring(name.lastIndexOf('/') + 1, name.lastIndexOf('.'))
def c = new NodeBuilder().
  'com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger.GerritTrigger'() {[
    spec { },
    gerritProjects {
       'com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger.data.GerritProject' {[
         compareType('PLAIN'),
         pattern(name),
         branches {
           'com.sonyericsson.hudson.plugins.gerrit.trigger.hudsontrigger.data.Branch' {[
             compareType('ANT'),
             pattern('**')
           ]}
         }
       ]}
    },
    silentMode('false'),
    escapeQuotes('true'),
    buildStartMessage {},
    buildFailureMessage {},
    buildSuccessfulMessage {},
    buildUnstableMessage {},
    buildUnsuccessfulFilepath {},
    customUrl {}
]}
node.triggers[0].append(c)

node.scm.userRemoteConfigs[0].children()[0].refspec[0].setValue('$GERRIT_REFSPEC')
node.scm.branches[0].children()[0].name[0].setValue('$GERRIT_BRANCH')
