本次上传的是一个SpringBoot整合MyBatis数据源的Demo

分为注解版和配置文件版：
	自定义注解版MyBatis的配置规则；给容器中添加一个ConfigurationCustomizer：
	@org.springframework.context.annotation.Configuration
	public class MyBatisConfig {
		@Bean
		public ConfigurationCustomizer configurationCustomizer(){
			return new ConfigurationCustomizer(){
				@Override
				public void customize(Configuration configuration) {
					configuration.setMapUnderscoreToCamelCase(true);
				}
			};
		}
	}
	配置文件版本需要指定全局配置文件的位置和sql映射文件的位置：
	mybatis:
		config‐location: classpath:mybatis/mybatis‐config.xml 指定全局配置文件的位置
		mapper‐locations: classpath:mybatis/mapper/*.xml 指定sql映射文件的位置
如有疑问~欢迎留言~