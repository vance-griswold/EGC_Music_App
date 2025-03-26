package com.model;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> playlist;
    private String title;


    public Playlist() {
        this.playlist = new ArrayList<>();
        this.title = "Untitled Playlist";
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void removeSong(Song song) {
        playlist.remove(song);
    }

    public void createPrivatePlaylist() {
        System.out.println("Private playlist created.");
    }

    public void publishPublicPlaylist() {
        System.out.println("Playlist published publicly.");
    }

    public void renamePlaylist(String newName) {
        System.out.println("Playlist renamed to: " + newName);
    }

    // Getters and setters omitted for brevity
}
