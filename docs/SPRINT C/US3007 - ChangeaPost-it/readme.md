# US 3007 : As User, I want to change a post-it on a board

## 1. Requirements Engineering

### 1.1. User Story Description

As a User, I want to create a post-it-on a board

**From the specifications document:**

The User - manager, student or teacher - should be able to change a Post-it from a Board if he has the write permission
This use case is necessary to manage the ShareBoard, specifically change a post-it on a board.

To change a Post-it, the user can choose within 2 options:
- change its content
- move it to another cell

This actions is only possible if the Post-it is in a Board with NOT_ARCHIVED status, 
and the user as WRITE Access on it.


To change a Post-it, the user should first choose 1 of the cell on which he has write access, 
then choose the Post-it he wants to change.

If no Board or Post-it is available to choose, the system displays an error message.

After showing the Post-its available, the user chooses: change content, or move it to another cell.
Each option has specific requirements:

After the change, it saves the new information on a DataBase and keep a history of the change.

**From the client clarifications:**

> **Question:**
> **Answer:**
>
>
### 1.4. Found out Dependencies

* [US-3002] "Create a Board"
* [US-3005] "Share a Board"
* [US-3006] "Create a Post-it"

* It is also necessary to have:
* Being logged as a user
* Connection to the dataBase
* To have write permission on the cell (the user has to already have write on the cell)
* the board should have the NON_ARCHIVED status
* SharedBoard Protocol should be implemented
* Communication TCP should be implemented, as well as an IP and a port being used


### 1.5 Input and Output Data

**Input Data:**
* Selected data
* A cell on which the user has write permission
* Choose to change content or move the post-it
* Cell on which he wants to move the post-it

**Typed Data:**
* Post-it content (text or image)

## 3. Analysis

* Several clients will try to concurrently change a post-it. Considering that, a solution design and implementation must be based on threads, condition variables and mutexes.
* Authentication of the user is done in the SharedBoardApp
* Communication between client and server is TCP based.
* Both Server and Client will have a keystore.
* It should follow the SBP - SharedBoard Protocol - communication

![arch](arch.png)

SharedBoardApp: UIs and Menu options to Manage the SharedBoards, among other options, the "As User, I want to change a post-it" US.
SharedBoardServer: Connect the SharedBoardApp and DataBase. The module SharedBoardServer control the multiple access to a board and it´s post-its, using the Tcp service-client, threads and mutex.
Relational Database Server: Database

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt

![dm_us3007](dm_us3007.png)


## 3. Design - User Story Realization

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

**SSD**

### Systematization ##


## 3.2. Sequence Diagram (SD)

![sd_us3007](sd_us3007.svg)

## 3.3. Class Diagram (CD)

![cd_us3007](cd_us3007.svg)


## 4. Communication protocol

* Tcp connection must be established
* Uses the client-server model. The client application (Shared Board App) is the one that takes
  the initiative of requesting a TCP connection establishment with the counterpart server
  application, which should accept incoming connection requests.
* Once established, the TCP connection between the client and the server is kept alive and is used
  for all required data exchanges while the client application is running
* Every request (sent by the client or the server) has a mandatory response (correspondingly sent
  by the server or the client).

### Message Format
| Field      | Offset (bytes) | Length (bytes) | Description                                                                                                                                                                                                                                                                                               |
|------------|----------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Version    | 0              | 1              | SBP message format version. This field is a single byte and should be interpreted as an unsigned integer (0 to 255). The present message format version number is one                                                                                                                                     |
| Code       | 1              | 1              | This field identifies the type of request or response, it should be interpreted as an unsigned integer (0 to 255)                                                                                                                                                                                         |
| D_LENGTH_1 | 2              | 1              | These field is used to specify the length in bytes of the DATA field. Both these fields are to be interpreted as unsigned integer numbers (0 to 555). he length of the DATA field is to be calculated as: _LENGTH_1 + 256 x D_LENGTH_2 he length of the DATA field may be zero, meaning it does not exist |
| D_LENGTH_2 | 3              | 1              | Same as D_LENGTH_1                                                                                                                                                                                                                                                                                        |
| Data       | 4              | -              | Contains data to meet the specific needs of the participating applications, the content depends on the message code.                                                                                                                                                                                      |


### Message code
| Code | Meaning  | Description                                                                                                                                                                                                                                                                                            |
|------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0    | COMMTEST | Communications test request with no other effect on the counterpart application than the response with a code two message (ACK). This request has no data                                                                                                                                              |
| 1    | DISCONN  | End of session request. The counterpart application is supposed to respond with a code two message, afterwards both applications are expected to close the session (TCP connection). This request has no data.                                                                                         |
| 2    | ACK      | Generic acknowledgment and success response message. Used in response to successful requests. This response contains no data.                                                                                                                                                                          |
| 3    | ERR      | Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase explaining is carried in the DATA field as string of ASICII codes, it’s not required  to be null terminated. |
| 4    | AUTH     | User authentication request. Described ahead.                                                                                                                                                                                                                                                          |


### 5. Tests

**Test 1:** ensure that a title is changed

**Test 2:** ensure that a description is changed

**Test 4:** ensure that a post-it can change from a cell to another