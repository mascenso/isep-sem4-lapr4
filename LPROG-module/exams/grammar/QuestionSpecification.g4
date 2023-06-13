grammar QuestionSpecification;

question: matchingQuestion
        | multipleChoiceQuestion
        | shortAnswerQuestion
        | numericalQuestion
        | selectMissingWordsQuestion
        | trueFalseQuestion;

matchingQuestion: 'Matching:' questionText '{'
                  listOne+
                  listTwo+
                  'Answer: ' answer+
                  'Grade:' grade+
                  '}';

listOne: 'List One:' questionText+;
listTwo: 'List Two:' questionText+;

questionText: STRING;

multipleChoiceQuestion: 'MultipleChoice:' questionText '{'
                        options+
                        'Answer: ' answer+
                        feedback?
                        'Grade:' grade+
                        '}';

shortAnswerQuestion: 'ShortAnswer:' questionText '{'
                     possibleAnswer+
                     ('Sensitive Case: ' sensitiveCase=('True'|'False'))?
                     'Answer: ' answer+
                     'Grade:' grade+
                     '}';

possibleAnswer: 'Option ' (STRING | NUM);

numericalQuestion: 'Numerical:' questionText '{'
                   acceptedError
                   possibleAnswer+
                   'Answer: ' answer
                   'Grade:' grade
                   '}';

acceptedError: 'Acceptance Error = ' NUM;

selectMissingWordsQuestion: 'Select Missing Words:' questionText '{'
                            missingWord+
                            'Answer: ' answer+
                            feedback?
                            'Number of attempts: ' NUM
                            penalty?
                           'Grade:' grade+
                            '}';

missingWord: 'Missing Word: ' (word | wordGroup)+;

wordGroup: '{' (word)+ '}';
word: STRING;

trueFalseQuestion: 'TrueFalse:' questionText '{'
        'Answer: '('True'|'False')
        feedback?
        'Grade:' grade
       '}';

feedback: 'Feedback:' STRING;
options: 'Option:' STRING;
grade: NUM;
answer: STRING|NUM;
penalty: 'Penalty:' DOUBLE;

NUM: [0-9]+(.[0-9]+)?;
DOUBLE: [0-9]+ (.[0-9]+)?;
ESC: '\\' [\\"];
STRING: '"' (ESC | ~[\r\n])* '"';

NONE: 'None';
ONSUBMISSION: 'OnSubmission';
AFTERCLOSING: 'AfterClosing';


WS: [ \t\r\n]+ -> skip;
