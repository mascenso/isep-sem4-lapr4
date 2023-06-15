# US 2009 As Student, I want to take an Automatic Exam

## 1. Context

This user story came to fill the need to have an Automatic exam validator in the application.
Automatic exam is in everything almost the same as the exam, the difference is that it doesn't have a start and end date.
With this it was also created a way for students to take exams and receive feedback automatically at the end of the exam.

### 2 Customer Specifications and Clarifications

**From the client clarifications:**

> **Question:**
> A propósito das US's 2004 e 2009, de que forma é que os exames serão apresentados ao aluno para o mesmo os realizar? Será semelhante às boards, em que será criada uma página em Java Script?
> **Answer:**
> Documento de especificação, página 11, Figura 4.1. É apresentada uma visão da arquitetura da solução.
> Apenas a aplicação "shared board app" implementa um servidor http para servir o "board viewer". Todas as outras funcionalidades da solução devem estar distribuídas pelas outras "apps", que devem ser java console applications. Ou seja, a "user interface" para a funcionalidade dos exames deve ser implementada como uma console application. A referencia aos "quiz" do moodle é apenas para ilustrar quais as funcionalidades pretendidas. Mas a sua implementação não necessita de ser realizada em HTML (ou seja, não é esperado que o façam).
> Pensava que isso estava claro no documento da especificação.

> **Question**
>Na sua resposta referiu:
> (...) Mas a sua implementação não necessita de ser realizada em HTML (ou seja, não é esperado que o façam).
>Quer isto dizer que, se a equipa de desenvolvimento tal pretender, poderá optar por implementar a componente resolver o exame em HTML (página web)?
>Obiviamente que o aspeto "The feedback and grade of the exam should be automatically calculated by a parser based on the grammar defined for exams structure.", referido na descrição da user story, seria implementado utilizado o "backend" java que tem sido desenvolvido até ao momento; portanto, a minha pergunta refere-se unicamente ao aspeto relacionado com a apresentação/interação com o utilizador.
> **Answer**
> Não é bem isso que o cliente pretende. O que o cliente pretende é que essa funcionalidade seja executada numa aplicação consola (com a particularidade de usarem na solução a linguagem de programação Java e o ANTLR). Se "fugirmos" destes requisitos de implementação podemos estar a levantar problemas aos objetivos de aprendizagem de duas unidades curriculares: EAPLI e LPROG. Assim, a minha resposta à sua pergunta é, em principio, não fazerem em HTML (até porque não sei bem o que seria isso de fazerem em HTML, existem muitas opções, nem sei bem o que é o vosso "backend" actual). No entanto, penso que será algo que podem discutir com os docentes de EAPLI e LPROG.
> A minha resposta negativa é por principio, pois parece-me que isso irá trazer muitas novas questões. Mas esta é, essencialmente, uma questão técnica, pelo que, se quiser prosseguir com essa ideia, sugiro uma consulta dos docentes de EAPLI e LPROG.

> **Question**
> After discussing these questions with the OT teacher, we would like to know your opinion about the grades.
> First we would like to know if you wish that the grades are saved in the program database. Second we would like for you to clarify the expected flow of both feedback and grade types.
> **Answer**
> Regarding the first question, if you do not save the grades how do you implement the functionalities of FRE05 and FRE06?
> Regarding the second question, the ideia is to have something very similar to the Moodle platform. According to the specification "The system must also support the automatic production of feedback and grading for the answers given by students when they take the exam. Usually this is done at the end of the exam." So, the grade and the feedback should be provided only and the end of the exam. At the end of the exam, the system should display to the student the resulting grade of the exam as well as the grade and feedback for each question/answer.
> You may find a simple workflow on how to create moodle tests(quiz) in https://youtu.be/dCDPS7ufGuQ
> Regarding grades, each question will have points when the answer is correct. If you sum all the points form all the answers you will have the grade of the exam.
> Please consider only the question types that are presented in the specification document. For each question type you will find further details on the specifics of the grading logic.

## 2. Requirements

The requirements are.
- The student must be logged into the application
- The student must be associated with one or more courses.
- The teacher must add exams and associate them to the course.
- The exams must be validated and stored in the database.
- The student can't have already taken the exam.
- The student's final grade must be stored in the database.

## 3. Analysis

A Student takes an automatic formative exam and answer its questions. 
Each time the system generates a new exam based on the database of questions and the specification of that exam.   
At the end of the exam, the system should display the feedback and result (i.e., grade) of the exam.
The feedback and grade of the exam should be automatically calculated by a parser based on the grammar defined for exams structure.

Only valid Automatic exams can be stored in the database, so when the student chooses the Automatic exam he wants to take, all of them
are ready to be taken.
When the exam is chosen the file of type Map <String, Map <String,Object>> is taken.
The exam cannot be taken outside the submission period.

The automatic Exam is saved on same repository that Exams normal but is saved without Date.

## 4. Design

## Class diagram
![a class diagram](cd-2004.png "A Class Diagram")
## Use case diagram
![use case diagram](uc-2004.png "A Use Case Diagram")


### 4.2. Sequence diagram

![a sequence diagram](sd-2004.png "A Sequence Diagram")

### 4.4. Tests


## 5. Implementation


## 6. Integration/Demonstration


## 7. Observations

