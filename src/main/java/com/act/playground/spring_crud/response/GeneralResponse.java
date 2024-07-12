package com.act.playground.spring_crud.response;

import com.act.playground.spring_crud.model.User;

public class GeneralResponse {
    private String message;
    private boolean success;
    private User user;
    
    public GeneralResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public GeneralResponse(String message, boolean status, User user) {
        this.message = message;
        this.success = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
