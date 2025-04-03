package library;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.model.*;
/**
 * @author Zachary DeYoung
 */
public class SongTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testFilterByRatingTrue() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        int rating = song.getRating();
        int rateTest = rating - 1;
        assertTrue(song.filterByRating(rateTest));
    }

    @Test
    public void testFilterByRatingEqual() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        int rating = song.getRating();
        int rateTest = rating;
        assertTrue(song.filterByRating(rateTest));
    }

    @Test
    public void testFilterByRatingFalse() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        int rating = song.getRating();
        int rateTest = rating + 1;
        assertFalse(song.filterByRating(rateTest));
    }

    @Test
    public void testSearchByNameTrue() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        assertTrue(song.searchByName("A horses journey"));
    }

    @Test
    public void testSearchByNameTrueLowercase() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        assertTrue(song.searchByName("a horses journey"));
    }

    @Test
    public void testSearchByNameTrueUpperCase() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        assertTrue(song.searchByName("A HORSES JOURNEY"));
    }

    @Test
    public void testSearchByNameFalse() {
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        assertTrue(song.searchByName("Hadestown"));
    }

    @Test
    public void testEditSong() {
        InputStream sysInBackup = System.in;
        String testInput = "y\ny\nn\nc\n5\nq\nn\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        MusicApp musicApp = new MusicApp(); 
        musicApp.login("asmith@gmail.com", "password");
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        Song song2 = songLibrary.searchSong("A horses journey");
        song.editSong();
        SheetMusic sheetMusic = new SheetMusic(song.getSongTitle(), song.getSheetMusic());
        ArrayList<Measure> measures = sheetMusic.getMeasures();
        ArrayList<Chord> chords = new ArrayList<Chord>();
        Chord chord = new Chord("C5q");
        chords.add(chord);
        Measure measure = new Measure(chords);
        measures.add(measure);
        SheetMusic sm2 = new SheetMusic("A horses journey", measures);
        song2.setSheetMusic(sm2);
        assertEquals(song,song2);
        System.setIn(sysInBackup);

    }

    @Test
    public void testEditSongNo() {
        InputStream sysInBackup = System.in;
        String testInput = "n\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        MusicApp musicApp = new MusicApp(); 
        musicApp.login("asmith@gmail.com", "password");
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        Song song2 = song;
        song.editSong();
        assertEquals(song,song2);
        System.setIn(sysInBackup);

    }

    @Test
    public void testEditSongErrorNo() {
        InputStream sysInBackup = System.in;
        String testInput = "q\nn\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        MusicApp musicApp = new MusicApp(); 
        musicApp.login("asmith@gmail.com", "password");
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song = songLibrary.searchSong("A horses journey");
        Song song2 = song;
        song.editSong();
        assertEquals(song,song2);
        System.setIn(sysInBackup);

    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testEditSongWrongAuthor() {
        MusicApp musicApp = new MusicApp(); 
        musicApp.login("JonnyBoy@gmail.com", "password");
        SongLibrary songLibrary = SongLibrary.getInstance();
        Song song3 = songLibrary.searchSong("A horses journey");
        song3.editSong();
        assertEquals("You are not the author of this song.", outputStreamCaptor.toString().trim());
    }
}
