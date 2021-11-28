package ru.misha.carCurs.Domain.User.Info;

import ru.misha.carCurs.Entities.User;

public interface UserInfoDataAccess {
    User findByUsername(String name);
}
