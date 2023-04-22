# UC - As user, I want to create a board

## 1. Requirements Engineering

### Brief format
The User starts the application. The system requests the data necessary to access the application. 
The User enters the access data. The system validates the access data entered and displays the application's initial menu. 
The User selects the option to create a board. 


### Complete format

#### Primary actor:
User

#### Stakeholders and Interested Parts:
* **User:** wants to create a board.


#### Pre-conditions:
The User must be authenticated in the system.

#### Post-conditions:
The system creates the shared board with the information provided by the user and makes it available to users who have access to the shared board.

#### Main Success Scenario (or Basic Flow):
1. The User authenticates in the system.
2. The User selects the option to create a new shared board.
3. The system presents a necessary information to create a shared board for the user to fill.
4. The user fills information requested and submit.
5. The system creates the shared board and show the user.

#### Extensions (or Alternative flows):

*1a The User enters the wrong access data in the system.
> The use case ends. The system informs the user that the access data is incorrect.

*3a The system identified that the user did not fill in all the requested data.
> The user must fill in all the requested data, otherwise the use case ends.


#### Special Requirements:
\-

#### Technology and Data Variations List:
\-

#### Frequency of Occurrence:
\-

#### Open issues:

### Domain Model Excerpt <br/>
![Domain Model Excerpt](UC01-domain_model_excerpt.svg)


