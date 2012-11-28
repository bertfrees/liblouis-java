package org.liblouis;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

public class TranslationRule extends Structure {
	
	private static final int DEFAULTRULESIZE = 50;
	
	public final int charsnext;
	public final int dotsnext;
	public final int after;
	public final int before;
	public final int opcode;
	public final short charslen;
	public final short dotslen;
	public final WideChar.ByValue[] charsdots = new WideChar.ByValue[DEFAULTRULESIZE];
	
	{ charsnext = dotsnext = after = before = opcode = charslen = dotslen = 0; }
	
	private IntByReference opcodeByReference = new IntByReference();
	private WideString chars = null;
	private Dots dots = null;
	private MultipassScript script = null;
	
	private int origOpcode = 0;
	private boolean enabled = true;
	
	public TranslationRule() {
		super();
		setFieldOrder(new String[]{
				"charsnext",
				"dotsnext",
				"after",
				"before",
				"opcode",
				"charslen",
				"dotslen",
				"charsdots"});
	}
	
	public TranslationRule(Pointer p) {
		this();
		useMemory(p);
	}
	
	@Override
	protected void useMemory(Pointer p) {
		super.useMemory(p);
		read();
		origOpcode = opcode;
		opcodeByReference.setPointer(p.share(fieldOffset("opcode")));
		switch (origOpcode) {
			case Opcodes.CTO_CONTEXT:
			case Opcodes.CTO_CORRECT:
			case Opcodes.CTO_SWAPCD:
			case Opcodes.CTO_SWAPDD:
			case Opcodes.CTO_PASS2:
			case Opcodes.CTO_PASS3:
			case Opcodes.CTO_PASS4:
				script = new MultipassScript(p.share(fieldOffset("charsdots")), charslen, dotslen);
				chars = dots = null;
				break;
			default:
				chars = new WideString(p.share(fieldOffset("charsdots")), 0, charslen);
				dots = new Dots(p.share(fieldOffset("charsdots")), charslen, dotslen);
				script = null; }
	}
	
	public int getOpcode() {
		return origOpcode;
	}
	
	public WideString getChars() {
		return chars;
	}
	
	public Dots getDots() {
		return dots;
	}
	
	public MultipassScript getScript() {
		return script;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void toggle() {
		if (enabled) {
			if (opcode == Opcodes.CTO_NONE) { return; }
			opcodeByReference.setValue(Opcodes.DISABLED);
			enabled = false; }
		else {
			opcodeByReference.setValue(origOpcode);
			enabled = true; }
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			TranslationRule that = (TranslationRule)obj;
			return this.getPointer().equals(that.getPointer()); }
		catch (ClassCastException e) {
			return false; }
	}
	
	@Override
	public int hashCode() {
		return getPointer().hashCode();
	}
}
