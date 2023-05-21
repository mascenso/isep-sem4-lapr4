// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/LPROG/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
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
		T__0=1, T__1=2, T__2=3, NEWLINE=4, WS=5, QUESTION=6, ANSWER=7, GRADE=8, 
		TRUE=9, FALSE=10, ACCEPTED_ANSWER=11, CHOICE_TEXT=12, SUBQUESTION=13, 
		GROUP=14, OPTION_TEXT=15;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_shortAnswer = 2, RULE_multichoice = 3, 
		RULE_matching = 4, RULE_trueFalse = 5, RULE_selectMissingWords = 6, RULE_numerical = 7, 
		RULE_choice = 8, RULE_subQuestion = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "shortAnswer", "multichoice", "matching", "trueFalse", 
			"selectMissingWords", "numerical", "choice", "subQuestion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'] ->'", null, null, null, null, null, "'True'", 
			"'False'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NEWLINE", "WS", "QUESTION", "ANSWER", "GRADE", 
			"TRUE", "FALSE", "ACCEPTED_ANSWER", "CHOICE_TEXT", "SUBQUESTION", "GROUP", 
			"OPTION_TEXT"
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
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				stat();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE || _la==QUESTION );
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
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericalQuestionContext extends StatContext {
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public NumericalQuestionContext(StatContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class TrueFalseQuestionContext extends StatContext {
		public TrueFalseContext trueFalse() {
			return getRuleContext(TrueFalseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public TrueFalseQuestionContext(StatContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class MatchingQuestionContext extends StatContext {
		public MatchingContext matching() {
			return getRuleContext(MatchingContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public MatchingQuestionContext(StatContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class SelectMissingWordsQuestionContext extends StatContext {
		public SelectMissingWordsContext selectMissingWords() {
			return getRuleContext(SelectMissingWordsContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public SelectMissingWordsQuestionContext(StatContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class ShortAnswerQuestionContext extends StatContext {
		public ShortAnswerContext shortAnswer() {
			return getRuleContext(ShortAnswerContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public ShortAnswerQuestionContext(StatContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class MultichoiceQuestionContext extends StatContext {
		public MultichoiceContext multichoice() {
			return getRuleContext(MultichoiceContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(QuestionValidatorParser.NEWLINE, 0); }
		public MultichoiceQuestionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMultichoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMultichoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMultichoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ShortAnswerQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				shortAnswer();
				setState(26);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new MultichoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				multichoice();
				setState(29);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new MatchingQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				matching();
				setState(32);
				match(NEWLINE);
				}
				break;
			case 4:
				_localctx = new TrueFalseQuestionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				trueFalse();
				setState(35);
				match(NEWLINE);
				}
				break;
			case 5:
				_localctx = new SelectMissingWordsQuestionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				selectMissingWords();
				setState(38);
				match(NEWLINE);
				}
				break;
			case 6:
				_localctx = new NumericalQuestionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				numerical();
				setState(41);
				match(NEWLINE);
				}
				break;
			case 7:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				match(NEWLINE);
				}
				break;
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
	public static class ShortAnswerContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public TerminalNode ANSWER() { return getToken(QuestionValidatorParser.ANSWER, 0); }
		public TerminalNode GRADE() { return getToken(QuestionValidatorParser.GRADE, 0); }
		public ShortAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortAnswerContext shortAnswer() throws RecognitionException {
		ShortAnswerContext _localctx = new ShortAnswerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_shortAnswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(QUESTION);
			setState(47);
			match(ANSWER);
			setState(48);
			match(GRADE);
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
	public static class MultichoiceContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public List<ChoiceContext> choice() {
			return getRuleContexts(ChoiceContext.class);
		}
		public ChoiceContext choice(int i) {
			return getRuleContext(ChoiceContext.class,i);
		}
		public MultichoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multichoice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMultichoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMultichoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMultichoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultichoiceContext multichoice() throws RecognitionException {
		MultichoiceContext _localctx = new MultichoiceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_multichoice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(QUESTION);
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				choice();
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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
	public static class MatchingContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public List<SubQuestionContext> subQuestion() {
			return getRuleContexts(SubQuestionContext.class);
		}
		public SubQuestionContext subQuestion(int i) {
			return getRuleContext(SubQuestionContext.class,i);
		}
		public MatchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitMatching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingContext matching() throws RecognitionException {
		MatchingContext _localctx = new MatchingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(QUESTION);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				subQuestion();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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
	public static class TrueFalseContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public TerminalNode GRADE() { return getToken(QuestionValidatorParser.GRADE, 0); }
		public TerminalNode TRUE() { return getToken(QuestionValidatorParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(QuestionValidatorParser.FALSE, 0); }
		public TrueFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterTrueFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitTrueFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitTrueFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseContext trueFalse() throws RecognitionException {
		TrueFalseContext _localctx = new TrueFalseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_trueFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(QUESTION);
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			match(GRADE);
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
	public static class SelectMissingWordsContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public List<TerminalNode> OPTION_TEXT() { return getTokens(QuestionValidatorParser.OPTION_TEXT); }
		public TerminalNode OPTION_TEXT(int i) {
			return getToken(QuestionValidatorParser.OPTION_TEXT, i);
		}
		public List<TerminalNode> GROUP() { return getTokens(QuestionValidatorParser.GROUP); }
		public TerminalNode GROUP(int i) {
			return getToken(QuestionValidatorParser.GROUP, i);
		}
		public SelectMissingWordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectMissingWords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterSelectMissingWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitSelectMissingWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitSelectMissingWords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectMissingWordsContext selectMissingWords() throws RecognitionException {
		SelectMissingWordsContext _localctx = new SelectMissingWordsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectMissingWords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(QUESTION);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPTION_TEXT) {
				{
				{
				setState(67);
				match(OPTION_TEXT);
				setState(68);
				match(GROUP);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class NumericalContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QuestionValidatorParser.QUESTION, 0); }
		public TerminalNode ACCEPTED_ANSWER() { return getToken(QuestionValidatorParser.ACCEPTED_ANSWER, 0); }
		public TerminalNode GRADE() { return getToken(QuestionValidatorParser.GRADE, 0); }
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		NumericalContext _localctx = new NumericalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numerical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(QUESTION);
			setState(75);
			match(ACCEPTED_ANSWER);
			setState(76);
			match(GRADE);
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
	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode CHOICE_TEXT() { return getToken(QuestionValidatorParser.CHOICE_TEXT, 0); }
		public TerminalNode GRADE() { return getToken(QuestionValidatorParser.GRADE, 0); }
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__0);
			setState(79);
			match(CHOICE_TEXT);
			setState(80);
			match(T__1);
			setState(81);
			match(GRADE);
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
	public static class SubQuestionContext extends ParserRuleContext {
		public TerminalNode SUBQUESTION() { return getToken(QuestionValidatorParser.SUBQUESTION, 0); }
		public TerminalNode ANSWER() { return getToken(QuestionValidatorParser.ANSWER, 0); }
		public TerminalNode GRADE() { return getToken(QuestionValidatorParser.GRADE, 0); }
		public SubQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).enterSubQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionValidatorListener ) ((QuestionValidatorListener)listener).exitSubQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionValidatorVisitor ) return ((QuestionValidatorVisitor<? extends T>)visitor).visitSubQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubQuestionContext subQuestion() throws RecognitionException {
		SubQuestionContext _localctx = new SubQuestionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subQuestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__0);
			setState(84);
			match(SUBQUESTION);
			setState(85);
			match(T__2);
			setState(86);
			match(ANSWER);
			setState(87);
			match(GRADE);
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
		"\u0004\u0001\u000fZ\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001-\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0004\u00035\b"+
		"\u0003\u000b\u0003\f\u00036\u0001\u0004\u0001\u0004\u0004\u0004;\b\u0004"+
		"\u000b\u0004\f\u0004<\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006F\b\u0006\n\u0006\f\u0006"+
		"I\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0000\u0001\u0001\u0000\t\nY\u0000\u0015\u0001\u0000\u0000\u0000\u0002"+
		",\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00062\u0001"+
		"\u0000\u0000\u0000\b8\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000"+
		"\fB\u0001\u0000\u0000\u0000\u000eJ\u0001\u0000\u0000\u0000\u0010N\u0001"+
		"\u0000\u0000\u0000\u0012S\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0002"+
		"\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000"+
		"\u0000\u0000\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001a\u0003\u0004"+
		"\u0002\u0000\u001a\u001b\u0005\u0004\u0000\u0000\u001b-\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0004\u0000"+
		"\u0000\u001e-\u0001\u0000\u0000\u0000\u001f \u0003\b\u0004\u0000 !\u0005"+
		"\u0004\u0000\u0000!-\u0001\u0000\u0000\u0000\"#\u0003\n\u0005\u0000#$"+
		"\u0005\u0004\u0000\u0000$-\u0001\u0000\u0000\u0000%&\u0003\f\u0006\u0000"+
		"&\'\u0005\u0004\u0000\u0000\'-\u0001\u0000\u0000\u0000()\u0003\u000e\u0007"+
		"\u0000)*\u0005\u0004\u0000\u0000*-\u0001\u0000\u0000\u0000+-\u0005\u0004"+
		"\u0000\u0000,\u0019\u0001\u0000\u0000\u0000,\u001c\u0001\u0000\u0000\u0000"+
		",\u001f\u0001\u0000\u0000\u0000,\"\u0001\u0000\u0000\u0000,%\u0001\u0000"+
		"\u0000\u0000,(\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0003"+
		"\u0001\u0000\u0000\u0000./\u0005\u0006\u0000\u0000/0\u0005\u0007\u0000"+
		"\u000001\u0005\b\u0000\u00001\u0005\u0001\u0000\u0000\u000024\u0005\u0006"+
		"\u0000\u000035\u0003\u0010\b\u000043\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007\u0007"+
		"\u0001\u0000\u0000\u00008:\u0005\u0006\u0000\u00009;\u0003\u0012\t\u0000"+
		":9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=\t\u0001\u0000\u0000\u0000>?\u0005\u0006"+
		"\u0000\u0000?@\u0007\u0000\u0000\u0000@A\u0005\b\u0000\u0000A\u000b\u0001"+
		"\u0000\u0000\u0000BG\u0005\u0006\u0000\u0000CD\u0005\u000f\u0000\u0000"+
		"DF\u0005\u000e\u0000\u0000EC\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\r\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0006\u0000\u0000KL\u0005"+
		"\u000b\u0000\u0000LM\u0005\b\u0000\u0000M\u000f\u0001\u0000\u0000\u0000"+
		"NO\u0005\u0001\u0000\u0000OP\u0005\f\u0000\u0000PQ\u0005\u0002\u0000\u0000"+
		"QR\u0005\b\u0000\u0000R\u0011\u0001\u0000\u0000\u0000ST\u0005\u0001\u0000"+
		"\u0000TU\u0005\r\u0000\u0000UV\u0005\u0003\u0000\u0000VW\u0005\u0007\u0000"+
		"\u0000WX\u0005\b\u0000\u0000X\u0013\u0001\u0000\u0000\u0000\u0005\u0017"+
		",6<G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}