# Project eCourse
<pre>
      ______                         
___  / ____/ ___  __  _______________ 
/ _ \/ /   / __ \/ / / / ___/ ___/ _ \
/  __/ /___/ /_/ / /_/ / /  (__  )  __/
\___/\____/\____/\__,_/_/  /____/\___/ 
</pre>

Engenharia de Aplicações (EAPLI)

Polythecnic of Porto, School of Engineering

---------------------------------------------

This application is part of the lab project for the Integrative Project - LEI - 2022/2023 - 2nd Semester, 2nd Year.

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

make sure Maven is installed and on the PATH

If using an Oracle database, you will need to change your maven settings for
downloading the Oracle drivers. see <https://blogs.oracle.com/dev2dev/entry/how_to_get_oracle_jdbc#settings> for more information.

run script

    rebuild-all.bat


## 4. How to Execute Tests

*To Do*

## 5. How to Run

make sure a JRE is installed and on the PATH

run script

    run-backoffice 

or

    run-user.bat

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

*To Do*

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh

## 8. Project structure

*To Do*

- eapli.base.consoleapp

  - presentation using console
  - Main class
  - application properties in resource folder

- eapli.base.bootstrap
  - bootstrap data. should be ignored on a "real" instalation

- eapli.base.core
  - use case controllers, model, and persistence

## 9. Architecture

The application follows a typical layered approach

    UI -> Controller -+-> Domain
                      |     ^
                      |     |
                      +-> Repositories


## 10. License and copyright

Copyright (c) 2013-2019 the original author or authors.

MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
