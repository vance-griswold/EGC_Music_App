package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class UserList {
    // Instance variable to hold the list of users
    private ArrayList<User> users;
    private Map<String, User> userDatabase;
    private static UserList instance;
    private static User currentUser;

    // Constructor initializes the list of users
    private UserList() {
    users = DataLoader.getUsers();
    userDatabase = new HashMap<>();
    for (User user : users) {
        userDatabase.put(user.getEmailAddress(), user);
    }
}

    // Method to get an instance
    public static UserList getInstance() {
        if ( instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    // Get a user by username
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user; 
            }
        }
        return null; 
    }

    // Get the list of users
    public ArrayList<User> getUsers() {
        return users;
    }

    // Create a new user and add them to the list
    public void create(User user) {
        users.add(user);
        System.out.println("User created: " + user.getUserName());
    }

    // Read and print all users username
    public void read() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user.getUserName());
            }
        }
    }

    // Update a user's details 
    public void update(String username, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserName().equals(username)) {
                users.set(i, updatedUser); 
                System.out.println("User updated: " + username);
                return;
            }
        }
        System.out.println("User not found: " + username);
    }

    // Delete a user from the list by their username
    public void delete(String username) {
        User userToDelete = getUser(username);
        if (userToDelete != null) {
            users.remove(userToDelete); 
            System.out.println("User deleted: " + username);
        } else {
            System.out.println("User not found: " + username);
        }
    }

    // Save the user list 
    public void save() {
        
        System.out.println("User list saved.");
    }

    public boolean login(String emailAddress, String password) {
        if (userDatabase.containsKey(emailAddress)) {
            User user = userDatabase.get(emailAddress);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            } else {
                System.out.println("Error: Incorrect password.");
            }
        } else {
            System.out.println("Error: No account found with this email.");
        }
        return false;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
