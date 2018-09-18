import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Test {
    /**
     * 代码生成示例代码
     */
    @org.junit.Test
    public void testGenerator() {
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)    //是否支持AR模式
              .setAuthor("huangxiaoyu") //作者
              .setOutputDir("D:\\Programming\\Java\\IDEA\\IDEAForJavaEE\\MyBatisPlus\\mybatisPlus03\\src\\main\\java")  //生成路径
              .setFileOverride(true)    //文件覆盖
              .setIdType(IdType.AUTO)   //主键策略
              .setServiceName("%sService")  //设置生成的service接口的名字的首字母是否为I
                                            //IEmployeeService
              .setBaseResultMap(true)
              .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUrl("jdbc:mysql://localhost:3306/mp")
                        .setUsername("root")
                        .setPassword("940906");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) //全局大写命名
                      .setDbColumnUnderline(true)   //表名 字段名是否使用下划线
                      .setColumnNaming(NamingStrategy.underline_to_camel)
                        // 数据库表映射到实体的命名策略
                      .setTablePrefix("tbl_")
                      .setInclude("tbl_employee");    //生成的表

        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("org.hxy.mp")
                     .setMapper("mapper")
                     .setService("service")
                     .setController("controller")
                     .setEntity("entity")
                     .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(packageConfig);

        //执行
        autoGenerator.execute();
    }
}
