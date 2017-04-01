package com.hub.model;

/**
 * @author ilakeyc
 * @since 2017/4/1
 */
public class Person extends BaseModel {
    private static final long serialVersionUID = -4873614405370681044L;

    private int age;
    private int gender;
    private String friends;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }
}
