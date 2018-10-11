package SpringBoot_MybatisPlus.mapper;

import SpringBoot_MybatisPlus.bean.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserMapper extends BaseMapper<User> {

    User findUserByMap(Map<String,Object> map);
}
