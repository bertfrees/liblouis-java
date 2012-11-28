package org.liblouis;

public abstract class MultipassCodes {

	public static final char PASS_FIRST = '`';
	public static final char PASS_LAST = '~';
	public static final char PASS_LOOKBACK = '_';
	public static final char PASS_STRING = '\"';
	public static final char PASS_DOTS = '@';
	public static final char PASS_OMIT = '?';
	public static final char PASS_STARTREPLACE = '[';
	public static final char PASS_ENDREPLACE = ']';
	public static final char PASS_VARIABLE = '#';
	public static final char PASS_NOT = '!';
	public static final char PASS_SEARCH = '/';
	public static final char PASS_ANY = 'a';
	public static final char PASS_DIGIT = 'd';
	public static final char PASS_LITDIGIT = 'D';
	public static final char PASS_LETTER = 'l';
	public static final char PASS_MATH = 'm';
	public static final char PASS_PUNCTUATION = 'p';
	public static final char PASS_SIGN = 'S';
	public static final char PASS_SPACE = 's';
	public static final char PASS_UPPERCASE = 'U';
	public static final char PASS_LOWERCASE = 'u';
	public static final char PASS_CLASS1 = 'w';
	public static final char PASS_CLASS2 = 'x';
	public static final char PASS_CLASS3 = 'y';
	public static final char PASS_CLASS4 = 'z';
	public static final char PASS_ATTRIBUTES = '$';
	public static final char PASS_GROUPSTART = '{';
	public static final char PASS_GROUPEND = '}';
	public static final char PASS_GROUPREPLACE = ';';
	public static final char PASS_SWAP = '%';
	public static final char PASS_HYPHEN = '-';
	public static final char PASS_UNTIL = '.';
	public static final char PASS_EQ = '=';
	public static final char PASS_LT = '<';
	public static final char PASS_GT = '>';
	public static final char PASS_ENDTEST = ' ';
	public static final char PASS_PLUS = '+';
	public static final char PASS_COPY = '*';
	public static final char PASS_LEFTPAREN = '(';
	public static final char PASS_RIGHTPAREN = ')';
	public static final char PASS_COMMA = ',';

	public static final char PASS_LTEQ = 130;
	public static final char PASS_GTEQ = 131;
	public static final char PASS_INVALIDTOKEN = 132;
	public static final char PASS_NOTEQ = 133;
	public static final char PASS_AND = 134;
	public static final char PASS_OR = 135;
	public static final char PASS_NAMEFOUND = 136;
	public static final char PASS_NUMBERFOUND = 137;
	public static final char PASS_BOOLEAN = 138;
	public static final char PASS_CLASS = 139;
	public static final char PASS_DEFINE = 140;
	public static final char PASS_EMPHASIS = 141;
	public static final char PASS_GROUP = 142;
	public static final char PASS_MARK = 143;
	public static final char PASS_REPGROUP = 143;
	public static final char PASS_SCRIPT = 144;
	public static final char PASS_NOMORETOKENS = 145;
	public static final char PASS_REPLACE = 146;
	public static final char PASS_IF = 147;
	public static final char PASS_THEN = 148;
	public static final char PASS_ALL = 255;

}
