package com.sport.stream.impl;

public class VowelNotFoundException extends RuntimeException {
	
	public VowelNotFoundException() {
		super("Vowel not found.");
	}
}
