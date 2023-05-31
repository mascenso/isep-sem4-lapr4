// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/PI/sem4pi-22-23-49/LPROG-module/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuestionValidatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, NUM=23, ESC=24, STRING=25, 
		NONE=26, ONSUBMISSION=27, AFTERCLOSING=28, WS=29, DOUBLE=30;
	public static final int
		RULE_question = 0, RULE_matchingQuestion = 1, RULE_listOne = 2, RULE_listTwo = 3, 
		RULE_questionText = 4, RULE_multipleChoiceQuestion = 5, RULE_shortAnswerQuestion = 6, 
		RULE_possibleAnswer = 7, RULE_numericalQuestion = 8, RULE_acceptedError = 9, 
		RULE_selectMissingWordsQuestion = 10, RULE_missingWord = 11, RULE_wordGroup = 12, 
		RULE_word = 13, RULE_trueFalseQuestion = 14, RULE_feedback = 15, RULE_options = 16, 
		RULE_grade = 17, RULE_answer = 18, RULE_penalty = 19;
	private static String[] makeRuleNames() {
		return new String[] {
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
			null, "'Matching:'", "'{'", "'Answer: '", "'Grade:'", "'}'", "'List One:'", 
			"'List Two:'", "'MultipleChoice:'", "'ShortAnswer:'", "'Sensitive Case: '", 
			"'True'", "'False'", "'Option '", "'Numerical:'", "'Acceptance Error = '", 
			"'Select Missing Words:'", "'Number of attempts: '", "'Missing Word: '", 
			"'TrueFalse:'", "'Feedback:'", "'Option:'", "'Peanlty:'", null, null, 
			null, "'None'", "'OnSubmission'", "'AfterClosing'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "NUM", 
			"ESC", "STRING", "NONE", "ONSUBMISSION", "AFTERCLOSING", "WS", "DOUBLE"
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
	public String getGrammarFileName() { return "QuestionValidator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionValidatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_question);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				matchingQuestion();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				multipleChoiceQuestion();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				shortAnswerQuestion();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				numericalQuestion();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				selectMissingWordsQuestion();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingQuestionContext matchingQuestion() throws RecognitionException {
		MatchingQuestionContext _localctx = new MatchingQuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_matchingQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			questionText();
			setState(50);
			match(T__1);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				listOne();
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				listTwo();
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(61);
			match(T__2);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				answer();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(67);
			match(T__3);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				grade();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(73);
			match(T__4);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterListOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitListOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitListOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListOneContext listOne() throws RecognitionException {
		ListOneContext _localctx = new ListOneContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listOne);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__5);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				questionText();
				}
				}
				setState(79); 
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterListTwo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitListTwo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitListTwo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTwoContext listTwo() throws RecognitionException {
		ListTwoContext _localctx = new ListTwoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listTwo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__6);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				questionText();
				}
				}
				setState(85); 
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public QuestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterQuestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitQuestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitQuestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTextContext questionText() throws RecognitionException {
		QuestionTextContext _localctx = new QuestionTextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multipleChoiceQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__7);
			setState(90);
			questionText();
			setState(91);
			match(T__1);
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				options();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__20 );
			setState(97);
			match(T__2);
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				answer();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(103);
				feedback();
				}
			}

			setState(106);
			match(T__3);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				grade();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(112);
			match(T__4);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterShortAnswerQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitShortAnswerQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitShortAnswerQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerQuestionContext shortAnswerQuestion() throws RecognitionException {
		ShortAnswerQuestionContext _localctx = new ShortAnswerQuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shortAnswerQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__8);
			setState(115);
			questionText();
			setState(116);
			match(T__1);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				possibleAnswer();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(122);
				match(T__9);
				setState(123);
				((ShortAnswerQuestionContext)_localctx).sensitiveCase = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((ShortAnswerQuestionContext)_localctx).sensitiveCase = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(126);
			match(T__2);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				answer();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(132);
			match(T__3);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				grade();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(138);
			match(T__4);
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public TerminalNode NUM() { return getToken(QuestionValidatorParser.NUM, 0); }
		public PossibleAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterPossibleAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitPossibleAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitPossibleAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswerContext possibleAnswer() throws RecognitionException {
		PossibleAnswerContext _localctx = new PossibleAnswerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_possibleAnswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__12);
			setState(141);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalQuestionContext numericalQuestion() throws RecognitionException {
		NumericalQuestionContext _localctx = new NumericalQuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_numericalQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__13);
			setState(144);
			questionText();
			setState(145);
			match(T__1);
			setState(146);
			acceptedError();
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(147);
				possibleAnswer();
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(152);
			match(T__2);
			setState(153);
			answer();
			setState(154);
			match(T__3);
			setState(155);
			grade();
			setState(156);
			match(T__4);
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
		public TerminalNode NUM() { return getToken(QuestionValidatorParser.NUM, 0); }
		public AcceptedErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceptedError; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterAcceptedError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitAcceptedError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitAcceptedError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcceptedErrorContext acceptedError() throws RecognitionException {
		AcceptedErrorContext _localctx = new AcceptedErrorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_acceptedError);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__14);
			setState(159);
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
		public TerminalNode NUM() { return getToken(QuestionValidatorParser.NUM, 0); }
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterSelectMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitSelectMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitSelectMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectMissingWordsQuestionContext selectMissingWordsQuestion() throws RecognitionException {
		SelectMissingWordsQuestionContext _localctx = new SelectMissingWordsQuestionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selectMissingWordsQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__15);
			setState(162);
			questionText();
			setState(163);
			match(T__1);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				missingWord();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__17 );
			setState(169);
			match(T__2);
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				answer();
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM || _la==STRING );
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(175);
				feedback();
				}
			}

			setState(178);
			match(T__16);
			setState(179);
			match(NUM);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(180);
				penalty();
				}
			}

			setState(183);
			match(T__3);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				grade();
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM );
			setState(189);
			match(T__4);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMissingWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMissingWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMissingWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingWordContext missingWord() throws RecognitionException {
		MissingWordContext _localctx = new MissingWordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_missingWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__17);
			setState(194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(192);
					word();
					}
					break;
				case T__1:
					{
					setState(193);
					wordGroup();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(196); 
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterWordGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitWordGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitWordGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordGroupContext wordGroup() throws RecognitionException {
		WordGroupContext _localctx = new WordGroupContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_wordGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__1);
			setState(200); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				word();
				}
				}
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
			setState(204);
			match(T__4);
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_word);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseQuestionContext trueFalseQuestion() throws RecognitionException {
		TrueFalseQuestionContext _localctx = new TrueFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_trueFalseQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__18);
			setState(209);
			questionText();
			setState(210);
			match(T__1);
			setState(211);
			match(T__2);
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(213);
				feedback();
				}
			}

			setState(216);
			match(T__3);
			setState(217);
			grade();
			setState(218);
			match(T__4);
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_feedback);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__19);
			setState(221);
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__20);
			setState(224);
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
		public TerminalNode NUM() { return getToken(QuestionValidatorParser.NUM, 0); }
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitGrade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeContext grade() throws RecognitionException {
		GradeContext _localctx = new GradeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
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
		public TerminalNode STRING() { return getToken(QuestionValidatorParser.STRING, 0); }
		public TerminalNode NUM() { return getToken(QuestionValidatorParser.NUM, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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
		public TerminalNode DOUBLE() { return getToken(QuestionValidatorParser.DOUBLE, 0); }
		public PenaltyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_penalty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterPenalty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitPenalty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitPenalty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PenaltyContext penalty() throws RecognitionException {
		PenaltyContext _localctx = new PenaltyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_penalty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__21);
			setState(231);
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
		"\u0004\u0001\u001e\u00ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u00015\b\u0001\u000b\u0001\f\u0001"+
		"6\u0001\u0001\u0004\u0001:\b\u0001\u000b\u0001\f\u0001;\u0001\u0001\u0001"+
		"\u0001\u0004\u0001@\b\u0001\u000b\u0001\f\u0001A\u0001\u0001\u0001\u0001"+
		"\u0004\u0001F\b\u0001\u000b\u0001\f\u0001G\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0004\u0002N\b\u0002\u000b\u0002\f\u0002O\u0001\u0003"+
		"\u0001\u0003\u0004\u0003T\b\u0003\u000b\u0003\f\u0003U\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005^\b"+
		"\u0005\u000b\u0005\f\u0005_\u0001\u0005\u0001\u0005\u0004\u0005d\b\u0005"+
		"\u000b\u0005\f\u0005e\u0001\u0005\u0003\u0005i\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005m\b\u0005\u000b\u0005\f\u0005n\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006w\b\u0006"+
		"\u000b\u0006\f\u0006x\u0001\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006\u0081\b\u0006\u000b\u0006\f\u0006\u0082"+
		"\u0001\u0006\u0001\u0006\u0004\u0006\u0087\b\u0006\u000b\u0006\f\u0006"+
		"\u0088\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0095\b\b\u000b\b\f\b\u0096"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00a6\b\n\u000b\n\f\n\u00a7"+
		"\u0001\n\u0001\n\u0004\n\u00ac\b\n\u000b\n\f\n\u00ad\u0001\n\u0003\n\u00b1"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b6\b\n\u0001\n\u0001\n\u0004\n"+
		"\u00ba\b\n\u000b\n\f\n\u00bb\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u00c3\b\u000b\u000b\u000b\f\u000b\u00c4\u0001\f\u0001"+
		"\f\u0004\f\u00c9\b\f\u000b\f\f\f\u00ca\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00d7\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0002"+
		"\u0001\u0000\u000b\f\u0002\u0000\u0017\u0017\u0019\u0019\u00f2\u0000."+
		"\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004K\u0001\u0000"+
		"\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bW\u0001\u0000\u0000\u0000"+
		"\nY\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000\u0000\u000e\u008c\u0001"+
		"\u0000\u0000\u0000\u0010\u008f\u0001\u0000\u0000\u0000\u0012\u009e\u0001"+
		"\u0000\u0000\u0000\u0014\u00a1\u0001\u0000\u0000\u0000\u0016\u00bf\u0001"+
		"\u0000\u0000\u0000\u0018\u00c6\u0001\u0000\u0000\u0000\u001a\u00ce\u0001"+
		"\u0000\u0000\u0000\u001c\u00d0\u0001\u0000\u0000\u0000\u001e\u00dc\u0001"+
		"\u0000\u0000\u0000 \u00df\u0001\u0000\u0000\u0000\"\u00e2\u0001\u0000"+
		"\u0000\u0000$\u00e4\u0001\u0000\u0000\u0000&\u00e6\u0001\u0000\u0000\u0000"+
		"(/\u0003\u0002\u0001\u0000)/\u0003\n\u0005\u0000*/\u0003\f\u0006\u0000"+
		"+/\u0003\u0010\b\u0000,/\u0003\u0014\n\u0000-/\u0003\u001c\u000e\u0000"+
		".(\u0001\u0000\u0000\u0000.)\u0001\u0000\u0000\u0000.*\u0001\u0000\u0000"+
		"\u0000.+\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000.-\u0001\u0000"+
		"\u0000\u0000/\u0001\u0001\u0000\u0000\u000001\u0005\u0001\u0000\u0000"+
		"12\u0003\b\u0004\u000024\u0005\u0002\u0000\u000035\u0003\u0004\u0002\u0000"+
		"43\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u00008:\u0003\u0006"+
		"\u0003\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=?\u0005\u0003\u0000\u0000>@\u0003$\u0012\u0000?>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CE\u0005\u0004\u0000\u0000DF\u0003\"\u0011"+
		"\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0005\u0000\u0000J\u0003\u0001\u0000\u0000\u0000KM\u0005\u0006\u0000"+
		"\u0000LN\u0003\b\u0004\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0005\u0001"+
		"\u0000\u0000\u0000QS\u0005\u0007\u0000\u0000RT\u0003\b\u0004\u0000SR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\u0007\u0001\u0000\u0000\u0000WX\u0005\u0019"+
		"\u0000\u0000X\t\u0001\u0000\u0000\u0000YZ\u0005\b\u0000\u0000Z[\u0003"+
		"\b\u0004\u0000[]\u0005\u0002\u0000\u0000\\^\u0003 \u0010\u0000]\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0005\u0003\u0000"+
		"\u0000bd\u0003$\u0012\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000"+
		"\u0000\u0000gi\u0003\u001e\u000f\u0000hg\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0005\u0004\u0000\u0000"+
		"km\u0003\"\u0011\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pq\u0005\u0005\u0000\u0000q\u000b\u0001\u0000\u0000\u0000rs\u0005"+
		"\t\u0000\u0000st\u0003\b\u0004\u0000tv\u0005\u0002\u0000\u0000uw\u0003"+
		"\u000e\u0007\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000z{\u0005\n\u0000\u0000{}\u0007\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0005"+
		"\u0003\u0000\u0000\u007f\u0081\u0003$\u0012\u0000\u0080\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u0086\u0005\u0004\u0000\u0000\u0085\u0087\u0003\"\u0011"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0005\u0000"+
		"\u0000\u008b\r\u0001\u0000\u0000\u0000\u008c\u008d\u0005\r\u0000\u0000"+
		"\u008d\u008e\u0007\u0001\u0000\u0000\u008e\u000f\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005\u000e\u0000\u0000\u0090\u0091\u0003\b\u0004\u0000\u0091"+
		"\u0092\u0005\u0002\u0000\u0000\u0092\u0094\u0003\u0012\t\u0000\u0093\u0095"+
		"\u0003\u000e\u0007\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u0003\u0000\u0000\u0099\u009a\u0003$\u0012\u0000\u009a\u009b\u0005"+
		"\u0004\u0000\u0000\u009b\u009c\u0003\"\u0011\u0000\u009c\u009d\u0005\u0005"+
		"\u0000\u0000\u009d\u0011\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u000f"+
		"\u0000\u0000\u009f\u00a0\u0005\u0017\u0000\u0000\u00a0\u0013\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2\u00a3\u0003\b\u0004"+
		"\u0000\u00a3\u00a5\u0005\u0002\u0000\u0000\u00a4\u00a6\u0003\u0016\u000b"+
		"\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005\u0003\u0000"+
		"\u0000\u00aa\u00ac\u0003$\u0012\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000"+
		"\u00af\u00b1\u0003\u001e\u000f\u0000\u00b0\u00af\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0011\u0000\u0000\u00b3\u00b5\u0005\u0017\u0000\u0000"+
		"\u00b4\u00b6\u0003&\u0013\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b9\u0005\u0004\u0000\u0000\u00b8\u00ba\u0003\"\u0011\u0000\u00b9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u0005\u0000\u0000\u00be\u0015"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c2\u0005\u0012\u0000\u0000\u00c0\u00c3"+
		"\u0003\u001a\r\u0000\u00c1\u00c3\u0003\u0018\f\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6\u00c8\u0005"+
		"\u0002\u0000\u0000\u00c7\u00c9\u0003\u001a\r\u0000\u00c8\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0005\u0005\u0000\u0000\u00cd\u0019\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0005\u0019\u0000\u0000\u00cf\u001b\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0005\u0013\u0000\u0000\u00d1\u00d2\u0003\b\u0004"+
		"\u0000\u00d2\u00d3\u0005\u0002\u0000\u0000\u00d3\u00d4\u0005\u0003\u0000"+
		"\u0000\u00d4\u00d6\u0007\u0000\u0000\u0000\u00d5\u00d7\u0003\u001e\u000f"+
		"\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0004\u0000"+
		"\u0000\u00d9\u00da\u0003\"\u0011\u0000\u00da\u00db\u0005\u0005\u0000\u0000"+
		"\u00db\u001d\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005\u0014\u0000\u0000"+
		"\u00dd\u00de\u0005\u0019\u0000\u0000\u00de\u001f\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0005\u0015\u0000\u0000\u00e0\u00e1\u0005\u0019\u0000\u0000"+
		"\u00e1!\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0017\u0000\u0000\u00e3"+
		"#\u0001\u0000\u0000\u0000\u00e4\u00e5\u0007\u0001\u0000\u0000\u00e5%\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005\u0016\u0000\u0000\u00e7\u00e8\u0005"+
		"\u001e\u0000\u0000\u00e8\'\u0001\u0000\u0000\u0000\u0019.6;AGOU_ehnx|"+
		"\u0082\u0088\u0096\u00a7\u00ad\u00b0\u00b5\u00bb\u00c2\u00c4\u00ca\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}