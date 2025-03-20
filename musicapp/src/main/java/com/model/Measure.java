package com.model;
import java.util.ArrayList;
/**
 * Measure class is used to represent a measure in a music sheet.
 * @author Evil Gnome Clan
 */
public class Measure {
    private ArrayList<Chord> chords;

    /**
     * Constructor for class
     * @param chords is an ArrayList of Chords that make up the measure
     */
    public Measure(ArrayList<Chord> chords) {
        this.chords = chords;
    }


    public String getMeasure() {
        String measure = "";
        for (Chord chord : chords) {
            measure += chord.getChord() + " ";
        }
        return measure;
    }
}
