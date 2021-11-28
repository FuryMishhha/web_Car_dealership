package ru.misha.carCurs.Controllers;

import ru.misha.carCurs.Domain.User.Registration.RegistrationResponseModel;
import ru.misha.carCurs.Domain.User.Registration.UserRegistrationOutputBoundary;

public class RegistrationPresenter implements UserRegistrationOutputBoundary {
    @Override
    public RegistrationResponseModel prepareSuccessView() {
        return new RegistrationResponseModel(false,false);
    }

    @Override
    public RegistrationResponseModel prepareFailView(RegistrationResponseModel registrationResponseModel) {
        return registrationResponseModel;
    }
}
