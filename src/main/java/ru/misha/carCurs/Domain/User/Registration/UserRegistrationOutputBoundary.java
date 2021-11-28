package ru.misha.carCurs.Domain.User.Registration;

public interface UserRegistrationOutputBoundary {
    RegistrationResponseModel prepareSuccessView();
    RegistrationResponseModel prepareFailView(RegistrationResponseModel registrationResponseModel);
}
