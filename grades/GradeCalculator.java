package grades;

public class GradeCalculator {

    // grading scale
    // 90-100 A, 80-89 B, 70-79 C, 60-69 D, below 60 F
    public static String letterGrade(double average) {
        if (average < 0 || average > 100) {
            throw new IllegalArgumentException("Average must be between 0 and 100");
        }
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static boolean isPassing(String grade) {
        return !grade.equals("F");
    }
}
