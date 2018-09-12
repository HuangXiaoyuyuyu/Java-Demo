package org.hxy.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hxy.mybatis.bean.Employee;
import org.hxy.mybatis.dao.EmployeeMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTestCache {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 两级缓存：
     *  一级缓存：(本地缓存)：SqlSession级别的缓存，一级缓存是一直开启的；
     *      与数据库同一次会话期间查询到的数据会放在本地缓存中。
     *      以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库;
     *
     *      一级缓存失效情况(没有使用到当前一级缓存的情况，效果就是还需要向数据库发出查询)：
     *      1.sqlSession不同。
     *      2.sqlSession相同，查询条件不同。(当前一级缓存中还没有这个数据)
     *      3.sqlSession相同，两次查询之间执行了增删改操作(这次增删改可能对当前数据有影响)
     *      4.sqlSession相同，手动清除了一级缓存(缓存清空)
     *
     *  二级缓存：(全局缓存)：基于namespace级别的缓存：一个namespace对应一个二级缓存；
     *     工作机制：
     *     1.一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中
     *     2.如果会话关闭，一级缓存中的数据会被保存到二级缓存中；新的会话查询信息，就可以参照二级缓存中的内容
     *     3.sqlSession===EmployeeMapper==>Employee
     *                    DepartmentMapper==>Department
     *            不同namespace查出的数据会放在自己对应的缓存中(map中)
     *            效果：数据会从二级缓存中获取
     *                 查出的数据都会被默认先放在一级缓存中
     *                 只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中
     *      使用：
     *      1.开启全局二级缓存配置<setting name="cacheEnabled" value="true" />
     *      2.去mapper.xml中配置使用的二级缓存：
     *          <cache></cache>
     *      3.我们的POJO需要实现序列化接口
     *
     * 和缓存有关的设置/属性：
     *      1.cacheEnabled=true，false：关闭缓存(二级缓存关闭)(一级缓存一直可以用的)
     *      2.每个select标签都有useCache="true",
     *              false:不使用缓存(一级缓存依然使用，二级缓存不使用)
     *      3.重点！！！！！
     *          每个增删改标签的：flushCache="true";
     *          增删改执行完成后就会清除缓存，一级二级缓存全部清空。
     *          查询标签：flushCache="false"，
     *              如果flushCache="true"；每次查询之后都会清空缓存，缓存是没有被使用的。
     *      4.sqlSession.clearCache();只是清除当前session的一级缓存
     *      5.localCacheScope：本地缓存的作用域(一级缓存SESSION)：当前会话的所有数据保存在会话缓存中
     *              STATEMENT：可以禁用一级缓存
     *
     * 第三方缓存整合：
     *      1.导入第三方缓存包即可
     *      2.导入与第三方缓存整和的适配包，官网有
     *      3.mapper.xml中使用自定义缓存
     */
    @Test
    public void testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession(true);

        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee01 = mapper.getEmployeeById(1);
            System.out.println(employee01);

            Employee employee02 = mapper.getEmployeeById(1);
            System.out.println(employee02);

            System.out.println(employee01 == employee02);
        } finally {
            session.close();
        }
    }

    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession(true);
        SqlSession session1 = sqlSessionFactory.openSession(true);

        try {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee);
            session.close();

            EmployeeMapper mapper1 = session1.getMapper(EmployeeMapper.class);
            Employee employee1 = mapper1.getEmployeeById(1);
            System.out.println(employee1);
            session1.close();
        } finally {

        }
    }
}
