package SpringBoot_MybatisPlus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class Role {
    private Integer rid;
    private String rname;
   /* @TableField(exist = false)
    private Set<User> users = new HashSet<>();*/
    @TableField(exist = false)
    private Set<Menu> menus = new HashSet<>();
}
