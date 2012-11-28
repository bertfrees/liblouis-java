package org.liblouis;

import com.sun.jna.Pointer;

public class MultipassScript extends WideString {
	
	private final String test;
	private final String action;
	
	public MultipassScript(Pointer p, int offset, int length) {
		super(p, offset, length);
		String[] testAction = toTestAction(super.read(length()));
		test = testAction[0];
		action = testAction[1];
	}
	
	public String getTest() {
		return test;
	}

	public String getAction() {
		return action;
	}
	
	@Override
	public String toString() {
		String[] testAction = toTestAction(super.read(length()));
		return test + " " + action;
	}
	
	private static String[] toTestAction(String script) {
		StringBuffer testBuffer = new StringBuffer();
		int i = 0;
		char c;
		while (i < script.length()) {
			c = script.charAt(i++);
			switch (c) {
				case MultipassCodes.PASS_FIRST:
				case MultipassCodes.PASS_LAST:
				case MultipassCodes.PASS_NOT:
				case MultipassCodes.PASS_STARTREPLACE:
				case MultipassCodes.PASS_ENDREPLACE:
				case MultipassCodes.PASS_SEARCH:
					testBuffer.append(c);
					break;
				case MultipassCodes.PASS_LOOKBACK:
					testBuffer.append(c);
					testBuffer.append(script.codePointAt(i++));
					break;
				case MultipassCodes.PASS_STRING:
				case MultipassCodes.PASS_DOTS:
					testBuffer.append(c);
					int len = script.codePointAt(i++);
					if (c == MultipassCodes.PASS_STRING)
						testBuffer.append(script.substring(i, i+len));
					else
						testBuffer.append(Dots.toPattern(script.substring(i, i+len)));
					i += len;
					break;
				case MultipassCodes.PASS_EQ:
				case MultipassCodes.PASS_LT:
				case MultipassCodes.PASS_GT:
				case MultipassCodes.PASS_LTEQ:
				case MultipassCodes.PASS_GTEQ:
					testBuffer.append('#');
					testBuffer.append(script.codePointAt(i++));
					testBuffer.append(c);
					testBuffer.append(script.codePointAt(i++));
					break;
				case MultipassCodes.PASS_ATTRIBUTES:
				case MultipassCodes.PASS_SWAP:
					if (c == MultipassCodes.PASS_ATTRIBUTES) {
						int attr = (script.codePointAt(i) << 16) | script.codePointAt(i+1);
						if ((attr & 0x1FFF) > 0) {
							testBuffer.append(c);
							testBuffer.append(CharacterAttributes.decode(attr)); }
						else
							testBuffer.append("%class" + (int)(Math.log(attr)/Math.log(2) - 8)); }
					else {
						// int ruleOffset = (script.codePointAt(i) << 16) | script.codePointAt(i+1);
						testBuffer.append(c);
						testBuffer.append("swap?"); }
					i+=2;
					int rangeStart = script.codePointAt(i++);
					int rangeEnd = script.codePointAt(i++);
					if (rangeStart == 1 && rangeEnd == 1) {}
					else if (rangeStart == 1 && rangeEnd == 32)
						testBuffer.append(MultipassCodes.PASS_UNTIL);
					else if (rangeStart == rangeEnd)
						testBuffer.append(rangeStart);
					else {
						testBuffer.append(rangeStart);
						testBuffer.append('-');
						testBuffer.append(rangeEnd); }
					break;
				case MultipassCodes.PASS_GROUPSTART:
				case MultipassCodes.PASS_GROUPEND:
					// int ruleOffset = (script.codePointAt(i) << 16) | script.codePointAt(i+1);
					testBuffer.append(c);
					testBuffer.append("group?");
					i+=2;
					break;
				case MultipassCodes.PASS_ENDTEST:
					break;
				default: }
			if (c == MultipassCodes.PASS_ENDTEST)
				break; }
		
		StringBuffer actionBuffer = new StringBuffer();
		while (i < script.length()) {
			c = script.charAt(i++);
			switch (c) {
				case MultipassCodes.PASS_COPY:
				case MultipassCodes.PASS_OMIT:
					actionBuffer.append(c);
					break;
				case MultipassCodes.PASS_STRING:
				case MultipassCodes.PASS_DOTS:
					actionBuffer.append(c);
					int len = script.codePointAt(i++);
					if (c == MultipassCodes.PASS_STRING)
						actionBuffer.append(script.substring(i, i+len));
					else
						actionBuffer.append(Dots.toPattern(script.substring(i, i+len)));
					i+=len;
					break;
				case MultipassCodes.PASS_EQ:
					actionBuffer.append('#');
					actionBuffer.append(script.codePointAt(i++));
					actionBuffer.append(c);
					actionBuffer.append(script.codePointAt(i++));
					break;
				case MultipassCodes.PASS_HYPHEN:
				case MultipassCodes.PASS_PLUS:
					actionBuffer.append('#');
					actionBuffer.append(script.codePointAt(i++));
					actionBuffer.append(c);
					break;
				case MultipassCodes.PASS_GROUPSTART:
				case MultipassCodes.PASS_GROUPEND:
				case MultipassCodes.PASS_GROUPREPLACE:
					// int ruleOffset = (script.codePointAt(i) << 16) | script.codePointAt(i+1);
					testBuffer.append(c);
					testBuffer.append("group?");
					i+=2;
					break;
				case MultipassCodes.PASS_SWAP:
					// int ruleOffset = (script.codePointAt(i) << 16) | script.codePointAt(i+1);
					actionBuffer.append(c);
					testBuffer.append("swap?");
					i+=2;
					break;
				default: }}
		
		return new String[]{testBuffer.toString(), actionBuffer.toString()};
	}
}
