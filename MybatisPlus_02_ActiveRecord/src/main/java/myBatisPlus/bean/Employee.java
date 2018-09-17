package myBatisPlus.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Employee extends Model<Employee> {
    private Integer id ;
    private String lastName;
    private String email ;
    private Integer gender ;
    private Integer age ;

    @TableField(exist = false)
    private Double salary;

    protected Serializable pkVal() {
        return id;
    }
}
