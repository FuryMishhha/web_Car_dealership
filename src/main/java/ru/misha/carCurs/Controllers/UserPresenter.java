package ru.misha.carCurs.Controllers;

import ru.misha.carCurs.Domain.User.Info.UserInfoOutputBoundary;
import ru.misha.carCurs.Models.UserDtoModel;

public class UserPresenter implements UserInfoOutputBoundary {

    @Override
    public UserDtoModel prepareAuthentication(UserDtoModel userDtoModel) {
        return userDtoModel;
    }

    @Override
    public UserDtoModel prepareNotAuthentication() {
        return null;
    }
}
