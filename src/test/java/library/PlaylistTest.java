package library;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.model.Difficulty;
import com.model.Genre;
import com.model.Playlist;
import com.model.Song;

public class PlaylistTest {

    /*
     * Author @Kayleigh Faus
     */

    @Test
    public void testAddSongToEmptyPlaylist() {
        Playlist playlist = new Playlist();
        Song song = new Song("Song1", "Artist1", Difficulty.EASY, Genre.POP, "SheetMusic1", 3);
        playlist.addSong(song);
        assertEquals(1, playlist.getPlaylistSize());
    }

    @Test
    public void testAddMultipleSongs() {
        Playlist playlist = new Playlist();
        Song song1 = new Song("Song1", "Artist1", Difficulty.MEDIUM, Genre.ROCK, "SheetMusic1", 4);
        Song song2 = new Song("Song2", "Artist2", Difficulty.HARD, Genre.COUNTRY, "SheetMusic2", 5);
        playlist.addSong(song1);
        playlist.addSong(song2);
        assertEquals(2, playlist.getPlaylistSize());
    }

    @Test
    public void testAddNullSong() {
        Playlist playlist = new Playlist();
        playlist.addSong(null);
        assertEquals(0, playlist.getPlaylistSize());  
    }

    @Test
    public void testAddSongWithSameName() {
        Playlist playlist = new Playlist();
        Song song1 = new Song("Song1", "Artist1", Difficulty.EASY, Genre.POP, "SheetMusic1", 3);
        Song song2 = new Song("Song1", "Artist2", Difficulty.MEDIUM, Genre.CLASSICAL, "SheetMusic2", 2);
        playlist.addSong(song1);
        playlist.addSong(song2);
        assertEquals(2, playlist.getPlaylistSize());
    }

    @Test
    public void testAddSongAfterRemoving() {
        Playlist playlist = new Playlist();
        Song song = new Song("Song1", "Artist1", Difficulty.HARD, Genre.ROCK, "SheetMusic1", 5);
        playlist.addSong(song);
        playlist.removeSong(song);
        playlist.addSong(song);
        assertEquals(1, playlist.getPlaylistSize());
    }

    @Test
    public void testRemoveExistingSong() {
        Playlist playlist = new Playlist();
        Song song = new Song("Song1", "Artist1", Difficulty.EASY, Genre.POP, "SheetMusic1", 3);
        playlist.addSong(song);
        playlist.removeSong(song);
        assertEquals(0, playlist.getPlaylistSize());
    }

    @Test
    public void testRemoveSongFromEmptyPlaylist() {
        Playlist playlist = new Playlist();
        Song song = new Song("Song1", "Artist1", Difficulty.MEDIUM, Genre.ROCK, "SheetMusic1", 4);
        playlist.removeSong(song);
        assertEquals(0, playlist.getPlaylistSize());
    }

    @Test
    public void testRemoveSongNotInPlaylist() {
        Playlist playlist = new Playlist();
        Song song1 = new Song("Song1", "Artist1", Difficulty.HARD, Genre.COUNTRY, "SheetMusic1", 5);
        Song song2 = new Song("Song2", "Artist2", Difficulty.EASY, Genre.CLASSICAL, "SheetMusic2", 2);
        playlist.addSong(song1);
        playlist.removeSong(song2);
        assertEquals(1, playlist.getPlaylistSize());
    }

    @Test
    public void testRenamePlaylist() {
        Playlist playlist = new Playlist();
        playlist.renamePlaylist("My New Playlist");
        assertEquals("My New Playlist", playlist.getTitle());
    }

    @Test
    public void testRenamePlaylistToSameName() {
        Playlist playlist = new Playlist();
        playlist.renamePlaylist("Untitled Playlist");
        assertEquals("Untitled Playlist", playlist.getTitle());
    }

    @Test
    public void testRenamePlaylistEmptyString() {
        Playlist playlist = new Playlist();
        playlist.renamePlaylist("");
        assertEquals("", playlist.getTitle());
    }

    @Test
    public void testRenamePlaylistAfterAddingSongs() {
        Playlist playlist = new Playlist();
        Song song = new Song("Song1", "Artist1", Difficulty.EASY, Genre.POP, "SheetMusic1", 3);
        playlist.addSong(song);
        playlist.renamePlaylist("My Playlist");
        assertEquals("My Playlist", playlist.getTitle());
    }
}
