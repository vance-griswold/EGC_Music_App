package com.model;

/**
 * MistakeIndicator class to track mistakes made
 * @author Evil Gnome Clan
 */
public class MistakeIndicator {

    private int totalMistakes;
    private int currentMistakes;

    /**
     * Constructor for MistakeIndicator class
     */
    public MistakeIndicator()
    {
        this.totalMistakes = 0;
        this.currentMistakes = 0;
    }

    /**
     * Tracks a mistake made by the user
     * @param playedNote
     * @param expectedNote
     */
    public void trackMistake(Note playedNote, Note expectedNote)
    {

    }

    /**
     * Resets the current mistakes count
     */
    public void resetMistakes()
    {

    }

    /**
     * Adds a mistake to the total mistakes count
     */
    public void addMistake()
    {

    }


}
