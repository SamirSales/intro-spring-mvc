package io.github.samirsales.curso.domain;

public enum Gender {
	FEMALE('F'), MALE('M');
	
	private char value;
	
	private Gender(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
