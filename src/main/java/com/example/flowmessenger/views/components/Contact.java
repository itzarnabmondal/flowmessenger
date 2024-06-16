package com.example.flowmessenger.views.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Contact extends HorizontalLayout {

    public Contact() {
        setAlignItems(Alignment.CENTER);

        var avatar = new Avatar();
        var name = new H5("Arnab Mondal");

        add(avatar, name);
    }

}