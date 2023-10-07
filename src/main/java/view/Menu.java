
package view;

import java.util.Scanner;
import tool.EmployeeManage;
import tool.Validation;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmployeeManage manage = new EmployeeManage();
        Validation valid = new Validation();
        Scanner sc = new Scanner(System.in);
        int userChoice;
        String line = "----------------------------------------------";
        do {
            System.out.println(line);
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
            System.out.println("12. Quit the program");
            userChoice = valid.checkInt("Enter your choice: ", 1, 12);
            switch (userChoice) {
                case 1:
                    System.out.println(line);
                    manage.addEmployee();
                    break;
                case 2:
                    System.out.println(line);
                    manage.searchEmployee();
                    break;
                case 3:
                    System.out.println(line);
                    manage.removeEmployee();
                    break;
                case 4:
                    System.out.println(line);
                    manage.updateEmployee();
                    break;
                case 5:
                    System.out.println(line);
                    manage.viewAllList();
                    break;
                case 6:
                    System.out.println(line);
                    manage.takeOnList();
                    break;
                case 7:
                    System.out.println(line);
                    manage.resignList();
                    break;
                case 8:
                    System.out.println(line);
                    manage.doctorList();
                    break;
                case 9:
                    System.out.println(line);
                    manage.nurseList();
                    break;
                case 10:
                    System.out.println(line);
                    manage.technicianList();
                    break;
                case 11:
                    System.out.println(line);
                    manage.writeToFile();
                    break;
                case 12:
                    System.out.println(line);
                    System.out.println("Bye bye");
                    System.out.println(line);
                    break;
            }
        } while (userChoice != 12);

        sc.close();
    }
}
