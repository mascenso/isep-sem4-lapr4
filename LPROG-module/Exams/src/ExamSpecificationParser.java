// Generated from /Users/miguelseixas/Desktop/Calc/Calc/grammar/ExamSpecification.g4 by ANTLR 4.12.0
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
		T__17=18, T__18=19, T__19=20, DOUBLE=21, STRING=22, NONE=23, ONSUBMISSION=24, 
		AFTERCLOSING=25, ID=26, WS=27;
	public static final int
		RULE_exam = 0, RULE_header = 1, RULE_feedbackType = 2, RULE_gradeType = 3, 
		RULE_description = 4, RULE_section = 5, RULE_question = 6, RULE_matchingQuestion = 7, 
		RULE_matchPair = 8, RULE_multipleChoiceQuestion = 9, RULE_answer = 10, 
		RULE_shortAnswerQuestion = 11, RULE_possibleAnswer = 12, RULE_numericalQuestion = 13, 
		RULE_selectMissingWordsQuestion = 14, RULE_missingWord = 15, RULE_trueFalseQuestion = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"exam", "header", "feedbackType", "gradeType", "description", "section", 
			"question", "matchingQuestion", "matchPair", "multipleChoiceQuestion", 
			"answer", "shortAnswerQuestion", "possibleAnswer", "numericalQuestion", 
			"selectMissingWordsQuestion", "missingWord", "trueFalseQuestion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Exam'", "'{'", "'}'", "'Header'", "'FeedbackType'", "':'", "'GradeType'", 
			"'Description'", "'Section'", "'Matching'", "'MatchPair'", "'=>'", "'MultipleChoice'", 
			"'Answer'", "'ShortAnswer'", "'PossibleAnswer'", "'Numerical'", "'SelectMissingWords'", 
			"'MissingWord'", "'TrueFalse'", null, null, "'None'", "'OnSubmission'", 
			"'AfterClosing'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "DOUBLE", "STRING", 
			"NONE", "ONSUBMISSION", "AFTERCLOSING", "ID", "WS"
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
			setState(34);
			match(T__0);
			setState(35);
			((ExamContext)_localctx).examTitle = match(STRING);
			setState(36);
			match(T__1);
			setState(37);
			header();
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				section();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 );
			setState(43);
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
		public FeedbackTypeContext feedbackType() {
			return getRuleContext(FeedbackTypeContext.class,0);
		}
		public GradeTypeContext gradeType() {
			return getRuleContext(GradeTypeContext.class,0);
		}
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
			setState(45);
			match(T__3);
			setState(46);
			match(T__1);
			setState(47);
			feedbackType();
			setState(48);
			gradeType();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(49);
				description();
				}
			}

			setState(52);
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
			setState(54);
			match(T__4);
			setState(55);
			match(T__5);
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
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
			setState(58);
			match(T__6);
			setState(59);
			match(T__5);
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720256L) != 0)) ) {
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
			setState(62);
			match(T__7);
			setState(63);
			match(T__5);
			setState(64);
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
		public Token sectionTitle;
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
			setState(66);
			match(T__8);
			setState(67);
			((SectionContext)_localctx).sectionTitle = match(STRING);
			setState(68);
			match(T__1);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(69);
				description();
				}
			}

			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				question();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1483776L) != 0) );
			setState(77);
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
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				matchingQuestion();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				multipleChoiceQuestion();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				shortAnswerQuestion();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				numericalQuestion();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				selectMissingWordsQuestion();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
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
		public Token questionText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public List<MatchPairContext> matchPair() {
			return getRuleContexts(MatchPairContext.class);
		}
		public MatchPairContext matchPair(int i) {
			return getRuleContext(MatchPairContext.class,i);
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
			setState(87);
			match(T__9);
			setState(88);
			((MatchingQuestionContext)_localctx).questionText = match(STRING);
			setState(89);
			match(T__1);
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				matchPair();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
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
	public static class MatchPairContext extends ParserRuleContext {
		public Token questionText;
		public Token answerText;
		public List<TerminalNode> STRING() { return getTokens(ExamSpecificationParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ExamSpecificationParser.STRING, i);
		}
		public MatchPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).enterMatchPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamSpecificationListener ) ((ExamSpecificationListener)listener).exitMatchPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamSpecificationVisitor ) return ((ExamSpecificationVisitor<? extends T>)visitor).visitMatchPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchPairContext matchPair() throws RecognitionException {
		MatchPairContext _localctx = new MatchPairContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_matchPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__10);
			setState(98);
			((MatchPairContext)_localctx).questionText = match(STRING);
			setState(99);
			match(T__11);
			setState(100);
			((MatchPairContext)_localctx).answerText = match(STRING);
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
		public Token questionText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
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
		enterRule(_localctx, 18, RULE_multipleChoiceQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__12);
			setState(103);
			((MultipleChoiceQuestionContext)_localctx).questionText = match(STRING);
			setState(104);
			match(T__1);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				answer();
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
			setState(110);
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
	public static class AnswerContext extends ParserRuleContext {
		public Token answerText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
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
		enterRule(_localctx, 20, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__13);
			setState(113);
			((AnswerContext)_localctx).answerText = match(STRING);
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
		public Token questionText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public List<PossibleAnswerContext> possibleAnswer() {
			return getRuleContexts(PossibleAnswerContext.class);
		}
		public PossibleAnswerContext possibleAnswer(int i) {
			return getRuleContext(PossibleAnswerContext.class,i);
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
		enterRule(_localctx, 22, RULE_shortAnswerQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__14);
			setState(116);
			((ShortAnswerQuestionContext)_localctx).questionText = match(STRING);
			setState(117);
			match(T__1);
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				possibleAnswer();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__15 );
			setState(123);
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
		public Token answerText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
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
		enterRule(_localctx, 24, RULE_possibleAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__15);
			setState(126);
			((PossibleAnswerContext)_localctx).answerText = match(STRING);
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
		public Token questionText;
		public Token acceptedError;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(ExamSpecificationParser.DOUBLE, 0); }
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
		enterRule(_localctx, 26, RULE_numericalQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__16);
			setState(129);
			((NumericalQuestionContext)_localctx).questionText = match(STRING);
			setState(130);
			match(T__1);
			setState(131);
			((NumericalQuestionContext)_localctx).acceptedError = match(DOUBLE);
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				possibleAnswer();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__15 );
			setState(137);
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
	public static class SelectMissingWordsQuestionContext extends ParserRuleContext {
		public Token questionText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
		public List<MissingWordContext> missingWord() {
			return getRuleContexts(MissingWordContext.class);
		}
		public MissingWordContext missingWord(int i) {
			return getRuleContext(MissingWordContext.class,i);
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
		enterRule(_localctx, 28, RULE_selectMissingWordsQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__17);
			setState(140);
			((SelectMissingWordsQuestionContext)_localctx).questionText = match(STRING);
			setState(141);
			match(T__1);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				missingWord();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__18 );
			setState(147);
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
		public Token word;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
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
		enterRule(_localctx, 30, RULE_missingWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__18);
			setState(150);
			((MissingWordContext)_localctx).word = match(STRING);
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
		public Token questionText;
		public TerminalNode STRING() { return getToken(ExamSpecificationParser.STRING, 0); }
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
		enterRule(_localctx, 32, RULE_trueFalseQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__19);
			setState(153);
			((TrueFalseQuestionContext)_localctx).questionText = match(STRING);
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
		"\u0004\u0001\u001b\u009c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000(\b\u0000\u000b\u0000\f\u0000)\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00013\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001\u0005\u0004\u0005"+
		"J\b\u0005\u000b\u0005\f\u0005K\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\\\b"+
		"\u0007\u000b\u0007\f\u0007]\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tk\b\t\u000b"+
		"\t\f\tl\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0004\u000bx\b\u000b\u000b\u000b\f\u000by\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0004\r\u0086\b\r\u000b\r\f\r\u0087\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0090\b\u000e\u000b\u000e"+
		"\f\u000e\u0091\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0001\u0001\u0000\u0017\u0019\u0098\u0000\"\u0001\u0000"+
		"\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\nB\u0001\u0000"+
		"\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000eW\u0001\u0000\u0000\u0000"+
		"\u0010a\u0001\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014p"+
		"\u0001\u0000\u0000\u0000\u0016s\u0001\u0000\u0000\u0000\u0018}\u0001\u0000"+
		"\u0000\u0000\u001a\u0080\u0001\u0000\u0000\u0000\u001c\u008b\u0001\u0000"+
		"\u0000\u0000\u001e\u0095\u0001\u0000\u0000\u0000 \u0098\u0001\u0000\u0000"+
		"\u0000\"#\u0005\u0001\u0000\u0000#$\u0005\u0016\u0000\u0000$%\u0005\u0002"+
		"\u0000\u0000%\'\u0003\u0002\u0001\u0000&(\u0003\n\u0005\u0000\'&\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"+
		")*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0005\u0003\u0000"+
		"\u0000,\u0001\u0001\u0000\u0000\u0000-.\u0005\u0004\u0000\u0000./\u0005"+
		"\u0002\u0000\u0000/0\u0003\u0004\u0002\u000002\u0003\u0006\u0003\u0000"+
		"13\u0003\b\u0004\u000021\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u00005\u0003\u0001\u0000"+
		"\u0000\u000067\u0005\u0005\u0000\u000078\u0005\u0006\u0000\u000089\u0007"+
		"\u0000\u0000\u00009\u0005\u0001\u0000\u0000\u0000:;\u0005\u0007\u0000"+
		"\u0000;<\u0005\u0006\u0000\u0000<=\u0007\u0000\u0000\u0000=\u0007\u0001"+
		"\u0000\u0000\u0000>?\u0005\b\u0000\u0000?@\u0005\u0006\u0000\u0000@A\u0005"+
		"\u0016\u0000\u0000A\t\u0001\u0000\u0000\u0000BC\u0005\t\u0000\u0000CD"+
		"\u0005\u0016\u0000\u0000DF\u0005\u0002\u0000\u0000EG\u0003\b\u0004\u0000"+
		"FE\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000"+
		"\u0000HJ\u0003\f\u0006\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MN\u0005\u0003\u0000\u0000N\u000b\u0001\u0000\u0000\u0000"+
		"OV\u0003\u000e\u0007\u0000PV\u0003\u0012\t\u0000QV\u0003\u0016\u000b\u0000"+
		"RV\u0003\u001a\r\u0000SV\u0003\u001c\u000e\u0000TV\u0003 \u0010\u0000"+
		"UO\u0001\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000"+
		"\u0000UR\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000"+
		"\u0000\u0000V\r\u0001\u0000\u0000\u0000WX\u0005\n\u0000\u0000XY\u0005"+
		"\u0016\u0000\u0000Y[\u0005\u0002\u0000\u0000Z\\\u0003\u0010\b\u0000[Z"+
		"\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0003"+
		"\u0000\u0000`\u000f\u0001\u0000\u0000\u0000ab\u0005\u000b\u0000\u0000"+
		"bc\u0005\u0016\u0000\u0000cd\u0005\f\u0000\u0000de\u0005\u0016\u0000\u0000"+
		"e\u0011\u0001\u0000\u0000\u0000fg\u0005\r\u0000\u0000gh\u0005\u0016\u0000"+
		"\u0000hj\u0005\u0002\u0000\u0000ik\u0003\u0014\n\u0000ji\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\u0003\u0000\u0000o\u0013"+
		"\u0001\u0000\u0000\u0000pq\u0005\u000e\u0000\u0000qr\u0005\u0016\u0000"+
		"\u0000r\u0015\u0001\u0000\u0000\u0000st\u0005\u000f\u0000\u0000tu\u0005"+
		"\u0016\u0000\u0000uw\u0005\u0002\u0000\u0000vx\u0003\u0018\f\u0000wv\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0005\u0003\u0000"+
		"\u0000|\u0017\u0001\u0000\u0000\u0000}~\u0005\u0010\u0000\u0000~\u007f"+
		"\u0005\u0016\u0000\u0000\u007f\u0019\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\u0011\u0000\u0000\u0081\u0082\u0005\u0016\u0000\u0000\u0082\u0083"+
		"\u0005\u0002\u0000\u0000\u0083\u0085\u0005\u0015\u0000\u0000\u0084\u0086"+
		"\u0003\u0018\f\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u0003\u0000\u0000\u008a\u001b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\u0012\u0000\u0000\u008c\u008d\u0005\u0016\u0000\u0000\u008d\u008f\u0005"+
		"\u0002\u0000\u0000\u008e\u0090\u0003\u001e\u000f\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0003\u0000\u0000\u0094\u001d\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0005\u0013\u0000\u0000\u0096\u0097\u0005"+
		"\u0016\u0000\u0000\u0097\u001f\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		"\u0014\u0000\u0000\u0099\u009a\u0005\u0016\u0000\u0000\u009a!\u0001\u0000"+
		"\u0000\u0000\n)2FKU]ly\u0087\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}