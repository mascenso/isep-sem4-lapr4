// Generated from /Users/patricia/Documents/ISEP/2ºano/2ºsemestre/LPROG/questions/grammar/QuestionValidator.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuestionValidatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NEWLINE=4, WS=5, QUESTION=6, ANSWER=7, GRADE=8, 
		TRUE=9, FALSE=10, ACCEPTED_ANSWER=11, CHOICE_TEXT=12, SUBQUESTION=13, 
		GROUP=14, OPTION_TEXT=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "NEWLINE", "WS", "QUESTION", "ANSWER", "GRADE", 
			"TRUE", "FALSE", "ACCEPTED_ANSWER", "CHOICE_TEXT", "SUBQUESTION", "GROUP", 
			"OPTION_TEXT"
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


	public QuestionValidatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QuestionValidator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000fw\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003*\b\u0003\u000b"+
		"\u0003\f\u0003+\u0001\u0004\u0004\u0004/\b\u0004\u000b\u0004\f\u00040"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u00056\b\u0005\u000b\u0005"+
		"\f\u00057\u0001\u0006\u0004\u0006;\b\u0006\u000b\u0006\f\u0006<\u0001"+
		"\u0007\u0004\u0007@\b\u0007\u000b\u0007\f\u0007A\u0001\u0007\u0001\u0007"+
		"\u0004\u0007F\b\u0007\u000b\u0007\f\u0007G\u0003\u0007J\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0004\nX\b\n\u000b\n\f\nY\u0001\n\u0001\n\u0004\n^"+
		"\b\n\u000b\n\f\n_\u0003\nb\b\n\u0001\u000b\u0004\u000be\b\u000b\u000b"+
		"\u000b\f\u000bf\u0001\f\u0004\fj\b\f\u000b\f\f\fk\u0001\r\u0004\ro\b\r"+
		"\u000b\r\f\rp\u0001\u000e\u0004\u000et\b\u000e\u000b\u000e\f\u000eu\u0000"+
		"\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u0001\u0000\u0004\u0002\u0000\n\n\r\r\u0002\u0000\t"+
		"\t  \u0003\u0000\n\n\r\r^^\u0001\u000009\u0084\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0001\u001f\u0001\u0000\u0000\u0000\u0003!\u0001\u0000\u0000\u0000\u0005"+
		"#\u0001\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t.\u0001\u0000"+
		"\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000"+
		"\u000f?\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000\u0013P"+
		"\u0001\u0000\u0000\u0000\u0015W\u0001\u0000\u0000\u0000\u0017d\u0001\u0000"+
		"\u0000\u0000\u0019i\u0001\u0000\u0000\u0000\u001bn\u0001\u0000\u0000\u0000"+
		"\u001ds\u0001\u0000\u0000\u0000\u001f \u0005[\u0000\u0000 \u0002\u0001"+
		"\u0000\u0000\u0000!\"\u0005]\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000"+
		"#$\u0005]\u0000\u0000$%\u0005 \u0000\u0000%&\u0005-\u0000\u0000&\'\u0005"+
		">\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000(*\u0007\u0000\u0000\u0000"+
		")(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,\b\u0001\u0000\u0000\u0000-/\u0007\u0001"+
		"\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"23\u0006\u0004\u0000\u00003\n\u0001\u0000\u0000\u000046\u0007\u0002\u0000"+
		"\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u00008\f\u0001\u0000\u0000\u00009;\u0007"+
		"\u0002\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\u000e\u0001\u0000"+
		"\u0000\u0000>@\u0007\u0003\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"BI\u0001\u0000\u0000\u0000CE\t\u0000\u0000\u0000DF\u0007\u0003\u0000\u0000"+
		"ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IC\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0010\u0001\u0000\u0000\u0000"+
		"KL\u0005T\u0000\u0000LM\u0005r\u0000\u0000MN\u0005u\u0000\u0000NO\u0005"+
		"e\u0000\u0000O\u0012\u0001\u0000\u0000\u0000PQ\u0005F\u0000\u0000QR\u0005"+
		"a\u0000\u0000RS\u0005l\u0000\u0000ST\u0005s\u0000\u0000TU\u0005e\u0000"+
		"\u0000U\u0014\u0001\u0000\u0000\u0000VX\u0007\u0003\u0000\u0000WV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Za\u0001\u0000\u0000\u0000[]\t\u0000\u0000\u0000"+
		"\\^\u0007\u0003\u0000\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a[\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0016"+
		"\u0001\u0000\u0000\u0000ce\u0007\u0002\u0000\u0000dc\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000g\u0018\u0001\u0000\u0000\u0000hj\u0007\u0002\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000l\u001a\u0001\u0000\u0000\u0000mo\u0007"+
		"\u0002\u0000\u0000nm\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q\u001c\u0001\u0000"+
		"\u0000\u0000rt\u0007\u0002\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u001e\u0001\u0000\u0000\u0000\u000f\u0000+07<AGIY_afkpu\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}