package eCourse.antlr;

import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExamParser {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("exam.txt"));
        ExamSpecificationLexer lexer = new ExamSpecificationLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamSpecificationParser parser = new ExamSpecificationParser(tokens);
        ParseTree tree = parser.exam(); // parse
        ExamVisitor visitor = new ExamVisitor();
        visitor.visit(tree);
    }
}
