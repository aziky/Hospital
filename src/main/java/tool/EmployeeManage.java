package tool;

import employee.Employee;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeManage implements IEmployeeManage {

    private List<Employee> listEmployees = new ArrayList<>();
    Validation valid = new Validation();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");



    public List<Employee> getListEmployees() {
        return listEmployees;
    }

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

        int salary = valid.checkInt("Enter salary (Press enter to return to the menu): ", "salary");
        if (salary == -1) {
            if (valid.askToContinue()) {
                return inputEmployee();
            } else {
                return null;
            }
        }

        int contractTime = valid.checkInt("Enter contract time (Press enter to return to the menu): ", "contract");
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
            System.out.println("Empty List");
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
            System.out.println("Empty List");
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
    public void updateEmployee() {

    }

    @Override
    public void viewAllList() {
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
        System.out.println(
                "=======================================================================RESIGN EMPLOYEES========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        for (Employee e : listEmployees) {
            if (e.getResignDate() != null) {
                printEmployee(e);
            }
        }
    }

    @Override
    public void doctorList() {
        System.out.println(
                "=======================================================================DOCTOR LIST========================================================================");
        System.out.printf("%-15s%-15s%-20s%-20s%-15s%-20s%-15s%-25s%-20s\n", "ID", "NAME", "PHONE", "BIRTHDAY", "ROLE",
                "HIRED DATE", "SALARY", "CONTRACT TIME", "RESIGN DATE");
        for (Employee e : listEmployees) {
            if (e.getRole().equalsIgnoreCase(null)) {
                printEmployee(e);
            }
        }
    }

    @Override
    public void nurseList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void technicianList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void writeToFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
