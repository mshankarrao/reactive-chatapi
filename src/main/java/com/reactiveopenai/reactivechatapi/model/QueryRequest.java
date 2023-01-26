package com.reactiveopenai.reactivechatapi.model;

import java.io.Serializable;

public class QueryRequest implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
