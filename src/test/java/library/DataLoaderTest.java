package library;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.model.DataConstants;
import com.model.DataLoader;
import com.model.Difficulty;
import com.model.Genre;
import com.model.Song;
import com.model.User;

/**
 * @author vancemg
 */
public class DataLoaderTest {

    @Before
    public void setup() throws Exception {
        DataConstants.TEST_MODE = true;

        // Empty test files
        Files.write(Paths.get(DataConstants.TEST_USER_FILE_NAME), "[]".getBytes());
        Files.write(Paths.get(DataConstants.TEST_SONG_FILE_NAME), "[]".getBytes());
    }

    private void writeTestUserJSON(String username, String email, int level, int xp) throws Exception {
        JSONArray users = new JSONArray();
        JSONObject user = new JSONObject();
        user.put("id", UUID.randomUUID().toString());
        user.put("userRole", "User");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("username", username);
        user.put("playlists", new JSONArray());
        user.put("emailAddress", email);
        user.put("experienceLevel", level);
        user.put("xpPoints", xp);
        user.put("password", "testpass");

        users.add(user);

        try (FileWriter file = new FileWriter(DataConstants.TEST_USER_FILE_NAME)) {
            file.write(users.toJSONString());
        }
    }

    private void writeTestSongJSON(String title, String difficulty, String genre, int rating) throws Exception {
        JSONArray songs = new JSONArray();
        JSONObject song = new JSONObject();
        song.put("id", UUID.randomUUID().toString());
        song.put("songTitle", title);
        song.put("author", "Composer");
        song.put("difficulty", difficulty);
        song.put("genre", genre);
        song.put("sheetMusic", "A B C");
        song.put("rating", rating);

        songs.add(song);

        try (FileWriter file = new FileWriter(DataConstants.TEST_SONG_FILE_NAME)) {
            file.write(songs.toJSONString());
        }
    }

    // --- User Loader Tests ---

    @Test
    public void testLoadSingleUser() throws Exception {
        writeTestUserJSON("junituser", "junit@email.com", 3, 1500);
        ArrayList<User> users = DataLoader.getUsers();
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("junituser", user.getUserName());
        assertEquals("junit@email.com", user.getEmailAddress());
        assertEquals(3, user.getExperienceLevel());
        assertEquals(1500, user.getXpPoints());
    }

    @Test
    public void testLoadNoUsersReturnsEmptyList() throws Exception {
        ArrayList<User> users = DataLoader.getUsers();
        assertTrue(users.isEmpty());
    }

    // --- Song Loader Tests ---

    @Test
    public void testLoadSingleSong() throws Exception {
        writeTestSongJSON("UnitTestSong", "EASY", "ROCK", 5);
        ArrayList<Song> songs = DataLoader.getSongs();
        assertEquals(1, songs.size());

        Song song = songs.get(0);
        assertEquals("UnitTestSong", song.getSongTitle());
        assertEquals(Difficulty.EASY, song.getDifficulty());
        assertEquals(Genre.ROCK, song.getGenre());
        assertEquals(5, song.getRating());
    }

    @Test
    public void testLoadNoSongsReturnsEmptyList() throws Exception {
        ArrayList<Song> songs = DataLoader.getSongs();
        assertTrue(songs.isEmpty());
    }

    @Test
    public void testLoadMultipleSongs() throws Exception {
        writeTestSongJSON("First", "EASY", "JAZZ", 3);
        writeTestSongJSON("Second", "HARD", "POP", 4);

        ArrayList<Song> songs = DataLoader.getSongs();
        assertTrue(songs.size() >= 2);
    }

    @Test
    public void testLoadCorruptedUserJSON() throws Exception {
        Files.write(Paths.get(DataConstants.TEST_USER_FILE_NAME), "{ this is not valid json ]".getBytes());
        ArrayList<User> users = DataLoader.getUsers();
        assertTrue(users.isEmpty());
    }

    @Test
    public void testUserMissingRequiredField() throws Exception {
        JSONArray users = new JSONArray();
        JSONObject user = new JSONObject();
        user.put("id", UUID.randomUUID().toString());
        user.put("userRole", "User");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("username", "noemailuser");
        user.put("playlists", new JSONArray());
        user.put("experienceLevel", 1);
        user.put("xpPoints", 100);
        user.put("password", "pass");

        users.add(user);
        Files.write(Paths.get(DataConstants.TEST_USER_FILE_NAME), users.toJSONString().getBytes());

        ArrayList<User> loaded = DataLoader.getUsers();
        assertEquals(1, loaded.size());
        assertNull(loaded.get(0).getEmailAddress()); // Depending on how you want to handle missing data
    }

    @Test
    public void testUserWithInvalidXPType() throws Exception {
        String invalidJSON = "[{\"id\":\"" + UUID.randomUUID() + "\"," + "\"userRole\":\"User\"," + "\"firstName\":\"Test\"," + "\"lastName\":\"User\"," + "\"username\":\"typeerror\"," + "\"playlists\":[]," + "\"emailAddress\":\"test@error.com\"," + "\"experienceLevel\":1," + "\"xpPoints\":\"notAnInt\"," + "\"password\":\"pass\"}]";

        Files.write(Paths.get(DataConstants.TEST_USER_FILE_NAME), invalidJSON.getBytes());
        ArrayList<User> users = DataLoader.getUsers();

        assertTrue(users.isEmpty());
    }

    @Test
    public void testSongMissingOptionalField() throws Exception {
        JSONArray songs = new JSONArray();
        JSONObject song = new JSONObject();
        song.put("id", UUID.randomUUID().toString());
        song.put("songTitle", "NoSheetMusic");
        song.put("author", "Unknown");
        song.put("difficulty", "MEDIUM");
        song.put("genre", "POP");
        song.put("rating", 3);

        songs.add(song);
        Files.write(Paths.get(DataConstants.TEST_SONG_FILE_NAME), songs.toJSONString().getBytes());

        ArrayList<Song> loaded = DataLoader.getSongs();
        assertEquals(1, loaded.size());
        assertNull(loaded.get(0).getSheetMusic());
    }

    @Test
    public void testSongWithInvalidEnum() throws Exception {
        JSONArray songs = new JSONArray();
        JSONObject song = new JSONObject();
        song.put("id", UUID.randomUUID().toString());
        song.put("songTitle", "BadEnums");
        song.put("author", "Nobody");
        song.put("difficulty", "INSANE"); // Not valid
        song.put("genre", "UNKNOWN");     // Not valid
        song.put("sheetMusic", "C D E");
        song.put("rating", 4);

        songs.add(song);
        Files.write(Paths.get(DataConstants.TEST_SONG_FILE_NAME), songs.toJSONString().getBytes());

        ArrayList<Song> loaded = DataLoader.getSongs();
        assertTrue(loaded.isEmpty()); // Should be skipped or catch exception
    }






}
