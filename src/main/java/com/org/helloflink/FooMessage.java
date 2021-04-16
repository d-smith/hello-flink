package com.org.helloflink;

public class FooMessage {
    private String message;

    public FooMessage() {

    }

    public FooMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FooMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
