package SpringBoot_MybatisPlus.service.impl;

import SpringBoot_MybatisPlus.bean.User;
import SpringBoot_MybatisPlus.mapper.UserMapper;
import SpringBoot_MybatisPlus.service.UserService;
import SpringBoot_MybatisPlus.utils.Encodes;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public Integer getCountByName(String name) {
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag", false);
        wrapper.eq("login_name", name);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("input" + user.getPassword());
        Encodes.entryptPassword(user);
        System.out.println("转换后：" + user.getPassword());
        user.setLocked(0);
        baseMapper.insert(user);
    }

    @Override
    public List<User> selectByLogin(String loginName, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("login_name",loginName);
        map.put("password",password);
        return baseMapper.selectByMap(map);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        Map<String,Object> map = new HashMap<>();
        map.put("login_name",loginName);
        return baseMapper.findUserByMap(map);

    }
}
