import java.util.HashMap;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee e;
    Employee f;
    Employee g;

    @org.junit.Before
    public void setUp() throws Exception {
        e = new Employee("John","Doe","111-111-1111","1 Main Ave, City, State",1000);
        f = new Employee("Tom","Apple","222-222-2222","2 Side Ct, City, State",1001);
        g = new Employee("Harry","Orange","333-333-3333","3 Cross St, City, State",1002);
    }

    @org.junit.Test
    public void createEmployee() {

        HashMap<Integer,Employee> TestMap = new HashMap<>();
        TestMap.put(1000,e);
        TestMap.put(1001,f);
        TestMap.put(1002,g);

        Operations op = new Operations();
        assertEquals(TestMap.get(1000),e);
        assertEquals(TestMap.get(1001),f);
        assertEquals(TestMap.get(1002),g);

        assertNotEquals(TestMap.get(1000),f);
    }
}