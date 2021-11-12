package com.itis.kozlov.danya.Models;

public class AuthenticationData {
    private String username;
    private String password;

    public AuthenticationData(String username, String password){
        this.password = password;
        this.username = username;
    }


    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
