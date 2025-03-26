package com.model;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        MusicApp musicApp = new MusicApp(); 
        
        /* 
        System.out.println("Checking existing users...");
        for (User user : UserList.getInstance().getUsers()) {
            System.out.println("User in system: " + user.getFirstName() + " " + user.getLastName() + " (" + user.getUserName() + ")");
        }

        System.out.println("\nFred attempts to create an account with username 'ffredrickson'...");
        UserList userList = UserList.getInstance();
        User existingUser = userList.getUser("ffredrickson");
        if (existingUser != null) {
            System.out.println("Error: The username 'ffredrickson' is already taken by Fellicia.");
        } else {
            User attempt = musicApp.signUp("Fred", "Fredrickson", "fred@example.com", "ffredrickson", "password");
        }

        System.out.println("\nFred tries again with a new username 'ffred'...");
        User fred = musicApp.signUp("Fred", "Fredrickson", "fred@example.com", "ffred", "password");
        if (fred != null) {
            System.out.println("Fred's account has been successfully created!");
        }

        System.out.println("\nFred logs out...");
        musicApp.logOut();

        System.out.println("\nUpdated user list after Fred's signup:");
        for (User user : userList.getUsers()) {
            System.out.println("User in system: " + user.getFirstName() + " " + user.getLastName() + " (" + user.getUserName() + ")");
        }

        System.out.println("\nFred logs back in...");
        boolean login = musicApp.login("fred@example.com", "password");
        if (login) {
            System.out.println("Fred has logged in successfully!");
        } else {
            System.out.println("Login failed for Fred.");
        }
        
        
        /*
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
        musicApp.logOut();
        musicApp.login("JonnyBoy@gmail.com", "password");
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song3 = songLibrary.searchSong("A horses journey");
        song3.editSong();
        MusicApp.playSong(song3); 
    } 
}