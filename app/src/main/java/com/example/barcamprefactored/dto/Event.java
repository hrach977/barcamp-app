package com.example.barcamprefactored.dto;

public class Event {
    private int id;
    private String speaker;
    private String topic;

    public Event(){}

    public Event(int id, String speaker, String topic) {
        this.id = id;
        this.speaker = speaker;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "speaker: " +  this.speaker + " topic: " + this.topic;
    }
}
