package org.example;

public class HelloWorld {
    private String message; // es varaible ko used kregy inside bean.xml, //// Dependency (managed by Spring)

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //The setter (setMessage(String message)) allows Spring to inject a value
    // (Hello Spring!) into it.
}
