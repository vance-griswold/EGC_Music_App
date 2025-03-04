package com.model;

/**
 * MusicApp class to represent the music app (facade)
 * @author Evil Gnome Clan
 */
public class MusicApp {

    private User user;
    private UserList userList;
    private SongLibrary library;

    /**
     * Information needed for user signup
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @return
     */
    public User signUp(String firstName, String lastName, String email, String password)
    {
        return null;
    }

     /**
     * Logs user in with their email address and password
     * @param emailAddress
     * @param password
     * @return
     */
    public boolean login(String emailAddress, String password)
    {
        return false;
    }

    /**
    * Views the user's profile
    * @param user
    */
    public void viewProfile(User user)
    {

    }

     /**
     * Resets the user's password
     * @param password
     */
    public void resetPassword(String password)
    {

    }

    /**
     * Logs the user out
     */
    public void logOut()
    {
        
    }

    /**
     * Creates a new song
     * @return
     */
    public Song newSong()
    {
        return null;
    }

    /**
     * Plays the selected song
     * @param song
     */
    public void playSong(Song song)
    {

    }

    /**
     * Plays daily song challenge
     * @param song
     */
    public void dailySong(dailySong song)
    {

    }

    /**
     * Views the selected playlist
     * @param playlist
     */
    public void viewPlaylist(Playlist playlist)
    {

    }

    /**
     * Views the user's lessons
     */
    public void viewLessons()
    {

    }

    /**
     * Views the leaderboard
     * @param leaderboard
     */
    public void viewLeaderboard(Leaderboard leaderboard)
    {

    }

    /**
     * Exits the application
     */
    public void exit()
    {

    }

    
}
