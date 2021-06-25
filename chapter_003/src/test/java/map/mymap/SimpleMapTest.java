package map.mymap;

import map.User;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {

    @Test
    public void whenPutAndGetThenOneTwo() {
        SimpleMap<User, String> map = new SimpleMap<>();
        User user1 = new User("Roman", 2, new GregorianCalendar(1997, 11, 21, 10, 20, 1));
        User user2 = new User("Roman", 2, new GregorianCalendar(1997, 11, 21, 10, 20, 2));
        map.put(user1, "one");
        map.put(user2, "two");
        assertThat(map.get(user1), is("one"));
        assertThat(map.get(user2), is("two"));
    }

    @Test
    public void whenYouRemoveThenNull() {
        SimpleMap<User, String> map = new SimpleMap<>();
        User user = new User("Roman", 2, new GregorianCalendar(1997, 11, 21, 10, 20, 1));
        map.put(user, "one");
        map.remove(user);
        assertNull(map.get(user));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterateYouChangeMapThenCME() {
        SimpleMap<User, String> map = new SimpleMap<>();
        User user1 = new User("Roman", 2, new GregorianCalendar(1997, 11, 21, 10, 20, 1));
        User user2 = new User("Roman", 2, new GregorianCalendar(1997, 11, 21, 10, 20, 1));
        map.put(user1, "one");
        Iterator<String> it = map.iterator();
        map.put(user2, "two");
        it.next();
    }
}