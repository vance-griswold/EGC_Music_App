package com.model;

import java.util.ArrayList;

/**
 * 
 * @author Evil Gnome Clan
 */
public class SheetMusic {
    private String name;
    private ArrayList<Measure> measures;
    private Instrument instrument;

    /**
     * 
     * @param name
     * @param measures
     * @param instrument
     */
    public SheetMusic(String name, ArrayList<Measure> measures, Instrument instrument) {
        this.name = name;
        this.measures = measures;
        this.instrument = instrument;
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
            song += measure.getMeasure() + " ";
        }
        return song;
    }
}
