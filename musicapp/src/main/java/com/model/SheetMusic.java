package com.model;

import java.util.ArrayList;

/**
 * 
 * @author Evil Gnome Clan
 */
public class SheetMusic {
    private String name;
    private ArrayList<Measure> measures;

    /**
     * 
     * @param name
     * @param measures
     * @param instrument
     */
    public SheetMusic(String name, ArrayList<Measure> measures) {
        this.name = name;
        this.measures = measures;
    }

    /**
     * Takes the song as the String and remakes it into an ArrayList of Measures
     * @param name
     * @param song
     */
    public SheetMusic(String name, String song ){
        this.name = name;
        this.measures = new ArrayList<Measure>();
        String[] measureArray = song.split("\\|");
        for (String measure : measureArray) {
            ArrayList<Chord> chords = new ArrayList<Chord>();
            String[] chordArray = measure.split(" ");
            for (String chord : chordArray) {
                chords.add(new Chord(chord));
            }
            measures.add(new Measure(chords));
        }
    }
    
    /**
     * 
     */
    public void addNote() {
    
    }

    /**
     * 
     */
    public void removeNote() {
    
    }

    public void addToLibrary(SheetMusic sheetMusic) {
    
    }

    public String getSong() {
        String song = "";
        for (Measure measure : measures) {
            song += measure.getMeasure() + " | ";
        }
        return song;
    }

    public void displayMeasures() {
        for (Measure measure : measures) {
            System.out.println(measure.getMeasure());
        }
    }
}
