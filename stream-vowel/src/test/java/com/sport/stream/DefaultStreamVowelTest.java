package com.sport.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sport.stream.api.Stream;
import com.sport.stream.impl.DefaultStreamVowel;
import com.sport.stream.impl.VowelNotFoundException;

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
	public void shouldNotReturnVowelE() {

		Stream stream = new DefaultStreamVowel("aAbBABacafi");

		Assert.assertFalse(stream.getNext() == 'e');
	}

	@Test
	public void shouldReturnVowelU() {

		Stream stream = new DefaultStreamVowel("blaibu");

		Assert.assertTrue(stream.getNext() == 'u');
	}
	
	@Test
	public void shouldNotHaveMoreToProcess() {

		Stream stream = new DefaultStreamVowel("hjukayekeke");
		Assert.assertTrue(stream.getNext() == 'a');
		Assert.assertTrue(stream.getNext() == 'e');
		Assert.assertFalse(stream.hasNext());
	}

	@Test
	public void shouldHaveMoreToProcess() {

		Stream stream = new DefaultStreamVowel("hjukayekeke");
		Assert.assertTrue(stream.getNext() == 'a');
		Assert.assertTrue(stream.hasNext());
	}
	
	@Test
	public void shouldProcessEverything() {

		Stream stream = new DefaultStreamVowel("hjukahkwe");
		Assert.assertTrue(stream.getNext() == 'a');
		Assert.assertFalse(stream.hasNext());
	}
	
	@Test
	public void shouldFindVowel() {

		Stream stream = new DefaultStreamVowel("Vowel Found");
		Assert.assertTrue(stream.getNext() == 'e');
	}

	@Test(expected = VowelNotFoundException.class)
	public void shouldNotFindVowel() {

		Stream stream = new DefaultStreamVowel("Not Found");
		stream.getNext();
	}
}
