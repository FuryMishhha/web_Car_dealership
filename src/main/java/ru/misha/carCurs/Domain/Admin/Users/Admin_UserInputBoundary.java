package ru.misha.carCurs.Domain.Admin.Users;

import org.springframework.stereotype.Component;
import ru.misha.carCurs.Models.UserDtoModel;

import java.util.List;

@Component
public interface Admin_UserInputBoundary {
    List<UserDtoModel> getAll();
    UserDtoModel findConcreteUser(Long id);
    boolean editUser(Long id, EditUserRequestModel editUserRequestModel);
    List<UserDtoModel> filterUsers(FilterUserRequestModel filterUserRequestModel);
    UserDtoModel deleteUser(Long id);
}
