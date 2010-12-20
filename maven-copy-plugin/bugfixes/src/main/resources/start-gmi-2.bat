@echo off@

set CATALINA_HOME=%~dp0%..
set CLF_HOME=%CATALINA_HOME%\\${testProperty}
set CLF_HOME=%CATALINA_HOME%${testProperty}
set GMI_HOME=%CLF_HOME%\\${anotherTestProperty}
set GMI_HOME=%CLF_HOME%${anotherTestProperty}
set GMI_JAVA_HOME=%CLF_HOME%\\${anotherTestProperty}
set GMI_JAVA_OPTS=-server -Xrs -XX:MaxPermSize=256m -Xms128m -Xmx1024m ${spring-version}

echo ======================================
echo CATALINA_HOME = [%CATALINA_HOME%]
echo CLF_HOME      = [%CLF_HOME%]
echo GMI_HOME      = [%GMI_HOME%]
echo GMI_JAVA_HOME = [%GMI_JAVA_HOME%]
echo GMI_JAVA_OPTS = [%GMI_JAVA_OPTS%]
echo ======================================

copy  %CATALINA_HOME%\\bin\\${testProperty} %windir%\\System32 >> "%CATALINA_HOME%\\logs\\GMI.log" 2>&1
"%GMI_JAVA_HOME%\\${anotherTestProperty}" -cp %GMI_HOME%;%GMI_HOME%\\gmimanager-jar-with-dependencies.jar %GMI_JAVA_OPTS% com.clearforest.gmi.manager.GMIManager
