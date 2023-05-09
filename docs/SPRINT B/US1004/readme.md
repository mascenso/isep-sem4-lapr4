# US 1004 - As Manager, I want to open and close courses

*This is an example template*

## 1. Context

*The context for this task is the development of a new feature requested by the costumer. The purpose of this user story is to allow manager to open and close courses.*

## 2. Requirements

*The requirement is to develop the functionality for open and close courses. This user story is a new feature that has not been implemented before and depends on the implementation of US1002 As Manager, I want to create courses*

**US 1004** As Manager, I want to open and close courses
1. The Manager authenticates in the system.
2. The Manager accesses the functionality for opening and closing courses.
3. The system displays the list of available courses and their status.
4. The manager selects the course opening or closing action.
5. The system updates the course status.
6. The system displays a status update confirmation message.


## 3. Analysis

* User Interface - This class is named OpenOrCloseCoursesUI where it will allow a manager to view available courses and be able to open or close.
* Controller     - This class is named OpenOrCloseController where will be responsible for managing UI requests and performing the necessary actions to open or close courses.
* Repository     - This class is named CoursesRepository where it will store the data about the Courses

*Below is the use case diagram to show the interactions between the manager and the system when open and close courses*

![Use Case Diagram](Use_Case_Diagram.svg)

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

### 4.2. Class Diagram

![class diagram](Class_Diagram.svg "A Class Diagram")

### 4.3 Sequence Diagran
![](Sequence_Diagram.svg)



### 4.4. Applied Patterns

### 4.5. Tests

**Test 1:** *Verifies that it is not possible to create an instance of the Example class with null values.*

```
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
	Example instance = new Example(null, null);
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*