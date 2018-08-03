package springbootdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootdatajpa.entity.User;
import springbootdatajpa.repository.UserRepository;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/user")
    public User insert(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }
}
