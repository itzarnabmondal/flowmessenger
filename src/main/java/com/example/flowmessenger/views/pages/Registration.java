package com.example.flowmessenger.views.pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.example.flowmessenger.services.RegistrationService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileBuffer;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.router.Route;

@Route("registration")
public class Registration extends Div {

    private TextField firstName;
    private TextField lastName;
    private FileBuffer fileBuffer;
    private Upload avatarUpload;
    private TextField username;
    private PasswordField passwordOne;
    private PasswordField passwordTwo;
    private Button submit;

    private String firstNameValue;
    private String lastNameValue;
    private String usernameValue;
    private String passwordOneValue;
    private String passwordTwoValue;

    public Registration() {
        setSizeFull();

        add(getRegistrationForm());
    }

    private VerticalLayout getRegistrationForm() {
        var title = new H2("Create Account");
        firstName = new TextField("First Name");
        firstName.setWidth("320px");
        lastName = new TextField("Last Name");
        lastName.setWidth("320px");
        fileBuffer = new FileBuffer();
        avatarUpload = new Upload(fileBuffer);
        avatarUpload.setWidth("320px");
        avatarUpload.setMaxFiles(1);
        avatarUpload.setMaxFileSize(5 * 1024 * 1024);
        avatarUpload.setAcceptedFileTypes("image/jpeg", "image/png");
        avatarUpload.addSucceededListener(event -> {
            FileData savedFileData = fileBuffer.getFileData();
            File uploadedFile = savedFileData.getFile();
            try {
                Path targetFilePath = RegistrationService.saveUploadedFile(uploadedFile, event.getFileName());
                Notification.show("File saved to: " + targetFilePath.toAbsolutePath());
            } catch (IOException e) {

                Notification.show("Error saving file: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });
        username = new TextField("Username");
        username.setWidth("320px");
        passwordOne = new PasswordField("Enter password");
        passwordOne.setWidth("320px");
        passwordTwo = new PasswordField("Confirm password");
        passwordTwo.setWidth("320px");
        submit = new Button("Submit");
        submit.setWidth("144px");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(click -> {
            // TODO
            loadDataFromForm();
        });
        var close = new Button("Close");
        close.addClickListener(click -> {
            UI.getCurrent().navigate("welcome");
        });
        var layout = new VerticalLayout(
                title,
                firstName,
                lastName,
                avatarUpload,
                username,
                passwordOne,
                passwordTwo,
                submit,
                close);
        layout.setAlignItems(FlexLayout.Alignment.CENTER);
        FlexLayout flexLayout = new FlexLayout(layout);
        flexLayout.setSizeFull();
        flexLayout.setJustifyContentMode(FlexLayout.JustifyContentMode.CENTER);
        flexLayout.setAlignItems(FlexLayout.Alignment.CENTER);
        return layout;
    }

    public void loadDataFromForm() {
        firstNameValue = firstName.getValue();
        lastNameValue = lastName.getValue();
        usernameValue = username.getValue();
        passwordOneValue = passwordOne.getValue();
        passwordTwoValue = passwordTwo.getValue();
    }

}