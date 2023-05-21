grammar QuestionValidator;

prog: stat+;

stat: 'Short: ' shortAnswer NEWLINE answer NEWLINE         # shortAnswerQuestion
    | 'MultiChoice: ' multichoice NEWLINE         # multichoiceQuestion
    | 'Matching: ' matching NEWLINE            # matchingQuestion
    | 'T/F: ' trueFalse NEWLINE           # trueFalseQuestion
    | 'MissingWords: ' selectMissingWords NEWLINE  # selectMissingWordsQuestion
    | 'Numerical: ' numerical NEWLINE           # numericalQuestion
    | NEWLINE                     # blank
;

shortAnswer: QUESTION 'Answer: 'ANSWER GRADE;

multichoice: QUESTION choice+;

matching: QUESTION subQuestion+;

trueFalse: 'Question: 'QUESTION (TRUE|FALSE) GRADE;

selectMissingWords: QUESTION (OPTION_TEXT GROUP)*;

numerical: QUESTION ACCEPTED_ANSWER GRADE;

choice: '[' CHOICE_TEXT']' GRADE;

subQuestion: '[' SUBQUESTION '] ->' ANSWER GRADE;

answer: ANSWER;

NEWLINE: [\r\n]+ ;
WS: [ \t]+ -> skip;

QUESTION: 'Question: '[^\r\n]+;
ANSWER: [^\r\n]+;
GRADE: [0-9]+(.[0-9]+)?;
TRUE: 'True';
FALSE: 'False';
ACCEPTED_ANSWER: [0-9]+(.[0-9]+)?;
CHOICE_TEXT: [^\r\n]+;
SUBQUESTION: [^\r\n]+;
GROUP: [^\r\n]+;
OPTION_TEXT: [^\r\n]+;


