package grades;

public class Student {
    private String id;
    private String name;
    private double[] marks;

    public Student(String id, String name, double[] marks) {
        if (!Validator.isValidId(id)) {
            throw new IllegalArgumentException("Invalid student id: " + id);
        }
        if (!Validator.isValidName(name)) {
            throw new IllegalArgumentException("Invalid student name: " + name);
        }
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Student needs at least one mark");
        }
        for (double m : marks) {
            if (!Validator.isValidMark(m)) {
                throw new IllegalArgumentException("Mark out of range: " + m);
            }
        }
        this.id = id.trim();
        this.name = name.trim();
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    public double getAverage() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public String getLetterGrade() {
        return GradeCalculator.letterGrade(getAverage());
    }
}
