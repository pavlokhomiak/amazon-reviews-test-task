package mate.academy.boot.hellobootdemo.mappers;

import static org.mockito.Mockito.when;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import mate.academy.boot.hellobootdemo.models.Role;
import mate.academy.boot.hellobootdemo.models.User;
import mate.academy.boot.hellobootdemo.repository.RoleRepository;
import mate.academy.boot.hellobootdemo.service.RoleService;
import mate.academy.boot.hellobootdemo.service.impl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class UserMapperTest {
    private static final ReviewDto reviewDto = new ReviewDto(Long.parseLong("38"), "B001EO5QW8",
            "A3MGP2E1ZZ6GRB", "\"Zardoz \"\"focuspuller\"\"\"", Integer.parseInt("1"),
            Integer.parseInt("1"), Integer.parseInt("5"), Long.parseLong("1238457600"),
            "it's oatmeal", "\"What else do you need to know? Oatmeal, instant (make it with a "
            + "half cup of low-fat milk and add raisins\tnuke for 90 seconds). More expensive than "
            + "something. It's still just oatmeal. Mmm, convenient!\"");
    private static final User expectedUser = new User();

    private RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
    private RoleService roleService = new RoleServiceImpl(roleRepository);
    private UserMapper mapper = new UserMapper(roleService);

    @BeforeClass
    public static void inject() {
        expectedUser.setUserId("A3MGP2E1ZZ6GRB");
        expectedUser.setProfileName("\"Zardoz \"\"focuspuller\"\"\"");
        expectedUser.setPassword("1111");
        Role role = new Role();
        role.setId(1L);
        role.setRoleName(Role.RoleName.USER);
        expectedUser.setRoles(List.of(role));
    }

    @Test
    public void shouldExecute_OK() {
        Role roleFromDb = new Role();
        roleFromDb.setId(1L);
        roleFromDb.setRoleName(Role.RoleName.USER);
        when(roleRepository.getRoleByRoleName(Role.RoleName.USER)).thenReturn(roleFromDb);
        User actualUser = mapper.toUser(reviewDto);

        Assert.assertEquals(expectedUser, actualUser);
    }
}
