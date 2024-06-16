package com.example.flowmessenger.models;

public class Conversation {

    private Long id;
    private Type type;
    private String name; // only for group conversations
    private long unixTimestamp;

    public enum Type {
        ONE_TO_ONE,
        GROUP
    }

    public Conversation() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }
    public void setUnixTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

}