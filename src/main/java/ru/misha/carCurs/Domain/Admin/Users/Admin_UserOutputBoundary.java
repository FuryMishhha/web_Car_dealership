package ru.misha.carCurs.Domain.Admin.Users;

import ru.misha.carCurs.Models.UserDtoModel;

import java.util.List;

public interface Admin_UserOutputBoundary {
    boolean prepareSuccessEditUserView(UserDtoModel userDtoModel);
    boolean prepareFailEditUserView(UserDtoModel userDtoModel);
    UserDtoModel prepareDeletedUserView(UserDtoModel userDtoModel);
    UserDtoModel prepareFindedUserView(UserDtoModel userDtoModel);
    List<UserDtoModel> convertUsers(List<UserDtoModel> users);
}
