package com.example.dnp.demomockito;

import java.io.Serializable;

/**
 * Created by DNP on 1/15/2017.
 */

public class MyUser implements Serializable {
    private String name;
    private String address;
    private int age;

    public MyUser(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
