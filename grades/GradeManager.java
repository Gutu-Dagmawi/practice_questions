package grades;

import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Student> students = new ArrayList<>();
    private String[] subjects;

    public GradeManager(String[] subjects) {
        this.subjects = subjects;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void addStudent(Student s) {
        if (s.getMarks().length != subjects.length) {
            throw new IllegalArgumentException("Number of marks doesn't match number of subjects");
        }
        for (Student other : students) {
            if (other.getId().equalsIgnoreCase(s.getId())) {
                throw new IllegalArgumentException("Student id already exists: " + s.getId());
            }
        }
        students.add(s);
    }

    public boolean idExists(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public double classAverage() {
        if (students.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Student s : students) {
            total += s.getAverage();
        }
        return total / students.size();
    }

    public Student topStudent() {
        Student top = null;
        for (Student s : students) {
            if (top == null || s.getAverage() > top.getAverage()) {
                top = s;
            }
        }
        return top;
    }

    public void printReport() {
        System.out.println();
        System.out.println("================ RESULTS ================");
        System.out.printf("%-12s %-20s", "ID", "Name");
        for (String sub : subjects) {
            System.out.printf(" %8s", shorten(sub));
        }
        System.out.printf(" %8s %6s %s%n", "Average", "Grade", "Status");

        for (Student s : students) {
            System.out.printf("%-12s %-20s", s.getId(), shorten20(s.getName()));
            for (double m : s.getMarks()) {
                System.out.printf(" %8.1f", m);
            }
            String grade = s.getLetterGrade();
            String status = GradeCalculator.isPassing(grade) ? "Pass" : "Fail";
            System.out.printf(" %8.2f %6s %s%n", s.getAverage(), grade, status);
        }

        System.out.println("-----------------------------------------");
        System.out.println("Number of students: " + students.size());
        System.out.printf("Class average: %.2f%n", classAverage());
        Student top = topStudent();
        if (top != null) {
            System.out.printf("Top student: %s (%.2f)%n", top.getName(), top.getAverage());
        }
    }

    private String shorten(String s) {
        if (s.length() > 8) {
            return s.substring(0, 8);
        }
        return s;
    }

    private String shorten20(String s) {
        if (s.length() > 20) {
            return s.substring(0, 17) + "...";
        }
        return s;
    }
}
