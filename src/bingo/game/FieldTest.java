package bingo.game;

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
}
