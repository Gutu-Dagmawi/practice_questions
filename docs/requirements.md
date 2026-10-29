# Requirements - Student Grade Management System

Job #6. From the assignment: "accepts student marks, calculates average marks and
letter grades, validates inputs, and displays results."

Console program (no GUI, no database, data is not saved after the program closes).

## Functional
1. User enters how many subjects there are (1-10) and the name of each subject.
2. User enters how many students there are (1-50).
3. For each student the user enters an ID, a name and one mark per subject.
4. The program calculates the average mark of each student.
5. The program gives each student a letter grade from the average (scale below).
6. The program shows Pass / Fail (F = fail).
7. After all input the program displays a results table: ID, name, marks, average, grade, status.
8. The program also shows number of students, class average and the top student.

## Validation
9. Marks must be numbers between 0 and 100. If not, show a message and ask again.
10. Name can't be empty and can only have letters (plus space . ' -). ID can't be empty
    and only letters/numbers/ / and -. Same ID can't be entered twice.
11. Number of subjects/students must be whole numbers in range, otherwise ask again
    (program should never crash on bad input).

## Grading scale
| Average  | Grade |
|----------|-------|
| 90 - 100 | A     |
| 80 - 89  | B     |
| 70 - 79  | C     |
| 60 - 69  | D     |
| below 60 | F     |

(Used a simple scale, the real uni one has A+, A-, B+ ... could add later.)
