package com.model;
import java.util.ArrayList;
public class Driver {
    public static void main(String[] args) {
        MusicApp musicApp = new MusicApp(); 
        

        //Create an account and Login:

        //signup
        System.out.println("Testing sign-up method:");
        User newUser = musicApp.signUp("Adam", "Smith", "asmith@gmail.com", "ASmithy", "1990-01-01");
        System.out.println("New user created: " + newUser.getUserName());

        //login
        System.out.println("Testing login method:");
        boolean loginSuccess = musicApp.login("asmith@gmail.com", "password");
        if (loginSuccess) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }

        //logout
        System.out.println("Testing logout method:");
        musicApp.logOut();

        //Playing a song
        SongLibrary songLibrary = SongLibrary.getInstance();
        ArrayList<Song> songs = songLibrary.filterByAuthor("Foo Fighters");
        Song song = songs.get(0);
        //MusicApp.playSong(song);
        song.printToText();

        //Making a song
        musicApp.login("asmith@gmail.com", "password");
        Song song2 = musicApp.newSong("A horses journey", Difficulty.EASY, Genre.CLASSICAL, "", 5);
        song2.editSong();
        MusicApp.playSong(song2);
        //MusicApp.logout();
        //MusicApp.login();
        //Song song3 = songLibrary.searchSong("A horses journey");
        //MusicApp.playSong(song3);
    }
}