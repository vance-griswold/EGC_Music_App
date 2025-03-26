package com.model;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.player.Player;

/**
 * SongLibrary class to represent a library of songs in the music app
 * @author Evil Gnome Clan
 */
public class SongLibrary {

    private ArrayList<Song> library;
    private static SongLibrary instance;

    /**
     * Constructor for SongLibrary class
     */
    private SongLibrary()
    {
        library = DataLoader.getSongs();
    }

    /**
     * Singleton pattern for SongLibrary
     * @return instance of SongLibrary
     */
    public static SongLibrary getInstance()
    {
        if(instance == null)
        {
            instance = new SongLibrary();
        }
        return instance;
    }

    /**
     * Gets the list of songs in the library
     * @return list of songs
     */
    public ArrayList<Song> getSongs()
    {
        return library;
    }

    /**
     * Gets a song by its ID
     * @param id unique song id
     */
    public Song getSong(UUID id)
    {
        for(Song song : library)
        {
            if(song.getId().equals(id))
            {
                return song;
            }
        }
        return null;
    }

    /**
     * Searches for a song by its title
     * @param name title of the song
     */
    public Song searchSong(String name)
    {
        for(Song song : library)
        {
            if(song.getSongTitle().equalsIgnoreCase(name))
            {
                return song;
            }
        }
        return null;
    }

    /**
     * Sorts songs by genre
     * @param genre genre of the song
     */
    public void sortByGenre(Genre genre)
    {
        for(int i = 0; i < library.size() - 1; i++)
        {
            for(int j = i + 1; j < library.size(); j++)
            {
                if(library.get(i).getGenre().compareTo(library.get(j).getGenre()) > 0)
                {
                    Song temp = library.get(i);
                    library.set(i, library.get(j));
                    library.set(j, temp);
                }
            }
        }
    }

    /**
     * Sorts songs by difficulty
     * @param difficulty difficulty of the song
     */
    public void sortByDifficulty(Difficulty difficulty)
    {
        for(int i = 0; i < library.size() - 1; i++)
        {
            for(int j = i + 1; j < library.size(); j++)
            {
                if(library.get(i).getDifficulty().compareTo(library.get(j).getDifficulty()) > 0)
                {
                    Song temp = library.get(i);
                    library.set(i, library.get(j));
                    library.set(j, temp);
                }
            }
        }
    }

    /**
     * Sorts songs by author
     * @param author author of the song
     */
    public void sortByAuthor(String author)
    {
        for(int i = 0; i < library.size() - 1; i++)
        {
            for(int j = i + 1; j < library.size(); j++)
            {
                if(library.get(i).getAuthor().compareToIgnoreCase(library.get(j).getAuthor()) > 0)
                {
                    Song temp = library.get(i);
                    library.set(i, library.get(j));
                    library.set(j, temp);
                }
            }
        }
    }

    /**
     * Filters songs by genre
     * @param genre genre of the song
     * @return filtered list of songs by genre
     */
    public ArrayList<Song> filterByGenre(Genre genre)
    {
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for(Song song : library)
        {
            if(song.getGenre() == genre)
            {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    /**
     * Filters songs by difficulty
     * @param difficulty difficulty of the song
     * @return filtered list of songs by difficulty
     */
    public ArrayList<Song> filterByDifficulty(Difficulty difficulty)
    {
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for(Song song : library)
        {
            if(song.getDifficulty() == difficulty)
            {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    /**
     * Filters songs by author
     * @param author author of the song
     * @return filtered list of songs by author
     */
    public ArrayList<Song> filterByAuthor(String author)
    {
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for(Song song : library)
        {
            if(song.getAuthor().equalsIgnoreCase(author))
            {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    /**
     * Plays a song from the library
     *@param song song to be played
     */
    public static void playSong(String song){
        Player player = new Player();
        player.play(song);
    }
    
    /**
     * Creates a new song and adds it to the library
     * @param song song to be created
     */
    public void create(Song song) {
        boolean check = false;
        for(Song s : library)
        {
            if(s.getId().equals(song.getId()))
            {
                this.update(song);
                check = true;
            }
        }
        if (check == false){
            library.add(song);
        }
    }

    /**
     * Reads/loads a song to the library
     */
    public void read()
    {
        DataLoader.getSongs();
    }

    /**
     * Updates existing song in library
     * @param song song to be updated
     */
    public void update(Song song)
    {
        for(int i = 0; i < library.size(); i++)
        {
            if(library.get(i).getId().equals(song.getId()))
            {
                library.set(i, song);
                break;
            }
        }
    }

    /**
     * Deletes a song from the library
     * @param song song to be deleted
     */
    public void delete(Song song)
    {
        library.remove(song);
    }

    /**
     * Saves the current state of the song library
     */
    public void save()
    {
        DataWriter.saveSongs();
    }
}
