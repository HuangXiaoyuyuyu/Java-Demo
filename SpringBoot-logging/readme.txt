该Demo使用SpringBoot默认配置好的日志的演示常见的日志级别，并且可以通过配置文件进行修改日志输出级别，具体日志信息以及日志信息存放的位置，如果需要使用logback.xml作为日志配置文件并且需要使用<springProfile></springProfile>标签会报错，这时候只需要将logback.xml修改为logback-spring.xml即可

市面上的日志框架：
JUL、JCL、Jboss-logging、logback、log4j、log4j2、slf4j......
SpringBoot选用slf4j和logback

SLF4j使用
如何在系统中使用SLF4j   https://www.slf4j.org
以后开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是调用日志抽象层里面的方法；
给系统里面导入slf4j的jar和  logback的实现jar

关于统一日志的解决方法：即如何让系统中所有的日志都统一到slf4j
1、将系统中其他日志框架先排除出去；
2、用中间包来替换原有的日志框架；
3、我们导入slf4j其他的实现

SpringBoot使用它来做日至功能：
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
</dependency>
