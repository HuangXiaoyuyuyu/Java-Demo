package org.hxy.mp.service.impl;

import org.hxy.mp.entity.Employee;
import org.hxy.mp.mapper.EmployeeMapper;
import org.hxy.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangxiaoyu
 * @since 2018-09-09
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    //EmployeeServiceImpl继承了ServiceImpl类,
    //mybatis-plus 通过这种方式为我们注入了EmployeeMapper,
    //这样可以使用service层默认为我们提供的很多方法 ,
    //也可以调用我们自己在dao层编写的操作数据库方法.
}
