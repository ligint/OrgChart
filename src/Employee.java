import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Employee {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Address;
    private int personId;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String address, int personId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Address = address;
        this.personId = personId;
    }

    String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", personId=" + personId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return personId == employee.personId &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                phoneNumber.equals(employee.phoneNumber) &&
                Address.equals(employee.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, Address, personId);
    }

    /*Reads from dataOrg.txt file and stores all the organization information in a HashMap
    * 1. Person Id is the Key
    * 2. Employee Object is the value(firstName, LastName, phoneNumber, Address, PersonId
    * */

    protected HashMap<Integer, Employee> createEmployee(String filename) {

        HashMap<Integer, Employee> EmployeeMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // Read file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                String[] data = line.split(";");

                // Create new Employee object
                Employee emp = new Employee();
                emp.setFirstName(data[0]);
                emp.setLastName(data[1]);
                emp.setPhoneNumber(data[2]);
                emp.setAddress(data[3]);
                Integer id = Integer.valueOf(data[4]);
                emp.setPersonId(id);
                // Add object to map
                EmployeeMap.put(id, emp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EmployeeMap;
    }

}
