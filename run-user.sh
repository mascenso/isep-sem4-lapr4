#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eCourse.app.user.console/target/app.user.console-0.1.0.jar:eCourse.app.user.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eCourse.app.user.console.BaseUserApp
