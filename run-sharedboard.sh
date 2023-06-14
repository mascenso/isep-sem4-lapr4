#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eCourse.app.sharedboard.console/target/app.sharedboard.console-0.1.0.jar:eCourse.app.sharedboard.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eCourse.app.sharedboard.console.SharedBoardApp
