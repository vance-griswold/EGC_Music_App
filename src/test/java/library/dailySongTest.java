package library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.model.dailySong;
import com.model.Song;
import com.model.Difficulty;
import com.model.Genre;
import java.util.UUID;

/**
 * @author Veronica Fisher
 */
public class dailySongTest {
    private dailySong dailySong;
    private Song testSong1;
    private Song testSong2;

    @Before
    public void setUpTest()
    {
        dailySong = new dailySong();
        testSong1 = new Song(UUID.randomUUID(), "song1", "author1", Difficulty.MEDIUM, Genre.CLASSICAL, "sheetMusic1", 5);
        testSong2 = new Song(UUID.randomUUID(), "song2", "author2", Difficulty.HARD, Genre.POP, "sheetMusic2", 4);
    }

    @Test
    public void testInitialValues()
    {
        assertNotNull(dailySong.getId());
        assertNull(dailySong.getSong());
        assertEquals(0, dailySong.getXpPoints());
        assertEquals(0, dailySong.getSongCounter());
        assertFalse(dailySong.isDailySongCompleted());
    }

    @Test
    public void testAssignDailySong() {
        dailySong.assignDailySong(testSong1);
        assertEquals(testSong1, dailySong.getSong());
        assertFalse(dailySong.isDailySongCompleted());
    }

    @Test
    public void testPlayDailySongIncreasesXPAndSongCount()
    {
        dailySong.assignDailySong(testSong1);
        dailySong.playDailySong(testSong1);
        
        assertTrue(dailySong.isDailySongCompleted());
        assertEquals(100, dailySong.getXpPoints()); //XP should increase by 100 once a song is complete
        assertEquals(1, dailySong.getSongCounter()); //song counter should increase by 1
    }

    @Test
    public void testPlayDailySongWithoutAssigning()
    {
        try {
            dailySong.playDailySong(testSong1);
            fail("Expected exception when trying to play song without a song assignment");
        } catch (NullPointerException e) {
            // Expected exception, test passes
        }
    }

    @Test
    public void testIncreaseXP()
    {
        dailySong.increaseXP(50);
        assertEquals(50, dailySong.getXpPoints());

        dailySong.increaseXP(25);
        assertEquals(75, dailySong.getXpPoints());
    }

    @Test
    public void testSongCounter()
    {
        dailySong.assignDailySong(testSong1);
        dailySong.playDailySong(testSong1);

        dailySong.assignDailySong(testSong2);
        dailySong.playDailySong(testSong2);

        assertEquals(2, dailySong.getSongCounter()); //two daily songs should be completed so songCounter should be 2 
        //(assuming one song was played per day for testing purposes)
    }

    @Test
    public void testXpDoesNotIncreaseWithoutPlayingSong()
    {
        dailySong.assignDailySong(testSong1);
        assertEquals(0, dailySong.getXpPoints()); //XP should not increase
    }

    @Test
    public void testCannotCompleteSameSongTwice()
    {
        dailySong.assignDailySong(testSong1);
        dailySong.playDailySong(testSong1);
        dailySong.playDailySong(testSong1);

        assertEquals(1, dailySong.getSongCounter()); //song counter should not increase again since the same song was played twice
        assertEquals(100, dailySong.getXpPoints()); //XP should still be 100
    }
}
