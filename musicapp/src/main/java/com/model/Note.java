package com.model;
/**
 * Note class is used to represent a note in a music sheet.
 * @author Evil Gnome Clan
 */
public class Note {
    private String duration;
    private boolean rest;
    private Scale scale;

    /**
     * Constructor for class
     * @param duration is the String duration for jfugue format
     * @param rest is a boolean to determine if the note is a rest
     * @param scale deteriminesthe scale of the note
     */
    public Note(String duration, boolean rest, Scale scale) {
        this.duration = duration;
        this.rest = rest;
        this.scale = scale;
    }

    /**
     * Get the note in the format of "Scale + Duration" or "R + Duration" if it is a rest.
     * @return String in proper note format for jfugue
     */
    public String getNote() {
        if (this.rest == true) {
            return "R" + this.duration;
        }else {
            return this.scale + this.duration;
        }
    }
}
