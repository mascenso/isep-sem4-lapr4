# US1010 - As Teacher, I want to schedule a class

## 1. Requirements Engineering


### 1.1. User Story Description

A teacher schedule a class (always a recurring class, happens every week). System must check if the Teacher is available for the class period.

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**
* Teachers are responsible for scheduling classes for their courses. 
* A class is always a recurring weekly event.
* A class must have a unique title, a date and a duration. 
* It should be impossible to schedule classes that are coincident with other classes of the same course. 
* The system should also warn if one of the participants in the class (either a teacher or a student) has other classes at the same time. [...]


**From the client clarifications:**

> **Question:** 

> **Answer:** 


### 1.3. Acceptance Criteria


* **FRC02:** Open/Close Enrollments in Course Only managers are able to execute this functionality.

### 1.4. Found out Dependencies

* There is a dependency to "US1001 - As Manager, I want to be able to register, disable/enable, and list users of the system (Teachers and Students, as well as Managers)
* There is a dependency to "US01002 - As Manager, I want to create courses
* There is a dependency to "US1005 - As Manager, I want to set the teachers of a course

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* none
	
* Selected data:
	* none


**Output Data:**

* Data saved in a file.
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Alternative 1**

![US06_SSD](US06-SSD.svg)


**Other alternatives might exist.**

### 1.7 Other Relevant Remarks
*The application should use object serialization to ensure persistence of the data between two runs of the application.*



## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US06_MD](US06_DM.svg)

### 2.2. Other Remarks
*The application should use object serialization to ensure persistence of the data between two runs of the application.*


## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...                | Answer                                        | Justification (with patterns)                                                                                            |
|:---------------|:-----------------------------------------------------------|:----------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------|
| Step 1         | ... Setting up the time, creating and scheduling the task? | Company                                       | IE: Knows the time to set the task running and how to get the wanted information.                                        |
|        	     | ... Executing the task?                                    | DGSDailyRecordTask                            | Creator (Rule 1): The company has a task, all the information to initiate it.                                            |
| Step 2      	 | ... Coordinating this part of the US?                      | ScheduleVaccinationController                 | Controller.                                                                                                              |
|        	     | ... Having the information?                                | VaccineScheduleContainer                      |Pure Fabrication and LC/HC: There is no reason to assign this responsibility to any existing class in the Domain Model.   |
| Step 3	     | ... Coordinating this part of the US?                      | CheckAndExportVaccinationStatisticsController | Controller.                                                                                                              |
|        	     |                                                            | and RegisterSNSUserVaccinationController      | Controller.                                                                                                              |
|                | ... Processing the data?                                   | AdministrationProcessContainer                | Pure Fabrication and LC/HC: There is no reason to assign this responsibility to any existing class in the Domain Model.  |
| Step 4	     | ... Coordinating this part of the US?                      | CheckAndExportVaccinationStatisticsController | Controller.                                                                                                              |
|  		         | ... Saving the data into a file?                           | AdministrationProcessContainer                | IE: Knows how to use the information.                                                                                    |
|   		     | ... Informing the task has ended?    	                  | DGSDailyRecordTask                            | Pure Fabrication: There is no reason to assign this responsibility to any existing class in the Domain Model.            |


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * DGSDailyRecordTask

Other software classes (i.e. Pure Fabrication) identified: 
 
 * RegisterSNSUserVaccinationController 
 * CheckAndExportVaccinationStatisticsController
 * AdministrationProcessContainer
 * VaccineScheduleContainer
 * ScheduleVaccinationController


## 3.2. Sequence Diagram (SD)

**Alternative 1**

![US06_SD](US06-SD.svg)


## 3.3. Class Diagram (CD)

**From alternative 1**

![US06_CD](US06-CD.svg)

# 4. Tests 

**Test 1:** Check if the matrix has the needed information.

	 @Test
    void getSNSUserVaccinatedByDay() throws ParseException {

        AdministrationProcessContainer administrationProcessContainer= new AdministrationProcessContainer();
       

	//STEPS OMITTED ...
	...//

        String[][] result = administrationProcessContainer.getSNSUserVaccinatedByDay(vsList);

        int expectedLength1 = 2;
        int expectedLength2 = 3;
        int resultLength = result.length;

        assertEquals(resultLength, expectedLength1);
        assertNotEquals(resultLength, expectedLength2);
    }

# 5. Construction (Implementation)

## Class Company

	/**
 	** Sets the task at the defined time in the config.properties
	*/
	private void setDGSDailyRecordTask() {

        Calendar today = Calendar.getInstance();
        Properties props = new Properties();

    //STEPS OMITTED ...
	...//

	today.set(Calendar.HOUR_OF_DAY, Integer.parseInt(props.getProperty("Record.Task.Daily.Hour")));
	today.set(Calendar.MINUTE, Integer.parseInt(props.getProperty("Record.Task.Daily.Minute")));
	today.set(Calendar.SECOND, 0);
	today.set(Calendar.MILLISECOND, 0);
	DGSDailyRecordTask task = new DGSDailyRecordTask(today);

## Class DGSDailyRecordTask

	public class DGSDailyRecordTask implements Serializable {
		public DGSDailyRecordTask(Calendar today) {
		timer = new Timer();
		this.timer.schedule(new runTask(), today.getTime(), TimeUnit.HOURS.toMillis(24));
		}
		try {

                System.out.println("Task scheduled initialized!");
		/**
		 Returns a list of vaccine schedules
 		 */
			List<VaccineSchedule> vsList = scheduleVaccination.getListOfVaccineSchedule();

	/**
	* Returns a matrix with information about the vaccinated SNSUsers, the date and the Vaccination Center.
  	*/
			String[][] vaccinatedList = registerSNSUserVaccinationController.getSNSUserVaccinatedByDay(vsList);

	/**
	* Saves into a file the number of today's vaccinated SNSUsers, by Vaccination Center.
	*/			
			checkAndExportVaccinationStatisticsController.saveToFileNumberOfSNSUsersVaccinatedByVCToday(vaccinatedList);
		}
	//STEPS OMITTED ...
	...//
	} finally {
	timer.cancel();
	}
	System.out.println("Task concluded!");
	}

# 6. Integration and Demo 
/-

# 7. Observations
/-





