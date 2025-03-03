package com.model;
import java.util.ArrayList;

/**
 * Classroom class to represent a classroom in the music app
 * @author Evil Gnome Clan
 */
public class Classroom {

    private ArrayList<Student> students;
    private ArrayList<Lesson> lessons;

    /**
     * Constructor for Classroom class
     */
    public Classroom()
    {
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    /**
     * Adds a student to the classroom
     * @param student
     */
    public void addStudent(Student student)
    {
        if(student != null)
        {
            this.students.add(student);
        }
    }

    /**
     * Assigns a lesson to the student in the classroom
     * @param lesson
     * @param students
     */
    public void assignLesson(Lesson lesson, ArrayList<Student> students)
    {
        if(lesson != null)
        {
            this.lessons.add(lesson);
            if(students != null)
            {
                for(Student student : students)
                {
                    student.takeLesson(lesson);
                }
            }
        }
    }
}
