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

     /**
     * add a chord to the sheet music
     */
    public void addChord(int index) {
    Chord chord = new Chord();
    chord = chord.chordInput();
    chords.add(index, chord);
    }

    /**
     * remove a chord from the sheet music
     */
    public void removeChord   () {
    
    }
    
    public String getMeasure() {
        String measure = "";
        boolean fs = false;
        for (Chord chord : chords) {
            fs = true;
            measure += chord.getChord() + " ";
        }
        if (fs){
            measure = measure.substring(0, measure.length() - 1);
        }
        return measure;
    }
}
