package org.liblouis;

import com.sun.jna.FromNativeContext;
import com.sun.jna.NativeMapped;

public interface WideChar extends NativeMapped {
	
	public void setValue(char value);
	
	public char getValue();
	
	public static class ByValue implements WideChar {
		
		private char value;
		
		public ByValue() {
			this((char)0);
		}
		
		public ByValue(char value) {
			this.value = value;
		}
		
		@Override
		public void setValue(char value) {
			this.value = value;
		}
		
		@Override
		public char getValue() {
			return value;
		}
		
		@Override
		public Class<?> nativeType() {
			return (Constants.CHARSIZE == 2) ? Short.class : Integer.class;
		}
		
		@Override
		public Object toNative() {
			return (Constants.CHARSIZE == 2) ? (short)value : (int)value;
		}
		
		@Override
		public NativeMapped fromNative(Object nativeValue, FromNativeContext context) {
			return new ByValue((char)((Constants.CHARSIZE == 2) ?
					((Short)nativeValue).shortValue() :
					((Integer)nativeValue).intValue()));
		}
		
		@Override
		public String toString() {
			return String.valueOf(getValue());
		}
	}
	
	public static abstract class Constants {
		
		public static final int CHARSIZE;
		public static final String ENCODING;
		
		static {
			CHARSIZE = Louis.getLibrary().lou_charSize();
			switch (CHARSIZE) {
				case 2:
					ENCODING = "UTF-16LE";
					break;
				case 4:
					ENCODING = "UTF-32LE";
					break;
				default:
					throw new RuntimeException();
			}
		}
	}
}
