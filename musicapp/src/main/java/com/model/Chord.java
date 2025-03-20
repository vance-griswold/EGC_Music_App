package com.model;
import java.util.ArrayList;
/**
 * Chord class is used to represent a chord in a music sheet.
 * @author Evil Gnome Clan
 */
public class Chord {
    private Note note;
    private boolean major;
    private boolean minor;

    /**
     * 
     * @param notes
     */
    public Chord(Note note, boolean major, boolean minor) {
        this.note = note;
        this.major = major;
        this.minor = minor;
    }

    /**
     * 
     * @return
     */
    public String getChord() {
        String chord = this.note.getNote();
        if(chord.contains("R")) {
            return chord;
        } else if (this.major == true) {
            chord = chord + "maj";
        } else if (this.minor == true) {
            chord = chord + "min";
        }
        return chord;
    }
}
