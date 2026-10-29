# Design

Job #7. Kept it simple, 5 classes in package `grades`.

```
Main  --uses-->  GradeManager  --has many-->  Student
  |                                            |
  +----uses----> Validator <-------uses--------+
                                               |
                 GradeCalculator <----uses-----+
```

| Class           | What it does |
|-----------------|--------------|
| Main            | console input/output, keeps asking until input is valid |
| Student         | id, name, marks[]; getAverage(), getLetterGrade() |
| GradeCalculator | static letterGrade(average), isPassing(grade) |
| Validator       | static checks: isValidMark, isValidName, isValidId, parseMark, parsePositiveInt |
| GradeManager    | list of students + subject names, classAverage(), topStudent(), printReport() |

Notes / decisions
- Validator returns -1 for bad numbers instead of throwing, easier to loop on in Main.
- Student constructor also validates and throws IllegalArgumentException, so a bad
  Student can't be created even if Main forgets to check.
- Average is not rounded before grading (89.99 is a B), only when printed.
  (added this note after the TC03 bug in testing, job 9)
- Using `sc.nextLine()` for everything and parsing myself, because mixing nextInt()
  and nextLine() caused problems in my last assignment.
- Testing: no JUnit, just a GradeTests class with a main method that prints PASS/FAIL.
