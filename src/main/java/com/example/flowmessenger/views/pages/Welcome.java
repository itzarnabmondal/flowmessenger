package com.example.flowmessenger.views.pages;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome")
public class Welcome extends Div {

    private final LoginOverlay loginOverlay;

    public Welcome() {
        setSizeFull();

        loginOverlay = new LoginOverlay();
        configLoginOverlay();

        var welcomeTxt = new H1("👋 Welcome");

        var loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClickListener(click -> {
            loginOverlay.setOpened(true);
        });

        var createAccountButton = new Button("Create Account");
        createAccountButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        createAccountButton.addClickListener(click -> {
            UI.getCurrent().navigate("registration");
        });

        var layout = new VerticalLayout(welcomeTxt, loginButton, createAccountButton);
        layout.setAlignItems(FlexLayout.Alignment.CENTER);

        FlexLayout flexLayout = new FlexLayout(layout);
        flexLayout.setSizeFull();
        flexLayout.setJustifyContentMode(FlexLayout.JustifyContentMode.CENTER);
        flexLayout.setAlignItems(FlexLayout.Alignment.CENTER);

        add(flexLayout);
    }

    private void configLoginOverlay() {
        loginOverlay.setTitle("Messenger");
        loginOverlay.setDescription("Built with ♥ and Vaadin");
        loginOverlay.getFooter().add(getFooterLayout());
    }

    private Component getFooterLayout() {
        var close = new Button("Close");
        close.addClickListener(click -> loginOverlay.close());
        var footerLayout = new HorizontalLayout(close);
        footerLayout.setJustifyContentMode(HorizontalLayout.JustifyContentMode.CENTER);
        return footerLayout;
    }

}