�����ϴ�����һ��SpringBoot����MyBatis����Դ��Demo

��Ϊע���������ļ��棺
	�Զ���ע���MyBatis�����ù��򣻸����������һ��ConfigurationCustomizer��
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
	�����ļ��汾��Ҫָ��ȫ�������ļ���λ�ú�sqlӳ���ļ���λ�ã�
	mybatis:
		config�\location: classpath:mybatis/mybatis�\config.xml ָ��ȫ�������ļ���λ��
		mapper�\locations: classpath:mybatis/mapper/*.xml ָ��sqlӳ���ļ���λ��
��������~��ӭ����~