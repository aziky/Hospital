package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import employee.Employee;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String patternId = "EM\\d{4}";
    private static final String patternPhone = "[0-9]{9,11}";
    private static final String patternDate = "dd-MM-yyy";
    private List<Employee> dataFileList = new ArrayList<>();

    public String checkName(String msg) {
        while (true) {
            System.out.print(msg);
            String name = sc.next().trim().toUpperCase();
            if (name.isEmpty()) {
                return "";
            }
            boolean checkName = true;
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isLetter(name.charAt(i))) {
                    checkName = false;
                }
            }
            if (!checkName) {
                System.out.println("Invalid name! Please try again.");
                continue;
            }
            return name;
        }
    }

    public String checkID(String msg, List<Employee> exList) {
        String ID;
        while (true) {
            System.out.print(msg);
            ID = sc.nextLine().trim().toUpperCase();
            if (ID.isEmpty()) {
                return "";
            }
            if (!ID.matches(patternId)) {
                System.err.println("Incorrect format\n");
                continue;
            }
            boolean isUnique = true;
            exList.addAll(dataFileList);
            for (Employee e : exList) {
                if (ID.equalsIgnoreCase(e.getID())) {
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique) {
                System.out.println("ID already exists!\n");
            } else { 
                return ID;
            }
        }
    }

    public int checkUpdateID(String msg, List<Employee> list) {
        while (true) {
            System.out.print(msg);
            String ID = sc.nextLine().trim().toUpperCase();

            if (ID.isEmpty()) {
                System.out.println("Can't not update empty information\n");
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (ID.equals(list.get(i).getID())) {
                    return i;
                }
            }

            return -1;
        }
    }

    public String checkPhone(String msg) {
        while (true) {
            System.out.print(msg);
            String phone = sc.nextLine();

            if (phone.isEmpty()) {
                return "";
            }

            if (!phone.matches(patternPhone)) {
                System.err.println("Invalid phone number! Phone number length has to have 9 to 11 digits\n");
                continue;
            }
            return phone;
        }
    }

    public Date checkDate(String msg) {
        while (true) {
            System.out.print(msg);
            String inputDate = sc.nextLine();

            if (inputDate.isEmpty()) {
                return null;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternDate);
            SimpleDateFormat sdf = new SimpleDateFormat(patternDate);

            try {
                LocalDate birthday = LocalDate.parse(inputDate, formatter);
                LocalDate now = LocalDate.now();
                int age = checkAge(birthday, now);

                if (birthday.isAfter(now)) {
                    System.out.println("Invalid birthday! Your birthday have to before current day.");
                    continue;
                }
                if (age < 18 || age > 60) {
                    System.out.println("You aren't in the range age to work");
                    continue;
                }

                Date bDate = sdf.parse(inputDate);
                return bDate;
            } catch (Exception e) {
                System.err.println("Invalid date! Your birthday must have this format dd-MM-yyyy\n");
            }
        }
    }

    private int checkAge(LocalDate birthday, LocalDate now) {
        int years = now.getYear() - birthday.getYear();
        int currentMonth = now.getMonthValue();
        int birthdayMonth = birthday.getMonthValue();
        int currentDay = now.getDayOfMonth();
        int birthDay = birthday.getDayOfMonth();

        if (currentMonth < birthdayMonth || (currentMonth == birthdayMonth && currentDay < birthDay)) {
            years--;
        }

        return years;
    }

    public String checkRole(String msg) throws FileNotFoundException, IOException {
        File file = new File("roles.txt");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        List<String> listRole = new ArrayList<>();
        String line;
        try {
            while ((line = bf.readLine()) != null) {
                listRole.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }

        bf.close();
        while (true) {
            System.out.print(msg);
            String inputRole = sc.nextLine().toLowerCase().trim();

            if (inputRole.isEmpty()) {
                return "";
            }

            for (String role : listRole) {
                if (inputRole.equalsIgnoreCase(role)) {
                    return Character.toUpperCase(inputRole.charAt(0)) + inputRole.substring(1);
                }
            }
            System.out.println("Don't have that role in file roles.txt");
            System.out.println("Select 1 from these roles " + listRole + "\n");
        }
    }

    public Date checkHiredDate(String msg, Date bDate) {

        while (true) {
            System.out.print(msg);
            String inputDate = sc.nextLine(); // empty return null;

            if (inputDate.isEmpty()) {
                return null;
            }

            SimpleDateFormat sdf = new SimpleDateFormat(patternDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternDate);
            try {
                LocalDate hDate = LocalDate.parse(inputDate, formatter);
                LocalDate now = LocalDate.now();
                if (hDate.isAfter(now)) {
                    System.out.println(
                            "Invalid input! Hired date must be before current day.");
                    continue;
                }
                Date date = sdf.parse(inputDate);
                if (bDate.before(bDate)){
                    System.out.println("Invalid input! Hired date must be after birthday ");
                }
                return date;
            } catch (Exception e) {
                System.err.println("Invalid date! Your birthday must have this format dd-MM-yyyy");
            }
        }
    }

    public int checkInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String inputInt = sc.nextLine().trim();

            if (inputInt.isEmpty()) {
                return -1;
            }

            try {
                int input = Integer.parseInt(inputInt);
                if (input < min || input > max) {
                    System.err.println("Invalid input! Must input from " + min + " to " + max);
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Must input a number!\n");
            }

        }
    }

    public boolean askToContinue() {
        while (true) {
            System.out.print("Do you want to continue adding information? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();
            if (!choice.equals("no") && !choice.equals("yes")) {
                System.err.println("Must input \"yes\" or \"no\"!");
                continue;
            }
            return choice.equals("yes");
        }
    }

    public List<Employee> loadData(List<Employee> list) throws FileNotFoundException, IOException {
        String line;
        File file = new File("employees.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat();
                StringTokenizer stk = new StringTokenizer(line, ",");
                String id = stk.nextToken().trim();
                String name = stk.nextToken().trim();
                String phone = stk.nextToken().trim();
                Date bDate = sdf.parse(stk.nextToken().trim());
                Date hiredDate = sdf.parse(stk.nextToken().trim());
                String role = stk.nextToken().trim();
                int salary = Integer.parseInt(stk.nextToken().trim());
                int contractTime = Integer.parseInt(stk.nextToken().trim());
                Date resignDate;
                if (stk.nextToken() == null) {
                    resignDate = null;
                } else {
                    resignDate = sdf.parse(stk.nextToken().trim());
                }
                Employee employee = new Employee(id, name, phone, bDate, role, hiredDate, salary, contractTime,
                        resignDate);
                dataFileList.add(employee);

            } catch (Exception e) {
                System.out.println("Error load data function in validation file");
            }

        }
        br.close();
        return dataFileList;
    }

}
