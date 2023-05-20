REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.student.console\target\app.student.console-1.4.0-SNAPSHOT.jar;app.student.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eCourse.app.student.console.StudentApp
