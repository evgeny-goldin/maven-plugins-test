def scm = node.scm[0]
scm.appendNode( 'localBranch', 'dev'  )
assert scm.remove( scm.clean[0] )
scm.appendNode( 'clean',       'true' )
node
