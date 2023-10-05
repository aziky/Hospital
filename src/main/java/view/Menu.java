
package view;

import java.util.Scanner;
import tool.EmployeeManage;


public class Menu {
    public static void main(String[] args) {
        EmployeeManage manage = new EmployeeManage();
        Scanner sc = new Scanner(System.in);
        int userChoice ;
        do {            
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. View all the list");
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
                    manage.viewAllList();
                    break;  
                default:
                    break;
            }
        } while (userChoice != 12);

        sc.close();
    }
}
