package map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapApp {
    public static void main(String[] args) {
        User usr1 = new User("Roman", 2, new GregorianCalendar(1997, 12, 21));
        User usr2 = new User("Petr", 4, new GregorianCalendar(1995, 5, 9));
        Map<User, Object> mp = new HashMap<>();
        mp.put(usr1, new Object());
        mp.put(usr2, new Object());
        for (Map.Entry m : mp.entrySet()) {
            System.out.println("Repository content elements:" + "[key:" + m.getKey().toString() + "value:" + m.getValue() + "]");
        }
    }
}
