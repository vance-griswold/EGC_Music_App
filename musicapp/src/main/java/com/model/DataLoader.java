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
    
    public ArrayList<User> getUsers() {
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
                int level = (int)personJSON.get(USER_LEVEL);
                int xpPoints = ((Long)personJSON.get(USER_XP)).intValue();
                Playlist songs = (Playlist)personJSON.get(USER_SONGS);
				
				users.add(new User(id, role, firstName, lastName,  userName, playlists, emailAddress, level, xpPoints, songs));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

    public void getSongs() {
        // Load songs from json
    }
}
