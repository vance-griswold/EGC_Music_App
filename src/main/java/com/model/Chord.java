package com.model;
import java.util.ArrayList;
import java.util.Scanner;
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
     * Default constructor for class
     */
    public Chord() {
        this.duration = "q";
        this.rest = true;
        this.scale = Scale.REST;
        this.octave = 5;
        this.major = false;
        this.minor = false;
    }

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
     * Constructor for chord to create object from a string
     * @param chord is the string to create the chord from
     */
    public Chord(String chord) {
        if (chord.equals("")){

            return;
        }
        if( chord.charAt(0) == 'R') {
            this.rest = true;
            this.duration = chord.substring(1);
            this.scale = Scale.REST;
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
     * Constructor for Chord made through input
     * @return Chord object of the user input chord
     */
    public Chord chordInput() {
        Chord newC = new Chord();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Note, Rest, or Chord? (n / c / r)");
        String ans1 = keyboard.nextLine();
        if(ans1.toLowerCase().equals("c")){
            System.out.println("Major or Minor? (major / minor)");
            String ansM = keyboard.nextLine();
            if(ansM.toLowerCase().equals("major")) {
                newC.major = true;
                newC.minor = false;
            }else if(ansM.toLowerCase().equals("minor")){
                newC.major = false;
                newC.minor = true;
            }else{
                System.out.println("Response invalid");
                newC = chordInput();
                return newC;
            }
        }else if(ans1.toLowerCase().equals("n")){
        }else if(ans1.toLowerCase().equals("r")){
            newC.rest = true;
            newC.scale = Scale.REST;
            System.out.println("Note duration? (w,h,q,qq,qqq)");
            String dur = keyboard.nextLine();
            if(dur.toLowerCase().equals("w") || dur.toLowerCase().equals("h") || dur.toLowerCase().equals("q") || dur.toLowerCase().equals("qq") || dur.toLowerCase().equals("qqq")) {
                newC.duration = dur;
            }else {
                System.out.println("Response invalid");
                newC = chordInput();
                return newC; 
            }
            return newC;   
        } else{
            System.out.println("Response invalid");
            newC = chordInput();
            return newC; 
        }
        System.out.println("Which note? (a-g)");
        String scale = keyboard.nextLine();
        if(scale.toLowerCase().equals("a") || scale.toLowerCase().equals("b") || scale.toLowerCase().equals("c") || scale.toLowerCase().equals("d") || scale.toLowerCase().equals("e") || scale.toLowerCase().equals("f") || scale.toLowerCase().equals("g")) {
            newC.scale = Scale.valueOf(scale.toUpperCase());
        }else {
            System.out.println("Response invalid");
            newC = chordInput();
            return newC; 
        }
        System.out.println("Which octave? (0-10)");
        String oct = keyboard.nextLine();
        if(oct.equals("0") || oct.equals("1") || oct.equals("2") || oct.equals("3") || oct.equals("4") || oct.equals("5") || oct.equals("6") || oct.equals("7") || oct.equals("8") || oct.equals("9") || oct.equals("10")) {
            newC.octave = Integer.parseInt(oct);
        }else {
            System.out.println("Response invalid");
            newC = chordInput();
            return newC; 
        }
        System.out.println("Note duration? (w,h,q,qq,qqq)");
        String dur = keyboard.nextLine();
        if(dur.toLowerCase().equals("w") || dur.toLowerCase().equals("h") || dur.toLowerCase().equals("q") || dur.toLowerCase().equals("qq") || dur.toLowerCase().equals("qqq")) {
            newC.duration = dur;
        }else {
            System.out.println("Response invalid");
            newC = chordInput();
            return newC; 
        }
        return newC;
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
