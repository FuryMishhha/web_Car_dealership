package ru.misha.carCurs.Domain.User.Info;

import ru.misha.carCurs.Models.UserDtoModel;

public interface UserInfoOutputBoundary {
    UserDtoModel prepareAuthentication(UserDtoModel userDtoModel);
    UserDtoModel prepareNotAuthentication();
}
