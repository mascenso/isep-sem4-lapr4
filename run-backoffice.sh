#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eapli.base/base.app.backoffice.console/target/base.app.backoffice.console-0.1.0.jar:base.app.backoffice.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eapli.base.app.backoffice.console.BaseBackoffice
