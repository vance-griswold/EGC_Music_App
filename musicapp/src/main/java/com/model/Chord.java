package com.model;
import java.util.ArrayList;
/**
 * Chord class is used to represent a chord in a music sheet.
 * @author Evil Gnome Clan
 */
public class Chord {
    private String duration;
    private boolean rest;
    private Scale scale;
    private int octave;
    private boolean major;
    private boolean minor;

    /**
      * Constructor for class
     * @param duration is the String duration for jfugue format
     * @param rest is a boolean to determine if the note is a rest
     * @param scale deteriminesthe scale of the note
     * @param octave is the octave of the note
     * @param major is a boolean to determine if the chord is major
     * @param minor is a boolean to determine if the chord is minor
     */
    public Chord(String duration, boolean rest, Scale scale, int octave, boolean major, boolean minor) {
        this.duration = duration;
        this.rest = rest;
        this.scale = scale;
        this.octave = octave;
        this.major = major;
        this.minor = minor;
    }

    /**
     * 
     * @return
     */
    public Chord(String chord) {
        if( chord.charAt(0) == 'R') {
            this.rest = true;
            this.duration = chord.substring(1);
        }else {
            this.scale = Scale.valueOf(chord.substring(0, 1));
            this.octave = Integer.parseInt(chord.substring(1, 2));
            if (chord.contains("maj")) {
                this.major = true;
                this.duration = chord.substring(5);
            } else if (chord.contains("min")) {
                this.minor = true;
                this.duration = chord.substring(5);
            } else {
                this.duration = chord.substring(2);
            }
        }
    }

    /**
     * Get the scale of the chord
     * @return String of the scale
     */
    public String getScale() {
        return this.scale.toString();
    }
    
    /**
     * Get the chord in the format of "Scale + Octave + Chord Signature + Duration" or "R + Duration" if it is a rest.
     * @return String in proper note format for jfugue
     */
    public String getChord() {
        String chord = "";
        if (this.rest == true) {
            chord = "R" + this.duration;
            return chord;
        }else {
            chord = this.getScale() + this.octave;
        }
        if (this.major == true) {
            chord = chord + "maj" + this.duration;
        } else if (this.minor == true) {
            chord = chord + "min" + this.duration;
        } else {
            chord = chord + this.duration;
        }
        return chord;
    }
}
