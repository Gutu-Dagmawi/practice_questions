package grades;

// simple tests, no JUnit (didn't want to set up maven for this)
public class GradeTests {
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        // letter grades + boundaries
        check("TC01 grade 95 -> A", GradeCalculator.letterGrade(95).equals("A"));
        check("TC02 grade 90 -> A (boundary)", GradeCalculator.letterGrade(90).equals("A"));
        check("TC03 grade 89.99 -> B", GradeCalculator.letterGrade(89.99).equals("B"));
        check("TC04 grade 75 -> C", GradeCalculator.letterGrade(75).equals("C"));
        check("TC05 grade 60 -> D (boundary)", GradeCalculator.letterGrade(60).equals("D"));
        check("TC06 grade 59.5 -> F", GradeCalculator.letterGrade(59.5).equals("F"));
        check("TC07 grade 0 -> F", GradeCalculator.letterGrade(0).equals("F"));
        check("TC08 grade 100 -> A", GradeCalculator.letterGrade(100).equals("A"));

        // average
        Student s = new Student("UGR/1234/16", "Abebe Kebede", new double[]{80, 90, 70});
        check("TC09 average of 80,90,70 = 80", Math.abs(s.getAverage() - 80) < 0.001);
        check("TC10 letter grade of that student = B", s.getLetterGrade().equals("B"));

        // validation
        check("TC11 mark -1 invalid", !Validator.isValidMark(-1));
        check("TC12 mark 101 invalid", !Validator.isValidMark(101));
        check("TC13 parse 'abc' -> -1", Validator.parseMark("abc") == -1);
        check("TC14 parse ' 77.5 ' -> 77.5", Validator.parseMark(" 77.5 ") == 77.5);
        check("TC15 empty name invalid", !Validator.isValidName("   "));
        check("TC16 name with digits invalid", !Validator.isValidName("Abebe2"));
        check("TC17 parsePositiveInt 0 -> -1", Validator.parsePositiveInt("0", 10) == -1);
        check("TC18 parsePositiveInt 11 with max 10 -> -1", Validator.parsePositiveInt("11", 10) == -1);

        // student constructor rejects bad marks
        boolean threw = false;
        try {
            new Student("1", "Sara", new double[]{50, 120});
        } catch (IllegalArgumentException e) {
            threw = true;
        }
        check("TC19 student with mark 120 throws", threw);

        // manager
        GradeManager gm = new GradeManager(new String[]{"Math", "Physics"});
        gm.addStudent(new Student("1", "Sara", new double[]{100, 80}));
        gm.addStudent(new Student("2", "Dawit", new double[]{50, 60}));
        check("TC20 class average = 72.5", Math.abs(gm.classAverage() - 72.5) < 0.001);
        check("TC21 top student = Sara", gm.topStudent().getName().equals("Sara"));

        threw = false;
        try {
            gm.addStudent(new Student("1", "Copy", new double[]{10, 10}));
        } catch (IllegalArgumentException e) {
            threw = true;
        }
        check("TC22 duplicate id rejected", threw);

        System.out.println();
        System.out.println("Passed: " + passed + "  Failed: " + failed);
    }

    static void check(String name, boolean ok) {
        if (ok) {
            passed++;
            System.out.println("PASS  " + name);
        } else {
            failed++;
            System.out.println("FAIL  " + name);
        }
    }
}
