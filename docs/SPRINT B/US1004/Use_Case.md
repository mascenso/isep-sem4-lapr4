# UC - As Manager, I want to open and close courses

## 1. Requirements Engineering

### Brief format
The Manager starts the application. The system requests the data necessary to access the application.
The Manager enters the access data. The system validates the access data entered and displays the application's initial menu.
The Manager selects the option Courses and choose if you want open or close the course.


### Complete format

#### Primary actor:
Manager

#### Stakeholders and Interested Parts:
* **Manager:** wants to open and close courses.


#### Pre-conditions:
The Manager must be authenticated in the system.

The manager must have access to the functionality to open and close courses.

There are courses available to open or close.

#### Post-conditions:
The course state is updated to open or closed.

#### Main Success Scenario (or Basic Flow):
1. The Manager authenticates in the system.
2. The Manager accesses the functionality for opening and closing courses.
3. The system displays the list of available courses and their status.
4. The manager selects the course opening or closing action.
5. The system updates the course status.
6. The system displays a status update confirmation message.

#### Extensions (or Alternative flows):

*1a The User enters the wrong access data in the system.
> The use case ends. The system informs the user that the access data is incorrect.

*2a The system identified that the user haven't access the functionality for opening and closing courses.
> The use case ends. The system informs the user that he does not have access to the functionality.

*3a The system identified that does not exist available courses.
> The use case ends. The system informs the user that does not exist available courses.

#### Special Requirements:
\-

#### Technology and Data Variations List:
\-

#### Frequency of Occurrence:
\-

#### Open issues:

### Domain Model Excerpt <br/>
![Domain Model Excerpt](UC01-domain_model_excerpt.svg)


