package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * A class to represent a user
 */
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private ArrayList<Playlist> playlists;
    private String password;
    private String userRole;
    private int experienceLevel;
    private int xpPoints;

    public User(String firstName, String lastName, String emailAddress, String username, String password, String userRole) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.experienceLevel = 1;
        this.xpPoints = 0;
        this.playlists = new ArrayList<>();
    }

    /**
     * Constructor for the User class
     * @param id the id of the user
     * @param role  the role of the user
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username of the user
     * @param playlists the playlists of the user
     * @param emailAddress the email address of the user
     * @param level the experience level of the user
     * @param xpPoints the experience points of the user
     * @param password the password of the user
     */
    public User(UUID id, String role, String firstName, String lastName, String userName, ArrayList<Playlist> playlists, String emailAddress, int level, int xpPoints, String password) {
        this.id = id;
        this.userRole = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.playlists = playlists;
        this.emailAddress = emailAddress;
        this.experienceLevel = level;
        this.xpPoints = xpPoints;
        this.password = password;
}

    /**
     * Increase the user's experience level
     */
    public void increaseLevel() {
        int newLevel = (int)(this.xpPoints / 2000) + 1; //level starts at 1
        if(newLevel > this.experienceLevel)
        {
            this.experienceLevel = newLevel;
        }
    }

    /**
     * Add experience points to the user
     * @param xp the experience points to add
     */
    public void addXP(int xp) {
        this.xpPoints += xp;
        increaseLevel();
    }

    /**
     * Get the id of the user
     * @return the id of the user
     */
    public String getId() {
        return id.toString();
    }

    /**
     * Get the role of the user
     * @return the role of the user
     */
    public String getRole() {
        return userRole;
    }

    /**
     * Get the username of the user
     * @return the username of the user
     */
    public String getUserName() {
        return username;
    }

    /**
     * Get the first name of the user
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name of the user
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the user's email address
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the user's current experience level
     * @return user's experience level
     */
    public int getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Get the current user's xp points
     * @return xp points
     */
    public int getXpPoints() {
        return xpPoints;
    }

    /**
     * Get the user's password
     * @return user password
     */
    public String getPassword() {
        return password;
    }
}
