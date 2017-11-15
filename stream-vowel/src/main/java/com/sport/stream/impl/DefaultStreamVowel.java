package com.sport.stream.impl;

import com.sport.stream.api.Stream;

public class DefaultStreamVowel implements Stream {
	
	private String input;
	
	public DefaultStreamVowel(String input) {
		this.input = input;
	}

	@Override
	public boolean hasNext() {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char getNext() {
		// TODO Auto-generated method stub
		return 0;
	}

}
