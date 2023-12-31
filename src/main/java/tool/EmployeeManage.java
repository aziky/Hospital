package tool;

import employee.Employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeManage implements IEmployeeManage {

    private List<Employee> listEmployees = new ArrayList<>();
    Validation valid = new Validation();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Employee inputEmployee() throws IOException {
        String ID = valid.checkID("Enter ID (Press Enter to return to the menu): ", listEmployees);
        if (ID.isEmpty()) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        String name = valid.checkName("Enter name (Press enter to return to the menu): ");
        if (name.isEmpty()) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        String phone = valid.checkPhone("Enter phone (Press enter to return to the menu): ");
        if (phone.isEmpty()) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        Date bDate = valid.checkDate("Enter your birthday date (Press enter to return to the menu): ");
        if (bDate == null) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        String role = valid.checkRole("Enter role (Press enter to return to the menu): ");
        if (role.isEmpty()) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        Date hiredDate = valid.checkHiredDate("Enter hired date (Press enter to return to the menu): ", bDate);
        if (hiredDate == null) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        int salary = valid.checkInt("Enter salary (Press enter to return to the menu): ", 100, 8000);
        if (salary == -1) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        int contractTime = valid.checkInt("Enter contract time (Press enter to return to the menu): ", 1, 30);
        if (contractTime == -1) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }
        Date resignDate = null;

        Employee employee = new Employee(ID, name, phone, bDate, role, hiredDate, salary, contractTime, resignDate);
        return employee;
    }

    @Override
    public void addEmployee() {
        Employee employee;
        try {
            employee = inputEmployee();
            if (employee != null) {
                listEmployees.add(employee);
                System.out.println("Success");
            } else {
                System.out.println("Adding employee canceled.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void searchEmployee() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't search employee because the list is empty");
            return;
        }

        String ID = valid.checkID("Enter ID (EMXXXX) with X a digit: ", listEmployees);
        for (Employee employee : listEmployees) {
            if (ID.equals(employee.getID())) {
                System.out.println("Employee found!");
                System.out.println(employee);
                return;
            }
        }

        System.out.println("Not found!");
    }

    @Override
    public void removeEmployee() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't remove employees because the list is empty");
            return;
        }

        String ID = valid.checkID("Enter ID (EMXXXX) with X a digit: ", listEmployees);
        Date date = new Date();
        for (Employee employee : listEmployees) {
            if (ID.equals(employee.getID())) {
                employee.setResignDate(date);
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Not exist");
    }

    @Override
    public void updateEmployee() throws FileNotFoundException, IOException {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't update because the list is empty");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int choice;
        int indexID = valid.checkUpdateID("Enter ID", listEmployees);
        if (indexID != -1) {
            do {
                System.out.println("1. Update name: ");
                System.out.println("2. Update phone");
                System.out.println("3. Update birthday");
                System.out.println("4. Update role");
                System.out.println("5. Update contract time");
                System.out.println("6. Exit");
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String name = valid.checkName("Enter name to update (Press Enter to cancel update): ");
                        if (name.isEmpty()) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setName(name);
                        break;
                    case 2:
                        String phone = valid.checkPhone("Enter phone to update (Press Enter to cancel update): ");
                        if (phone.isEmpty()) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setPhone(phone);

                        break;
                    case 3:
                        Date bDate = valid.checkDate("Enter birthday to update (Press Enter to cancel update): ");
                        if (bDate.toString().isEmpty()) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setbDate(bDate);
                        break;
                    case 4:
                        String role = valid.checkRole("Enter role to update (Press Enter to cancel update): ");
                        if (role.isEmpty()) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setRole(role);
                        break;
                    case 5:
                        int salary = valid
                                .checkInt("Enter salary to update (Press Enter to cancel update): ", 100, 8000);
                        if (salary == -1) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setSalary(salary);

                        break;
                    case 6:
                        int contractTime = valid
                                .checkInt("Enter contract time to update (Press Enter to cancel update): ", 1, 30);
                        if (contractTime == -1) {
                            if (valid.askToContinue()) {
                                updateEmployee();
                            } else {
                                System.out.println("Updating employees canceled.");
                                return;
                            }
                        }
                        listEmployees.get(indexID).setContractTime(contractTime);

                        break;
                    default:
                        System.err.println("Please try again! Input from 1 to 6");
                        break;
                }
            } while (choice != 6);
        } else {
            System.out.println("ID not found!");
            sc.close();
            return;
        }
        sc.close();

    }

    @Override
    public void viewAllList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================HOSPITAL LIST========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        for (Employee e : listEmployees) {
            printEmployee(e);
        }
        System.out.println();
    }

    @Override
    public void takeOnList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================WORKING EMPLOYEES========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        for (Employee e : listEmployees) {
            if (e.getResignDate() == null) {
                printEmployee(e);
            }
        }
    }

    @Override
    public void resignList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================RESIGN EMPLOYEES========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        boolean check = false;
        for (Employee e : listEmployees) {
            if (e.getResignDate() != null) {
                printEmployee(e);
                check = true;
            }
        }

        if (!check) {
            System.out.println("No employees resign!");
        }
    }

    @Override
    public void doctorList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the doctor list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================DOCTOR LIST========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");

        boolean check = false;
        for (Employee e : listEmployees) {
            if (e.getRole().equalsIgnoreCase("doctor")) {
                printEmployee(e);
                check = true;
            }
        }

        if (!check) {
            System.out.println("No doctor in the hospital");
        }
    }

    @Override
    public void nurseList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the nurse list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================NURSE LIST========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        boolean check = false;
        for (Employee e : listEmployees) {
            if (e.getRole().equalsIgnoreCase("nurse")) {
                printEmployee(e);
                check = true;
            }
        }

        if (!check) {
            System.out.println("No nurse in the hospital");
        }
    }

    @Override
    public void technicianList() {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't view the technician list because it is empty");
            return;
        }
        System.out.println(
                "=======================================================================TECHNICIAN LIST========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");

        boolean check = false;
        for (Employee e : listEmployees) {
            if (e.getRole().equalsIgnoreCase("technician")) {
                printEmployee(e);
                check = true;
            }
        }

        if (!check) {
            System.out.println("No technician in the hospital");
        }
    }

    @Override
    public void writeToFile() throws FileNotFoundException, IOException {
        if (listEmployees.isEmpty()) {
            System.out.println("Can't write to file because the list is empty");
            return;
        }
        File file = new File("employees.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        StringBuilder data = new StringBuilder();
        
        List<Employee> dataEmployees = valid.loadData(listEmployees);
        dataEmployees.addAll(listEmployees);
        for (Employee e : dataEmployees) {
            data.append(e.toString()).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(data.toString());
        bw.close();

        System.out.println("Successful wrote to file");
    }

    public void printEmployee(Employee p) {
        if (p.getResignDate() == null) {
            System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", p.getID(), p.getName(), p.getPhone(),
                    sdf.format(p.getbDate()), p.getRole(), sdf.format(p.getHireDate()), p.getSalary(),
                    p.getContractTime(), p.getResignDate());
            return;
        }
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", p.getID(), p.getName(), p.getPhone(),
                sdf.format(p.getbDate()), p.getRole(), sdf.format(p.getHireDate()), p.getSalary(), p.getContractTime(),
                sdf.format(p.getResignDate()));
    }

}
