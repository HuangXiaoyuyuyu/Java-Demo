package SpringBoot_MybatisPlus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class User {
    private Integer id;
    private String loginName;
    private String nickName;
    private String icon;
    private String password;
    private String salt;
    private String tel;
    private String email;
    private Integer locked;
    @TableField(fill = FieldFill.INSERT)
    private Date create_date;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_date;
    @TableField(fill = FieldFill.INSERT)
    private Integer del_flag;
    private Integer is_admin;
   /* @TableField(exist = false)
    private MultipartFile upload;*/
    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();
   /* @TableField(exist = false)
    private Set<Menu> menus = new HashSet<>();*/
}

