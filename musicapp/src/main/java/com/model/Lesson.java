package com.model;
import java.util.ArrayList;

/**
 * Lesson class to represent a lesson in the music app
 * @author Evil Gnome Clan
 */
public class Lesson {

    private String title;
    private ArrayList<String> instructions;
    private Song song;
    private int score;
    private Instrument instrument;

    /**
     * Constructor for Lesson class
     */
    public Lesson()
    {
        this.instructions = new ArrayList<>();
        this.score = 0;
    }

    /**
     * Gets score of the lesson
     * @return lesson score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Assigns the lesson to a student
     * @param student
     */
    public void assignToStudent(Student student)
    {
        if(student != null)
        {
            student.takeLesson(this);
        }
    }

    /**
     * Sets difficulty level of the song
     * @param level
     */
    public void setDifficulty(Difficulty level)
    {
        if(song != null)
        {
            song.setDifficulty(level);
        }
    }

    /**
     * Calculates the lesson score based on mistakes and total notes
     * @param mistakes
     * @param totalNotes
     */
    public void calculateScore(int mistakes, int totalNotes)
    {
        if(totalNotes > 0 && mistakes >= 0)
        {
            this.score = (totalNotes - mistakes) / totalNotes * 100;
        }
    }
}
