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

    }

    /**
     * Sets the speed of the metronome
     * @param speed
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
     * @param tempo
     */
    public void setTempo(int tempo)
    {
    
    }
}
