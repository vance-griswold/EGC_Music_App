package com.model;
/**
 * Note class is used to represent a note in a music sheet.
 * @author Evil Gnome Clan
 */
public class Note {
    private int durationTop;
    private int durationBottom;
    private boolean rest;
    private Scale scale;
    private boolean sharp;
    private boolean flat;

    public Note(int durationTop, int durationBottom, boolean rest, Scale scale, boolean sharp, boolean flat) {
        this.durationTop = durationTop;
        this.durationBottom = durationBottom;
        this.rest = rest;
        this.scale = scale;
        this.sharp = sharp;
        this.flat = flat;
    }
}
