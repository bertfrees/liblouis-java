package org.liblouis;

import com.sun.jna.Pointer;

public class Dots extends WideString {

	public Dots(Pointer p, int offset, int length) {
		super(p, offset, length);
	}

	public String toPattern() {
		return toPattern(super.read(length()));
	}

	@Override
	public String toString() {
		return toPattern();
	}

	public static String toPattern(String dots) {
		StringBuffer buffer = new StringBuffer();
		if (dots.isEmpty())
			return "";
		for (int i=0; i<dots.length(); i++) {
			buffer.append('-');
			int cp = dots.codePointAt(i);
			if (cp == B16)
				buffer.append('0');
			else {
				if ((cp & B1) > 0) { buffer.append('1'); }
				if ((cp & B2) > 0) { buffer.append('2'); }
				if ((cp & B3) > 0) { buffer.append('3'); }
				if ((cp & B4) > 0) { buffer.append('4'); }
				if ((cp & B5) > 0) { buffer.append('5'); }
				if ((cp & B6) > 0) { buffer.append('6'); }
				if ((cp & B7) > 0) { buffer.append('7'); }
				if ((cp & B8) > 0) { buffer.append('8'); }
				if ((cp & B9) > 0) { buffer.append('9'); }
				if ((cp & B10) > 0) { buffer.append('a'); }
				if ((cp & B11) > 0) { buffer.append('b'); }
				if ((cp & B12) > 0) { buffer.append('c'); }
				if ((cp & B13) > 0) { buffer.append('d'); }
				if ((cp & B14) > 0) { buffer.append('e'); }
				if ((cp & B15) > 0) { buffer.append('f'); }}}
		return (buffer.deleteCharAt(0).toString());
	}

	private static final int B1 = 1;
	private static final int B2 = 2;
	private static final int B3 = 4;
	private static final int B4 = 8;
	private static final int B5 = 16;
	private static final int B6 = 32;
	private static final int B7 = 64;
	private static final int B8 = 128;
	private static final int B9 = 256;
	private static final int B10 = 512;
	private static final int B11 = 1024;
	private static final int B12 = 2048;
	private static final int B13 = 4096;
	private static final int B14 = 8192;
	private static final int B15 = 16384;
	private static final int B16 = 32768;

}
