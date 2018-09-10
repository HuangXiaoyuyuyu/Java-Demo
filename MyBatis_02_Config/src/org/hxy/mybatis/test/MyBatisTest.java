package org.hxy.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hxy.mybatis.bean.Employee;
import org.hxy.mybatis.dao.EmployeeMapper;
import org.hxy.mybatis.dao.EmployeeMapperAnnotation;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1.接口式编程
 *  原生：     Dao    ====> DaoImpl
 *  mybatis   Mapper ====> xxMapper.xml
 *
 * 2.SqlSession代表和数据库的一次会话；用完必须关闭，释放资源。
 *
 * 3.SqlSession和Connection一样都是非线程安全的，每次使用都应获取新的对象。
 *
 * 4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 *      (将接口和xml进行绑定)
 *       eg:EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
 *
 * 5.两个重要的配置文件：
 *          mybatis的全局配置文件：包含数据库连接池信息，事物管理信息等。。。系统运行环境信息
 *          sql映射文件：保存了每一sql语句的映射信息；抽取sql语句。

 */
public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 2.sql映射文件：配置了每一个sql以及sql的封装规则
     * 3.将sql映射文件注册在全局配置文件中
     * 4.写代码：
     *         1).根据全局配置文件得到SqlSessionFactory
     *         2).使用SqlSessionFactory，获取sqlSession对象使用来进行增删改查
     *            一个SqlSession就是代表和数据库的一次会话，用完关闭
     *         3).使用sql的唯一标识来告诉MyBatis执行哪一个sql。sql都是保存在sql映射文件中的
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();

        //获取sqlSession实例，能直接执行已经映射的sql语句
        //sql唯一标识：statement Unique identifier matching the statement to use
        //执行sql要用的参数：parameter A parameter object to pass to the statement
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Employee employee = sqlSession.selectOne("org.hxy.mybatis.EmployeeMapper. selectEmp",1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test01() throws IOException {
        //1.获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        try{
            //3.获取接口的实现类
            //会为接口自动创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(mapper.getClass());
            System.out.println(employee);
        } finally {
            session.close();
        }

    }

    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();

        try {
            EmployeeMapperAnnotation mapper = session.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }
}
