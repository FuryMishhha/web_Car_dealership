package ru.misha.carCurs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.misha.carCurs.Domain.User.Info.UserInfoInputBoundary;
import ru.misha.carCurs.Domain.User.Registration.UserRegistrationInputBoundary;
import ru.misha.carCurs.Models.UserDtoModel;

@RestController
public class UsersController {

    UserRegistrationInputBoundary userRegistrationInputBoundary;

    UserInfoInputBoundary userInfoInputBoundary;

    public UsersController(UserRegistrationInputBoundary userRegistrationInputBoundary, UserInfoInputBoundary userInfoInputBoundary) {
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
        this.userInfoInputBoundary = userInfoInputBoundary;
    }

    @GetMapping("/get_account")
    public UserDtoModel dataForAccount(){
        return userInfoInputBoundary.backInfo();
    }
}
