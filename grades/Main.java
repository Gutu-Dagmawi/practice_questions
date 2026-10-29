package grades;

import java.util.Scanner;

/*
  Student Grade Management System
  - reads student marks from the console
  - calculates average + letter grade
  - validates every input and asks again if wrong
  - prints a results table
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Student Grade Management System ===");

        int numSubjects = askInt("How many subjects? (1-10): ", 10);
        String[] subjects = new String[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            subjects[i] = askText("Name of subject " + (i + 1) + ": ");
        }

        GradeManager manager = new GradeManager(subjects);

        int numStudents = askInt("How many students? (1-50): ", 50);
        for (int i = 0; i < numStudents; i++) {
            System.out.println();
            System.out.println("--- Student " + (i + 1) + " ---");

            String id = askText("Student ID: ");
            while (!Validator.isValidId(id) || manager.idExists(id)) {
                if (manager.idExists(id)) {
                    System.out.println("That ID was already entered.");
                } else {
                    System.out.println("Invalid ID (letters, numbers, / and - only).");
                }
                id = askText("Student ID: ");
            }

            String name = askText("Student name: ");
            while (!Validator.isValidName(name)) {
                System.out.println("Invalid name, use letters only.");
                name = askText("Student name: ");
            }

            double[] marks = new double[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                marks[j] = askMark("Mark for " + subjects[j] + " (0-100): ");
            }

            manager.addStudent(new Student(id, name, marks));
        }

        manager.printReport();
    }

    static String askText(String prompt) {
        System.out.print(prompt);
        String line = sc.nextLine().trim();
        while (line.isEmpty()) {
            System.out.println("Input can't be empty.");
            System.out.print(prompt);
            line = sc.nextLine().trim();
        }
        return line;
    }

    static int askInt(String prompt, int max) {
        int n = Validator.parsePositiveInt(askText(prompt), max);
        while (n == -1) {
            System.out.println("Please enter a whole number between 1 and " + max + ".");
            n = Validator.parsePositiveInt(askText(prompt), max);
        }
        return n;
    }

    static double askMark(String prompt) {
        double m = Validator.parseMark(askText(prompt));
        while (m == -1) {
            System.out.println("Mark must be a number between 0 and 100.");
            m = Validator.parseMark(askText(prompt));
        }
        return m;
    }
}
