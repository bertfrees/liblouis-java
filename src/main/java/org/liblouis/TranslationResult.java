package org.liblouis;

import java.util.Arrays;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class TranslationResult {
	
	private String braille = null;
	private boolean[] hyphenPositions = null;
	private int[] outputPositions = null;
	private int[] inputPositions = null;
	private TranslationRule[] ruleTrace = null;
	
	public TranslationResult(
			WideString outbuf,
			IntByReference outlen,
			byte[] outputHyphens) {
		
		this.braille = outbuf.read(outlen.getValue());
		if (outputHyphens != null) {
			this.hyphenPositions = new boolean[outlen.getValue()-1];
			for (int i=0; i<hyphenPositions.length; i++)
				hyphenPositions[i] = (outputHyphens[i+1] == '1'); }
	}
	
	public TranslationResult(
			WideString outbuf,
			IntByReference inlen,
			IntByReference outlen,
			int[] outputPos,
			int[] inputPos,
			Pointer rules,
			IntByReference rulesLen) {
		
		this(outbuf, outlen, null);
		this.outputPositions = Arrays.copyOf(outputPos, inlen.getValue());
		this.inputPositions = Arrays.copyOf(inputPos, outlen.getValue());
		this.ruleTrace = new TranslationRule[rulesLen.getValue()];
		int i = 0;
		for (Pointer p : rules.getPointerArray(0, rulesLen.getValue()))
			ruleTrace[i++] = new TranslationRule(p);
	}
	
	public String getBraille() {
		return braille;
	}
	
	public boolean[] getHyphenPositions() {
		return hyphenPositions;
	}
	
	public int[] getOutputPositions() {
		return outputPositions;
	}
	
	public int[] getInputPositions() {
		return inputPositions;
	}
	
	public TranslationRule[] getRuleTrace() {
		return ruleTrace;
	}
}