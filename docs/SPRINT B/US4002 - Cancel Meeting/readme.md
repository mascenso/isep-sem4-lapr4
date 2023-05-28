# US4002 As User, I want to cancel a meeting


## 1. Context

*In the application it is necessary to have a way to Cancel meetings after they are scheduled.
This US responds to that need*

## 2. Requirements



## 3. Analysis

## System sequence diagram
![use case diagram](ssd-4002.png "A system sequence Diagram")

**input Data:**
* Typed Data:
  * meeting

**Output Data:**
* Meeting is canceled and save on repository


*Rational*

| Interaction ID | Question: Which class is responsible for... | Answer                                       | Justification (with patterns)                                               |
|:---------------|:--------------------------------------------|:---------------------------------------------|:----------------------------------------------------------------------------|
| Step 1         | ... interacting with the actor?             | CancelMeetingUI                              | UI layer interacts with the user, following the UI pattern.                 |
|                | ... coordinating the US?                    | CancelMeetingController                      | Controller handles the use case, following the Application pattern.         |                                                                                                          |                                                           |
| Step 2         | Saving the Meeting                          | CancelMeetingController / PersistenceContext | Controller collaborates with the PersistenceContext to persist the Meeting. |
| Step 3         | show meeting information for user           | CancelMeetingUI                              | UI layer displays the meeting information to the user.                      |
| Step 4         | .. cancel the meeting                       | CancelMeetingController / meeting            | 
| Step 5         | .. show list of meeting of user             | ListMeetingsService                          |

## 4. Design

## Class diagram
![a class diagram](cd-4002.png "A Class Diagram")
## Use case diagram
![use case diagram](uc-4002.png "A Use Case Diagram")
## Sequence diagram
![use case diagram](sd-4002.png "A sequence Diagram")


### 4.1. Realization

### 4.3. Applied Patterns

*UI Pattern*
*Application patters (controller)*
*Domain Service*
*Persistence patterns*

### 4.4. Tests


## 5. Implementation



## 6. Integration/Demonstration



## 7. Observations

