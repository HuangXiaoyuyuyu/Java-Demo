��Demo����ʹ��Spring Initializer���ٴ����Ĺ��� ͨ��дapplication.yml ��application.yml��ֵ�Զ�ע�뵽bean�� ������SpringBoot�Դ��Ĳ�������в���
�Զ�ע��ͨ�����������ļ������õ�ÿһ�����Ե�ֵ��ӳ�䵽�������� @ConfigurationProperties������SpringBoot�������е��������Ժ������ļ�����ص����ý��а󶨣�
prefix = "person"�������ļ����ĸ�������������Խ���һһӳ��

ʹ��Spring Initializer���ٴ���Spring boot��Ŀ��
	IDE��֧��ʹ��Spring����Ŀ�����򵼿��ٴ���һ��Spring Boot��Ŀ
	ѡ��������Ҫ��ģ��  �򵼻���������Spring Boot��Ŀ
	Ĭ�����ɵ�Spring Boot��Ŀ
			- �������Ѿ����ɺ���  ����ֻ��Ҫ�����Լ����߼�
			- resources�ļ�����Ŀ¼�ṹ
			- static���������еľ�̬��Դ   js css  images
			- templates���������е�ģ��ҳ��  ��Spring BootĬ��jar��ʹ��Ƕ��ʽ��Tomcat��Ĭ�ϲ�֧��JSPҳ�棩   ����ʹ��ģ�����棨freemarker��thymeleaf��
			- application.properties��Spring BootӦ�õ������ļ�  �����޸�һЩĬ������

SpringBootʹ��һ��ȫ�ֵ������ļ��������ļ����ǹ̶��ģ�
		application.properties
		application.yml
		
YAML�﷨��
		1�������﷨
					k:(�ո�)v����ʾһ�Լ�ֵ�ԣ��ո�����У���
			��**�ո�**�����������Ʋ㼶��ϵ��ֻҪ��������һ�����ݣ�����ͬһ���㼶��
```yaml
server:
    port: 8081
    path: /hello
```
���Ժ�ֵҲ�Ǵ�Сд���У�
		2��ֵ��д��
					����������ͨ��ֵ�����֣��ַ�����������
							k: v������ֱ����д��
							�ַ���Ĭ�ϲ��ü��ϵ����Ż���˫���ţ�
									""��˫���ţ�����ת���ַ�������������ַ��������ַ�����Ϊ�������ʾ����˼
											name:   "zhangsan \n lisi"�������zhangsan ����  lisi
						''�������ţ���ת�������ַ��������ַ�����ֻ��һ����ͨ���ַ�������
											name:   ��zhangsan \n lisi���������zhangsan \n  lisi
					����Map�����Ժ�ֵ������ֵ�ԣ���
							k: v������һ����д��������Ժ�ֵ�Ĺ�ϵ��ע������
							������k: v�ķ�ʽ
								yaml
								friends:
										lastName: zhangsan
										age: 20
								����д����
								yaml
								friends: {lastName: zhangsan,age: 18}
					���飨List��Set����
							��- ֵ��ʾ�����е�һ��Ԫ��
							yaml
							pets:
							 - cat
							 - dog
							 - pig
							����д��
						yaml
						pets: [cat,dog,pig]
						

