��Demoʹ��SpringBootĬ�����úõ���־����ʾ��������־���𣬲��ҿ���ͨ�������ļ������޸���־������𣬾�����־��Ϣ�Լ���־��Ϣ��ŵ�λ�ã������Ҫʹ��logback.xml��Ϊ��־�����ļ�������Ҫʹ��<springProfile></springProfile>��ǩ�ᱨ����ʱ��ֻ��Ҫ��logback.xml�޸�Ϊlogback-spring.xml����

�����ϵ���־��ܣ�
JUL��JCL��Jboss-logging��logback��log4j��log4j2��slf4j......
SpringBootѡ��slf4j��logback

SLF4jʹ��
�����ϵͳ��ʹ��SLF4j   https://www.slf4j.org
�Ժ󿪷���ʱ����־��¼�����ĵ��ã���Ӧ����ֱ�ӵ�����־��ʵ���࣬���ǵ�����־���������ķ�����
��ϵͳ���浼��slf4j��jar��  logback��ʵ��jar

����ͳһ��־�Ľ���������������ϵͳ�����е���־��ͳһ��slf4j
1����ϵͳ��������־������ų���ȥ��
2�����м�����滻ԭ�е���־��ܣ�
3�����ǵ���slf4j������ʵ��

SpringBootʹ���������������ܣ�
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
</dependency>
