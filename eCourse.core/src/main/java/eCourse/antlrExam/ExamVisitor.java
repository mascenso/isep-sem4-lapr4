package eCourse.antlrExam;

import java.util.*;
import java.util.stream.Collectors;

public class ExamVisitor extends ExamSpecificationBaseVisitor<Void> {

    // Memory for storing variables, questions, answers, grades, etc.
    Map<String, Map<String,Object>> memory = new LinkedHashMap<>();

    public Map<String, Map<String,Object>> getMemory(){
        return memory;
    }
    @Override
    public Void visitExam(ExamSpecificationParser.ExamContext ctx) {
        // Process the exam specification
        String examTitle = ctx.examTitle.getText().replace("\"", "");
        memory.put("Header",  new HashMap<>());
        memory.get("Header").put("examTitle",examTitle);
        memory.get("Header").put("MaxExamGrade",0);

        visitHeader(ctx.header());

        for (ExamSpecificationParser.SectionContext section : ctx.section()) {
            visitSection(section);
        }
        return null;
    }

    @Override
    public Void visitHeader(ExamSpecificationParser.HeaderContext ctx) {
        // Process the header information

        String feedbackType = ctx.feedbackType().getText().replace("\"", "");
        String gradeType = ctx.gradeType().getText().replace("\"", "");
        memory.get("Header").put("feedbackType", feedbackType);
        memory.get("Header").put("gradeType", gradeType);

        if (ctx.description() != null) {
            String description = ctx.description().STRING().getText().replace("\"", "");
            memory.get("Header").put("description", description);
        }


        return null;
    }

    @Override
    public Void visitSection(ExamSpecificationParser.SectionContext ctx) {
        // Process each section

        String sectionTitle = ctx.sectionTitle.getText().replace("\"", "");
        memory.get("Header").put("sectionTitle", sectionTitle);

        if (ctx.description() != null) {
            String sectionDescription = ctx.description().STRING().getText().replace("\"", "");

            memory.get("Header").put("sectionDescription", sectionDescription);
        }

        for (ExamSpecificationParser.QuestionContext question : ctx.question()) {
            visitQuestion(question);
        }

        return null;
    }


    @Override
    public Void visitMatchingQuestion(ExamSpecificationParser.MatchingQuestionContext ctx) {
        // Process matching question

        String questionText = ctx.questionText().getText().replace("\"", "");
        List<String> listOne = List.of(ctx.getChild(3).getChild(1).getChild(0).toString().replace("\"", "").split(" "));
        List<String> listTwo = List.of(ctx.getChild(4).getChild(1).getChild(0).toString().replace("\"", "").split(" "));
        List <String> correctAnswer = List.of(ctx.getChild(6).getChild(0).toString().replace("\"", "").split(" "));
        List <Float> grade = new ArrayList<>();
        float maxGrade =0;
        for (int i = 0; i < correctAnswer.size(); i++) {
            grade.add(Float.parseFloat(ctx.getChild(i+8).getChild(0).toString()));
            maxGrade += grade.get(i);
        }
        if(memory.containsKey("matchingQuestion-0")){
            boolean exist = true;
            for (int i = 1; exist ; i++) {
                if (!memory.containsKey("matchingQuestion-"+i)){
                    memory.put("matchingQuestion-"+i, new HashMap<>());
                    memory.get("matchingQuestion-"+i).put("Question", questionText);
                    memory.get("matchingQuestion-"+i).put("ListOne",listOne);
                    memory.get("matchingQuestion-"+i).put("ListTwo",listTwo);
                    memory.get("matchingQuestion-"+i).put("CorrectAnswer",correctAnswer);
                    memory.get("matchingQuestion-"+i).put("Grade",grade);
                    memory.get("matchingQuestion-"+i).put("MaxGrade",maxGrade);
                    exist = false;
                }
            }
        }else {
            memory.put("matchingQuestion-0",new HashMap<>());
            memory.get("matchingQuestion-0").put("Question", questionText);
            memory.get("matchingQuestion-0").put("ListOne",listOne);
            memory.get("matchingQuestion-0").put("ListTwo",listTwo);
            memory.get("matchingQuestion-0").put("CorrectAnswer",correctAnswer);
            memory.get("matchingQuestion-0").put("Grade",grade);
            memory.get("matchingQuestion-0").put("MaxGrade",maxGrade);
        }
        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+maxGrade);

        return null;
    }


    @Override
    public Void visitShortAnswerQuestion(ExamSpecificationParser.ShortAnswerQuestionContext ctx) {
        // Process short answer question
        String questionText = ctx.questionText().getText().replace("\"", "");
        List<String> options = new ArrayList<>();
        List<String> answer = List.of(ctx.answer().get(0).children.toString().replace("\"", "").replace("[", "").replace("]", "").split(" "));
        boolean sensitiveCase = Boolean.parseBoolean(ctx.sensitiveCase.getText());
        List<Float> grade = new ArrayList<>();
        boolean exist = true;
        float maxGrade =0;

        //get all grades
        for (ExamSpecificationParser.GradeContext grades : ctx.grade()) {
            grade.add(Float.parseFloat(grades.getText().replace("\"", "")));
            maxGrade += Float.parseFloat(grades.getText().replace("\"", ""));
        }
        //if already exist one this increment
        if(memory.containsKey("ShortAnswerQuestion-0")){
            for (int i = 1; exist ; i++) {
                // Process possible answers
                for (ExamSpecificationParser.PossibleAnswerContext possibleAnswer : ctx.possibleAnswer()) {
                    options.add(possibleAnswer.getText().replace("\"", "").replace("Option",""));
                }
                memory.put("ShortAnswerQuestion-"+i,new HashMap<>());
                memory.get("ShortAnswerQuestion-"+i).put("Question", questionText);
                memory.get("ShortAnswerQuestion-"+i).put("PossibleAnswer", options);
                memory.get("ShortAnswerQuestion-"+i).put("CorrectAnswer", answer);
                memory.get("ShortAnswerQuestion-"+i).put("SensitiveCase",sensitiveCase);
                memory.get("ShortAnswerQuestion-"+i).put("Grade",grade);
                memory.get("ShortAnswerQuestion-"+i).put("MaxGrade",maxGrade);
                exist = false;
            }
        }else{

            for (ExamSpecificationParser.PossibleAnswerContext possibleAnswer : ctx.possibleAnswer()) {
                options.add(possibleAnswer.getText().replace("\"", "").replace("Option",""));
            }
            memory.put("ShortAnswerQuestion-0",new HashMap<>());
            memory.get("ShortAnswerQuestion-0").put("Question", questionText);
            memory.get("ShortAnswerQuestion-0").put("PossibleAnswer", options);
            memory.get("ShortAnswerQuestion-0").put("CorrectAnswer", answer);
            memory.get("ShortAnswerQuestion-0").put("SensitiveCase",sensitiveCase);
            memory.get("ShortAnswerQuestion-0").put("Grade",grade);
            memory.get("ShortAnswerQuestion-0").put("MaxGrade",maxGrade);
        }

        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+maxGrade);

        return null;
    }
    @Override
    public Void visitNumericalQuestion (ExamSpecificationParser.NumericalQuestionContext ctx) {
        String questionText = ctx.questionText().getText().replace("\"", "");
        float answer = Float.parseFloat(ctx.answer().getText());
        float grade = Float.parseFloat(ctx.grade().getText());
        float acceptanceError = Float.parseFloat(ctx.acceptedError().getText().toString().replace("Acceptance Error = ", ""));

        boolean exist = true;
        if(memory.containsKey("NumericalQuestion-0")){
            for (int i = 1; exist ; i++) {

                memory.put("NumericalQuestion-"+i,new HashMap<>());
                memory.get("NumericalQuestion-"+i).put("Question", questionText);
                memory.get("NumericalQuestion-"+i).put("CorrectAnswer", answer);
                memory.get("NumericalQuestion-"+i).put("Grade", grade);
                memory.get("NumericalQuestion-"+i).put("AcceptanceError", acceptanceError);
                memory.get("NumericalQuestion-"+i).put("MaxGrade", grade);
                exist = false;
            }
        }else{
            memory.put("NumericalQuestion-0",new HashMap<>());
            memory.put("NumericalQuestion-0",new HashMap<>());
            memory.get("NumericalQuestion-0").put("Question", questionText);
            memory.get("NumericalQuestion-0").put("CorrectAnswer", answer);
            memory.get("NumericalQuestion-0").put("Grade", grade);
            memory.get("NumericalQuestion-0").put("AcceptanceError", acceptanceError);
            memory.get("NumericalQuestion-0").put("MaxGrade", grade);
        }

        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+grade);
        return null;
    }

    @Override
    public Void visitSelectMissingWordsQuestion (ExamSpecificationParser.SelectMissingWordsQuestionContext ctx){
        String questionText = ctx.questionText().getText().replace("\"", "");
        List <String> options = List.of(ctx.missingWord().get(0).getText().replace("Missing Word: {","").replace("}","").replace("\"", "").split(" "));
        List <String> correctAnswer = List.of(ctx.answer().get(0).getText().replace("\"", "").split(" "));
        List <String> grade = List.of(ctx.grade().get(0).children.toString().replace("[","").replace("]","").replace("\"", "").split(" "));
        List <Float> gradeOnFloat = grade.stream().map(Float::parseFloat).collect(Collectors.toList());
        float maxGrade =gradeOnFloat.stream().reduce(0.0f,Float::sum);
        int numberOfAttemps = Integer.parseInt(ctx.children.get(7).getText());

        boolean exist = true;
        if(memory.containsKey("MissingWordsQuestion-0")){
            for (int i = 1; exist ; i++) {

                memory.put("MissingWordsQuestion-"+i,new HashMap<>());
                memory.get("MissingWordsQuestion-"+i).put("Question", questionText);
                memory.get("MissingWordsQuestion-"+i).put("CorrectAnswer", correctAnswer);
                memory.get("MissingWordsQuestion-"+i).put("options", options);
                memory.get("MissingWordsQuestion-"+i).put("Grade", gradeOnFloat);
                memory.get("MissingWordsQuestion-"+i).put("numberOfAtemps", numberOfAttemps);
                memory.get("MissingWordsQuestion-"+i).put("MaxGrade", maxGrade);
                exist = false;
            }
        }else{
            memory.put("MissingWordsQuestion-0",new HashMap<>());
            memory.get("MissingWordsQuestion-0").put("Question", questionText);
            memory.get("MissingWordsQuestion-0").put("CorrectAnswer", correctAnswer);
            memory.get("MissingWordsQuestion-0").put("options", options);
            memory.get("MissingWordsQuestion-0").put("Grade", gradeOnFloat);
            memory.get("MissingWordsQuestion-0").put("numberOfAtemps", numberOfAttemps);
            memory.get("MissingWordsQuestion-0").put("MaxGrade", maxGrade);
        }

        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+maxGrade);

        return null;
    }

    @Override
    public Void visitMultipleChoiceQuestion (ExamSpecificationParser.MultipleChoiceQuestionContext ctx){

        String questionText = ctx.questionText().getText().replace("\"", "");
        List<String> options = new ArrayList<>();
        List <String> answer = List.of(ctx.answer().get(0).getText().replace("\"", "").split(" "));
        List <String> grade = List.of((ctx.grade().get(0).getText().replace("[","").replace("]","").replace("\"", "").split(" ")));
        List <Float> gradeOnFloat = grade.stream().map(Float::parseFloat).collect(Collectors.toList());
        float maxGrade = gradeOnFloat.stream().reduce(0.0f,Float::sum);

        for (int i = 3;  !ctx.getChild(i).getText().contains("Answer"); i++) {
            options.add(ctx.getChild(i).getChild(1).getText().replace("\"", ""));
        }
        boolean exist = true;
        if(memory.containsKey("MultipleChoiceQuestion-0")){
            for (int i = 1; exist ; i++) {

                memory.put("MultipleChoiceQuestion-"+i,new HashMap<>());
                memory.get("MultipleChoiceQuestion-"+i).put("Question", questionText);
                memory.get("MultipleChoiceQuestion-"+i).put("CorrectAnswer", answer);
                memory.get("MultipleChoiceQuestion-"+i).put("options", options);
                memory.get("MultipleChoiceQuestion-"+i).put("Grade", gradeOnFloat);
                memory.get("MultipleChoiceQuestion-"+i).put("MaxGrade", maxGrade);
                exist = false;
            }
        }else{
            memory.put("MultipleChoiceQuestion-0",new HashMap<>());
            memory.get("MultipleChoiceQuestion-0").put("Question", questionText);
            memory.get("MultipleChoiceQuestion-0").put("CorrectAnswer", answer);
            memory.get("MultipleChoiceQuestion-0").put("options", options);
            memory.get("MultipleChoiceQuestion-0").put("Grade", gradeOnFloat);
            memory.get("MultipleChoiceQuestion-0").put("MaxGrade", maxGrade);
        }

        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+maxGrade);
        return null;
    }

    @Override
    public Void visitTrueFalseQuestion (ExamSpecificationParser.TrueFalseQuestionContext ctx){
        String questionText = ctx.questionText().getText().replace("\"", "");
        boolean answer = Boolean.parseBoolean(ctx.children.get(4).getText());
        float grade = Float.parseFloat(ctx.grade().getText());
        float maxGrade = grade;

        boolean exist = true;
        if(memory.containsKey("TrueOrFalseQuestion-0")){
            for (int i = 1; exist ; i++) {

                memory.put("TrueOrFalseQuestion-"+i,new HashMap<>());
                memory.get("TrueOrFalseQuestion-"+i).put("Question", questionText);
                memory.get("TrueOrFalseQuestion-"+i).put("CorrectAnswer", answer);
                memory.get("TrueOrFalseQuestion-"+i).put("Grade", grade);
                memory.get("TrueOrFalseQuestion-"+i).put("MaxGrade", maxGrade);
                exist = false;
            }
        }else{
            memory.put("TrueOrFalseQuestion-0",new HashMap<>());
            memory.get("TrueOrFalseQuestion-0").put("Question", questionText);
            memory.get("TrueOrFalseQuestion-0").put("CorrectAnswer", answer);
            memory.get("TrueOrFalseQuestion-0").put("Grade",grade);
            memory.get("TrueOrFalseQuestion-0").put("MaxGrade", maxGrade);
        }

        float oldMaxGrade = Float.parseFloat(memory.get("Header").get("MaxExamGrade").toString());
        memory.get("Header").put("MaxExamGrade",oldMaxGrade+maxGrade);

        return null;
    }

}
