package bingo.game;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LototronTest {
	
	@Test
	public void testLototronNumbersRange() {

		Lototron loto = new Lototron();
		int nextNumber;
		do {
			nextNumber = loto.getNextNumber();

			if (nextNumber > 75) fail("out of range");
		} while (nextNumber > 0);

	}
	
	@Test
	public void testGetLetterB() {
		char letter = Lototron.getLetter(1);
		Assert.assertEquals('B', letter);
	}

	@Test
	public void testGetLetterI() {
		char letter = Lototron.getLetter(16);
		Assert.assertEquals('I', letter);
	}

	@Test
	public void testGetLetterN() {
		char letter = Lototron.getLetter(31);
		Assert.assertEquals('N', letter);
	}

	@Test
	public void testGetLetterG() {
		char letter = Lototron.getLetter(46);
		Assert.assertEquals('G', letter);
	}

	@Test
	public void testGetLetterO() {
		char letter = Lototron.getLetter(61);
		Assert.assertEquals('O', letter);
	}
	@Test
	public void testGetLetterO2() {
		char letter = Lototron.getLetter(75);
		Assert.assertEquals('O', letter);
	}
}
