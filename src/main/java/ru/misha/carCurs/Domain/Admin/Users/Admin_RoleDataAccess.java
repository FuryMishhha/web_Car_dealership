package ru.misha.carCurs.Domain.Admin.Users;

import ru.misha.carCurs.Entities.Role;

public interface Admin_RoleDataAccess {
    public Role findById(Long id);
}
