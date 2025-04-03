package com.model;

/**
 * Metronome class to represent a metronome in the music app
 * @author Evil Gnome Clan
 */
public class Metronome {
    
    private int speed;
    private int tempo;
    private boolean isEnabled;

    /**
     * Constructor for Metronome class
     */
    public Metronome()
    {
        this.speed = 60; // 60 bpm
        this.tempo = 4; // 4/4 time signature
        this.isEnabled = false;
    }

    /**
     * Toggles the metronome on or off
     */
    public void toggle()
    {
        isEnabled = !isEnabled; // Toggle the isEnabled flag
    }

    /**
     * Sets the speed of the metronome
     * @param speed the speed to set (in bpm)
     */
    public void setSpeed(int speed)
    {
        if(speed > 0)
        {
            this.speed = speed;
        }
    }

    /**
     * Sets the tempo of the metronome
     * @param tempo the tempo to set (beats per measure)
     */
    public void setTempo(int tempo)
    {
        if(tempo > 0)
        {
            this.tempo = tempo;
        }
    }

    /**
     * Get the speed of the metronome
     * @return the speed (in bpm)
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Get the tempo of the metronome
     * @return the tempo (beats per measure)
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Check if the metronome is enabled
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled() {
        return isEnabled;
    }

  
    
}
