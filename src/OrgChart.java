import java.util.Scanner;

public class OrgChart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User :");
        String name = sc.nextLine();

        Operations op = new Operations();
        op.printOrgChart(name);
    }

}
