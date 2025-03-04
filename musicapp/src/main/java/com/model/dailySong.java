package com.model;
import java.util.UUID;

/**
 * Class that assigns a daily song to a user
 * @author Evil Gnome Clan
 */
public class dailySong {
    
    private UUID id;
    private Song song;
    private int xpPoints;
    private int streakCounter;
    private boolean dailySongCompleted;

    /**
     * Constructor for dailySong class
     */
    public dailySong()
    {
        this.id = UUID.randomUUID();
        this.xpPoints = 0;
        this.streakCounter = 0;
        this.dailySongCompleted = false;
    }

    /**
     * Assigns a daily song to the user
     * @param song
     */
    public void assignDailySong(Song song)
    {
        this.song = song;
        this.dailySongCompleted = false;
    }

    /**
     * Plays the daily song challenge
     * @param song
     */
    public void playDailySong(Song song)
    {

    }

    /**
     * Resets the streak counter
     */
    public void resetStreak() 
    {

    }

    /**
     * Increases the streak counter by one
     */
    public void increaseStreak()
    {

    }

    /**
     * Increases the user's XP points
     * @param amount
     */
    public void increaseXP(int amount)
    {

    }
}
