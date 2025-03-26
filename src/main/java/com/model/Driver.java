package com.model;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        MusicApp musicApp = new MusicApp(); 
        

        //Create an account and Login:
        /*
        //signup
        System.out.println("Testing sign-up method:");
        User newUser = musicApp.signUp("Test", "User", "test@example.com", "TestUser", "password");
        System.out.println("New user created: " + newUser.getUserName());
        
        //login
        System.out.println("Testing login method:");
        boolean loginSuccess = musicApp.login("JonnyBoy@gmail.com", "password");
        if (loginSuccess) {
            System.out.println(":)");
        } else {
            System.out.println("Login failed.");
        }
        
        //logout
        System.out.println("Testing logout method:");
        musicApp.logOut();
        
        //Playing a song
        SongLibrary songLibrary = SongLibrary.getInstance();
        ArrayList<Song> songs = songLibrary.filterByAuthor("Frederic Chopin");
        Song song = songs.get(0);
        MusicApp.playSong(song);
        song.printToText();
        */
        //Making a song
        musicApp.login("asmith@gmail.com", "password");
        Song song2 = musicApp.newSong("A horses journey", Difficulty.EASY, Genre.CLASSICAL, "", 5);
        song2.editSong();
        MusicApp.playSong(song2);
        SongLibrary songLibrary = SongLibrary.getInstance();
        musicApp.logOut();
        musicApp.login("JonnyBoy@gmail.com", "password");
        Song song3 = songLibrary.searchSong("A horses journey");
        song3.editSong();
        MusicApp.playSong(song3); 
    } 
}