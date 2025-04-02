package library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.model.Leaderboard;
import com.model.User;

/**
 * @author Veronica Fisher
 */
public class LeaderboardTest {
    private Leaderboard leaderboard;
    private User user1, user2, user3;

    @Before
    public void setUpTest()
    {
        leaderboard = new Leaderboard();
        user1 = new User(UUID.randomUUID(), "student", "Sally", "S", "sally123", new ArrayList<>(), "sally@test.com", 10, 700, "password");
        user2 = new User(UUID.randomUUID(),"student", "Bobby", "B", "bobby123", new ArrayList<>(), "bobby@test.com", 6, 300, "password");
        user3 = new User(UUID.randomUUID(), "student", "Jackie", "J", "jackie123", new ArrayList<>(), "jackie@test.com", 9, 600, "password");
    }

    @Test
    public void testUpdateLeaderboardAddsUser()
    {
        leaderboard.updateLeaderboard(user1);
        assertTrue(leaderboard.getHighestLevelUsers().contains(user1));

        leaderboard.updateLeaderboard(user2);
        assertTrue(leaderboard.getHighestLevelUsers().contains(user2));

        leaderboard.updateLeaderboard(user3);
        assertTrue(leaderboard.getHighestLevelUsers().contains(user3));
    }

    @Test
    public void testUpdateLeaderboardNoDuplicates()
    {
        leaderboard.updateLeaderboard(user1);
        leaderboard.updateLeaderboard(user1);
        assertEquals(1, leaderboard.getHighestLevelUsers().size());
    }

    @Test
    public void testSortHighestLevelusers()
    {
        leaderboard.updateHighestLevelUsers(user1); //level 10, 700 xp points
        leaderboard.updateHighestLevelUsers(user2); //level 6, 300 xp points
        leaderboard.updateHighestLevelUsers(user3); //level 9, 600 xp points

        ArrayList<User> sortedUsers = leaderboard.getHighestLevelUsers();
        assertEquals(user1, sortedUsers.get(0));
        assertEquals(user3, sortedUsers.get(1));
        assertEquals(user2, sortedUsers.get(2));
    }

    @Test
    public void testDisplayHighestLevelUsers()
    {
        leaderboard.updateHighestLevelUsers(user1);
        leaderboard.updateHighestLevelUsers(user2);
        leaderboard.updateHighestLevelUsers(user3);
    }

    @Test
    public void testSortHighestLevelUsersWithLevelTie()
    {
        //users with same level but different number of xp points
        User user4 = new User(UUID.randomUUID(), "student", "Chris", "C", "chris123", new ArrayList<>(), "chris@test.com", 10, 600, "password");
        User user5 = new User(UUID.randomUUID(), "student", "Alicia", "A", "alicia123", new ArrayList<>(), "alicia@test.com", 10, 500, "password");

        leaderboard.updateHighestLevelUsers(user1);
        leaderboard.updateHighestLevelUsers(user4);
        leaderboard.updateHighestLevelUsers(user5);

        ArrayList<User> sortedUsers = leaderboard.getHighestLevelUsers();

        //xp points in descending order
        assertEquals(user1, sortedUsers.get(0)); //700 xp points
        assertEquals(user4, sortedUsers.get(1)); //600 xp points
        assertEquals(user5, sortedUsers.get(2)); //400 xp points
    }

    @Test
    public void testEmptyLeaderboard()
    {
        assertTrue(leaderboard.getHighestLevelUsers().isEmpty());
    }

    @Test
    public void testLargeNumberOfUsers()
    {
        for(int i = 0; i < 100; i++)
        {
            User user = new User(UUID.randomUUID(), "student", "User" + i, "Test", "user" + i, new ArrayList<>(), "user" + i + "@test.com", (i % 10) + 1, i * 100, "password");
            leaderboard.updateLeaderboard(user);
        }
        assertEquals(30, leaderboard.getHighestLevelUsers().size());
    }

    @Test
    public void testLeaderboardDoesNotExceedMaxUsers()
    {
        for(int i = 0; i < 31; i++)
        {
            User user = new User(UUID.randomUUID(), "student", "User" + i, "Test", "user" + i, new ArrayList<>(), "user" + i + "@test.com", (i % 10) + 1, i * 100, "password");
            leaderboard.updateLeaderboard(user);
        }
        assertEquals(30, leaderboard.getHighestLevelUsers().size());
    }

    @Test
    public void testLeaderboardSortAfterUpdates()
    {
        leaderboard.updateLeaderboard(user1);
        leaderboard.updateLeaderboard(user2);
        leaderboard.updateLeaderboard(user3);

        User user4 = new User(UUID.randomUUID(), "student", "Molly", "M", "molly123", new ArrayList<>(), "molly@test.com", 11, 700, "password");
        leaderboard.updateLeaderboard(user4);

        ArrayList<User> sortedUsers = leaderboard.getHighestLevelUsers();
        assertEquals(user4, sortedUsers.get(0));
    }

    @Test
    public void testDisplayLeaderboard()
    {
        leaderboard.updateLeaderboard(user1);
        leaderboard.updateLeaderboard(user2);
        leaderboard.updateLeaderboard(user3);

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        leaderboard.displayLeaderboard();
        String output = outputStream.toString();
        assertTrue(output.contains("Highest Level Users:"));
        assertTrue(output.contains(user1.getUserName()));
    }
}
