import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Organization {

    private String title;
    private String organization;
    private int personId;

    public Organization() {

    }

    public Organization(String title, String organization, int personId) {
        this.title = title;
        this.organization = organization;
        this.personId = personId;
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

    public int getPersonId() {
        return personId;
    }

    private void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", organization='" + organization + '\'' +
                ", personId=" + personId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return personId == that.personId &&
                title.equals(that.title) &&
                organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, organization, personId);
    }

    /*Reads from dataOrg.txt file and stores all the organization information in a HashMap
     * 1. Person Id is the Key
     * 2. Organization Object is the value(title, organization, PersonId
     * */

    protected HashMap<Integer, Organization> createOrg(String filename) {

        HashMap<Integer, Organization> mapCreateOrg = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // Read file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                String[] data = line.split(";");

                // Create new Organization object
                Organization org = new Organization();
                org.setTitle(data[0]);
                org.setOrganization(data[1]);
                Integer id = Integer.valueOf(data[2]);
                org.setPersonId(id);

                // Add object to map
                mapCreateOrg.put(id, org);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapCreateOrg;
    }

}
