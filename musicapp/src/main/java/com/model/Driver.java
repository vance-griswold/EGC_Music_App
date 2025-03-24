package com.model;
import java.util.ArrayList;
import java.util.UUID;
public class Driver {
    public static void main(String[] args) {
        //Import Song from JSON and play using Jfugue
        //Import Song from JSON and play using Jfugue
        //Song song = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
        //playSong(song.getSheetMusic());

       // Song song2 = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
       // SheetMusic sheetMusic = new SheetMusic(song2.getSongTitle(), song2.getSheetMusic());
       // sheetMusic.displayMeasures();

        //Add measure to an existing song
       // Song song2 = songLibrary.getSong(UUID.fromString("c361b262-4ae5-4bef-bc23-23e81e2e949e"));
       // SheetMusic sheetMusic = new SheetMusic(song2.getSongTitle(), song2.getSheetMusic());
       // sheetMusic.addMeasure();
       // playSong(sheetMusic.getSong());
       // song2.setSheetMusic(sheetMusic);
        //DataWriter.saveSongs();

        //Create an account and Login:

        //Playing a song
        SongLibrary songLibrary = SongLibrary.getInstance();
        ArrayList<Song> songs = songLibrary.filterByAuthor("Foo Fighters");
        Song song = songs.get(0);
        //MusicApp.playSong(song);
        song.printToText();
    }
}
