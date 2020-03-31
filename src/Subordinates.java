import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subordinates {

    private String fname;
    private String lname;
    private String title;
    private String organization;
    private String phoneNumber;
    ArrayList<Subordinates> list;

    public Subordinates() {
        list = new ArrayList<>();
    }

    public Subordinates(String fname, String lname, String title, String organization, String phoneNumber) {
        this.fname = fname;
        this.lname = lname;
        this.title = title;
        this.organization = organization;
        this.phoneNumber = phoneNumber;
    }

    public String getFname() {
        return fname;
    }

    private void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    private void setLname(String lname) {
        this.lname = lname;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return organization;
    }

    private void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "'" + fname + '\'' +
                        ", '" + lname + '\'' +
                        ", '" + title + '\'' +
                        ", '" + organization + '\'' +
                        ", '" + phoneNumber + '\'';
    }

    /* Finds the name passes as user input in the HashMap and returns the key */
    protected Integer findId(String name, HashMap<Integer, Employee> map) {

        int id = 0;
        String[] input = name.split(" ");
        // loops through the hashMap and looks for the name;
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            Employee e = entry.getValue();
            // returns the personId if name is found
            if (e.getFirstName().equalsIgnoreCase(input[0]) || e.getLastName().equalsIgnoreCase(input[0])) {
                id = e.getPersonId();

            }

        }

        return id;

    }


    // prints all the subordinates using the personId
    protected ArrayList<Subordinates> printSubordinates(Integer id, HashMap<Integer, Employee> emap, HashMap<Integer, Organization> omap, HashMap<Integer, List<Integer>> tmap) {

        if (emap.containsKey(id) && omap.containsKey(id)) {
            Employee e = emap.get(id);
            Organization o = omap.get(id);

            Subordinates sb = new Subordinates();
            sb.setFname(e.getFirstName());
            sb.setLname(e.getLastName());
            sb.setTitle(o.getTitle());
            sb.setOrganization(o.getOrganization());
            sb.setPhoneNumber(e.getPhoneNumber());

            list.add(sb);

        }
        // to print the values of all the subordinates
        if (tmap.containsKey(id)) {
            List<Integer> subOrd = tmap.get(id);
            for (Integer a : subOrd) {
                printSubordinates(a, emap, omap, tmap);

            }
        }
        return list;

    }
}
