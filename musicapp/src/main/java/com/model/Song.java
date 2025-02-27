package com.model;
import java.util.UUID;

/**
 * Song class to represent a song in the music app
 * @author Evil Gnome Clan
 */
public class Song {
    
    private UUID id; 
    private String songTitle;
    private String author;
    private Difficulty difficulty;
    private Genre genre;
    private SheetMusic sheetMusic;

    /**
     * Constructor for Song class
     * @param songTitle
     * @param Author
     * @param difficulty
     * @param genre
     * @param sheetMusic
     */
    public Song(String songTitle, String Author, Difficulty difficulty, Genre genre, SheetMusic sheetMusic)
    {
        this.id = UUID.randomUUID();
        this.songTitle = songTitle;
        this.author = Author;
        this.difficulty = difficulty;
        this.genre = genre;
        this.sheetMusic = sheetMusic;
    }

    /**
     * ID getter
     * @return unique song id
     */
    public UUID getId()
    {
        return null;
    }

    /**
     * Filters songs by their rating
     * @param minRating
     * @return
     */
    public boolean filterByRating(int minRating)
    {
        return false;
    }

    /**
     * Searches for a song by its title
     * @param songTitle
     * @return
     */
    public boolean searchByName(String songTitle)
    {
        return false;
    }
}


