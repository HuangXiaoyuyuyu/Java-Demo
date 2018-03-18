使用POI需要添加POI相关的依赖，如下：
<!--添加poi依赖-->
    <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi-ooxml</artifactId>
      <version>3.9</version>
    </dependency>

下面介绍java操作excel的方式：
	JXL，POI都是操作excel
	Excel一些企业小的应用都直接用excel来实现，例如：工资报表，人员名单，进销存
	作为数据的备份和恢复（导入、导出）

	Jxl 它只能操作excel 2003版本，它导入导出数据量小时性能很高
	POI 它可以操作office系列软件word、excel、ppt、visio(画网络布局、家装)，在早期版本中它在导出海量数据时，容易崩溃。在新版本中它解决了这个海量数据时，进行了优化，解决了这个问题。

具体的操作步骤见demo的注释，如有疑问，欢迎留言。
