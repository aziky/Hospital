
package view;

import java.util.Scanner;
import tool.EmployeeManage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        EmployeeManage manage = new EmployeeManage();
        Scanner sc = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Update");
            System.out.println("5. View all the list");
            System.out.println("6. View tak-on list");
            System.out.println("7. View resign list");
            System.out.println("8. View doctor list");
            System.out.println("9. View nurse list");
            System.out.println("10. View technician list");
            System.out.println("11. Write list to file");
            System.out.println("12. quit");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            switch (userChoice) {
                case 1:
                    manage.addEmployee();
                    break;
                case 2:
                    manage.searchEmployee();
                    break;
                case 3:
                    manage.removeEmployee();
                    break;
                case 4:
                    manage.updateEmployee();
                    break;
                case 5:
                    manage.viewAllList();
                    break;
                case 6:
                    manage.takeOnList();
                    break;
                case 7:
                    manage.resignList();
                    break;
                case 8:
                    manage.doctorList();
                    break;
                case 9:
                    manage.nurseList();
                    break;
                case 10:
                    manage.technicianList();
                    break;
                case 11:
                    manage.writeToFile();
                    break;
                default:
                    System.out.println("Bye bye!");
                    break;
            }
        } while (userChoice != 12);

        sc.close();
    }
}
