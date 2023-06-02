// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/PI/sem4pi-22-23-49/exam.domain/src/main/java/eCourse/ExamGrammar/grammar/ExamSpecification.g4 by ANTLR 4.12.0
package eCourse.ExamGrammar.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamSpecificationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, NUM=30, ESC=31, STRING=32, 
		NONE=33, ONSUBMISSION=34, AFTERCLOSING=35, WS=36, DOUBLE=37;
	public static final int
		RULE_exam = 0, RULE_header = 1, RULE_feedbackType = 2, RULE_gradeType = 3, 
		RULE_description = 4, RULE_section = 5, RULE_question = 6, RULE_matchingQuestion = 7, 
		RULE_listOne = 8, RULE_listTwo = 9, RULE_questionText = 10, RULE_multipleChoiceQuestion = 11, 
		RULE_shortAnswerQuestion = 12, RULE_possibleAnswer = 13, RULE_numericalQuestion = 14, 
		RULE_acceptedError = 15, RULE_selectMissingWordsQuestion = 16, RULE_missingWord = 17, 
		RULE_wordGroup = 18, RULE_word = 19, RULE_trueFalseQuestion = 20, RULE_feedback = 21, 
		RULE_options = 22, RULE_grade = 23, RULE_answer = 24, RULE_penalty = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"exam", "header", "feedbackType", "gradeType", "description", "section", 
			"question", "matchingQuestion", "listOne", "listTwo", "questionText", 
			"multipleChoiceQuestion", "shortAnswerQuestion", "possibleAnswer", "numericalQuestion", 
			"acceptedError", "selectMissingWordsQuestion", "missingWord", "wordGroup", 
			"word", "trueFalseQuestion", "feedback", "options", "grade", "answer", 
			"penalty"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Exam'", "'{'", "'}'", "'Header'", "'FeedbackType:'", "'GradeType:'", 
			"'Description:'", "'Section'", "'Questions {'", "'Matching:'", "'Answer: '", 
			"'Grade:'", "'List One:'", "'List Two:'", "'MultipleChoice:'", "'ShortAnswer:'", 
			"'Sensitive Case: '", "'True'", "'False'", "'Option '", "'Numerical:'", 
			"'Acceptance Error = '", "'Select Missing Words:'", "'Number of attempts: '", 
			"'Missing Word: '", "'TrueFalse:'", "'Feedback:'", "'Option:'", "'Peanlty:'", 
			null, null, null, "'None'", "'OnSubmission'", "'AfterClosing'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "NUM", "ESC", "STRING", "NONE", "ONSUBMISSION", 
			"AFTERCLOSING", "WS", "DOUBLE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExamSpecification.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamSpecificationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExamContext extends ParserRuleContext {
		public Token examTitle;
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitExam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitExam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__0);
			setState(53);
			((ExamContext)_localctx).examTitle = match(STRING);
			setState(54);
			match(T__1);
			setState(55);
			header();
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				section();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 );
			setState(61);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public Token headerTitle;
		public FeedbackTypeContext feedbackType() {
			return getRuleContext(FeedbackTypeContext.class,0);
		}
		public GradeTypeContext gradeType() {
			return getRuleContext(GradeTypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__3);
			setState(64);
			((HeaderContext)_localctx).headerTitle = match(STRING);
			setState(65);
			match(T__1);
			setState(66);
			feedbackType();
			setState(67);
			gradeType();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(68);
				description();
				}
			}

			setState(71);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackTypeContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(ExamSpecificationParser.NONE, 0); }
		public TerminalNode ONSUBMISSION() { return getToken(ExamSpecificationParser.ONSUBMISSION, 0); }
		public TerminalNode AFTERCLOSING() { return getToken(ExamSpecificationParser.AFTERCLOSING, 0); }
		public FeedbackTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedbackType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterFeedbackType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitFeedbackType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitFeedbackType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackTypeContext feedbackType() throws RecognitionException {
		FeedbackTypeContext _localctx = new FeedbackTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feedbackType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__4);
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeTypeContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(ExamSpecificationParser.NONE, 0); }
		public TerminalNode ONSUBMISSION() { return getToken(ExamSpecificationParser.ONSUBMISSION, 0); }
		public TerminalNode AFTERCLOSING() { return getToken(ExamSpecificationParser.AFTERCLOSING, 0); }
		public GradeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterGradeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitGradeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitGradeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeTypeContext gradeType() throws RecognitionException {
		GradeTypeContext _localctx = new GradeTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_gradeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__5);
			setState(77);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__6);
			setState(80);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__7);
			setState(83);
			match(STRING);
			setState(84);
			match(T__1);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(85);
				description();
				}
			}

			setState(88);
			match(T__8);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				question();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 77693952L) != 0) );
			setState(94);
			match(T__2);
			setState(95);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public MatchingQuestionContext matchingQuestion() {
			return getRuleContext(MatchingQuestionContext.class,0);
		}
		public MultipleChoiceQuestionContext multipleChoiceQuestion() {
			return getRuleContext(MultipleChoiceQuestionContext.class,0);
		}
		public ShortAnswerQuestionContext shortAnswerQuestion() {
			return getRuleContext(ShortAnswerQuestionContext.class,0);
		}
		public NumericalQuestionContext numericalQuestion() {
			return getRuleContext(NumericalQuestionContext.class,0);
		}
		public SelectMissingWordsQuestionContext selectMissingWordsQuestion() {
			return getRuleContext(SelectMissingWordsQuestionContext.class,0);
		}
		public TrueFalseQuestionContext trueFalseQuestion() {
			return getRuleContext(TrueFalseQuestionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				matchingQuestion();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				multipleChoiceQuestion();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				shortAnswerQuestion();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				numericalQuestion();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				selectMissingWordsQuestion();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				trueFalseQuestion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchingQuestionContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public List<ListOneContext> listOne() {
			return getRuleContexts(ListOneContext.class);
		}
		public ListOneContext listOne(int i) {
			return getRuleContext(ListOneContext.class,i);
		}
		public List<ListTwoContext> listTwo() {
			return getRuleContexts(ListTwoContext.class);
		}
		public ListTwoContext listTwo(int i) {
			return getRuleContext(ListTwoContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<GradeContext> grade() {
			return getRuleContexts(GradeContext.class);
		}
		public GradeContext grade(int i) {
			return getRuleContext(GradeContext.class,i);
		}
		public MatchingQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingQuestionContext matchingQuestion() throws RecognitionException {
		MatchingQuestionContext _localctx = new MatchingQuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_matchingQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__9);
			setState(106);
			questionText();
			setState(107);
			match(T__1);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				listOne();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113);
				listTwo();
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
			setState(118);
			match(T__10);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				answer();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(124);
			match(T__11);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				grade();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(130);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListOneContext extends ParserRuleContext {
		public List<QuestionTextContext> questionText() {
			return getRuleContexts(QuestionTextContext.class);
		}
		public QuestionTextContext questionText(int i) {
			return getRuleContext(QuestionTextContext.class,i);
		}
		public ListOneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterListOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitListOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitListOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListOneContext listOne() throws RecognitionException {
		ListOneContext _localctx = new ListOneContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listOne);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__12);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				questionText();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListTwoContext extends ParserRuleContext {
		public List<QuestionTextContext> questionText() {
			return getRuleContexts(QuestionTextContext.class);
		}
		public QuestionTextContext questionText(int i) {
			return getRuleContext(QuestionTextContext.class,i);
		}
		public ListTwoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listTwo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterListTwo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitListTwo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitListTwo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTwoContext listTwo() throws RecognitionException {
		ListTwoContext _localctx = new ListTwoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listTwo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__13);
			setState(140); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				questionText();
				}
				}
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionTextContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public QuestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterQuestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitQuestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitQuestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTextContext questionText() throws RecognitionException {
		QuestionTextContext _localctx = new QuestionTextContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_questionText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultipleChoiceQuestionContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public List<OptionsContext> options() {
			return getRuleContexts(OptionsContext.class);
		}
		public OptionsContext options(int i) {
			return getRuleContext(OptionsContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<GradeContext> grade() {
			return getRuleContexts(GradeContext.class);
		}
		public GradeContext grade(int i) {
			return getRuleContext(GradeContext.class,i);
		}
		public MultipleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multipleChoiceQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__14);
			setState(147);
			questionText();
			setState(148);
			match(T__1);
			setState(150); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(149);
				options();
				}
				}
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__27 );
			setState(154);
			match(T__10);
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				answer();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(160);
				feedback();
				}
			}

			setState(163);
			match(T__11);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				grade();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(169);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShortAnswerQuestionContext extends ParserRuleContext {
		public Token sensitiveCase;
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public List<PossibleAnswerContext> possibleAnswer() {
			return getRuleContexts(PossibleAnswerContext.class);
		}
		public PossibleAnswerContext possibleAnswer(int i) {
			return getRuleContext(PossibleAnswerContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<GradeContext> grade() {
			return getRuleContexts(GradeContext.class);
		}
		public GradeContext grade(int i) {
			return getRuleContext(GradeContext.class,i);
		}
		public ShortAnswerQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswerQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterShortAnswerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitShortAnswerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitShortAnswerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerQuestionContext shortAnswerQuestion() throws RecognitionException {
		ShortAnswerQuestionContext _localctx = new ShortAnswerQuestionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_shortAnswerQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__15);
			setState(172);
			questionText();
			setState(173);
			match(T__1);
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				possibleAnswer();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(179);
				match(T__16);
				setState(180);
				((ShortAnswerQuestionContext)_localctx).sensitiveCase = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((ShortAnswerQuestionContext)_localctx).sensitiveCase = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(183);
			match(T__10);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				answer();
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(189);
			match(T__11);
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
				grade();
				}
				}
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(195);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PossibleAnswerContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public TerminalNode NUM() { return getToken(ExamSpecificationParser.NUM, 0); }
		public PossibleAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterPossibleAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitPossibleAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitPossibleAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswerContext possibleAnswer() throws RecognitionException {
		PossibleAnswerContext _localctx = new PossibleAnswerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_possibleAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__19);
			setState(198);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericalQuestionContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public AcceptedErrorContext acceptedError() {
			return getRuleContext(AcceptedErrorContext.class,0);
		}
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public GradeContext grade() {
			return getRuleContext(GradeContext.class,0);
		}
		public List<PossibleAnswerContext> possibleAnswer() {
			return getRuleContexts(PossibleAnswerContext.class);
		}
		public PossibleAnswerContext possibleAnswer(int i) {
			return getRuleContext(PossibleAnswerContext.class,i);
		}
		public NumericalQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalQuestionContext numericalQuestion() throws RecognitionException {
		NumericalQuestionContext _localctx = new NumericalQuestionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numericalQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__20);
			setState(201);
			questionText();
			setState(202);
			match(T__1);
			setState(203);
			acceptedError();
			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(204);
				possibleAnswer();
				}
				}
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(209);
			match(T__10);
			setState(210);
			answer();
			setState(211);
			match(T__11);
			setState(212);
			grade();
			setState(213);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AcceptedErrorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(ExamSpecificationParser.NUM, 0); }
		public AcceptedErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceptedError; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterAcceptedError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitAcceptedError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitAcceptedError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcceptedErrorContext acceptedError() throws RecognitionException {
		AcceptedErrorContext _localctx = new AcceptedErrorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_acceptedError);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__21);
			setState(216);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectMissingWordsQuestionContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public TerminalNode NUM() { return getToken(ExamSpecificationParser.NUM, 0); }
		public List<MissingWordContext> missingWord() {
			return getRuleContexts(MissingWordContext.class);
		}
		public MissingWordContext missingWord(int i) {
			return getRuleContext(MissingWordContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public PenaltyContext penalty() {
			return getRuleContext(PenaltyContext.class,0);
		}
		public List<GradeContext> grade() {
			return getRuleContexts(GradeContext.class);
		}
		public GradeContext grade(int i) {
			return getRuleContext(GradeContext.class,i);
		}
		public SelectMissingWordsQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectMissingWordsQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterSelectMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitSelectMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitSelectMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectMissingWordsQuestionContext selectMissingWordsQuestion() throws RecognitionException {
		SelectMissingWordsQuestionContext _localctx = new SelectMissingWordsQuestionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selectMissingWordsQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__22);
			setState(219);
			questionText();
			setState(220);
			match(T__1);
			setState(222); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(221);
				missingWord();
				}
				}
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__24 );
			setState(226);
			match(T__10);
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				answer();
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(232);
				feedback();
				}
			}

			setState(235);
			match(T__23);
			setState(236);
			match(NUM);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(237);
				penalty();
				}
			}

			setState(240);
			match(T__11);
			setState(242); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(241);
				grade();
				}
				}
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(246);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MissingWordContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<WordGroupContext> wordGroup() {
			return getRuleContexts(WordGroupContext.class);
		}
		public WordGroupContext wordGroup(int i) {
			return getRuleContext(WordGroupContext.class,i);
		}
		public MissingWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterMissingWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitMissingWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitMissingWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingWordContext missingWord() throws RecognitionException {
		MissingWordContext _localctx = new MissingWordContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_missingWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__24);
			setState(251); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(251);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(249);
					word();
					}
					break;
				case T__1:
					{
					setState(250);
					wordGroup();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(253); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==STRING );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WordGroupContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public WordGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterWordGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitWordGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitWordGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordGroupContext wordGroup() throws RecognitionException {
		WordGroupContext _localctx = new WordGroupContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_wordGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__1);
			setState(257); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(256);
				word();
				}
				}
				setState(259); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			setState(261);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WordContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_word);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrueFalseQuestionContext extends ParserRuleContext {
		public QuestionTextContext questionText() {
			return getRuleContext(QuestionTextContext.class,0);
		}
		public GradeContext grade() {
			return getRuleContext(GradeContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public TrueFalseQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalseQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseQuestionContext trueFalseQuestion() throws RecognitionException {
		TrueFalseQuestionContext _localctx = new TrueFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_trueFalseQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__25);
			setState(266);
			questionText();
			setState(267);
			match(T__1);
			setState(268);
			match(T__10);
			setState(269);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(270);
				feedback();
				}
			}

			setState(273);
			match(T__11);
			setState(274);
			grade();
			setState(275);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_feedback);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__26);
			setState(278);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__27);
			setState(281);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GradeContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(ExamSpecificationParser.NUM, 0); }
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitGrade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeContext grade() throws RecognitionException {
		GradeContext _localctx = new GradeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public TerminalNode NUM() { return getToken(ExamSpecificationParser.NUM, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PenaltyContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(ExamSpecificationParser.DOUBLE, 0); }
		public PenaltyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_penalty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterPenalty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitPenalty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitPenalty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PenaltyContext penalty() throws RecognitionException {
		PenaltyContext _localctx = new PenaltyContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_penalty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__28);
			setState(288);
			match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u0123\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0004\u0000:\b\u0000\u000b\u0000\f\u0000;\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001F\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005W\b\u0005\u0001\u0005\u0001\u0005\u0004\u0005[\b\u0005\u000b\u0005"+
		"\f\u0005\\\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006h\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007n\b\u0007"+
		"\u000b\u0007\f\u0007o\u0001\u0007\u0004\u0007s\b\u0007\u000b\u0007\f\u0007"+
		"t\u0001\u0007\u0001\u0007\u0004\u0007y\b\u0007\u000b\u0007\f\u0007z\u0001"+
		"\u0007\u0001\u0007\u0004\u0007\u007f\b\u0007\u000b\u0007\f\u0007\u0080"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\b\u0087\b\b\u000b\b\f\b"+
		"\u0088\u0001\t\u0001\t\u0004\t\u008d\b\t\u000b\t\f\t\u008e\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0097\b"+
		"\u000b\u000b\u000b\f\u000b\u0098\u0001\u000b\u0001\u000b\u0004\u000b\u009d"+
		"\b\u000b\u000b\u000b\f\u000b\u009e\u0001\u000b\u0003\u000b\u00a2\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0004\u000b\u00a6\b\u000b\u000b\u000b\f\u000b"+
		"\u00a7\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f"+
		"\u00b0\b\f\u000b\f\f\f\u00b1\u0001\f\u0001\f\u0003\f\u00b6\b\f\u0001\f"+
		"\u0001\f\u0004\f\u00ba\b\f\u000b\f\f\f\u00bb\u0001\f\u0001\f\u0004\f\u00c0"+
		"\b\f\u000b\f\f\f\u00c1\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00ce\b\u000e"+
		"\u000b\u000e\f\u000e\u00cf\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00df\b\u0010\u000b\u0010"+
		"\f\u0010\u00e0\u0001\u0010\u0001\u0010\u0004\u0010\u00e5\b\u0010\u000b"+
		"\u0010\f\u0010\u00e6\u0001\u0010\u0003\u0010\u00ea\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00ef\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0004\u0010\u00f3\b\u0010\u000b\u0010\f\u0010\u00f4\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00fc\b\u0011\u000b"+
		"\u0011\f\u0011\u00fd\u0001\u0012\u0001\u0012\u0004\u0012\u0102\b\u0012"+
		"\u000b\u0012\f\u0012\u0103\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0110\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000"+
		"\u0003\u0001\u0000!#\u0001\u0000\u0012\u0013\u0002\u0000\u001e\u001e "+
		" \u0129\u00004\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000"+
		"\u0004I\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000\u0000\bO\u0001"+
		"\u0000\u0000\u0000\nR\u0001\u0000\u0000\u0000\fg\u0001\u0000\u0000\u0000"+
		"\u000ei\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012"+
		"\u008a\u0001\u0000\u0000\u0000\u0014\u0090\u0001\u0000\u0000\u0000\u0016"+
		"\u0092\u0001\u0000\u0000\u0000\u0018\u00ab\u0001\u0000\u0000\u0000\u001a"+
		"\u00c5\u0001\u0000\u0000\u0000\u001c\u00c8\u0001\u0000\u0000\u0000\u001e"+
		"\u00d7\u0001\u0000\u0000\u0000 \u00da\u0001\u0000\u0000\u0000\"\u00f8"+
		"\u0001\u0000\u0000\u0000$\u00ff\u0001\u0000\u0000\u0000&\u0107\u0001\u0000"+
		"\u0000\u0000(\u0109\u0001\u0000\u0000\u0000*\u0115\u0001\u0000\u0000\u0000"+
		",\u0118\u0001\u0000\u0000\u0000.\u011b\u0001\u0000\u0000\u00000\u011d"+
		"\u0001\u0000\u0000\u00002\u011f\u0001\u0000\u0000\u000045\u0005\u0001"+
		"\u0000\u000056\u0005 \u0000\u000067\u0005\u0002\u0000\u000079\u0003\u0002"+
		"\u0001\u00008:\u0003\n\u0005\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0005\u0003\u0000\u0000>\u0001\u0001\u0000\u0000"+
		"\u0000?@\u0005\u0004\u0000\u0000@A\u0005 \u0000\u0000AB\u0005\u0002\u0000"+
		"\u0000BC\u0003\u0004\u0002\u0000CE\u0003\u0006\u0003\u0000DF\u0003\b\u0004"+
		"\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0003\u0000\u0000H\u0003\u0001\u0000\u0000\u0000"+
		"IJ\u0005\u0005\u0000\u0000JK\u0007\u0000\u0000\u0000K\u0005\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0006\u0000\u0000MN\u0007\u0000\u0000\u0000N\u0007"+
		"\u0001\u0000\u0000\u0000OP\u0005\u0007\u0000\u0000PQ\u0005 \u0000\u0000"+
		"Q\t\u0001\u0000\u0000\u0000RS\u0005\b\u0000\u0000ST\u0005 \u0000\u0000"+
		"TV\u0005\u0002\u0000\u0000UW\u0003\b\u0004\u0000VU\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0005\t\u0000\u0000"+
		"Y[\u0003\f\u0006\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0003\u0000\u0000_`\u0005\u0003\u0000\u0000`\u000b"+
		"\u0001\u0000\u0000\u0000ah\u0003\u000e\u0007\u0000bh\u0003\u0016\u000b"+
		"\u0000ch\u0003\u0018\f\u0000dh\u0003\u001c\u000e\u0000eh\u0003 \u0010"+
		"\u0000fh\u0003(\u0014\u0000ga\u0001\u0000\u0000\u0000gb\u0001\u0000\u0000"+
		"\u0000gc\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000h\r\u0001\u0000\u0000\u0000ij\u0005"+
		"\n\u0000\u0000jk\u0003\u0014\n\u0000km\u0005\u0002\u0000\u0000ln\u0003"+
		"\u0010\b\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qs\u0003\u0012\t\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vx\u0005\u000b\u0000\u0000wy\u00030\u0018\u0000xw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0005\f\u0000\u0000}\u007f\u0003"+
		".\u0017\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0003\u0000\u0000"+
		"\u0083\u000f\u0001\u0000\u0000\u0000\u0084\u0086\u0005\r\u0000\u0000\u0085"+
		"\u0087\u0003\u0014\n\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u0011\u0001\u0000\u0000\u0000\u008a\u008c"+
		"\u0005\u000e\u0000\u0000\u008b\u008d\u0003\u0014\n\u0000\u008c\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0013\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0005 \u0000\u0000\u0091\u0015\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\u000f\u0000\u0000\u0093\u0094\u0003\u0014"+
		"\n\u0000\u0094\u0096\u0005\u0002\u0000\u0000\u0095\u0097\u0003,\u0016"+
		"\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0005\u000b\u0000"+
		"\u0000\u009b\u009d\u00030\u0018\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a2\u0003*\u0015\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a5\u0005\f\u0000\u0000\u00a4\u00a6\u0003.\u0017\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0003\u0000\u0000\u00aa\u0017"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0010\u0000\u0000\u00ac\u00ad"+
		"\u0003\u0014\n\u0000\u00ad\u00af\u0005\u0002\u0000\u0000\u00ae\u00b0\u0003"+
		"\u001a\r\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0011"+
		"\u0000\u0000\u00b4\u00b6\u0007\u0001\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b9\u0005\u000b\u0000\u0000\u00b8\u00ba\u00030\u0018"+
		"\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\f\u0000\u0000"+
		"\u00be\u00c0\u0003.\u0017\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u0003\u0000\u0000\u00c4\u0019\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0014\u0000\u0000\u00c6\u00c7\u0007\u0002\u0000\u0000\u00c7"+
		"\u001b\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0015\u0000\u0000\u00c9"+
		"\u00ca\u0003\u0014\n\u0000\u00ca\u00cb\u0005\u0002\u0000\u0000\u00cb\u00cd"+
		"\u0003\u001e\u000f\u0000\u00cc\u00ce\u0003\u001a\r\u0000\u00cd\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2\u00d3\u0003"+
		"0\u0018\u0000\u00d3\u00d4\u0005\f\u0000\u0000\u00d4\u00d5\u0003.\u0017"+
		"\u0000\u00d5\u00d6\u0005\u0003\u0000\u0000\u00d6\u001d\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0016\u0000\u0000\u00d8\u00d9\u0005\u001e\u0000"+
		"\u0000\u00d9\u001f\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0017\u0000"+
		"\u0000\u00db\u00dc\u0003\u0014\n\u0000\u00dc\u00de\u0005\u0002\u0000\u0000"+
		"\u00dd\u00df\u0003\"\u0011\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e4\u0005\u000b\u0000\u0000\u00e3\u00e5\u00030\u0018\u0000\u00e4\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e8\u00ea\u0003*\u0015\u0000\u00e9\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005\u0018\u0000\u0000\u00ec\u00ee\u0005"+
		"\u001e\u0000\u0000\u00ed\u00ef\u00032\u0019\u0000\u00ee\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f2\u0005\f\u0000\u0000\u00f1\u00f3\u0003.\u0017"+
		"\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u0003\u0000"+
		"\u0000\u00f7!\u0001\u0000\u0000\u0000\u00f8\u00fb\u0005\u0019\u0000\u0000"+
		"\u00f9\u00fc\u0003&\u0013\u0000\u00fa\u00fc\u0003$\u0012\u0000\u00fb\u00f9"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe#\u0001\u0000\u0000\u0000\u00ff\u0101\u0005"+
		"\u0002\u0000\u0000\u0100\u0102\u0003&\u0013\u0000\u0101\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0005\u0003\u0000\u0000\u0106%\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005 \u0000\u0000\u0108\'\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0005\u001a\u0000\u0000\u010a\u010b\u0003\u0014\n\u0000\u010b"+
		"\u010c\u0005\u0002\u0000\u0000\u010c\u010d\u0005\u000b\u0000\u0000\u010d"+
		"\u010f\u0007\u0001\u0000\u0000\u010e\u0110\u0003*\u0015\u0000\u010f\u010e"+
		"\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0005\f\u0000\u0000\u0112\u0113\u0003"+
		".\u0017\u0000\u0113\u0114\u0005\u0003\u0000\u0000\u0114)\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0005\u001b\u0000\u0000\u0116\u0117\u0005 \u0000\u0000"+
		"\u0117+\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u001c\u0000\u0000\u0119"+
		"\u011a\u0005 \u0000\u0000\u011a-\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"\u001e\u0000\u0000\u011c/\u0001\u0000\u0000\u0000\u011d\u011e\u0007\u0002"+
		"\u0000\u0000\u011e1\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u001d\u0000"+
		"\u0000\u0120\u0121\u0005%\u0000\u0000\u01213\u0001\u0000\u0000\u0000\u001d"+
		";EV\\gotz\u0080\u0088\u008e\u0098\u009e\u00a1\u00a7\u00b1\u00b5\u00bb"+
		"\u00c1\u00cf\u00e0\u00e6\u00e9\u00ee\u00f4\u00fb\u00fd\u0103\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}