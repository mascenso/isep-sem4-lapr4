#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eCourse.app.other.console/target/app.other.console-1.4.0-SNAPSHOT.jar:eCourse.app.other.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eCourse.app.other.console.OtherApp
