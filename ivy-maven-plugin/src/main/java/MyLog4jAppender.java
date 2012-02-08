/**
 * Test interface, Log4j is added to "compile" classpath with "ivy-maven-plugin" at runtime.
 */
interface MyLog4jAppender extends org.apache.log4j.Appender
{
}
