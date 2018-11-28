package com.example.netef.oshriandnetef.Classes;

public class MyActionEvent {
    private static final long serialVersionUID = 1L;
    private String message;
    private Object source;

    public MyActionEvent(Object source, String message) {
        this.source = source;
        this.message = message;

    }

    // get the message
    public String getMsg() {
        return message;
    }

    public Object getSource() {
        return source;
    }
}
