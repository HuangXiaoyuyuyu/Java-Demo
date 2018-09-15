package org.hxy.mybatisPlus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
//@TableName(value = "tbl_employee")
public class Employee {
    //@TableId(type = IdType.AUTO)
    private Integer id ;
    private String lastName;
    private String email ;
    private Integer gender ;
    private Integer age ;
    @TableField(exist = false)
    private Double salary;
}
