package com.model;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.chart.PieChart.Data;

public class MusicApp {

    private User currentUser;
    private Map<String, User> userDatabase;
    private SongLibrary library;

    /**
     * Constructor to initialize the MusicApp with an empty user database and song library.
     */
    public MusicApp() {
        this.userDatabase = new HashMap<>();
        this.library = SongLibrary.getInstance(); 
    }

    /**
     * Signs up a new user and adds them to the user database.
     * 
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param password The password for the new account.
     * @return The newly created User object if sign-up is successful, otherwise null.
     */
    public User signUp(String firstName, String lastName, String email, String password) {
        if (userDatabase.containsKey(email)) {
            System.out.println("Error: A user with this email already exists.");
            return null;
        }
        User newUser = new User(firstName, lastName, email, password, "User"); 
        userDatabase.put(email, newUser);
        System.out.println("Sign-up successful! Welcome, " + firstName);
        return newUser;
    }

    /**
     * Logs a user in if the credentials match an existing account.
     * 
     * @param emailAddress The email address of the user.
     * @param password The password entered by the user.
     * @return true if login is successful, false otherwise.
     */
    public boolean login(String emailAddress, String password) {
        if (userDatabase.containsKey(emailAddress)) {
            User user = userDatabase.get(emailAddress);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome back, " + user.getFirstName());
                return true;
            } else {
                System.out.println("Error: Incorrect password.");
            }
        } else {
            System.out.println("Error: No account found with this email.");
        }
        return false;
    }

    /**
     * Logs out the current user if they are logged in.
     */
    public void logOut() {
        if (currentUser != null) {
            System.out.println("Logged out successfully. Goodbye, " + currentUser.getFirstName() + "!");
            currentUser = null;
            DataWriter.saveUsers();
            DataWriter.saveSongs();
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    /**
     * Displays the profile information of the current user.
     */
    public void viewProfile() {
        if (currentUser != null) {
            System.out.println("Profile Information:");
            System.out.println("Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            System.out.println("Email: " + currentUser.getEmailAddress());
        } else {
            System.out.println("Error: No user is currently logged in.");
        }
    }

    /**
     * Resets the password for the current user.
     * 
     * @param newPassword The new password to set.
     */
    public void resetPassword(String newPassword) {
        if (currentUser == null) {
            System.out.println("Error: Please log in to reset your password.");
            return;
        }
        currentUser.setPassword(newPassword);
        System.out.println("Password updated successfully.");
    }

    /**
     * Adds a new song to the song library.
     * 
     * @param title The title of the song.
     * @param artist The artist of the song.
     * @param duration The duration of the song in seconds.
     * @param difficulty The difficulty level of the song.
     * @param genre The genre of the song.
     * @param sheetMusic The sheet music for the song.
     * @param rating The rating of the song.
     * @return The newly created Song object.
     */
    public Song newSong(String title, String artist, int duration, Difficulty difficulty, Genre genre, String sheetMusic, int rating) {
        if (currentUser == null) {
            System.out.println("Error: Please log in to add a song.");
            return null;
        }
        Song song = new Song(title, artist, difficulty, genre, sheetMusic, rating);
        library.addSong(song); 
        System.out.println("New song added: " + title + " by " + artist);
        return song;
    }

    /**
     * Plays the specified song.
     * 
     * @param song The song to play.
     */
    public void playSong(Song song) {
        if (song != null) {
            System.out.println("Now playing: " + song.getSongTitle() + " by " + song.getAuthor());
            SongLibrary.playSong(song.getSheetMusic());
        } else {
            System.out.println("Error: Song not found.");
        }
    }

    /**
     * Displays and plays a random song from the song library as the daily challenge.
     */
    public void dailySong() {
        Song dailySong = library.getRandomSong();
        if (dailySong != null) {
            System.out.println("Daily Song Challenge: " + dailySong.getSongTitle() + " by " + dailySong.getAuthor());
            playSong(dailySong);
        } else {
            System.out.println("Error: No songs available for the daily challenge.");
        }
    }

    /**
     * Displays the songs in the specified playlist.
     * 
     * @param playlist The playlist to view.
     */
    public void viewPlaylist(Playlist playlist) {
        if (playlist != null) {
            System.out.println("Playlist: " + playlist.getTitle());
            playlist.displaySongs(); 
        } else {
            System.out.println("Error: Playlist not found.");
        }
    }

    /**
     * Placeholder method to display lessons (Feature not implemented).
     */
    public void viewLessons() {
        System.out.println("Displaying lessons (Feature not implemented yet).");
    }

    /**
     * Displays the leaderboard for the app.
     * 
     * @param leaderboard The leaderboard to display.
     */
    public void viewLeaderboard(Leaderboard leaderboard) {
        System.out.println("Leaderboard:");
        leaderboard.displayLeaderboard();
    }

    /**
     * Exits the MusicApp and terminates the program.
     */
    public void exit() {
        System.out.println("Exiting MusicApp. See you next time!");
        DataWriter.saveSongs();
        DataWriter.saveUsers();
        System.exit(0);
    }
}
