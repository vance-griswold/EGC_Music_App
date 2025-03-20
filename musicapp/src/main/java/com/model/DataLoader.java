package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class is used to load data from the json to the application.
 * @author Evil Gnome Clan
 */
public class DataLoader extends DataConstants {
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String role = (String)personJSON.get(USER_ROLE);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
                String userName = (String)personJSON.get(USER_USERNAME);
                ArrayList<Playlist> playlists = (ArrayList<Playlist>)personJSON.get(USER_PLAYLISTS);
                String emailAddress = (String)personJSON.get(USER_EMAIL_ADDRESS);
                int level = ((Long)personJSON.get(USER_LEVEL)).intValue();
                int xpPoints = ((Long)personJSON.get(USER_XP)).intValue();
				
				users.add(new User(id, role, firstName, lastName,  userName, playlists, emailAddress, level, xpPoints));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

    public static ArrayList<Song> getSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		try {
			FileReader reader = new FileReader(SONG_FILE_NAME);
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(SONG_ID));
                String title = (String)personJSON.get(SONG_TITLE);
				String author = (String)personJSON.get(SONG_AUTHOR);
				String difficulty = (String)personJSON.get(SONG_DIFFICULTY);
                String genre = (String)personJSON.get(SONG_GENRE);
                String sheetMusic = (String)personJSON.get(SONG_SHEETMUSIC);
				int rating = ((Long)personJSON.get(SONG_RATING)).intValue();
				
				Difficulty diff = Difficulty.valueOf(difficulty);
				Genre gen = Genre.valueOf(genre);
				songs.add(new Song(id, title, author, diff, gen, sheetMusic, rating));
			}
			
			return songs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return songs;
	}

	public static void main(String[] args) {
		SongLibrary list = SongLibrary.getInstance();
		UUID id = UUID.fromString("9e42d9ac-7380-4ced-989b-ddb196ea7913");
		Song hcb = list.getSong(id);
		//System.out.println(hcb.getSheetMusic());
    }
}
