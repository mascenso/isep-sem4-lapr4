grammar ExamSpecification;

exam: 'Exam' examTitle=STRING '{'
        header
        section+
      '}';

header: 'Header' '{'
          feedbackType
          gradeType
          description?
        '}';

feedbackType: 'FeedbackType' ':' (NONE | ONSUBMISSION | AFTERCLOSING);
gradeType: 'GradeType' ':' (NONE | ONSUBMISSION | AFTERCLOSING);
description: 'Description' ':' STRING;

section: 'Section' sectionTitle=STRING '{'
           description?
           question+
         '}';

question: matchingQuestion | multipleChoiceQuestion | shortAnswerQuestion | numericalQuestion | selectMissingWordsQuestion | trueFalseQuestion;

matchingQuestion: 'Matching' questionText=STRING '{'
                    matchPair+
                  '}';

matchPair: 'MatchPair' questionText=STRING '=>' answerText=STRING;

multipleChoiceQuestion: 'MultipleChoice' questionText=STRING '{'
                          answer+
                        '}';

answer: 'Answer' answerText=STRING;

shortAnswerQuestion: 'ShortAnswer' questionText=STRING '{'
                       possibleAnswer+
                     '}';

possibleAnswer: 'PossibleAnswer' answerText=STRING;

numericalQuestion: 'Numerical' questionText=STRING '{'
                     acceptedError=DOUBLE
                     possibleAnswer+
                   '}';

selectMissingWordsQuestion: 'SelectMissingWords' questionText=STRING '{'
                              missingWord+
                            '}';

missingWord: 'MissingWord' word=STRING;

trueFalseQuestion: 'TrueFalse' questionText=STRING;

DOUBLE: '-'? DIGIT+ ('.' DIGIT+)?;

STRING: '"' (ESC | ~["\r\n"])* '"';
fragment ESC: '\\' ["\\"];

NONE: 'None';
ONSUBMISSION: 'OnSubmission';
AFTERCLOSING: 'AfterClosing';

ID: [a-zA-Z]+;

fragment DIGIT: [0-9];

WS: [ \t\r\n]+ -> skip;
