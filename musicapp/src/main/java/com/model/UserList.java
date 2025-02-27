package com.model;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private static UserList instance;

    private UserList() {
        this.users = new ArrayList<>();
    }

    public static UserList getInstance(UserList users) {
        if (instance == null) {
            instance = users;
        }
        return instance;
    }

    public User getUser(String username) {
        return null;
    }

    public void create(User user) {
        users.add(user);
    }

    public void read() {
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    public void update() {
        System.out.println("Update user details.");
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void save() {
        System.out.println("User list saved.");
    }

 
}
