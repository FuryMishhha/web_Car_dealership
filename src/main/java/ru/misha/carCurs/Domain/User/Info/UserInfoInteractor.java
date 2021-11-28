package ru.misha.carCurs.Domain.User.Info;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.misha.carCurs.Entities.User;
import ru.misha.carCurs.Models.UserDtoModel;

public class UserInfoInteractor implements UserInfoInputBoundary{

    private final UserInfoDataAccess userInfoDataAccess;

    private final UserInfoOutputBoundary userInfoOutputBoundary;

    public UserInfoInteractor(UserInfoDataAccess userInfoDataAccess, UserInfoOutputBoundary userInfoOutputBoundary) {
        this.userInfoDataAccess = userInfoDataAccess;
        this.userInfoOutputBoundary = userInfoOutputBoundary;
    }

    @Override
    public UserDtoModel backInfo() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (name.equals("anonymousUser"))
            return userInfoOutputBoundary.prepareNotAuthentication();
        else {
            User user = userInfoDataAccess.findByUsername(name);
            return userInfoOutputBoundary.prepareAuthentication(UserDtoModel.userMapper(user));
        }
    }
}
