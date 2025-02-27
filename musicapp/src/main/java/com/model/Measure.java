package com.model;
import java.util.ArrayList;
/**
 * Measure class is used to represent a measure in a music sheet.
 * @author Evil Gnome Clan
 */
public class Measure {
    private ArrayList<Chord> chords;
    private int timeSignatureTop;
    private int timeSignatureBottom;
    private String clef;

    /**
     * 
     * @param chords
     * @param timeSignatureTop
     * @param timeSignatureBottom
     * @param clef
     */
    public Measure(ArrayList<Chord> chords, int timeSignatureTop, int timeSignatureBottom, String clef) {
        this.chords = chords;
        this.timeSignatureTop = timeSignatureTop;
        this.timeSignatureBottom = timeSignatureBottom;
        this.clef = clef;
    }

    /**
     * 
     * @return
     */
    public boolean isFull(){
        return chords.size() == timeSignatureTop;
    }
}
