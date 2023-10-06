package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import employee.Employee;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    private static final String patternId = "EM\\d{4}";
    private static final String patternPhone = "[0-9]{9,11}";
    private static final String patternDate = "dd-MM-yyy";

    // public static boolean checkContinue = true;

    public boolean checkContinue() {
        while (true) {
            System.out.print("Do you want to continue adding: ");
            String answer = sc.nextLine().toLowerCase();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("no")) {
                return false;
            }
        }
    }

    public String checkName(String msg) {
        while (true) {
            System.out.print(msg);
            String name = sc.nextLine().trim().toUpperCase();
            if (name.isEmpty()) {
                return "";
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
                System.err.println("Incorrect format");
                continue;
            }
            boolean isUnique = true;
            for (Employee e : exList) {
                if (ID.equalsIgnoreCase(e.getID())) {
                    break;
                }
            }
            if (!isUnique) {
                System.out.println("ID already exists!");
            } else {
                break;
            }

        }
        return ID;
    }

    public int checkUpdateID(String msg, List<Employee> list) {
        while (true) {
            System.out.print(msg);
            String ID = sc.nextLine().trim().toUpperCase();
            
            if (ID.isEmpty()){
                System.out.println("Can't not update empty information");
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (ID.equals(list.get(i).getID())){
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
                System.err.println("Invalid! Phone number length has to have 9 to 11 digits");
                continue;
            }
            return phone;
        }
    }

    public Date checkDate(String msg) {
        while (true) {
            System.out.print(msg);
            String inputDate = sc.nextLine(); // empty return null;

            if (inputDate.isEmpty()) {
                return null;
            }

            SimpleDateFormat sdf = new SimpleDateFormat(patternDate);

            try {
                Date date = sdf.parse(inputDate);
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid date! Your date must have this format dd-MM-yyyy");
            }
        }
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
            System.out.println("Select 1 from these roles " + listRole);
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

            try {
                Date date = sdf.parse(inputDate);
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid date!");
            }
        }
    }

    public Date checkResignDate(String msg, Date hiredDate) {
        while (true) {
            System.out.print(msg);
            String inputDate = sc.nextLine(); // empty return null;

            if (inputDate.isEmpty()) {
                return null;
            }

            SimpleDateFormat sdf = new SimpleDateFormat(patternDate);

            try {
                Date date = sdf.parse(inputDate);
                return date;
            } catch (ParseException e) {
                System.err.println("Invalid date!");
            }
        }
    }

    public int checkInt(String msg, String type) {
        while (true) {
            System.out.print(msg);
            String inputInt = sc.nextLine().trim();

            if (inputInt.isEmpty()) {
                return -1;
            }

            try {
                int contractTime = Integer.parseInt(inputInt);
                if (type.equals("contract")) {
                    if (contractTime < 1 || contractTime > 30) {
                        System.err.println("Invalid salary! Your contract time must be from 1 to 30 years");
                        continue;
                    }
                    return contractTime;
                }
                if (type.equals("salary")) {
                    int salary = Integer.parseInt(inputInt);
                    if (salary < 100 || salary > 8000) {
                        System.err.println("Invalid salary! Your salary must be from 100$ to 8000$");
                        continue;
                    }
                    return salary;
                }
            } catch (NumberFormatException e) {
                System.err.println("Must input a number!");
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

    public boolean askResignDate() {
        while (true) {
            System.out.print("Does this employee have a resign date (yes/no)");
            String choice = sc.nextLine().trim().toLowerCase();
            if (!choice.equals("no") && !choice.equals("yes")) {
                System.err.println("Must input \"yes\" or \"no\"!");
                continue;
            }
            return choice.equals("yes");
        }
    }

}
