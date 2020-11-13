package mate.academy.boot.hellobootdemo.service;

import mate.academy.boot.hellobootdemo.models.Role;
import mate.academy.boot.hellobootdemo.models.User;

import java.util.List;

public interface RoleService {
    void add(Role role);

    Role getById(Long id);

    List<Role> getAll();

    void deleteById(Long id);
}
