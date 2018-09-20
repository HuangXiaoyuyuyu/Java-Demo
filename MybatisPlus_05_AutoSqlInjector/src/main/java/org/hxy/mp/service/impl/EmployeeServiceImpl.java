package org.hxy.mp.service.impl;

import org.hxy.mp.beans.Employee;
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
 * @since 2018-09-11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
