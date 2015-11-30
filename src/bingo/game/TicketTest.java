package bingo.game;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class TicketTest {

	// Check for fields count on ticket.
	// Must be 25
	@Test
	public void testTicketFields() {
		Ticket ticket = new Ticket();

		int sum = 0;
		for (Field[] cols : ticket.Fields) {
			sum = sum + cols.length;
		}

		Assert.assertEquals(25, sum);
	}

	@Test
	public void testTicketFieldNr() {
		Ticket ticket = new Ticket();
		boolean[] uniqe = new boolean[75];

		for (int i = 0; i < ticket.Fields.length; i++) {
			for (int j = 0; j < ticket.Fields[i].length; j++) {

				int value = ticket.Fields[i][j].getNumber();

				if (uniqe[value - 1] == true) {
					fail("Dublicated value:" + value);
				}

				uniqe[value - 1] = true;
			}
		}

	}
}