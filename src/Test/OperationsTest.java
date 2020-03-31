import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OperationsTest {


    Subordinates sb1;
    Subordinates sb2;
    Subordinates sb3;
    ArrayList<Subordinates> listTest;


    @Before
    public void setUp() throws Exception {

        sb1 = new Subordinates("John", "Doe", "Manager", "Product Engineering", "111-111-1111");
        sb2 = new Subordinates("Tom", "Apple", "Team Lead", "Product Engineering", "222-222-2222");
        sb3 = new Subordinates("Harry", "Orange", "Developer", "Product Engineering", "333-333-3333");
        listTest = new ArrayList<>();
    }

    @Test
    public void printOrgChart() {
        listTest.add(sb1);
        listTest.add(sb2);
        listTest.add(sb3);

        assertEquals(listTest.get(0),sb1);
        assertEquals(listTest.get(1),sb2);
        assertEquals(listTest.get(2),sb3);
    }
}