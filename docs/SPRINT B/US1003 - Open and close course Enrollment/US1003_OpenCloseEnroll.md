# US1003 - As a Manager, I want to open and close enrollments in courses

## 1. Requirements Engineering


### 1.1. User Story Description

DGS wants to record daily the total number of people vaccinated in each vaccination center.

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**
* [...] DGS is responsible for the Vaccination Program in Portugal and needs a software application to manage the vaccination process [...]


**From the client clarifications:**

> **Question:** In the acceptance criteria, "the algorithm should run automatically at a time defined in a configuration file and should register a date, the name of the vaccination center and the total number of vaccinated users." How it is supposed to register this information? Should it be recorded in a file (ex: txt,..) or recorded in the system (ex: in a store)?

> **Answer:** The data should be written to a CSV file (field delimiter should be a semicolon.


### 1.3. Acceptance Criteria


* **FRC02:** Open/Close Enrollments in Course Only managers are able to execute this functionality.

### 1.4. Found out Dependencies

* There is a dependency to "US08 - As a Nurse, I want to record the administration of a vaccine to an SNS User." since the list to export is directly dependent of the registration of the administration of the vaccine.
* There is a dependency to "US01 - As an SNS user, I intend to use the application to schedule a vaccine." since the SNSUsers needs to have the vaccine scheduled to get the vaccine.
* There is a dependency to "US02 - As a receptionist at one vaccination center, I want to schedule a vaccination." since the SNSUsers needs to have the vaccine scheduled to get the vaccine.
* There is a dependency to "US04 - As a receptionist at a vaccination center, I want to register the arrival of an SNS user to take the vaccine." since the arrival of the SNSUsers must be registered so the nurse can get a list of SNSUsers present in the Vaccination Center that are ready to take the vaccine.
* There is a dependency to "US05 - As a Nurse, I intend to consult the users in the waiting room of a vaccination center." since the nurse has a list of SNSUsers in the waiting room, sorted by order of arrival, so she/he can call the next SNSUser to take the vaccine.

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





