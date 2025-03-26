package com.model;

/**
 * Piano class to represent a piano instrument in the music app
 * @author Evil Gnome Clan
 */
public class Piano extends Instrument {
    
    private boolean isSheetMusicEnabled;
    private boolean isFallingTabsEnabled;

    /**
     * Constructor for Piano class
     */
    public Piano()
    {
        this.isSheetMusicEnabled = false;
        this.isFallingTabsEnabled = false;
    }

    /**
     * Displays the sheet music for the piano
     */
    public void displaySheetMusic()
    {
        isSheetMusicEnabled = true;
    }

    /**
     * Displays the falling tabs for the piano
     */
    public void displayFallingTabs()
    {
        isFallingTabsEnabled = true;
    }
    
    /**
     * Plays a note on the piano
     */
    public void playNote()
    {

    }

    /**
     * Plays a chord on the piano
     */
    public void playChord()
    {

    }
}
