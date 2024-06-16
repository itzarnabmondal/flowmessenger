package com.example.flowmessenger.views.components;

import com.vaadin.flow.component.Component;

public class MessageBoxListItem {

    private String avatarUrl;
    private String username;
    private String timestamp;
    private String text;
//     private boolean hasImage;
//     private boolean hasAttachment;
    private Component component;

    public MessageBoxListItem(String avatarUrl,
                              String username,
                              String timestamp,
                              String text) {
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.timestamp = timestamp;
        this.text = text;
        component = null;
    }

    public MessageBoxListItem(String avatarUrl,
                              String username,
                              String timestamp,
                              String text,
                              Component component) {
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.timestamp = timestamp;
        this.text = text;
        this.component = component;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Component getComponent() {
        return component;
    }
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "MessageBoxListItem{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", username='" + username + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", text='" + text + '\'' +
                ", component=" + component +
                '}';
    }

}