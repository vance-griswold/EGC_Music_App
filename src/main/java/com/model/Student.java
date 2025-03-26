package com.model;
import java.util.ArrayList;

/**
 * Student class to represent a student user
 * Inherits from User class
 * @author Evil Gnome Clan
 */
public class Student extends User {

    private ArrayList<Lesson> assignments;

    /**
     * Constructor for Student class
     */
    public Student()
    {
        this.assignments = new ArrayList<>();
    }

    /**
     * Adds a new lesson to the student's list of assignments
     * @param lesson
     */
    public void takeLesson(Lesson lesson)
    {
        if(lesson != null)
        {
            this.assignments.add(lesson);
        }
    }
}
