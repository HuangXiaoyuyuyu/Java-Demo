package SpringBoot_MybatisPlus.service;


import SpringBoot_MybatisPlus.bean.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    Integer getCountByName(String name);

    void saveUser(User user);

    List<User> selectByLogin(String loginName, String password);

    User findUserByLoginName(String loginName);
}
