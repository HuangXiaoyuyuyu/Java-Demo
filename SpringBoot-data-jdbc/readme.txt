本次上传的是一个SpringBoot整合Druid数据源的Demo

SpringBoot默认是用org.apache.tomcat.jdbc.pool.DataSource作为数据源；
数据源的相关配置都在DataSourceProperties里面；

整合阿里巴巴的Druid需要导入druid数据源 并配置Druid的监控
	1.配置一个管理后台的servlet
	2.配置一个web监控的filter

如有疑问~欢迎留言~