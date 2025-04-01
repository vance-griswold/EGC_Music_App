package library;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.model.DataConstants;
import com.model.DataWriter;
import com.model.Difficulty;
import com.model.Genre;
import com.model.Song;
import com.model.SongLibrary;
import com.model.User;
import com.model.UserList;

public class DataWriterTest {

    @Before
    public void setup() throws Exception {
        DataConstants.TEST_MODE = true;
        UserList.getInstance().getUsers().clear();
        SongLibrary.getInstance().getSongs().clear();

        // Reset test JSON files
        Files.write(Paths.get(DataConstants.TEST_USER_FILE_NAME), "[]".getBytes());
        Files.write(Paths.get(DataConstants.TEST_SONG_FILE_NAME), "[]".getBytes());
    }

    private User createTestUser(String username) {
        return new User(UUID.randomUUID(),"User", "First", "Last", username, new ArrayList<>(),username + "@test.com", 1, 0, "password");
    }

    private Song createTestSong(String title) {
        return new Song(UUID.randomUUID(), title, "Test Author", Difficulty.MEDIUM, Genre.ROCK, "C5q D5q E5q", 4);
    }

    // --- User save tests ---

    @Test
    public void testSaveSingleUser() throws Exception {
        UserList userList = UserList.getInstance();
        userList.create(createTestUser("singleuser"));
        DataWriter.saveUsers();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_USER_FILE_NAME)));
        assertTrue(content.contains("singleuser"));
    }

    @Test
    public void testSaveMultipleUsers() throws Exception {
        UserList userList = UserList.getInstance();
        for (int i = 0; i < 5; i++) {
            userList.create(createTestUser("user" + i));
        }
        DataWriter.saveUsers();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_USER_FILE_NAME)));
        assertTrue(content.contains("user0"));
        assertTrue(content.contains("user4"));
    }

    @Test
    public void testOverwriteUserFile() throws Exception {
        UserList userList = UserList.getInstance();
        userList.create(createTestUser("overwrite"));
        DataWriter.saveUsers();

        userList.getUsers().clear();
        userList.create(createTestUser("replacement"));
        DataWriter.saveUsers();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_USER_FILE_NAME)));
        assertFalse(content.contains("overwrite"));
        assertTrue(content.contains("replacement"));
    }

    // --- Song save tests ---

    @Test
    public void testSaveSingleSong() throws Exception {
        SongLibrary songLibrary = SongLibrary.getInstance();
        songLibrary.getSongs().add(createTestSong("OneSong"));
        DataWriter.saveSongs();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_SONG_FILE_NAME)));
        assertTrue(content.contains("OneSong"));
    }

    @Test
    public void testSaveMultipleSongs() throws Exception {
        SongLibrary songLibrary = SongLibrary.getInstance();
        for (int i = 1; i <= 3; i++) {
            songLibrary.getSongs().add(createTestSong("Song" + i));
        }
        DataWriter.saveSongs();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_SONG_FILE_NAME)));
        assertTrue(content.contains("Song1"));
        assertTrue(content.contains("Song3"));
    }

    @Test
    public void testOverwriteSongFile() throws Exception {
        SongLibrary songLibrary = SongLibrary.getInstance();
        songLibrary.getSongs().add(createTestSong("OldSong"));
        DataWriter.saveSongs();

        songLibrary.getSongs().clear();
        songLibrary.getSongs().add(createTestSong("NewSong"));
        DataWriter.saveSongs();

        String content = new String(Files.readAllBytes(Paths.get(DataConstants.TEST_SONG_FILE_NAME)));
        assertFalse(content.contains("OldSong"));
        assertTrue(content.contains("NewSong"));
    }
}
