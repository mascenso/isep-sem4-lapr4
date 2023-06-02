import java.util.HashMap;
import java.util.Map;

public class ExamVisitor extends ExamSpecificationBaseVisitor<Void> {

    // Memory for storing variables, questions, answers, grades, etc.
    Map<String, Object> memory = new HashMap<>();

    @Override
    public Void visitExam(ExamSpecificationParser.ExamContext ctx) {
        System.out.println("Exam Specification:");
        // Process the exam specification
        System.out.println(ctx.examTitle.getText());
        String examTitle = ctx.examTitle.getText();
        memory.put("examTitle", examTitle);

        visitHeader(ctx.header());

        for (ExamSpecificationParser.SectionContext section : ctx.section()) {
            visitSection(section);
        }

        return null;
    }

    @Override
    public Void visitHeader(ExamSpecificationParser.HeaderContext ctx) {
        // Process the header information
        System.out.println();
        System.out.println("Header:");
        System.out.println(ctx.feedbackType().getText());
        System.out.println(ctx.gradeType().getText());
        String feedbackType = ctx.feedbackType().getText();
        String gradeType = ctx.gradeType().getText();
        memory.put("feedbackType", feedbackType);
        memory.put("gradeType", gradeType);

        if (ctx.description() != null) {
            String description = ctx.description().STRING().getText();
            memory.put("description", description);
        }

        return null;
    }

    @Override
    public Void visitSection(ExamSpecificationParser.SectionContext ctx) {
        // Process each section
        System.out.println();
        System.out.println("Section:");
        System.out.println(ctx.sectionTitle.getText());
        String sectionTitle = ctx.sectionTitle.getText();
        memory.put("sectionTitle", sectionTitle);

        if (ctx.description() != null) {
            String sectionDescription = ctx.description().STRING().getText();
            System.out.println(ctx.description().STRING().getText());
            memory.put("sectionDescription", sectionDescription);
        }

        for (ExamSpecificationParser.QuestionContext question : ctx.question()) {
            visitQuestion(question);
        }

        return null;
    }

/*
    @Override
    public Void visitMatchingQuestion(ExamSpecificationParser.MatchingQuestionContext ctx) {
        // Process matching question
        System.out.println();
        System.out.println("Question:");
        System.out.println(ctx.questionText.getText());
        String questionText = ctx.questionText.getText();
        memory.put("questionText", questionText);

        // Process sub-questions and answers
        for (ExamSpecificationParser.MatchPairContext pair : ctx.matchPair()) {
            System.out.println(pair.answerText.getText());
            String answer = pair.answerText.getText();
            memory.put("answer", answer);

            // Perform additional operations as needed
            // For example, store the sub-question and answer in a data structure
        }

        return null;
    }

    @Override
    public Void visitShortAnswer(ExamSpecificationParser.ShortAnswerQuestionContext ctx) {
        // Process short answer question
        System.out.println();
        System.out.println("Question:");
        System.out.println(ctx.questionText.getText());
        String questionText = ctx.questionText.getText();
        memory.put("questionText", questionText);

        // Process possible answers
        for (ExamSpecificationParser.PossibleAnswerContext possibleAnswer : ctx.possibleAnswer()) {
            System.out.println(possibleAnswer.getText());
            String answer = possibleAnswer.getText();
            memory.put("answer", answer);

            // Perform additional operations as needed
            // For example, store the possible answer in a data structure
        }

        return null;
    }

 */


}
