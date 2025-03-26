package com.model;
import java.util.Scanner;
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
    private String sheetMusic;
    private int rating;

    /**
     * Constructor for Song class
     * @param songTitle title of the song
     * @param Author author/creator of the song
     * @param difficulty difficulty of the song
     * @param genre genre of the song
     * @param sheetMusic sheet music for the song
     * @param rating rating of the song
     */
    public Song(String songTitle, String author, Difficulty difficulty, Genre genre, String sheetMusic, int rating)
    {
        this.id = UUID.randomUUID();
        this.songTitle = songTitle;
        this.author = author;
        this.difficulty = difficulty;
        this.genre = genre;
        this.sheetMusic = sheetMusic;
        this.rating = rating;
    }

    /**
     * Constructor for Song class
     * @param id unique song id
     * @param songTitle title of the song
     * @param Author author/creator of the song
     * @param difficulty difficulty of the song
     * @param genre genre of the song
     * @param sheetMusic sheet music for the song
     * @param rating rating of the song
     */
    public Song(UUID id, String songTitle, String author, Difficulty difficulty, Genre genre, String sheetMusic, int rating)
    {
        this.id = id;
        this.songTitle = songTitle;
        this.author = author;
        this.difficulty = difficulty;
        this.genre = genre;
        this.sheetMusic = sheetMusic;
        this.rating = rating;
    }

    /**
     * ID getter
     * @return unique song id
     */
    public UUID getId()
    {
        return id;
    }

    /**
     * Gets song title
     * @return title of song
     */
    public String getSongTitle()
    {
        return songTitle;
    }

    /**
     * Gets song author
     * @return author of song
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Gets song genre
     * @return song genre
     */
    public Genre getGenre()
    {
        return genre;
    }

    /**
     * Gets difficulty of song
     * @return song difficulty
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Gets sheet music for the song
     * @return sheet music object
     */
    public String getSheetMusic()
    {
        return sheetMusic;
    }

    /** 
     * Sets sheet music for the song
     * @param sheetMusic sheet music object
    */
    public void setSheetMusic(SheetMusic sheetMusic)
    {
        String s = sheetMusic.getSong();
        this.sheetMusic = s;
    }
    /**
     * Filters songs by their rating
     * @param minRating minimum rating to filter by
     * @return true if song meets the rating criteria
     */
    public boolean filterByRating(int minRating)
    {
        return this.rating >= minRating;
    }

    /**
     * Searches for a song by its title
     * @param songTitle title of the song to search for
     * @return true if the song title matches, false if it does not
     */
    public boolean searchByName(String songTitle)
    {
        if(songTitle != null && songTitle.equalsIgnoreCase(this.songTitle))
        {
            return true;
        }
        else
        {
            System.out.println(songTitle + " not found.");
            return false;
        }
    }

    /**
     * Sets rating of the song
     * @param rating rating value
     */
    public void setRating(int rating)
    {
        if(rating >= 0 && rating <= 5)
        {
            this.rating = rating;
        }
        else
        {
            System.out.println("Invalid rating. Please enter a rating between 0 and 5.");
        }
    }

    /**
     * Gets the rating of the song
     * @return rating value
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * Allows the user to edit a song
     * Checks to make sure user is the author, if not they cannot edit
     */
    public void editSong()
    {
        if(this.author.equals(MusicApp.getCurrentUser().getUserName())) {
            SheetMusic sheetMusic = new SheetMusic(this.songTitle, this.sheetMusic);
            Boolean addMore = true;
        while( addMore == true) {
            System.out.println("Would you like to add a measure? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("Y")) {
                addMore = true;
            } else if (input.toUpperCase().equals("N")){
                addMore = false;
            }else{
                System.out.println(rating + " is not a valid input. Please enter Y or N.");
                this.editSong();
            }
            if(addMore == true) {
                sheetMusic.addMeasure();
            }
        }     
            this.setSheetMusic(sheetMusic);
        }else {
            System.out.println("You are not the author of this song.");
        }
    }

    /**
     * Prints the sheet music to text
     */
    public void printToText() 
    {
        SheetMusic sheetMusic = new SheetMusic(this.songTitle, this.sheetMusic);
        sheetMusic.toText();
    }
}


