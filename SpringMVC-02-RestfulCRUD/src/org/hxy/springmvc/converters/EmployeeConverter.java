package org.hxy.springmvc.converters;

import org.hxy.springmvc.model.Department;
import org.hxy.springmvc.model.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String,Employee> {
    @Override
    public Employee convert(String s) {
        if (s != null) {
            String[] vals = s.split("-");
            if (vals != null && vals.length == 4) {
                String lastName = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(vals[3]));
                Employee employee = new Employee(null,lastName,email,gender,department);

                System.out.println(s + "---converter---"+ employee);

                return employee;
            }
        }
        return null;
    }
}
