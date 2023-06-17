REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.sharedboard.console\target\app.sharedboard.console-1.4.0-SNAPSHOT.jar;app.sharedboard.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eCourse.app.sharedboard.console.SharedBoardApp
