package com.example.flowmessenger.views.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MessageBox extends HorizontalLayout {

    private Avatar avatar;
    private Span username;
    private Span timestamp;
    private Paragraph text;
    private Div content;
    private Image image;

    private MessageBoxListItem item;

    public MessageBox(MessageBoxListItem item) {
        this.item = item;

        initializeComponents();
        configureComponents();
        buildLayout();
    }

    private void initializeComponents() {
        avatar = new Avatar();
        username = new Span();
        timestamp = new Span();
        text = new Paragraph();
        image = new Image();
        content = new Div();
    }

    private void configureComponents() {
        if (item.getAvatarUrl() != null) {
            avatar.setImage(item.getAvatarUrl());
        } else {
            avatar.setAbbreviation("AM");
        }
        username.setText(item.getUsername());
        username.getStyle().set("font-size", "18px");
        timestamp.setText(item.getTimestamp());
        timestamp.getStyle().set("font-size", "12px");
        text.setText(item.getText());
//         image.setWidth("240px");

    }

    private void buildLayout() {
        VerticalLayout avatarLayout = createAvatarLayout();
        VerticalLayout mainLayout = createMainLayout();
        add(avatarLayout, mainLayout);
    }

    private VerticalLayout createAvatarLayout() {
        VerticalLayout avatarLayout = new VerticalLayout(avatar);
        avatarLayout.setPadding(false);
        avatarLayout.setMargin(false);
        avatarLayout.getStyle().set("width", "fit-content");
        avatarLayout.getStyle().set("padding-top", "10px");
        return avatarLayout;
    }

    private VerticalLayout createMainLayout() {
        VerticalLayout mainLayout = new VerticalLayout(createUsernameAndTimestampLayout(), createContentLayout());
        mainLayout.setPadding(false);
        mainLayout.setMargin(false);
        mainLayout.getStyle().set("gap", "0px");
        return mainLayout;
    }

    private VerticalLayout createUsernameAndTimestampLayout() {
        VerticalLayout layout = new VerticalLayout(username, timestamp);
        layout.setPadding(false);
        layout.setMargin(false);
        layout.getStyle().set("align-items", "left").set("gap", "0px");
        return layout;
    }

    private Div createContentLayout() {
        content.getStyle().set("gap", "0px");
        content.add(text);
//         if (item.hasImage()) {
//             content.add(image);
//         }
//         if (item.hasAttachment()) {
//             content.add(item.getComponent());
//         }
        if (item.getComponent() != null && item.getComponent() instanceof Image ) {
            content.add(item.getComponent());
        }
        return content;
    }

}