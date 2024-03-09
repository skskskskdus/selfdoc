package com.example.application_login;

public class Activity_UserAccount {
    private String IdToken;
    private String  emailId;
    private  String password;


    public Activity_UserAccount() { }
    public String getIdToken() {
        return IdToken;
    }

    public void setIdToken(String idToken) {
        IdToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
