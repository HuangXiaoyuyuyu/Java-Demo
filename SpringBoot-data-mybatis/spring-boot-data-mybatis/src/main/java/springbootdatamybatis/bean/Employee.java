package springbootdatamybatis.bean;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
