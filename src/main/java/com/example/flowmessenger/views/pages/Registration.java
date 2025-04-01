package com.example.flowmessenger.views.pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.example.flowmessenger.services.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
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
    private PasswordField password;
    private Button submit;

    private String firstNameValue;
    private String lastNameValue;
    private String usernameValue;
    private String passwordValue;

    public Registration() {
        setSizeFull();

        add(getRegistrationForm());
    }

    private VerticalLayout getRegistrationForm() {
        var title = new H2("Create Account");
        firstName = new TextField("First Name");
        firstName.setWidth("320px");
        firstName.setAllowedCharPattern("[a-zA-Z]+");
        firstName.setMaxLength(15);
        lastName = new TextField("Last Name");
        lastName.setWidth("320px");
        lastName.setAllowedCharPattern("[a-zA-Z]+");
        lastName.setMaxLength(15);
        fileBuffer = new FileBuffer();
        avatarUpload = new Upload(fileBuffer);
        avatarUpload.setWidth("320px");
        avatarUpload.setMaxFiles(1);
        avatarUpload.setMaxFileSize(5 * 1024 * 1024);
        avatarUpload.setAcceptedFileTypes("image/jpeg", "image/png");
        avatarUpload.setDropLabel(new Span("Drag and drop your profile picture here or click to upload."));
        avatarUpload.addSucceededListener(event -> {
            FileData savedFileData = fileBuffer.getFileData();
            File uploadedFile = savedFileData.getFile();
            try {
                Path targetFilePath = UserService.saveUploadedFile(uploadedFile, event.getFileName());
                Notification.show("File saved to: " + targetFilePath.toAbsolutePath());
            } catch (IOException e) {

                Notification.show("Error saving file: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });
        username = new TextField("Username");
        username.setWidth("320px");
        username.setAllowedCharPattern("[a-zA-Z0-9]+");
        username.setMinLength(3);
        username.setMaxLength(15);
        password = new PasswordField("Enter password");
        password.setWidth("320px");
        password.setAllowedCharPattern("^(?!.*\\s)[a-zA-Z0-9!@#$%^&*()_+={}|:;,.<>?/-]*$");
        password.setMinLength(8);
        password.setMaxLength(32);
        password.setHelperText("Password must contain at least one uppercase letter, one lowercase letter, one number, one special character and be between 8-32 characters long.");
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
                password,
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
        passwordValue = password.getValue();
    }

}