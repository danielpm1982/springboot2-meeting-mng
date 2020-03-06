package com.danielpm1982.springboot2meetingmng.modelAttribute;

public class EventModelAttribute {
    private String name;
    private String theme;
    private String outfit;
    private String host;
    private String attendance;
    private String details;
    public EventModelAttribute() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getOutfit() {
        return outfit;
    }
    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getAttendance() {
        return attendance;
    }
    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "EventModelAttribute{" +
                "name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", outfit='" + outfit + '\'' +
                ", host='" + host + '\'' +
                ", attendance='" + attendance + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
