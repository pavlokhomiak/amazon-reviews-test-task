package mate.academy.boot.hellobootdemo.service;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.User;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User getById(Long id);

    void update(User user, Long id);

    void delete(Long id);
}
