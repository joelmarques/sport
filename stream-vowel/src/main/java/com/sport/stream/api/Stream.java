package com.sport.stream.api;

public interface Stream {
	
	/**
	 * Return the next character to be processed in the stream.
	 */	
	public char getNext();
	
	/**
	 * return if the stream still contains characters to process.
	 */
	public boolean hasNext();
}
