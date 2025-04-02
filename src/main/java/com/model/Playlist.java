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
        if (song != null) { /
            playlist.add(song);
        }
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
        this.title = newName;
        System.out.println("Playlist renamed to: " + newName);
    }

    /**
     * Returns the size of the playlist (number of songs)
     * @return the size of the playlist
     */
    public int getPlaylistSize() {
        return playlist.size();
    }

    /**
     * Returns the title of the playlist
     * @return the title of the playlist
     */
    public String getTitle() {
        return title;
    }
}
