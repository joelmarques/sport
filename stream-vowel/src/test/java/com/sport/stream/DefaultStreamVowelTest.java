package com.sport.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sport.stream.api.Stream;
import com.sport.stream.impl.DefaultStreamVowel;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultStreamVowelTest {
	
	@Test
	public void shouldReturnVowelE() {
		
		Stream stream = new DefaultStreamVowel("aAbBABacafe");
		
		Assert.assertTrue(stream.getNext() == 'e');
	}
	
	@Test
	public void shouldReturnVowelU() {
		
		Stream stream = new DefaultStreamVowel("blaibu");
		
		Assert.assertTrue(stream.getNext() == 'u');
	}
}
