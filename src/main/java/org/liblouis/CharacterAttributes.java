package org.liblouis;

public abstract class CharacterAttributes {

	public static String decode(int attributes) {
		if (attributes == 0xFFFFFFFF)
			return String.valueOf(MultipassCodes.PASS_ANY);
		else {
			StringBuffer buffer = new StringBuffer();
			if ((attributes & CTC_SPACE) > 0) { buffer.append(MultipassCodes.PASS_SPACE); }
			if ((attributes & CTC_LETTER) > 0) { buffer.append(MultipassCodes.PASS_LETTER); }
			if ((attributes & CTC_DIGIT) > 0) { buffer.append(MultipassCodes.PASS_DIGIT); }
			if ((attributes & CTC_PUNCTUATION) > 0) { buffer.append(MultipassCodes.PASS_PUNCTUATION); }
			if ((attributes & CTC_UPPERCASE) > 0) { buffer.append(MultipassCodes.PASS_UPPERCASE); }
			if ((attributes & CTC_LOWERCASE) > 0) { buffer.append(MultipassCodes.PASS_LOWERCASE); }
			if ((attributes & CTC_MATH) > 0) { buffer.append(MultipassCodes.PASS_MATH); }
			if ((attributes & CTC_SIGN) > 0) { buffer.append(MultipassCodes.PASS_SIGN); }
			if ((attributes & CTC_LITDIGIT) > 0) { buffer.append(MultipassCodes.PASS_LITDIGIT); }
			if ((attributes & CTC_CLASS1) > 0) { buffer.append(MultipassCodes.PASS_CLASS1); }
			if ((attributes & CTC_CLASS2) > 0) { buffer.append(MultipassCodes.PASS_CLASS2); }
			if ((attributes & CTC_CLASS3) > 0) { buffer.append(MultipassCodes.PASS_CLASS3); }
			if ((attributes & CTC_CLASS4) > 0) { buffer.append(MultipassCodes.PASS_CLASS4); }
			return buffer.toString(); }
	}

	public static final int CTC_SPACE = 1;
	public static final int CTC_LETTER = 2;
	public static final int CTC_DIGIT = 4;
	public static final int CTC_PUNCTUATION = 8;
	public static final int CTC_UPPERCASE = 16;
	public static final int CTC_LOWERCASE = 32;
	public static final int CTC_MATH = 64;
	public static final int CTC_SIGN = 128;
	public static final int CTC_LITDIGIT = 256;
	public static final int CTC_CLASS1 = 512;
	public static final int CTC_CLASS2 = 1024;
	public static final int CTC_CLASS3 = 2048;
	public static final int CTC_CLASS4 = 4096;

}
