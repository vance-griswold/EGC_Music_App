package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * SongLibrary class to represent a library of songs in the music app
 * @author Evil Gnome Clan
 */
public class SongLibrary {
    private ArrayList<Song> library;

    /**
     * Constructor for SongLibrary class
     */
    private SongLibrary()
    {
        this.library = new ArrayList<Song>();
    }

    /**
     * Singleton pattern for SongLibrary
     * @param library
     * @return
     */
    public static SongLibrary getInstance()
    {
       return null;
    }

    /**
     * Gets a song by its ID
     * @param id
     * @return
     */
    public Song getSong(UUID id)
    {
        return null;
    }

    /**
     * Searches for a song by its title
     * @param name
     * @return
     */
    public Song searchSong(String name)
    {
        return null;
    }

    /**
     * Sorts songs by genre
     * @param genre
     */
    public void sortByGenre(Genre genre)
    {
        //sorting logic
    }

    /**
     * Sorts songs by difficulty
     * @param difficulty
     */
    public void sortByDifficulty(Difficulty difficulty)
    {
        //sorting logic
    }

    /**
     * Sorts songs by author
     * @param author
     */
    public void sortByAuthor(String author)
    {
        //sorting logic
    }

    /**
     * Filters songs by genre
     * @param genre
     * @return
     */
    public ArrayList<Song> filterByGenre(Genre genre)
    {
        return null;
    }

    /**
     * Filters songs by difficulty
     * @param difficulty
     * @return
     */
    public ArrayList<Song> filterByDifficulty(Difficulty difficulty)
    {
        return null;
    }

    /**
     * Filters songs by author
     * @param author
     * @return
     */
    public ArrayList<Song> filterByAuthor(String author)
    {
        return null;
    }

    /**
     * Creates a new song
     * @param song
     */
    public void create(Song song)
    {

    }

    /**
     * Reads/loads a song to the library
     */
    public void read()
    {

    }

    /**
     * Updates existing song in library
     * @param song
     */
    public void update(Song song)
    {

    }

    /**
     * Deletes a song from the library
     * @param song
     */
    public void delete(Song song)
    {

    }

    /**
     * Saves the current state of the song library
     */
    public void save()
    {

    }
}
