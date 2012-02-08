/**
 * Test interface, Log4j is added to "compile" classpath with "maven-ivy-plugin" at runtime.
 */
interface MyLog4jAppender extends org.apache.log4j.Appender
{
}
