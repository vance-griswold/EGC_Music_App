package com.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Leaderboard class to track top users in the music app
 * @author Evil Gnome Clan
 */
public class Leaderboard {
    
    private ArrayList<User> highestLevelUsers;
    private static final int MAX_USERS = 30; //maximum users to display on the leaderboard

    /**
     * Constructor for Leaderboard class, initializes the leaderboard lists
     */
    public Leaderboard()
    {
        this.highestLevelUsers = new ArrayList<User>();
    }

    /**
     * Updates the leaderboard with the latest user data
     * @param user the user to be updated in the Leaderboard
     */
    public void updateLeaderboard(User user)
    {
        if(user == null)
        {
            System.out.println("Error: User is null, cannot update Leaderboard");
            return;
        }
        updateHighestLevelUsers(user);
    }

    /**
     * Updates highest level users
     * @param user highest level users
     */
    public void updateHighestLevelUsers(User user)
    {
        if(!highestLevelUsers.contains(user))
        {
            highestLevelUsers.add(user);
        }
        sortHighestLevelUsers();

        if(highestLevelUsers.size() > MAX_USERS)
        {
            highestLevelUsers.remove(highestLevelUsers.size() - 1);
        }
    }

    /**
     * Sorts highest level users
     * Compares users by experience level first, if users have the same level then compares by xp points
     */
    public void sortHighestLevelUsers()
    {
        Collections.sort(highestLevelUsers, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int levelComparison = Integer.compare(user2.getExperienceLevel(), user1.getExperienceLevel());
                if(levelComparison != 0)
                {
                    return levelComparison;
                }
                return Integer.compare(user2.getXpPoints(), user1.getXpPoints());
            }   
        });
    }

    /**
     * Gets the highest level users
     * @return a copy of the list of highest level users (does not modify)
     */
    public ArrayList<User> getHighestLevelUsers()
    {
        return new ArrayList<>(highestLevelUsers);
    }

    /**
     * Displays the highest level users
     */
    public void displayHighestLevelUsers()
    {
        System.out.println("Highest Level Users:" );
        int rank = 1;

        for(User user : highestLevelUsers)
        {
            System.out.println(rank + ". " + user.getUserName() + " --- Level: " + user.getExperienceLevel());
            rank++;
        }
    }

    /**
     * Displays all user Leaderboard information
     */
    public void displayLeaderboard()
    {
        System.out.println("***Leaderboard Rankings***");
        displayHighestLevelUsers();
    }
}
