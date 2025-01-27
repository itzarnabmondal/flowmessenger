package com.example.flowmessenger.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;

public class ChatLayout extends VerticalLayout {

    private MessageBoxList messageBoxList;

    public ChatLayout() {
        add(getTopBar(), getMessageBoxList(), getBottomBar());
        setHeightFull(); // Ensure the layout takes up full screen height
        getStyle().set("position", "relative");
    }

    private HorizontalLayout getTopBar() {
        var avatar = new Avatar();
        var name = new H5("Arnab Mondal");
        expand(name);
        var searchField = new TextField();
        searchField.setPlaceholder("Search messages");
        searchField.setClearButtonVisible(true);
        searchField.getStyle().setPaddingRight("50px");

        var horizontalLayout = new HorizontalLayout(avatar, name, searchField);
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);

        // Make the top bar sticky
        horizontalLayout.getStyle().set("position", "sticky").set("top", "0").set("background", "white").set("z-index",
                "10");

        return horizontalLayout;
    }

    private Component getMessageBoxList() {
        messageBoxList = new MessageBoxList();
        long currentTime = System.currentTimeMillis();
        var item = new MessageBoxListItem(
                "https://avatars.githubusercontent.com/u/110527370",
                "arnab",
                "" + currentTime,
                "Hello ");
        for (int i = 0; i < 100; i++) {
            messageBoxList.addMessage(item);
        }

        // Make the message box scrollable
        messageBoxList.getStyle().set("overflow-y", "auto").set("flex-grow", "1");

        return messageBoxList;
    }

    private HorizontalLayout getBottomBar() {
        var textArea = new TextArea();
        expand(textArea);
        var attachmentButton = new Button("📂");
        attachmentButton.addClickListener(click -> showFileUploadDialog());
        var sendButton = new Button("Send");
        sendButton.addClickListener(click -> {
            // TODO: Handle message sending
            textArea.clear(); // to clear text input field after sending a message
        });

        var horizontalLayout = new HorizontalLayout(textArea, attachmentButton, sendButton);
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);

        // Make the bottom bar sticky
        horizontalLayout.getStyle().set("position", "sticky").set("bottom", "0").set("background", "white")
                .set("z-index", "10");

        return horizontalLayout;
    }

    private void showFileUploadDialog() {
        var dialog = new Dialog();
        dialog.setHeaderTitle("Upload Files");
        var multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        var multiFilesUpload = new Upload(multiFileMemoryBuffer);
        var submitButton = new Button("Submit");
        var dialogLayout = new VerticalLayout(multiFilesUpload, submitButton);
        dialogLayout.setAlignItems(Alignment.CENTER);
        dialog.add(dialogLayout);
        dialog.open();
    }
}
