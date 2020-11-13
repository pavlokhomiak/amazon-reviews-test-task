package mate.academy.boot.hellobootdemo.service.impl;

import mate.academy.boot.hellobootdemo.models.Role;
import mate.academy.boot.hellobootdemo.models.User;
import mate.academy.boot.hellobootdemo.repository.RoleRepository;
import mate.academy.boot.hellobootdemo.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
