package com.model;
import java.util.UUID;

import org.jfugue.player.Player;

public class Driver {
    public static void main(String[] args) {
        //Import Song from JSON and play using Jfugue
        SongLibrary songLibrary = SongLibrary.getInstance();
        //Import Song from JSON and play using Jfugue
        //Song song = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
        //playSong(song.getSheetMusic());

       // Song song2 = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
       // SheetMusic sheetMusic = new SheetMusic(song2.getSongTitle(), song2.getSheetMusic());
       // sheetMusic.displayMeasures();

        //Add measure to an existing song
        Song song2 = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
        SheetMusic sheetMusic = new SheetMusic(song2.getSongTitle(), song2.getSheetMusic());
        sheetMusic.addMeasure();
        playSong(sheetMusic.getSong());
        song2.setSheetMusic(sheetMusic);
        DataWriter.saveSongs();
    }

    public static void playSong(String song){
        Player player = new Player();
        player.play(song);
    }

}
