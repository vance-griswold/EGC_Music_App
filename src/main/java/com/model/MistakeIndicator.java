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
        if(playedNote != expectedNote)
        {
            addMistake();
        }
    }

    /**
     * Resets the current mistakes count
     */
    public void resetMistakes()
    {
        this.currentMistakes = 0;
    }

    /**
     * Adds a mistake to the total mistakes count
     */
    public void addMistake()
    {
        this.currentMistakes++;
        this.totalMistakes++;
    }

    /**
     * Gets the current mistakes the user has
     * @return current mistakes
     */
    public int getCurrentMistakes()
    {
        return currentMistakes;
    }

    /**
     * Gets the total mistakes the user has
     * @return total mistakes
     */
    public int getTotalMistakes()
    {
        return totalMistakes;
    }
}
