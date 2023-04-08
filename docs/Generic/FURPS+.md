# Supplementary Specification (FURPS+)

## Functionality

#### Communication
- The System must support services that allow the sending and receiving of notifications/messages.

#### Security
- The System must support and apply authentication and authorization for all its users and functionalities.
- All users must be authenticated in the system.
- The System will have restricted access to some functionalities and data, depending on the type of user authenticated.
- The System must ensure the privacy and security of user data.
- The System should allow users to take exams online on a secure and monitored platform.

#### System Management
- The System will have control version.
- All software must be properly documented.
- The System can be created in bootstrap to ensure that it will work on any operating system or mobile with a browser.

#### Auditing & Reporting
- The data from the system's performance must be recorded for auditing.

#### Helpdesk
- The System must have a helpdesk used to report application errors.


## Usability

#### Accessibility
- The system must have mechanisms that allow individuals with disabilities to use it.

#### Design
- The System must have a well-organized and an intuitive user interface.
- The text should be easily visible from 1 meter from the large-monitor display, and half a meter from a mobile display (smartphones, tablets).
- Colors associated with common forms of blindness should not be used.

#### Error Prevention
- The System must validate all necessary information, avoiding distraction or mistyping errors.

#### Interface
- The interface must be consistent and ready for mobile and web use.

#### User Manual
- The application must include a system manual and a FAQ section, and the possibility of an online help system using chat rooms or emails.


## Reliability

#### Recoverability
- There must be redundancies in the system databases to prevent its complete failure and to promote a fast recoverability.

#### Possibility of prediction
- The system must record its failures in order to calculate the MTTF ("Mean-Time To Failure") and simulate the next failure.

#### Accuracy
- The System must be accurate with the user's permissions and functionalities.

#### Frequency and severity of failure
- The System will be running 24/7, so it will be stored in a cloud system, such as Cloudfare, to ensure the possibility of data query anywhere and avoid failure.
- The System must be available with minimal downtime and scheduled maintenance options.
- The System must have a reliable backup and recovery system to ensure data integrity in case of hardware or software failures.


## Performance

- The System must have good response speed, with minimal loading and processing times, even for large amounts of data and simultaneous access.
- The System must be able to adapt to different traffic volumes and user growth, without compromising quality and response speed.

#### CPU Usage
- The System must be lightweight and avoid heavy CPU usage.


## Supportability

- The System will support multiple languages and time-zones through an API.
- The System will be used in the browser, and must be compatible with different operating systems.
- The System must have efficient and responsive user support, with contact options by e-mail or chat.
- The System must have detailed, up-to-date documentation, including user and developer manuals, technical and business specifications, and troubleshooting guides.

#### Testability
- The System's software requirements should be converted to test cases before the software is fully developed, using a Test-Driven Development approach.

#### Adaptability
- The System must be prepared to adapt to new exams types and learning systems.

#### Scalability
- To promote scalabity, the System's database should be cloud based.


## +

### Design Constraints
- The software development will be based on a set of principles, concepts, and practices for domain-oriented software development (Domain-Driven Design).
- The System will be analyzed, designed and implemented with the use of coding standards, such as GRASP or SOLID.
- The software development process will be iterative and incremental.

### Implementation Constraints
- All the software will be implemented using Java as programming language, using the best pratices of coding like camelCase for the naming of variables.
- The user interface should be implemented using VUE, CSS and HTML.

### Interface Constraints
- The System must be implemented in order to be available to every operational system (Browser/Virtual Machine).

### Physical Constraints
- The System will only work on machines that fulfill the minimum requirements (4g network, minimum 2g RAM, 2.4 GHz processor).