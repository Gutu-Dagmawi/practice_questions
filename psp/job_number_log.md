# Job Number Log

Name: Dagmawi Gutu

Time in minutes. Rate = minutes per unit.
"To Date" = cumulative for that same process type (Program with Program, Doc with Doc, ...).

Units used:
- Program / Code -> LOC (non blank lines, counted with grep, GradeTests.java not included)
- Doc -> pages
- Req -> number of requirements
- Design -> number of classes
- Test -> number of test cases

| Job | Date | Process | Est. Time | Est. Units | Act. Time | Act. Units | Act. Rate | To Date Time | To Date Units | To Date Rate | To Date Max | To Date Min | Description |
|-----|------|---------|-----------|------------|-----------|------------|-----------|--------------|---------------|--------------|-------------|-------------|-------------|
| 1  | Feb 2025   | Program |     |     | 95  | 60  | 1.58  | 95   | 60  | 1.58  | 1.58  | 1.58  | Calculator lab (Java basics) |
| 2  | Mar 2025   | Program |     |     | 240 | 150 | 1.60  | 335  | 210 | 1.60  | 1.60  | 1.58  | Bank account OOP lab |
| 3  | Apr 2025   | Doc     |     |     | 100 | 4   | 25.00 | 100  | 4   | 25.00 | 25.00 | 25.00 | Lab report for bank account lab |
| 4  | Jul 2025   | Program |     |     | 420 | 288 | 1.46  | 755  | 498 | 1.52  | 1.60  | 1.46  | Streaming platform OOP practice (interfaces, exceptions, file I/O) - was in this repo |
| 5  | Jan 2026   | Program |     |     | 300 | 180 | 1.67  | 1055 | 678 | 1.56  | 1.67  | 1.46  | Linked list / stack assignment (C++) |
| 6  | 26/10/2026 | Req     | 30  | 8   | 45  | 11  | 4.09  | 45   | 11  | 4.09  | 4.09  | 4.09  | Grade system - requirements analysis |
| 7  | 27/10/2026 | Design  | 40  | 4   | 55  | 5   | 11.00 | 55   | 5   | 11.00 | 11.00 | 11.00 | Grade system - design |
| 8  | 27/10/2026 | Program | 390 | 250 | 410 | 278 | 1.47  | 1465 | 956 | 1.53  | 1.67  | 1.46  | Grade system - implementation |
| 9  | 29/10/2026 | Test    | 60  | 15  | 95  | 22  | 4.32  | 95   | 22  | 4.32  | 4.32  | 4.32  | Grade system - testing |
| 10 | 29/10/2026 | Doc     | 50  | 2   | 40  | 2   | 20.00 | 140  | 6   | 23.33 | 25.00 | 20.00 | Grade system - documentation (README) |

Jobs 1-5: no estimates, I wasn't estimating back then so left blank. Actual times are
rough (see daily time log).

## How I got the estimates (jobs 6-10)
- Req, Design, Test: no previous data for these, just guessed.
- Program (job 8): guessed ~250 LOC, used To Date rate 1.56 min/LOC from jobs 1-5
  -> 250 x 1.56 = 390 min.
- Doc (job 10): 2 pages x 25 min/page (To Date rate from job 3) = 50 min.

## Estimated vs actual
| Process | Est. Time | Act. Time | Diff |
|---------|-----------|-----------|------|
| Req     | 30        | 45        | +15  |
| Design  | 40        | 55        | +15  |
| Program | 390       | 410       | +20  |
| Test    | 60        | 95        | +35  |
| Doc     | 50        | 40        | -10  |
| Total   | 570       | 645       | +75  |

## Notes / what I learned
- First time doing this, kept forgetting to start/stop the timer at the beginning.
- The code estimate was the closest one (5% over) because I had data from old
  assignments. The ones I just guessed (req, design, test) were all under.
- Testing took longest compared to estimate, mostly because of the rounding bug.
- Interruptions add up, ~85 min over the 4 days.
- Next time: estimate test cases from number of requirements (~2 per requirement?)
  and use the rates from this project for req/design/test.
