package com.model;
import java.util.ArrayList;

/**
 * Leaderboard class to track top users in the music app
 * @author Evil Gnome Clan
 */
public class Leaderboard {
    
    private ArrayList<User> highestLevelUsers;
    private ArrayList<User> highestStreakUsers;
    private ArrayList<User> dailyTopScorers;

    /**
     * Constructor for Leaderboard class, initializes the leaderboard lists
     */
    public Leaderboard()
    {
        this.highestLevelUsers = new ArrayList<User>();
        this.highestStreakUsers = new ArrayList<User>();
        this.dailyTopScorers = new ArrayList<User>();
    }

    /**
     * Updates the leaderboard with the latest user data
     * @param user
     */
    public void updateLeaderboard(User user)
    {

    }
}
