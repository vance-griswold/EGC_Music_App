package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class to write data to JSON files
 */
public class DataWriter extends DataConstants {

    /**
     * Saves the users to the JSON file
     */
    public static void saveUsers() {
        UserList userListInstance = UserList.getInstance();
        ArrayList<User> userList = userListInstance.getUsers();

        JSONArray jsonUsers = new JSONArray();

        for (User user : userList) {
            jsonUsers.add(getUserJSON(user));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the JSON object of the user
     * @param user the user to get the JSON object of
     * @return the JSON object of the user
     */
    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId());
        userDetails.put(USER_ROLE, user.getRole());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL_ADDRESS, user.getEmailAddress());
        userDetails.put(USER_LEVEL, user.getExperienceLevel());
        userDetails.put(USER_XP, user.getXpPoints());
        userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }

    /**
     * Saves the songs to the JSON file
     */
    public static void saveSongs()
    {
        SongLibrary songLibraryInstance = SongLibrary.getInstance();
        ArrayList<Song> songList = songLibraryInstance.getSongs();

        JSONArray jsonSongs = new JSONArray();

        for (Song song : songList) {
            jsonSongs.add(getSongJSON(song));
        }

        try (FileWriter file = new FileWriter(SONG_FILE_NAME)) {
            file.write(jsonSongs.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the JSON object of the song
     * @param song the song to get the JSON object of
     * @return the JSON object of the song
     */
    private static JSONObject getSongJSON(Song song) {
        JSONObject songDetails = new JSONObject();
        songDetails.put(SONG_ID, song.getId().toString());
        songDetails.put(SONG_TITLE, song.getSongTitle());
        songDetails.put(SONG_AUTHOR, song.getAuthor());
        songDetails.put(SONG_DIFFICULTY, song.getDifficulty().toString());
        songDetails.put(SONG_GENRE, song.getGenre().toString());
        songDetails.put(SONG_SHEETMUSIC, song.getSheetMusic());
        songDetails.put(SONG_RATING, song.getRating());

        return songDetails;
    }

   
}
