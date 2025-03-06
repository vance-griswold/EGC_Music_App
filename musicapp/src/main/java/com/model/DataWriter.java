package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

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

    private static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId());
        userDetails.put(USER_ROLE, user.getRole());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL_ADDRESS, user.getEmailAddress());
        userDetails.put(USER_EXPERIENCE_LEVEL, user.getExperienceLevel());
        userDetails.put(USER_XP_POINTS, user.getXpPoints());

        return userDetails;
    }

    public static void main(String[] args) {
        saveUsers();
    }
}
