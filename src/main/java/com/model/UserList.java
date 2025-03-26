package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A class to represent a list of users
 */
public class UserList {
    private ArrayList<User> users;
    private Map<String, User> userDatabase;
    private static UserList instance;
    private static User currentUser;

    /**
     * Constructor for the UserList class
     */
    private UserList() {
    users = DataLoader.getUsers();
    userDatabase = new HashMap<>();
    for (User user : users) {
        userDatabase.put(user.getEmailAddress(), user);
    }
}

    /**
     * Get the instance of the UserList class
     * @return the instance of the UserList class
     */
    public static UserList getInstance() {
        if ( instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    /**
     * Get a user by their username
     * @param username the username of the user
     * @return the user with the given username
     */
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user; 
            }
        }
        return null; 
    }

    /**
     * Get a user by their email address
     * @return the user
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Create a new user
     * @param user the user to create
     */
    public void create(User user) {
        users.add(user);
        System.out.println("User created: " + user.getUserName());
    }

    /**
     * Read the list of users
     */
    public void read() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user.getUserName());
            }
        }
    }

    /**
     * Update a user in the list
     * @param username the username of the user to update
     * @param updatedUser the updated user
     * @return the updated user
     */ 
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

    /**
     * Delete a user from the list
     * @param username the username of the user to delete
     */
    public void delete(String username) {
        User userToDelete = getUser(username);
        if (userToDelete != null) {
            users.remove(userToDelete); 
            System.out.println("User deleted: " + username);
        } else {
            System.out.println("User not found: " + username);
        }
    }

    /**
     *  Save the list of users
     */ 
    public void save() {
        
        System.out.println("User list saved.");
    }

    /**
     * Sign up a new user
     * @param emailAddress the email address of the user
     * @param password the password of the user
     * @return boolian value
     */
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

    /**
     * Log out the current user
     * @return current user
     */
    public static User getCurrentUser() {
        return currentUser;
    }
}
