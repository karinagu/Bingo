package bingo.game;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class FieldTest {

	@Test
	public void testField() {
		Field field = new Field(1);
		Assert.assertNotNull(field);
	}

	@Test(expected = NumberFormatException.class)
	public void testFieldFail() {
		Field field = new Field(99);
		Assert.assertNotNull(field);
	}

	@Test
	public void testGetLetterB() {
		Field field = new Field(1);
		char letter = field.GetLetter();
		Assert.assertEquals('B', letter);
	}

	@Test
	public void testGetLetterI() {
		Field field = new Field(16);
		char letter = field.GetLetter();
		Assert.assertEquals('I', letter);
	}

	@Test
	public void testGetLetterN() {
		Field field = new Field(31);
		char letter = field.GetLetter();
		Assert.assertEquals('N', letter);
	}

	@Test
	public void testGetLetterG() {
		Field field = new Field(46);
		char letter = field.GetLetter();
		Assert.assertEquals('G', letter);
	}

	@Test
	public void testGetLetterO() {
		Field field = new Field(61);
		char letter = field.GetLetter();
		Assert.assertEquals('O', letter);
	}
}
