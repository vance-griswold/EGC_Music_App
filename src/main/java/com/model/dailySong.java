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
     * Assigns a daily song to the user, resets
     * @param song daily song assigned
     */
    public void assignDailySong(Song song)
    {
        this.song = song;
        this.dailySongCompleted = false;
    }

    /**
     * Plays the daily song challenge
     * @param song song from library to be played
     */
    public void playDailySong(Song song)
    {
       SongLibrary.playSong(song.getSheetMusic());
       this.dailySongCompleted = true;

       if(this.dailySongCompleted)
       {
        increaseStreak();
        increaseXP(100); //actual xp amount tbd
        System.out.println("You completed the daily song! Your current streak is " + streakCounter);
       }
    }

    /**
     * Resets the streak counter
     */
    public void resetStreak() 
    {
        this.streakCounter = 0;
    }

    /**
     * Increases the streak counter by one
     */
    public void increaseStreak()
    {
        if(this.dailySongCompleted)
        {
            this.streakCounter ++;
        }
    }

    /**
     * Increases the user's XP points
     * @param amount XP points added
     */
    public void increaseXP(int amount)
    {
        this.xpPoints += amount;
    }

    /**
     * Gets the current streak counter
     * @return user's streak count
     */
    public int getStreakCounter() {
        return streakCounter;
    }
}
