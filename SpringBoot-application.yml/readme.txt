该Demo就是使用Spring Initializer快速创建的工程 通过写application.yml 把application.yml的值自动注入到bean中 并利用SpringBoot自带的测试类进行测试
自动注入通过：将配置文件中配置的每一个属性的值，映射到这个组件中 @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
prefix = "person"：配置文件中哪个下面的所有属性进行一一映射

使用Spring Initializer快速创建Spring boot项目：
	IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目
	选择我们需要的模块  向导会联网创建Spring Boot项目
	默认生成的Spring Boot项目
			- 主程序已经生成好了  我们只需要我们自己的逻辑
			- resources文件夹中目录结构
			- static：保存所有的静态资源   js css  images
			- templates：保存所有的模板页面  （Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）   可以使用模板引擎（freemarker、thymeleaf）
			- application.properties：Spring Boot应用的配置文件  可以修改一些默认设置

SpringBoot使用一个全局的配置文件，配置文件名是固定的：
		application.properties
		application.yml
		
YAML语法：
		1、基本语法
					k:(空格)v：表示一对键值对（空格必须有）；
			以**空格**的缩进来控制层级关系；只要是左对齐的一列数据，都是同一个层级的
```yaml
server:
    port: 8081
    path: /hello
```
属性和值也是大小写敏感；
		2、值的写法
					字面量：普通的值（数字，字符串，布尔）
							k: v：字面直接来写；
							字符串默认不用加上单引号或者双引号；
									""：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思
											name:   "zhangsan \n lisi"：输出；zhangsan 换行  lisi
						''：单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据
											name:   ‘zhangsan \n lisi’：输出；zhangsan \n  lisi
					对象、Map（属性和值）（键值对）：
							k: v：在下一行来写对象的属性和值的关系；注意缩进
							对象还是k: v的方式
								yaml
								friends:
										lastName: zhangsan
										age: 20
								行内写法：
								yaml
								friends: {lastName: zhangsan,age: 18}
					数组（List、Set）：
							用- 值表示数组中的一个元素
							yaml
							pets:
							 - cat
							 - dog
							 - pig
							行内写法
						yaml
						pets: [cat,dog,pig]
						

