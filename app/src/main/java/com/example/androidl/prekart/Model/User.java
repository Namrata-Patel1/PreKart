package com.example.androidl.prekart.Model;

/**
 * Created by JAATbOY on 11/27/2017.
 */

public class User {

    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;

    public User() {
    }
//phone can be null so we can remove phone from constructor
    public User(String name, String password) {
        Name = name;
        Password = password;
        IsStaff = "false";
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
