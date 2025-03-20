package com.model;
import java.util.UUID;

import org.jfugue.player.Player;

public class Driver {
    public static void main(String[] args) {
        //Import Song from JSON and play using Jfugue
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.getSong(UUID.fromString("98861408-c98d-4f28-8ee0-57f3d63b45c0"));
        playSong(song.getSheetMusic());
        playSong(song.getSheetMusic());
        playSong(song.getSheetMusic());

    }

    public static void playSong(String song){
        Player player = new Player();
        player.play(song);
    }

}
