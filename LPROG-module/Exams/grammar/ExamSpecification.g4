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

matchingQuestion: 'Matching:' questionText=STRING '{'
                    matchPair+
                    correctPair+
                  '}';

matchPair: 'MatchPair' questionText=STRING '=>' answerText=STRING;
correctPair: 'Correct Pair' questionText=STRING '=>' answerText=STRING;

multipleChoiceQuestion: 'MultipleChoice:' questionText=STRING '{'
                          options+
                          answer+
                        '}';

options: 'Option:' answerText=STRING;

answer: 'Answer: ' answerText=STRING;

shortAnswerQuestion: 'ShortAnswer:' questionText=STRING '{'
                       possibleAnswer+
                     '}';

possibleAnswer: 'Possible Answer' (answerText=STRING | answerText=DOUBLE);

numericalQuestion: 'Numerical:' questionText=STRING '{'
                     acceptedError
                     possibleAnswer+
                   '}';

acceptedError: 'Acceptance Error = ' DOUBLE;

selectMissingWordsQuestion: 'Select Missing Words:' questionText=STRING '{'
                              missingWord+
                            '}';

missingWord: 'Missing Word: ' word=STRING;

trueFalseQuestion: 'TrueFalse:' questionText=STRING '{' 'Answer: '('True'|'False') '}';


DOUBLE: [0-9]+ '.' [0-9]+;
INTEGER: [0-9]+;
ESC: '\\' ["\\"];
STRING: '"' (ESC | ~["\r\n"])* '"';


NONE: 'None';
ONSUBMISSION: 'OnSubmission';
AFTERCLOSING: 'AfterClosing';

WS: [ \t\r\n]+ -> skip;
