package ru.misha.carCurs.Database;

import ru.misha.carCurs.Domain.Admin.Users.Admin_RoleDataAccess;
import ru.misha.carCurs.Entities.Role;
import ru.misha.carCurs.Repositories.RoleRepository;

public class JpaRole implements Admin_RoleDataAccess {
    private final RoleRepository roleRepository;

    public JpaRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
