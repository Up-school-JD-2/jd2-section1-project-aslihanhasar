package com.aslihanhsr.projects.movieLibrary;

public class User {
    private final Long userId;
    private String userFullName;
    private String userPassword;
    private String userEmail;

    public User(Long userId, String userFullName, String userPassword, String userEmail) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User Id : ").append(userId).append('\n');
        sb.append("User Name : ").append(userFullName).append('\n');
        sb.append("User e-mail :").append(userEmail).append('\n');
        sb.append('\n');
        return sb.toString();
    }
}
