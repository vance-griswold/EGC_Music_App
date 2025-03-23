package com.model;
import java.util.ArrayList;

/**
 * Teacher class to represent a teacher user
 * Inherits from User class
 */
public class Teacher extends User {
    private ArrayList<Classroom> classes;

    /**
     * Constructor for Teacher class
     */
    public Teacher(String firstName, String lastName, String emailAddress, String username, String password) {
        super(firstName, lastName, emailAddress, username, password, "Teacher");
        this.classes = new ArrayList<>();
    }

    /**
     * Adds a new class to the teacher's list of classes
     * @param newClasses list of classrooms to be added
     */
    public void addNewClass(ArrayList<Classroom> newClasses) {
        if (newClasses != null) {
            this.classes.addAll(newClasses);
        }
    }

    /**
     * Getter for classes
     * @return List of classrooms
     */
    public ArrayList<Classroom> getClasses() {
        return classes;
    }
}
