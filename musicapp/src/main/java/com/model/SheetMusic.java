package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Evil Gnome Clan
 */
public class SheetMusic {
    private String name;
    private ArrayList<Measure> measures;

    /**
     * 
     * @param name
     * @param measures
     * @param instrument
     */
    public SheetMusic(String name, ArrayList<Measure> measures) {
        this.name = name;
        this.measures = measures;
    }

    /**
     * Takes the song as the String and remakes it into an ArrayList of Measures
     * @param name
     * @param song
     */
    public SheetMusic(String name, String song ){
        this.name = name;
        if (song.equals("")) {
            this.measures = new ArrayList<Measure>();
            return;
        }
        this.measures = new ArrayList<Measure>();
        String[] measureArray = song.split("\\|");
        for (String measure : measureArray) {
            ArrayList<Chord> chords = new ArrayList<Chord>();
            String[] chordArray = measure.split(" ");
            for (String chord : chordArray) {
                chords.add(new Chord(chord));
            }
            measures.add(new Measure(chords));
        }
    }
    
   /**
    * 
    * @param measure
    */
    public void addMeasure() {
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Boolean addMore = true;
        while( addMore == true) {
            System.out.println("Would you like to add a chord? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("Y")) {
                addMore = true;
            } else {
                addMore = false;

            }
            if(addMore == true) {
                Chord newChord = new Chord();
                newChord = newChord.chordInput();
                chords.add(newChord);
            }
        }     
        measures.add(new Measure(chords));
    }

    public String getSong() {
        String song = "";
        for (Measure measure : measures) {
            song += measure.getMeasure() + "|";
        }
        return song;
    }

    public void displayMeasures() {
        for (Measure measure : measures) {
            System.out.println(measure.getMeasure());
        }
    }

    public void toText() {
        String fileName = name + ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Song: " + name + "\n");
            
            ArrayList<char[][]> printedSong = new ArrayList<char[][]>();
            for (Measure measure : measures) {
                printedSong.add(measure.getMeasureArray());
            }

            for (int k = 0; k < printedSong.size(); k++) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < printedSong.get(k).length; j++) {
                        fileWriter.write(printedSong.get(k)[j][i]);
                    }
                    fileWriter.write("\n");
                }
                fileWriter.write("\n\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
