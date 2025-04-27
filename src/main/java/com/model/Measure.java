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
     * add a chord to the measure
     */
    public void addChord(int index, Chord chord) {
        chords.add(index, chord);
    } 
    
    /**
     * add a chord to the measure
     */
    public void addChord(Chord chord) {
        chords.add(chord);
    } 

    /**
     * remove a chord from the measure
     */
    public void removeChord() {
        chords.remove(chords.size() - 1);
    }
    
    /**
     * get the measure as a jfugue readable string
     * @return measure as a string
     */
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

    /**
     * get the measure as a 2d array to print as readable sheet music
     * @return measure as a 2D array of characters
     */
    public char[][] getMeasureArray() {
        char[][]  printedMeasure = new char[16][8];
        for (int i = 0; i < 8; i++) {
            if (i%2 == 0) {
                for (int j = 0; j < 16; j++) {
                    printedMeasure[j][i] = ' ';
                }
            } else {
                for (int j = 0; j < 16; j++) {
                    printedMeasure[j][i] = '-';
                }
            }
        }
        int skip = 0;
        for( int i = 0; i < chords.size(); i++) {
            if (chords.get(i).getScale().equals("F")) {
                printedMeasure[skip][7] = 'F';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("G")) {
                printedMeasure[skip][6] = 'G';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("A")) {
                printedMeasure[skip][5] = 'A';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("B")) {
                printedMeasure[skip][4] = 'B';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("C")) {
                printedMeasure[skip][3] = 'C';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("D")) {
                printedMeasure[skip][2] = 'D';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("E")) {
                printedMeasure[skip][1] = 'E';
                skip = skip +2;
            } else if (chords.get(i).getScale().equals("REST")) {
                printedMeasure[skip][4] = 'R';
                skip = skip +2;
            }
        }
        return printedMeasure;
    }
}
