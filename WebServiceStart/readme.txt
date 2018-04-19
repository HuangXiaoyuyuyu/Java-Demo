该Demo是WebService的入门,通过访问http://localhost:8888/ns?wsdl就可以看到具体的WSDL，然后通过访问type标签的schemaLocation里的链接就可以看到具定义的数据类型以及返回值

其中服务器的创建就是要创建接口、创建实现类并且开启服务

WebService的三要素就是SOAP、WSDL和UDDI

WSDL简单了解：
	1.type：用来定义访问的类型
	2.message:SOAP
	3.portType:指明服务器的接口，并通过operation绑定相应的in和out的消息：其中in表示参数，out表示返回值
	4.binding：指定传递消息所使用的格式
	5.service:指定服务器发布的名称