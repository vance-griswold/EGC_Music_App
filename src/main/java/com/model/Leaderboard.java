package com.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
/**
 * Leaderboard class to track top users in the music app
 * @author Evil Gnome Clan
 */
public class Leaderboard {
    
    private ArrayList<User> highestLevelUsers;
    private ArrayList<User> highestStreakUsers;
    //private ArrayList<User> dailyTopScorers;
    //private static final int LEADERBOARD_SIZE = 20;

    /**
     * Constructor for Leaderboard class, initializes the leaderboard lists
     */
    public Leaderboard()
    {
        this.highestLevelUsers = new ArrayList<User>();
        this.highestStreakUsers = new ArrayList<User>();
        //this.dailyTopScorers = new ArrayList<User>();
    }

    /**
     * Updates the leaderboard with the latest user data
     * @param user
     */
    public void updateLeaderboard(User user)
    {
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
    }

    /**
     * Updates highest streak users
     * @param user highest streak users
     */
    public void updateHighestStreakUsers(User user)
    {
        //TODO
    }
    
    /**
     * Updates users by daily top scorers
     *
    public void updateDailyTopScorers(User user)
    {

    }
    */

    /**
     * Sorts highest level users using selection sort
     */
    public void sortHighestLevelUsers()
    {
        int n = highestLevelUsers.size();
        for(int i = 0; i < n - 1; i++)
        {
            int maxIndex = i;
            for(int j = i + 1; j < n; j++)
            {
                User user1 = highestLevelUsers.get(j);
                User user2 = highestLevelUsers.get(maxIndex);

                if(user1.getExperienceLevel() > user2.getExperienceLevel() ||
                    (user1.getExperienceLevel() == user2.getExperienceLevel() && user1.getXpPoints() > user2.getXpPoints()))
                    {
                        maxIndex = j;
                    }
            }
            if(maxIndex != i)
            {
                User temp = highestLevelUsers.get(i);
                highestLevelUsers.set(i, highestLevelUsers.get(maxIndex));
                highestLevelUsers.set(maxIndex, temp);
            }
        }
    }

    /**
     * Sorts users by number of daily songs completed
     */
    public void sortHighestStreakUsers()
    {
        //TODO
    }

    /**
     * Sorts users by top daily scores
     *
    public void sortDailyTopScoreres()
    {
        
    }
    */


    /**
     * Displays the highest level users
     */
    public void displayHighestLevelUsers()
    {
        System.out.println("Highest Level Users:" );
        for(User user : highestLevelUsers)
        {
            System.out.println(user.getUserName() + " --- Level: " + user.getExperienceLevel());
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
