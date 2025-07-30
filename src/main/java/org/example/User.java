package org.example;

public class User {
    String email;
    String password;
    boolean isVip;

    public User(String email, String password, boolean isVip){
        this.email=email;
        this.password=password;
        this.isVip=isVip;
    }

    public boolean isVip() {
        return isVip;
    }
    public void setVip(Boolean vip_state){
        this.isVip=vip_state;
    }
}
