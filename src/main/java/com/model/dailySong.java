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
    private int songCounter; //tracks total songs completed
    private boolean dailySongCompleted;

    /**
     * Constructor for dailySong class
     */
    public dailySong()
    {
        this.id = UUID.randomUUID();
        this.xpPoints = 0;
        this.songCounter = 0;
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
            increaseSongCounter();
            increaseXP(100); //actual xp amount tbd
            //System.out.println("You completed the daily song! Your current streak is " + streakCounter);
       }
        else
        {
            //System.out.println("You have not completed the daily song yet.");
        }
    }

    /**
     * Checks if the daily song has been completed
     * @return true if completed, false if not
     */
    public boolean isDailySongCompleted()
    {
        return dailySongCompleted;
    }

    /**
     * Increases the song counter by one
     */
    public void increaseSongCounter()
    {
        this.songCounter++; //running total of songs the user has completed
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
     * Gets the current song count
     * @return total number of songs completed
     */
    public int getSongCounter() {
        return songCounter;
    }

    /**
     * Gets the unique ID of the daily song
     * @return unique song ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the daily song assigned to the user
     * @return daily song
     */
    public Song getSong() {
        return song;
    }

    /**
     * Gets the XP points of the user
     * @return user's xp points
     */
    public int getXpPoints() {
        return xpPoints;
    }
}
