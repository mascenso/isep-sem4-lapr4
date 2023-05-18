REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=eCourse.app.backoffice.console\target\eCourse.app.backoffice.console-0.1.0.jar;eCourse.app.backoffice.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eCourse.app.backoffice.console.ECourseBackoffice
