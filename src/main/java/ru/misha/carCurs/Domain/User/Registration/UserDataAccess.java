package ru.misha.carCurs.Domain.User.Registration;

import ru.misha.carCurs.Entities.User;

public interface UserDataAccess {
    void save(User user);
    User findByUsername(String username);
}
