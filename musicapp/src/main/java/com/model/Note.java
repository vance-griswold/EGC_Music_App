package com.model;
/**
 * Note class is used to represent a note in a music sheet.
 * @author Evil Gnome Clan
 */
public class Note {
    private String duration;
    private boolean rest;
    private Scale scale;

    public Note(String duration, boolean rest, Scale scale) {
        this.duration = duration;
        this.rest = rest;
        this.scale = scale;
    }

    public String getNote() {
        if (this.rest == true) {
            return "R" + this.duration;
        }else {
            return this.scale + this.duration;
        }
    }
}
