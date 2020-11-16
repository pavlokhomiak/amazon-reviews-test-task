package mate.academy.boot.hellobootdemo.util;

import mate.academy.boot.hellobootdemo.models.Role;
import mate.academy.boot.hellobootdemo.service.RoleService;
import org.springframework.boot.CommandLineRunner;

public class DataInjector implements CommandLineRunner {
    private final RoleService roleService;

    public DataInjector(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
    }
}
