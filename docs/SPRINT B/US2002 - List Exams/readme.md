# US 2002: As Student, I want to view a list of my future exams

## 1. Context

This task is to develop a new functionality to the system. 
It is not related to a bug fix or an incomplete task from a previous sprint. 
The team has been assigned this task for the first time.
Is an important task to be able to list the exams of the student
## 2. Requirements

**US 2002** As {Ator} I want to list all the exams that are available to me

    FRE02 - List Exams - The system displays to a student his/her future exams

The user needs to be logged in the application. In the menu created for the porpuse of listing exams, the user is able
to view all the exams for the courses they are enrolled.
This US is dependent on:
*US1002 - Create Courses*
*US1003 - Open and close enrollment in courses*
*US1008 - Request Enrollment in courses*
*US1009 - approve and reject student application to courses*
*US2001 - create/update an exam*


## 3. Analysis

*In this section, the team should report the study/analysis/comparison 
that was done in order to take the best design decisions for the requirement. 
This section should also include supporting diagrams/artifacts 
(such as domain model; use case diagrams, etc.),*

To design the new functionality, we conducted an analysis of the requirements, using use case diagrams and sequence diagrams. 
We also identified the necessary classes and their relationships, creating a class diagram to represent the structure of the system.

## 4. Design




| Interaction ID | Question: Which class is responsible for... | Answer              | Justification (with patterns)                                                                                        |
|:---------------|:--------------------------------------------|:--------------------|:---------------------------------------------------------------------------------------------------------------------|
| Step 1         | ... interacting with the actor?             | ListExamsUI         | UI pattern: ListExamsUI is responsible for interacting with the actor by presenting the list of exams.               |
|                | ... coordinating the US?                    | ListExamsController | Controller pattern: ListExamsController is responsible for coordinating the use case and invoking necessary classes. |
| Step 2         | ... Validate User                           | AppSettings         | Settings pattern: AppSettings is responsible for validating if the user is valid based on application settings.      |
| Step 3         | .. return list of courses                   | ExamsRepository     | Repository pattern: ExamsRepository is responsible for retrieving the list of exams from the database.               |
| Step 4         | .. show the course to the user              | ListExamsUI         | UI pattern: ListExamsUI is responsible for presenting the exams to the user.                                         |

### 4.1. Realization

### 4.2. Class Diagram

![a class diagram](US2002-SD.puml "A SD Diagram")

### 4.3. Applied Patterns

### 4.4. Tests

**ShowAllCourses:** *Make sure that all courses are shown when we choose the course list option.*

```
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
	Example instance = new Example(null, null);
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the 
implementation is according to the design. It should also describe and explain other 
important artifacts necessary to fully understand the implementation like, for instance, 
configuration files.*

*It is also a best practice to include a listing (with a brief summary) 
of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to 
integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an 
demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*