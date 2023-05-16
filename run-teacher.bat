REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.teacher.console\target\app.teacher.console-1.4.0-SNAPSHOT.jar;app.teacher.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eCourse.app.teacher.console.TeacherApp
