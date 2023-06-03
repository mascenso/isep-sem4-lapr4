# US 3004 - As User, I want to share a board

*This is an example template*

## 1. Context

*Explain the context for this task. It is the first time the task is assigned to be developed or this tasks was incomplete in a previous sprint and is to be completed in this sprint? Are we fixing some bug?*

This US allows the owner of a board to share it with another user(s). Only the owner can share the board.
When a user shares a board he/she must specify the users and, for each user, if the access is read or write.
By default, all the users have read permissions. When an update is done regarding the access to the board, a notification must be sent to the user.


## 2. Requirements

*In this section you should present the functionality that is being developed, how do you understand it, as well as possible correlations to other requirements (i.e., dependencies).*

**US3004** As User, I want to share a board

-US3004.1 - This functional part of the system has very specific technical requirements, particularly some concerns about synchronization problems.
-US3004.2 - The solution design and implementation must be based on threads, condition variables and mutexes. Specific requirements will be provided in SCOMP.

- Dependencies:
    * US3001 - As Project Manager, I want the team to prepare the communication infrastruture for the Shared Boards and the depoyment of the solution.
    * US3003 - As User, I want to create a board.

"Boards are one of the main used tools for teaching."
"The project aims to implement the concept of shared board, as a board that can be used to share and organize ideas and information."

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

- At anytime, the application user (authorized) may want to share a board that he/she owns or update the access permissions given before to a User.
For that matter, a repository for shareBoards needs to be created in other to assure the business domain and an abstraction 
layer between the domain code and the data storage.


**Input Data:**

* Selected data:
    * board,
    * user(s),
    * access type.

**Output Data:**

* a shared board.


**Domain Model Excerpt**

![US3004-DM](US3004-DM.png "US3004 - Domain Model Excerpt")


## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*


### 4.1. Realization


**System Sequence Diagram (SSD)**

![US3004-SSD](US3004-SSD.svg "US3004 - System Sequence Diagram")

**Rationale**

| Interaction ID                            | Question: Which class is responsible for... | Answer                | Justification (with patterns)                                                                                   |
|:------------------------------------------|:--------------------------------------------|:----------------------|:----------------------------------------------------------------------------------------------------------------|
| Step 1 - Asks to share a board            | ... interacting with the actor?             | ShareABoardUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.   |
|                                           | ... coordinating the US?                    | ShareABoardController | Controller.                                                                                                     |
| Step 2 - Shows list of owned boards       | ... having the requested information?       | SharedBoardRepository | Abstracts data access by providing an abstraction layer between the domain code and the data storage mechanism. |
|                                           | ... interacting with the actor?             | ShareABoardUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.   |
|                                           | ... managing the information?               | ListBoardsService     | Encapsulate a specific set of functionalities and allows for more manageable and incremental updates.           |
| Step 4 - Shows list of users              | ... having the requested information?       | UsersRepository       | Abstracts data access by providing an abstraction layer between the domain code and the data storage mechanism. |
|                                           | ... interacting with the actor?             | ShareABoardUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.   |
| Step 6 - Asks for access type             | ... having the requested information?       | SharedBoardUser       | Creator (Rule 1).                                                                                               |
| Step 8 - Creates a notification to users  | ... interacting with the actor?             | NotificationUI        | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model.   |
|                                           | ... creating the notification?              | BoardSharedEvent      | Low coupling.                                                                                                   |


**Sequence Diagram (SD)**


![US3004-SD](US3004-SD.svg "US3004 - Share a Board Sequence Diagram")


*Note* Factories, Persistence Context and other DDD domains weren't represented to lower the SD's complexity.

### 4.2. Class Diagram

![US3004-CD](US3004-CD.svg "US3004 - Class Diagram")

### 4.3. Applied Patterns
    - Controller
    - Persistence Context
    - Repository Factory
    - Repository
    - Service
    - Event
    
### 4.4. Tests

**Test 1:** * Verifies that it is not possible to share a board that the user doesn't own.
**Test 2:** * Verifies that the owner of a board must specify an access type permission when sharing the board.
**Test 3:** * Verifies that the user gets notified when gaining access to a shared board.

```

   
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

N/A

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

N/A

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*

N/A