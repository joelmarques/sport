package com.sport.stream.impl;

import java.util.HashSet;
import java.util.Set;

import com.sport.stream.api.Stream;

public class DefaultStreamVowel implements Stream {
	
	private static final String VOWELS = "aeiou";
	
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";

    private String stream;

    private int indexStream = -1;
    
    private Set<Character> processeds = new HashSet<Character>();
    
    public DefaultStreamVowel(String stream) {
        this.stream = stream;
    }
    
    @Override
    public char getNext() {
    	
        if (this.hasNext()) {
            return stream.charAt(indexStream);
        } 
        
        throw new VowelNotFoundException();
    }

    @Override
    public boolean hasNext() {
        
        for (;;) {
            
            indexStream++;
            
            if (stream.length() <= indexStream) {
            	return false;
            }

            char currentCharacter = stream.charAt(indexStream);

            if (!isVowel(currentCharacter)) {
                continue;
            }
            
            if (processeds.contains(Character.toLowerCase(currentCharacter))) {
            	continue;
            }

            if (indexStream < 2) {
                processeds.add(Character.toLowerCase(currentCharacter));
                continue;
            }

            char previousCharacter = stream.charAt(indexStream - 2);
            char character = stream.charAt(indexStream - 1);
            char nextCharacter = stream.charAt(indexStream);
            
            processeds.add(Character.toLowerCase(currentCharacter));

            if (isVowel(previousCharacter) && isConsonant(character) && isVowel(nextCharacter)) {
                return true;
            }
        }
    }

    private boolean isVowel(char character) {
        return VOWELS.indexOf(Character.toLowerCase(character)) > -1;
    }
    
    private boolean isConsonant(char character) {
        return CONSONANTS.indexOf(Character.toLowerCase(character)) > -1;
    }
}