package com.example.demo.model.sns;

public class Notification {

    private final String subject;

    private final String message;

    public Notification(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
