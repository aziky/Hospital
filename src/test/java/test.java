
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Scanner;
// import java.util.TreeSet;
// // import java.util.zip.DataFormatException;

// public class test {

//     public static void main(String[] args) throws ParseException {
//         Scanner sc = new Scanner(System.in);

//         // test patternPhone
//         // String input;
//         // String pattern = "[0-9]{9,11}";
//         // while (true) {
//         // input = sc.nextLine();
//         // if (input.matches(pattern)) {
//         // System.out.println("true");
//         // } else {
//         // System.out.println("false");
//         // }

//         // }

//         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
//         String input ="";
//         while (!input.equalsIgnoreCase("n")) {
//             try {
//                 input = sc.nextLine();
//                 Date date = sdf.parse(input);
//                 System.out.println("output: " + sdf.format(date));
//             } catch (ParseException e) {
//                 System.err.println("error");
//             }

//         }
//     }
// }

// //check date
// // import java.text.ParseException;
// // import java.text.SimpleDateFormat;
// // import java.util.Date;
// // import java.util.Scanner;

// // public class test {
// //     public static void main(String[] args) {
// //         Scanner scanner = new Scanner(System.in);
// //         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
// //         Date currentDate = new Date(); // Initialize with the current date

// //         System.out.println("Current Date: " + dateFormat.format(currentDate));
// //         System.out.print("Enter a new date (dd-MM-yyyy) or leave it blank to keep the old information: ");
// //         String userInput = scanner.nextLine().trim();

// //         if (!userInput.isEmpty()) {
// //             try {
// //                 Date newDate = dateFormat.parse(userInput);
// //                 currentDate = newDate; // Update the date with the user's input
// //             } catch (ParseException e) {
// //                 System.out.println("Invalid date format. Keeping the old date.");
// //             }
// //         }

// //         System.out.println("Updated Date: " + dateFormat.format(currentDate));
// //     }
// // }

// // import java.text.ParseException;
// // import java.util.InputMismatchException;
// // import java.util.Scanner;

// // public class test {
// //     public static void main(String[] args) {
// //         Scanner sc = new Scanner(System.in);

// //         while (true) {
// //             try {
// //                 String input = sc.nextLine().trim();
// //                 int number = Integer.parseInt(input);
// //                 if (number < 100 || number > 8000) {
// //                     System.err.println("Invalid salary! Your salary must be from 100$ to 8000$");
// //                 } else {
// //                     System.out.println("output: " + number);

// //                 }
// //             } catch (NumberFormatException e) {
// //                 System.err.println("error");
// //             }
// //         }
// //     }
// // }

import java.util.Date;
public class test{
    public static void main(String[] args) {
        
    }
}