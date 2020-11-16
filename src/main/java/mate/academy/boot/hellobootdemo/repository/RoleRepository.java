package mate.academy.boot.hellobootdemo.repository;

import mate.academy.boot.hellobootdemo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(Role.RoleName roleName);
}
