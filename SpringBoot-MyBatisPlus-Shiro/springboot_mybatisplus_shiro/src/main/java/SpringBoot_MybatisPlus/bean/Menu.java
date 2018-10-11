package SpringBoot_MybatisPlus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class Menu {
    private Integer mid;
    private String mname;
   /* @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();*/
}
