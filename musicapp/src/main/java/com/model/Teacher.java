package com.model;
import java.util.ArrayList;

/**
 * Teacher class to represent a teacher user
 * Inherits from User class
 * @author Evil Gnome Clan
 */
public class Teacher extends User {
    private ArrayList<Classroom> classes;
}

/**
 * Constructor for Teacher class
 */
public Teacher() 
{
    this.classes = new ArrayList<>();
}

/**
 * Adds a new class to the teacher's list of classes
 * @param newClasses list of classrooms to be added
 */
public void addNewClass(ArrayList<Classroom> newClasses)
{
    if(newClasses != null)
    {
        this.classes.addAll(newClasses);
    }
}