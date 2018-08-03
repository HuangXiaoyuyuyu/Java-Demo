package springbootdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootdatajpa.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
