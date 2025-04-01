package library;

import com.model.User;
import com.model.UserList;
import com.model.DataConstants;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class UserListTest {

    @Before
    public void setup() {
        DataConstants.TEST_MODE = true;
    }


    private User createTestUser(String username) {
        return new User(
            UUID.randomUUID(),"User", "Test", "User", username, new ArrayList<>(), username + "@email.com", 1, 0, "testpass");
    }

    // Get user tests
    @Test
    public void testGetUserValid() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("alice123");
        userList.getUsers().add(user);
        assertEquals(user, userList.getUser("alice123"));
    }

    @Test
    public void testGetUserInvalid() {
        UserList userList = UserList.getInstance();
        assertNull(userList.getUser("nonexistent"));
    }

    @Test
    public void testGetUserEmptyString() {
        UserList userList = UserList.getInstance();
        assertNull(userList.getUser(""));
    }

    @Test
    public void testGetUserNull() {
        UserList userList = UserList.getInstance();
        assertNull(userList.getUser(null));
    }

    @Test
    public void testGetCurrentUserAfterFailedLogin() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("shouldfail");
        userList.create(user);
        userList.login("shouldfail@email.com", "wrongpass");
        assertNull(UserList.getCurrentUser());
    }


    // Create tests
    @Test
    public void testCreateUser() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("johnd");
        int initialSize = userList.getUsers().size();
        userList.create(user);
        assertEquals(initialSize + 1, userList.getUsers().size());
        assertEquals(user, userList.getUser("johnd"));
    }

    @Test
    public void testCreateDuplicateUser() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("duplicate");
        userList.create(user);
        userList.create(user);
        int count = 0;
        for (User u : userList.getUsers()) {
            if (u.getUserName().equals("duplicate")) count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void testBulkCreateUsers() {
        UserList userList = UserList.getInstance();
        for (int i = 0; i < 50; i++) {
            userList.create(createTestUser("bulk" + i));
        }
        assertEquals(50, userList.getUsers().size());
    }

    @Test
    public void testCreateUsersSameUsernameDifferentObjects() {
        UserList userList = UserList.getInstance();
        User user1 = createTestUser("sameuser");
        User user2 = createTestUser("sameuser");

        userList.create(user1);
        userList.create(user2);

        int count = 0;
        for (User u : userList.getUsers()) {
            if (u.getUserName().equals("sameuser")) count++;
        }
        assertEquals(2, count); // current behavior allows it
    }




    // Update tests
    @Test
    public void testUpdateUserValid() {
        UserList userList = UserList.getInstance();
        User original = createTestUser("bob123");
        userList.getUsers().add(original);

        User updated = new User(
            UUID.fromString(original.getId()), "User", "Bobby", "Smith", "bob123", new ArrayList<>(), "bob@email.com", 1, 10, "newpass");

        userList.update("bob123", updated);

        assertEquals("Bobby", userList.getUser("bob123").getFirstName());
        assertEquals("newpass", userList.getUser("bob123").getPassword());
    }

    @Test
    public void testUpdateUserInvalid() {
        UserList userList = UserList.getInstance();
        User updated = createTestUser("fakey");
        userList.update("ghost", updated); // Should print "User not found"
        assertNull(userList.getUser("fakey"));
    }

        @Test
    public void testUpdateWithSameData() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("sameuser");
        userList.create(user);

        User identical = new User(
            UUID.fromString(user.getId()), "User", "Test", "User", "sameuser", new ArrayList<>(), "sameuser@email.com", 1, 0, "testpass");
        userList.update("sameuser", identical);

        assertEquals("Test", userList.getUser("sameuser").getFirstName());
    }

    @Test
    public void testUpdateUserWithChangedEmail() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("editme");
        userList.create(user);

        User updated = new User(
            UUID.fromString(user.getId()), "User", "Edit", "Changed", "editme", new ArrayList<>(), "newemail@email.com", 1, 5, "updatedpass");
        userList.update("editme", updated);

        assertEquals("newemail@email.com", userList.getUser("editme").getEmailAddress());
        assertEquals("Edit", userList.getUser("editme").getFirstName());
    }

    @Test
    public void testUpdateUnaddedUser() {
        UserList userList = UserList.getInstance();
        User ghost = createTestUser("unadded");
        userList.update("unadded", ghost);
        assertNull(userList.getUser("unadded"));
}




    // Delete tests
    @Test
    public void testDeleteExistingUser() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("deleteme");
        userList.getUsers().add(user);
        userList.delete("deleteme");
        assertNull(userList.getUser("deleteme"));
    }

    @Test
    public void testDeleteNonexistentUser() {
        UserList userList = UserList.getInstance();
        int sizeBefore = userList.getUsers().size();
        userList.delete("nonexistent");
        assertEquals(sizeBefore, userList.getUsers().size());
    }

    @Test
    public void testDeleteUserTwice() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("doubledelete");
        userList.create(user);
        userList.delete("doubledelete"); 
        userList.delete("doubledelete");
        assertNull(userList.getUser("doubledelete"));
    }

    // Login tests
    @Test
    public void testLoginSuccess() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("logg");
        userList.getUsers().add(user);
        boolean result = userList.login("logg@email.com", "testpass");
        assertTrue(result);
        assertEquals(user, UserList.getCurrentUser());
    }

    @Test
    public void testLoginIncorrectPassword() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("wrongpass");
        userList.getUsers().add(user);
        boolean result = userList.login("wrongpass@email.com", "wrongpassword");
        assertFalse(result);
    }

    @Test
    public void testLoginNonexistentEmail() {
        UserList userList = UserList.getInstance();
        boolean result = userList.login("ghost@void.com", "doesntmatter");
        assertFalse(result);
    }

    @Test
    public void testLoginWithNullEmail() {
        UserList userList = UserList.getInstance();
        boolean result = userList.login(null, "testpass");
        assertFalse(result);
    }

    @Test
    public void testLoginWithNullPassword() {
        UserList userList = UserList.getInstance();
        User user = createTestUser("nullpass");
        userList.create(user);
        boolean result = userList.login("nullpass@email.com", null);
        assertFalse(result); // Avoids NullPointerException if handled well
    }




    //read tests
    @Test
    public void testReadUsersPrints() {
        UserList userList = UserList.getInstance();
        userList.create(createTestUser("read1"));
        userList.create(createTestUser("read2"));
        userList.read(); // Just exercises the method
        assertEquals(2, userList.getUsers().size());
    }

    //save tests
    @Test
    public void testSaveDoesNotCrash() {
        UserList userList = UserList.getInstance();
        userList.create(createTestUser("saveuser"));
        userList.save(); // Only prints "User list saved"
        assertTrue(userList.getUsers().size() > 0);
    }


}
