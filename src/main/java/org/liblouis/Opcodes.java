package org.liblouis;

public abstract class Opcodes {

	public static String getName(int opcode) {
		try {
			return opcodeNames[opcode]; }
		catch (ArrayIndexOutOfBoundsException e) {
			return "<" + opcode + ">"; }
	}
	
	public static final int DISABLED = -1;
	
	public static final int CTO_INCLUDEFILE = 0;
	public static final int CTO_LOCALE = 1;
	public static final int CTO_UNDEFINED = 2;
	public static final int CTO_CAPITALSIGN = 3;
	public static final int CTO_BEGINCAPITALSIGN = 4;
	public static final int CTO_LENBEGCAPS = 5;
	public static final int CTO_ENDCAPITALSIGN = 6;
	public static final int CTO_FIRSTWORDCAPS = 7;
	public static final int CTO_LASTWORDCAPSBEFORE = 8;
	public static final int CTO_LASTWORDCAPSAFTER = 9;
	public static final int CTO_LENCAPSPHRASE = 10;
	public static final int CTO_LETTERSIGN = 11;
	public static final int CTO_NOLETSIGNBEFORE = 12;
	public static final int CTO_NOLETSIGN = 13;
	public static final int CTO_NOLETSIGNAFTER = 14;
	public static final int CTO_NUMBERSIGN = 15;
	public static final int CTO_FIRSTWORDITAL = 16;
	public static final int CTO_ITALSIGN = 17;
	public static final int CTO_LASTWORDITALBEFORE = 18;
	public static final int CTO_LASTWORDITALAFTER = 19;
	public static final int CTO_BEGITAL = 20;
	public static final int CTO_FIRSTLETTERITAL = 21;
	public static final int CTO_ENDITAL = 22;
	public static final int CTO_LASTLETTERITAL = 23;
	public static final int CTO_SINGLELETTERITAL = 24;
	public static final int CTO_ITALWORD = 25;
	public static final int CTO_LENITALPHRASE = 26;
	public static final int CTO_FIRSTWORDBOLD = 27;
	public static final int CTO_BOLDSIGN = 28;
	public static final int CTO_LASTWORDBOLDBEFORE = 29;
	public static final int CTO_LASTWORDBOLDAFTER = 30;
	public static final int CTO_BEGBOLD = 31;
	public static final int CTO_FIRSTLETTERBOLD = 32;
	public static final int CTO_ENDBOLD = 33;
	public static final int CTO_LASTLETTERBOLD = 34;
	public static final int CTO_SINGLELETTERBOLD = 35;
	public static final int CTO_BOLDWORD = 36;
	public static final int CTO_LENBOLDPHRASE = 37;
	public static final int CTO_FIRSTWORDUNDER = 38;
	public static final int CTO_UNDERSIGN = 39;
	public static final int CTO_LASTWORDUNDERBEFORE = 40;
	public static final int CTO_LASTWORDUNDERAFTER = 41;
	public static final int CTO_BEGUNDER = 42;
	public static final int CTO_FIRSTLETTERUNDER = 43;
	public static final int CTO_ENDUNDER = 44;
	public static final int CTO_LASTLETTERUNDER = 45;
	public static final int CTO_SINGLELETTERUNDER = 46;
	public static final int CTO_UNDERWORD = 47;
	public static final int CTO_LENUNDERPHRASE = 48;
	public static final int CTO_BEGCOMP = 49;
	public static final int CTO_COMPBEGEMPH1 = 50;
	public static final int CTO_COMPENDEMPH1 = 51;
	public static final int CTO_COMPBEGEMPH2 = 52;
	public static final int CTO_COMPENDEMPH2 = 53;
	public static final int CTO_COMPBEGEMPH3 = 54;
	public static final int CTO_COMPENDEMPH3 = 55;
	public static final int CTO_COMPCAPSIGN = 56;
	public static final int CTO_COMPBEGCAPS = 57;
	public static final int CTO_COMPENDCAPS = 58;
	public static final int CTO_ENDCOMP = 59;
	public static final int CTO_MULTIND = 60;
	public static final int CTO_COMPDOTS = 61;
	public static final int CTO_COMP6 = 62;
	public static final int CTO_CLASS = 63;
	public static final int CTO_AFTER = 64;
	public static final int CTO_BEFORE = 65;
	public static final int CTO_NOBACK = 66;
	public static final int CTO_NOFOR = 67;
	public static final int CTO_SWAPCC = 68;
	public static final int CTO_SWAPCD = 69;
	public static final int CTO_SWAPDD = 70;
	public static final int CTO_SPACE = 71;
	public static final int CTO_DIGIT = 72;
	public static final int CTO_PUNCTUATION = 73;
	public static final int CTO_MATH = 74;
	public static final int CTO_SIGN = 75;
	public static final int CTO_LETTER = 76;
	public static final int CTO_UPPERCASE = 77;
	public static final int CTO_LOWERCASE = 78;
	public static final int CTO_GROUPING = 79;
	public static final int CTO_UPLOW = 80;
	public static final int CTO_LITDIGIT = 81;
	public static final int CTO_DISPLAY = 82;
	public static final int CTO_REPLACE = 83;
	public static final int CTO_CONTEXT = 84;
	public static final int CTO_CORRECT = 85;
	public static final int CTO_PASS2 = 86;
	public static final int CTO_PASS3 = 87;
	public static final int CTO_PASS4 = 88;
	public static final int CTO_REPEATED = 89;
	public static final int CTO_REPWORD = 90;
	public static final int CTO_CAPSNOCONT = 91;
	public static final int CTO_ALWAYS = 92;
	public static final int CTO_EXACTDOTS = 93;
	public static final int CTO_NOCROSS = 94;
	public static final int CTO_SYLLABLE = 95;
	public static final int CTO_NOCONT = 96;
	public static final int CTO_COMPBRL = 97;
	public static final int CTO_LITERAL = 98;
	public static final int CTO_LARGESIGN = 99;
	public static final int CTO_WHOLEWORD = 100;
	public static final int CTO_PARTWORD = 101;
	public static final int CTO_JOINNUM = 102;
	public static final int CTO_JOINABLEWORD = 103;
	public static final int CTO_LOWWORD = 104;
	public static final int CTO_CONTRACTION = 105;
	public static final int CTO_SUFFIXABLEWORD = 106;
	public static final int CTO_PREFIXABLEWORD = 107;
	public static final int CTO_BEGWORD = 108;
	public static final int CTO_BEGMIDWORD = 109;
	public static final int CTO_MIDWORD = 110;
	public static final int CTO_MIDENDWORD = 111;
	public static final int CTO_ENDWORD = 112;
	public static final int CTO_PREPUNC = 113;
	public static final int CTO_POSTPUNC = 114;
	public static final int CTO_BEGNUM = 115;
	public static final int CTO_MIDNUM = 116;
	public static final int CTO_ENDNUM = 117;
	public static final int CTO_DECPOINT = 118;
	public static final int CTO_HYPHEN = 119;
	public static final int CTO_NOBREAK = 120;
	public static final int CTO_NONE = 121;

	/* Internal opcodes */
	public static final int CTO_CAPITALRULE = 122;
	public static final int CTO_BEGINCAPITALRULE = 123;
	public static final int CTO_ENDCAPITALRULE = 124;
	public static final int CTO_FIRSTWORDCAPSRULE = 125;
	public static final int CTO_LASTWORDCAPSBEFORERULE = 126;
	public static final int CTO_LASTWORDCAPSAFTERRULE = 127;
	public static final int CTO_LETTERRULE = 128;
	public static final int CTO_NUMBERRULE = 129;
	public static final int CTO_FIRSTWORDITALRULE = 130;
	public static final int CTO_LASTWORDITALBEFORERULE = 131;
	public static final int CTO_LASTWORDITALAFTERRULE = 132;
	public static final int CTO_FIRSTLETTERITALRULE = 133;
	public static final int CTO_LASTLETTERITALRULE = 134;
	public static final int CTO_SINGLELETTERITALRULE = 135;
	public static final int CTO_ITALWORDRULE = 136;
	public static final int CTO_FIRSTWORDBOLDRULE = 137;
	public static final int CTO_LASTWORDBOLDBEFORERULE = 138;
	public static final int CTO_LASTWORDBOLDAFTERRULE = 139;
	public static final int CTO_FIRSTLETTERBOLDRULE = 140;
	public static final int CTO_LASTLETTERBOLDRULE = 141;
	public static final int CTO_SINGLELETTERBOLDRULE = 142;
	public static final int CTO_BOLDWORDRULE = 143;
	public static final int CTO_FIRSTWORDUNDERRULE = 144;
	public static final int CTO_LASTWORDUNDERBEFORERULE = 145;
	public static final int CTO_LASTWORDUNDERAFTERRULE = 146;
	public static final int CTO_FIRSTLETTERUNDERRULE = 147;
	public static final int CTO_LASTLETTERUNDERRULE = 148;
	public static final int CTO_SINGLELETTERUNDERRULE = 149;
	public static final int CTO_UNDERWORDRULE = 150;
	public static final int CTO_BEGCOMPRULE = 151;
	public static final int CTO_COMPBEGEMPH1RULE = 152;
	public static final int CTO_COMPENDEMPH1RULE = 153;
	public static final int CTO_COMPBEGEMPH2RULE = 154;
	public static final int CTO_COMPENDEMRH2RULE = 155;
	public static final int CTO_COMPBEGEMPH3RULE = 156;
	public static final int CTO_COMPENDEMPH3RULE = 157;
	public static final int CTO_COMPCAPSIGNRULE = 158;
	public static final int CTO_COMPBEGCAPSRULE = 159;
	public static final int CTO_COMPENDCAPSRULE = 160;
	public static final int CTO_ENDCOMPRULE = 161;
	public static final int CTO_CAPSNOCONTRULE = 162;
	public static final int CTO_All = 163;
	
	private static final String[] opcodeNames = new String[] {
		"include",
		"locale",
		"undefined",
		"capsign",
		"begcaps",
		"lenbegcaps",
		"endcaps",
		"firstwordcaps",
		"lastwordbeforecaps",
		"lastwordaftercaps",
		"lencapsphrase",
		"letsign",
		"noletsignbefore",
		"noletsign",
		"noletsignafter",
		"numsign",
		"firstwordital",
		"italsign",
		"lastworditalbefore",
		"lastworditalafter",
		"begital",
		"firstletterital",
		"endital",
		"lastletterital",
		"singleletterital",
		"italword",
		"lenitalphrase",
		"firstwordbold",
		"boldsign",
		"lastwordboldbefore",
		"lastwordboldafter",
		"begbold",
		"firstletterbold",
		"endbold",
		"lastletterbold",
		"singleletterbold",
		"boldword",
		"lenboldphrase",
		"firstwordunder",
		"undersign",
		"lastwordunderbefore",
		"lastwordunderafter",
		"begunder",
		"firstletterunder",
		"endunder",
		"lastletterunder",
		"singleletterunder",
		"underword",
		"lenunderphrase",
		"begcomp",
		"compbegemph1",
		"compendemph1",
		"compbegemph2",
		"compendemph2",
		"compbegemph3",
		"compendemph3",
		"compcapsign",
		"compbegcaps",
		"compendcaps",
		"endcomp",
		"multind",
		"compdots",
		"comp6",
		"class",
		"after",
		"before",
		"noback",
		"nofor",
		"swapcc",
		"swapcd",
		"swapdd",
		"space",
		"digit",
		"punctuation",
		"math",
		"sign",
		"letter",
		"uppercase",
		"lowercase",
		"grouping",
		"uplow",
		"litdigit",
		"display",
		"replace",
		"context",
		"correct",
		"pass2",
		"pass3",
		"pass4",
		"repeated",
		"repword",
		"capsnocont",
		"always",
		"exactdots",
		"nocross",
		"syllable",
		"nocont",
		"compbrl",
		"literal",
		"largesign",
		"word",
		"partword",
		"joinnum",
		"joinword",
		"lowword",
		"contraction",
		"sufword",
		"prfword",
		"begword",
		"begmidword",
		"midword",
		"midendword",
		"endword",
		"prepunc",
		"postpunc",
		"begnum",
		"midnum",
		"endnum",
		"decpoint",
		"hyphen",
		"nobreak",
		"NONE"
	};
}
