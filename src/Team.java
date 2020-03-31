import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Team {

    private int Manager;
    private int teamMember;

    public Team() {

    }

    public Team(int manager, int teamMember) {
        this.Manager = manager;
        this.teamMember = teamMember;
    }

    public int getManager() {
        return Manager;
    }

    private void setManager(int manager) {
        this.Manager = manager;
    }

    public int getTeamMember() {
        return teamMember;
    }

    private void setTeamMember(int teamMember) {
        this.teamMember = teamMember;
    }

    @Override
    public String toString() {
        return "Team{" +
                "Manager=" + Manager +
                ", teamMember=" + teamMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Manager == team.Manager &&
                teamMember == team.teamMember;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Manager, teamMember);
    }


    /*Reads from dataTeam.txt file and stores all the organization information in a HashMap
     * 1. managerId is the Key
     * 2. List of members is the value;
     * */


    protected HashMap<Integer, List<Integer>> createTeam(String filename) {

        HashMap<Integer, List<Integer>> mapCreateTeam = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // Read file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                String[] data = line.split(";");

                // Create new Team object
                Team team = new Team();
                Integer managerId = Integer.valueOf(data[0]);
                Integer memberId = Integer.valueOf(data[1]);
                team.setManager(managerId);
                team.setTeamMember(memberId);

                // if manager id is not a key, then create a new entry in HashMap
                if (!mapCreateTeam.containsKey(managerId)) {
                    mapCreateTeam.put(managerId, new ArrayList<>());
                }
                // if manager id is key , then add the teamMember to the list;
                mapCreateTeam.get(managerId).add(memberId);

                //if teamMember is a key , then add get the list of people under him
                if (mapCreateTeam.containsKey(memberId)) {

                    List<Integer> list1 = mapCreateTeam.get(memberId);
                    for (Integer x : list1) {
                        //add all the people under teamMember to Manager(level 2)
                        //Eg: if a developer is under manager then he is also under senior manager
                        mapCreateTeam.get(managerId).add(x);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapCreateTeam;
    }
}
