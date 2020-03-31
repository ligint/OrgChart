import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operations {

    File f1;
    File f2;
    File f3;
    String path1;
    String path2;
    String path3;

    Employee e;
    Organization or;
    Team t1 ;
    Subordinates sub;

    HashMap<Integer, Employee> EmployeeMap;
    HashMap<Integer, Organization> OrganizationMap;
    HashMap<Integer, List<Integer>> TeamMap;



    public Operations() {

        f1 = new File("data.txt");
        f2 = new File("dataOrg.txt");
        f3 = new File("dataTeam.txt");
        path1 = f1.getAbsolutePath();
        path2 = f2.getAbsolutePath();
        path3 = f3.getAbsolutePath();

        e = new Employee();
        or = new Organization();
        t1 = new Team();
        sub = new Subordinates();
    }



    void printOrgChart(String name) {


        EmployeeMap = e.createEmployee(path1);
        OrganizationMap = or.createOrg(path2);
        TeamMap = t1.createTeam(path3);

        Integer personId = sub.findId(name, EmployeeMap);

        ArrayList<Subordinates> list1 = sub.printSubordinates(personId, EmployeeMap, OrganizationMap, TeamMap);
        System.out.println("OrgChart : ");
        for (Subordinates s : list1) {

            System.out.println(s.toString());

        }

    }


}
