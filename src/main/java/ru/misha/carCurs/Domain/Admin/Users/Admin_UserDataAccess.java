package ru.misha.carCurs.Domain.Admin.Users;

import ru.misha.carCurs.Entities.User;

import java.util.List;

public interface Admin_UserDataAccess {
    List<User> getAll();
    List<User> filter(Long id,String username,String ROLE_USER, String ROLE_ADMIN);
    User findById(Long id);
    User findByUsername(String username);
    void save(User user);
    User deleteById(Long id);
}
