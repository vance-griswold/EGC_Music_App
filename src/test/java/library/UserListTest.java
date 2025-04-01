package library;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.model.User;
import com.model.UserList;

/**
 * @author vancemg
 */
public class UserListTest {

    @Test
    public void testDefaultConstructor() {
        UserList userList = new UserList();
        assertEquals(null, userList.getUser("username"));
    }

    @Test
    public void getInstanceOfUserList() {
        UserList userList = UserList.getInstance();
        assertEquals(userList, UserList.getInstance());
    }

    @Test
    public void testGetUser() {
        UserList userList = UserList.getInstance();
        User user = new User(UUID.randomUUID(), "firstName", "lastName", "username", null, "emailAddress", 1, 0, "password");
        userList.getUsers().add(user);
        assertEquals(user, userList.getUser("username"));
    }

    
}