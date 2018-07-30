这是一个SpringBoot使用外置的Servlet容器的demo

嵌入式Servlet容器(执行SpringBoot主类的main方法，启动ioc容器，创建嵌入式的Servlet容器)：
	应用打成可执行的jar
优点：简单、便携；
缺点：默认不支持JSP、优化定制比较复杂

外置的Servlet容器(启动Servlet容器，再启动SpringBoot应用)
	外面安装Tomcat---应用war包的方式打包；

步骤：
	1.必须创建一个war项目
	2.将嵌入式的Tomcat指定为provided
	3.必须编写一个SpringBootServletInitializer的子类，并调用configure方法
	4.启动服务器就可以使用
	
如有疑问~欢迎留言~
