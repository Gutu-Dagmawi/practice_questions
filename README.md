# Student Grade Management System

Small console program in Java for my PSP (Personal Software Process) exercise, Part 2.
It accepts student marks, calculates averages and letter grades, validates the
input and prints the results.

Before this the repo had my streaming platform OOP practice (see git history),
that one is now Job #4 in the job log.

## Files
- `grades/` - source code
  - `Main.java` - run this
  - `Student.java`, `GradeCalculator.java`, `Validator.java`, `GradeManager.java`
  - `GradeTests.java` - my tests (22 test cases)
- `docs/requirements.md` - requirements (job 6)
- `docs/design.md` - design (job 7)
- `psp/job_number_log.md` - Job Number Log (previous work + this project)
- `psp/daily_time_log.md` - Daily Time Log

## How to run
Needs JDK 17 or newer. From the repo root:

```
javac -d out grades/*.java
java -cp out grades.Main
```

Run the tests:
```
java -cp out grades.GradeTests
```

(or just open the folder in IntelliJ and run Main)

## Example
```
=== Student Grade Management System ===
How many subjects? (1-10): 2
Name of subject 1: Math
Name of subject 2: Physics
How many students? (1-50): 3

--- Student 1 ---
Student ID: UGR/1/16
Student name: Abebe Kebede
Mark for Math (0-100): 80
Mark for Physics (0-100): 90
...
--- Student 2 ---
Student ID: UGR/1/16
That ID was already entered.
Student ID: 2
Student name: Sara
Mark for Math (0-100): abc
Mark must be a number between 0 and 100.
...

================ RESULTS ================
ID           Name                     Math  Physics  Average  Grade Status
UGR/1/16     Abebe Kebede             80.0     90.0    85.00      B Pass
2            Sara                     95.0     88.0    91.50      A Pass
3            Dawit                    40.0     55.0    47.50      F Fail
-----------------------------------------
Number of students: 3
Class average: 74.67
Top student: Sara (91.50)
```

## Grading scale
A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60

## Limitations
- data is lost when the program closes (no file saving)
- every student has to take all the subjects
- simple grading scale only
