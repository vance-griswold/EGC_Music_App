package com.model;

/**
 * Represents a musical instrument with properties like type, tabs, and sheet music.
 * Also includes methods for playing notes, checking notes, and displaying sheet music.
 * 
 * @author Evil Gnome Clan
 */
public class Instrument {
    
    private String type;
    private boolean hasTabs;
    private boolean hasSheetMusic;
    private Instrument virtualInstrument;

    /**
     * Constructs an Instrument object with the specified properties.
     * Hellos
     * @param type The type of the instrument (e.g., "Guitar").
     * @param hasTabs Whether the instrument has tabs.
     * @param hasSheetMusic Whether the instrument has sheet music.
     * @param virtualInstrument A virtual instrument representation of this instrument.
     */
    public Instrument(String type, boolean hasTabs, boolean hasSheetMusic, Instrument virtualInstrument) {
        this.type = type;
        this.hasTabs = hasTabs;
        this.hasSheetMusic = hasSheetMusic;
        this.virtualInstrument = virtualInstrument;
    }

    /**
     * Gets the type of the instrument.
     *
     * @return The type of the instrument.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the instrument.
     *
     * @param type The type of the instrument.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Checks whether the instrument has tabs.
     *
     * @return true if the instrument has tabs, false otherwise.
     */
    public boolean isHasTabs() {
        return hasTabs;
    }

    /**
     * Sets whether the instrument has tabs.
     *
     * @param hasTabs true if the instrument has tabs, false otherwise.
     */
    public void setHasTabs(boolean hasTabs) {
        this.hasTabs = hasTabs;
    }

    /**
     * Checks if the instrument has sheet music.
     *
     * @return true if the instrument has sheet music, false otherwise.
     */
    public boolean isHasSheetMusic() {
        return hasSheetMusic;
    }

    /**
     * Sets whether the instrument has sheet music.
     *
     * @param hasSheetMusic true if the instrument has sheet music, false otherwise.
     */
    public void setHasSheetMusic(boolean hasSheetMusic) {
        this.hasSheetMusic = hasSheetMusic;
    }

    /**
     * Gets the virtual representation of the instrument.
     *
     * @return The virtual instrument object.
     */
    public Instrument getVirtualInstrument() {
        return virtualInstrument;
    }

    /**
     * Sets the virtual representation of the instrument.
     *
     * @param virtualInstrument The virtual instrument object.
     */
    public void setVirtualInstrument(Instrument virtualInstrument) {
        this.virtualInstrument = virtualInstrument;
    }

    /**
     * Simulates playing a note on the instrument.
     *
     * @param note The note to be played (C, D etc)
     */
    public void playNote(String note) {
        System.out.println("Playing note: " + note);
    }

    /**
     * Checks whether the given note is valid for the instrument.
     *
     * @param note The note to be checked.
     * @return false 
     */
    public boolean checkNote(String note) {
        return false;
    }

    /**
     * Displays the sheet music for the instrument if its available.
     */
    public void displaySheetMusic() {
        if (hasSheetMusic) {
            System.out.println("Displaying sheet music for: " + type);
        } else {
            System.out.println("No sheet music available for: " + type);
        }
    }
}
