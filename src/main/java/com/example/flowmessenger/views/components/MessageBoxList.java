package com.example.flowmessenger.views.components;

import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Div;

import java.util.Collection;

@Route("messageList")
public class MessageBoxList extends VerticalLayout {

    private Div container;

    public MessageBoxList() {
        setSizeFull();
        setSpacing(true);
        setPadding(true);

        container = new Div();
        container.setWidthFull();

        Scroller scroller = new Scroller(container);
        scroller.setSizeFull();

        add(scroller);
    }

    public void addMessage(MessageBoxListItem item) {
        container.add(new MessageBox(item));
    }

    public void addMessages(Collection<MessageBoxListItem> items) {
        items.forEach(item -> container.add(new MessageBox(item)));
    }

}