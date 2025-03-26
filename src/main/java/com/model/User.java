package com.model;
import java.util.ArrayList;
import java.util.UUID;

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

    public User(UUID id, String role, String firstName, String lastName,  String userName, ArrayList<Playlist> playlists, String emailAddress, int level, int xpPoints, String password){
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

    public void increaseLevel(int xp) {
        
    }

    public void addXP(int xp) {
        this.xpPoints += xp;
    }

    public String getId() {
        return id.toString();
    }

    public String getRole() {
        return userRole;
    }

    public String getUserName() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public int getXpPoints() {
        return xpPoints;
    }

    public String getPassword() {
        return password;
    }
}
