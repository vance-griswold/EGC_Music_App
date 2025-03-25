package com.model;
import java.util.ArrayList;
import java.util.UUID;
public class Driver {
    public static void main(String[] args) {
        MusicApp musicApp = new MusicApp(); 
        

        //Create an account and Login:

        //Playing a song
        SongLibrary songLibrary = SongLibrary.getInstance();
        ArrayList<Song> songs = songLibrary.filterByAuthor("Foo Fighters");
        Song song = songs.get(0);
        //MusicApp.playSong(song);
        song.printToText();

        //Making a song
        musicApp.login("asmith@gmail.com", "password");
        Song song2 = musicApp.newSong("A horses journey", Difficulty.EASY, Genre.CLASSICAL, "C5majh G5majh|A5minh F5majh|Rh Rh4", 5);
        //song2.editSong();
        //MusicApp.playSong(song2);
        songLibrary.save();
        //MusicApp.logout();
        //MusicApp.login();
        //Song song3 = songLibrary.searchSong("A horses journey");
        //MusicApp.playSong(song3);
    }
}