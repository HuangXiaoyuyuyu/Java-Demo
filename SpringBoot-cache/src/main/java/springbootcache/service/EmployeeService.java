package springbootcache.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import springbootcache.bean.Employee;
import springbootcache.mapper.EmployeeMapper;

import javax.annotation.Resource;
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    //@Cacheable(value = "emp",key = "#root.methodName+'['+#id+']'")
    @Cacheable(value = "emp",keyGenerator = "keyGenerator"/*,condition = "#a0>1"*/)
    public Employee getEmpById(Integer id) {
        System.out.println("查询~~~" + id + "~~~员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(cacheNames = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update+++++++++++++");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = "emp",allEntries = true)
    public void deleteEmpById(Integer id) {
        System.out.println("deleteEmpById~~~~~~~     " + id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = "emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*cacheNames = "emp",*/key = "#result.id")
            }
            )
    public Employee getEmpByLastName(String lastName) {
        System.out.println("getEmpByLastName~~~~" + lastName);
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }

}
