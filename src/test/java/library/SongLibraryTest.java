package library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

import com.model.SongLibrary;
import com.model.Song;
import com.model.Difficulty;
import com.model.Genre;

/**
 * @author Veronica Fisher
 */
public class SongLibraryTest {
    private SongLibrary songLibrary;
    private Song song1, song2;

    @Before
    public void setUpTest()
    {
        songLibrary = SongLibrary.getInstance();
        song1 = new Song(UUID.randomUUID(), "song1", "author1", Difficulty.EASY, Genre.CLASSICAL, "sheetMusic1", 5);
        song2 = new Song(UUID.randomUUID(), "song2", "author2", Difficulty.MEDIUM, Genre.POP, "sheetMusic2", 4);

        songLibrary.create(song1);
        songLibrary.create(song2);
    }

    @Test
    public void testGetSongs()
    {
        ArrayList<Song> songs = songLibrary.getSongs();
        assertNotNull(songs);
        assertEquals(2, songs.size());
        assertTrue(songs.contains(song1));
        assertTrue(songs.contains(song2));
    }

    @Test
    public void testGetSongById()
    {
        Song getSongId = songLibrary.getSong(song1.getId());
        assertNotNull(getSongId);
        assertEquals(song1.getSongTitle(), getSongId.getSongTitle());
    }

    @Test
    public void testSearchSongByTitle()
    {
        Song foundSong = songLibrary.searchSong("song1");
        assertNotNull(foundSong);
        assertEquals(song1.getSongTitle(), foundSong.getSongTitle());

        Song notFoundSong = songLibrary.searchSong("Could not find song");
        assertNull(notFoundSong);
    }

    @Test
    public void testSortByGenre()
    {
        songLibrary.sortByGenre(Genre.ROCK);
        ArrayList<Song> songs = songLibrary.getSongs();
        assertEquals(song1, songs.get(0));
    }

    @Test
    public void testSortByDifficulty()
    {
        songLibrary.sortByDifficulty(Difficulty.EASY);
        ArrayList<Song> songs = songLibrary.getSongs();
        assertEquals(song1, songs.get(0));
    }

    @Test
    public void testFilterByGenre()
    {
        ArrayList<Song> filteredSongs = songLibrary.filterByGenre(Genre.ROCK);
        assertNotNull(filteredSongs);
        assertEquals(1, filteredSongs.size());
        assertTrue(filteredSongs.contains(song1));
    }

    @Test
    public void testFilterByDifficulty()
    {
        ArrayList<Song> filteredSongs = songLibrary.filterByDifficulty(Difficulty.MEDIUM);
        assertNotNull(filteredSongs);
        assertEquals(1, filteredSongs.size());
        assertTrue(filteredSongs.contains(song2));
    }

    @Test
    public void testFilterByAuthor()
    {
        ArrayList<Song> filteredSongs = songLibrary.filterByAuthor("author1");
        assertNotNull(filteredSongs);
        assertEquals(1, filteredSongs.size());
        assertTrue(filteredSongs.contains(song1));
    }

    @Test
    public void testCreateSong()
    {
        Song newSong = new Song(UUID.randomUUID(), "newSong", "newAuthor", Difficulty.HARD, Genre.COUNTRY, "sheetMusic3", 3);
        songLibrary.create(newSong);
        assertTrue(songLibrary.getSongs().contains(newSong));
    }

    @Test
    public void testUpdateSong()
    {
        Song newSong = new Song(UUID.randomUUID(), "newSong", "newAuthor", Difficulty.HARD, Genre.COUNTRY, "sheetMusic3", 3);
        songLibrary.create(newSong);
        newSong.setRating(4);
        songLibrary.update(newSong);

        Song updatedSong = songLibrary.getSong(newSong.getId());
        assertEquals(4, updatedSong.getRating());
    }

    @Test
    public void testDeleteSong()
    {
        songLibrary.delete(song1);
        assertNull(songLibrary.getSong(song1.getId()));
    }
}
