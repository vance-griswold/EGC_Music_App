package com.model;
import java.util.ArrayList;

/**
 * A class to represent a playlist
 */
public class Playlist {
    private ArrayList<Song> playlist;
    private String title;


    /**
     * Constructor for the Playlist class
     */
    public Playlist() {
        this.playlist = new ArrayList<>();
        this.title = "Untitled Playlist";
    }

    /**
     * Adds a song to the playlist
     * @param song the song to add to the playlist
     */
    public void addSong(Song song) {
        playlist.add(song);
    }

    /**
     * Removes a song from the playlist
     * @param song the song to remove from the playlist
     */
    public void removeSong(Song song) {
        playlist.remove(song);
    }

    /**
     * Creates a private playlist
     */
    public void createPrivatePlaylist() {
        System.out.println("Private playlist created.");
    }

    /**
     * Publishes a playlist publicly
     */
    public void publishPublicPlaylist() {
        System.out.println("Playlist published publicly.");
    }

    /**
     * Renames the playlist
     * @param newName the new name of the playlist
     */
    public void renamePlaylist(String newName) {
        System.out.println("Playlist renamed to: " + newName);
    }

}
