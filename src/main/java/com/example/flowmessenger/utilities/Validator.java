package com.example.flowmessenger.utilities;

import com.example.flowmessenger.services.UserService;
import com.vaadin.flow.component.notification.Notification;

public class Validator {

    private String namePattern = "^[A-Za-z]{2,25}$";
    private String usernamePattern = "^[A-Za-z0-9]{3,20}$";
    private String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,32}$";

    private UserService userService;

    public Validator(UserService userService) {
        this.userService = userService;
    }

    public boolean validateRegistrationForm(String firstNameValue, String lastNameValue, String usernameValue, String passwordOneValue, String passwordTwoValue) {

        // Validate first name
        if (!firstNameValue.matches(namePattern)) {
            Notification.show("First name is invalid. Only letters are allowed (2-50 characters).");
            return false;
        }
        // Validate last name
        if (!lastNameValue.matches(namePattern)) {
            Notification.show("Last name is invalid. Only letters are allowed (2-50 characters).");
            return false;
        }
        // Validator username
        if (!usernameValue.matches(usernamePattern)) {
            Notification.show("Username is invalid. Only letters and numbers are allowed (3-20 characters).");
            return false;
        }
        // Check if username is already taken
        if (userService.isUsernameTaken(usernameValue)) {
            Notification.show("Username is already taken.");
            return false;
        }
        // Validate password
        if (!passwordOneValue.matches(passwordPattern)) {
            Notification.show("Password is invalid. It must contain at least one uppercase letter, one lowercase letter, one number, one special character and be between 8-32 characters long.");
            return false;
        }
        // Check if both passwords matches or not
        if (!passwordOneValue.equals(passwordTwoValue)) {
            Notification.show("Passwords do not match.");
            return false;
        }

        return true; 
    }

}