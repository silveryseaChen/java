package com.chy.reflect;

/**
 * Created by chy on 2018/11/27.
 */
public class User {

    public String name;
    private String password;
    protected String age;
    String status;

    public User(){
        this.name = "name_val";
        this.password = "password_val";
        this.age = "age_val";
        this.status = "status_val";
    }

}
