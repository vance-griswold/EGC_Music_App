package com.model;
import java.util.ArrayList;
/**
 * Chord class is used to represent a chord in a music sheet.
 * @author Evil Gnome Clan
 */
public class Chord {
    private ArrayList<Note> notes;

    /**
     * 
     * @param notes
     */
    public Chord(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * 
     */
    public String toString() {
        return "";
    }
}
