package bingo.game;

import java.util.Arrays;

public class Lototron {

	private int[] Numbers;
	private int nextNumber;
	private int currentNumber;
	private LototronResult gameType = LototronResult.WIN_CORNER;

	public Lototron() {
		this.Numbers = new int[41];

		for (int i = 0; i < this.Numbers.length; i++) {
			int number;
			do {
				number = (int) (Math.random() * 75 + 1);
			} while (Arrays.binarySearch(this.Numbers, number) > -1);
			this.Numbers[i] = number;
		}
	}

	// Returns lototron number next random number.
	// When run out of numbers, 0 is returned
	public int getNextNumber() {
		if (this.nextNumber >= this.Numbers.length) {
			return 0;
		} else {

			this.currentNumber = this.Numbers[nextNumber];
			this.nextNumber++;

			return currentNumber;
		}

	}

	@SuppressWarnings("incomplete-switch")
	public LototronResult checkTicket(Ticket ticket) {
		Field field = ticket.findField(currentNumber);

		if (field != null) {
			field.match = true;

			switch (gameType) {
			case WIN_CORNER:
				if (checkCornerWin(ticket)) {
					gameType = LototronResult.WIN_DIAG;
					return LototronResult.WIN_CORNER;
				}
				break;
			case WIN_DIAG:
				if (checkDiagWin(ticket)) {
					gameType = LototronResult.WIN_FULL;
					return LototronResult.WIN_DIAG;
				}
				break;
			case WIN_FULL:
				if (checkFullWin(ticket)) {
					return LototronResult.WIN_FULL;
				}
				break;
			}

			if (nextNumber == 33 && gameType != LototronResult.WIN_DIAG) {
				gameType = LototronResult.WIN_DIAG;
			}
			if (nextNumber == 38 && gameType != LototronResult.WIN_FULL) {
				gameType = LototronResult.WIN_FULL;
			}

			return LototronResult.HIT;
		}

		return LototronResult.NONE;
	}

	private boolean checkCornerWin(Ticket ticket) {
		return nextNumber < 33 && ticket.Fields[0][0].match && ticket.Fields[0][4].match && ticket.Fields[4][0].match
				&& ticket.Fields[4][4].match;
	}

	private boolean checkDiagWin(Ticket ticket) {
		boolean checkDiag = true;
		for (int i = 0; i < ticket.Fields.length; i++) {
			for (int j = 0; j < ticket.Fields.length; j++) {
				if (i == j && i + j == Numbers.length - 1) {
					if (!ticket.Fields[i][j].match) {
						checkDiag = false;
					}
				}
			}
		}
		return nextNumber < 38 && checkDiag;
	}

	private boolean checkFullWin(Ticket ticket) {
		boolean checkFull = true;
		for (int i = 0; i < ticket.Fields.length; i++) {
			for (int j = 0; j < ticket.Fields.length; j++) {
				if (!ticket.Fields[i][j].match) {
					checkFull = false;
				}

			}
		}
		return checkFull;
	}

	public static char getLetter(int number) {
		int index = (int) ((number - 1) / 15);
		return "BINGO".charAt(index);
	}
}