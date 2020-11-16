package mate.academy.boot.hellobootdemo.service;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.Role;

public interface RoleService {
    void add(Role role);

    Role getById(Long id);

    Role getByRoleName(Role.RoleName roleName);

    List<Role> getAll();

    void deleteById(Long id);
}
