package mate.academy.boot.hellobootdemo.mappers;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import mate.academy.boot.hellobootdemo.models.Role;
import mate.academy.boot.hellobootdemo.models.User;
import mate.academy.boot.hellobootdemo.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String DEFAULT_PASSWORD = "1111";
    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User toUser(ReviewDto dto) {
        User user = new User();
        user.setProfileName(dto.getProfileName());
        user.setPassword(DEFAULT_PASSWORD);
        user.setUserId(dto.getUserId());
        user.setRoles(List.of(roleService.getByRoleName(Role.RoleName.USER)));
        return user;
    }
}
