package ru.misha.carCurs.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.misha.carCurs.Domain.User.Registration.RegistrationRequest;
import ru.misha.carCurs.Domain.User.Registration.RegistrationResponseModel;
import ru.misha.carCurs.Domain.User.Registration.UserRegistrationInputBoundary;

@RestController
public class RegistrationController {

    private final UserRegistrationInputBoundary userRegistrationInputBoundary;

    public RegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary) {
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }

    @PostMapping("/addUser")
    public RegistrationResponseModel addUser(@RequestBody RegistrationRequest registrationRequest) {
        return userRegistrationInputBoundary.save(registrationRequest);
    }
}
