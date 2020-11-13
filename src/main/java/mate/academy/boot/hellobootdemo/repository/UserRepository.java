package mate.academy.boot.hellobootdemo.repository;

import mate.academy.boot.hellobootdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
