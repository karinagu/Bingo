package bingo.game;

/**
 * 
 * Lototron generates random Bingo numbers and performs Bingo
 *         ticket checks
 */
public class Lototron {

	private int[] Numbers;
	private int nextNumberIndex;
	private int currentNumber;
	private LototronResult gameType = LototronResult.WIN_CORNER;

	/**
	 * Generates unique random Bingo numbers on initialisation 41 numbers in
	 * range 1-75
	 */
	public Lototron() {
		boolean[] unique = new boolean[75];
		this.Numbers = new int[41];

		for (int i = 0; i < this.Numbers.length; i++) {
			int number;
			do {
				number = (int) (Math.random() * 75 + 1);
			} while (unique[number - 1]);
			unique[number - 1] = true;
			this.Numbers[i] = number;
		}

	}

	/**
	 * Returns lototron next random number. When run out of numbers, 0 is
	 * returned
	 * 
	 * @return 0 or random number
	 */
	public int getNextNumber() {
		if (this.nextNumberIndex >= this.Numbers.length) {
			return 0;
		} else {
			this.currentNumber = this.Numbers[this.nextNumberIndex];
			this.nextNumberIndex++;

			return currentNumber;
		}

	}

	/**
	 * Checking Bingo ticket for match and winnings
	 * 
	 * @param ticket Ticket for check
	 * @return check result
	 */
	@SuppressWarnings("incomplete-switch")
	public LototronResult checkTicket(Ticket ticket) {
		Field field = ticket.findField(currentNumber);

		if (field != null) {
			field.match = true;

			switch (this.gameType) {
			case WIN_CORNER:
				if (checkCornerWin(ticket)) {
					this.gameType = LototronResult.WIN_DIAG;
					return LototronResult.WIN_CORNER;
				}
				break;
			case WIN_DIAG:
				if (checkDiagWin(ticket)) {
					this.gameType = LototronResult.WIN_FULL;
					return LototronResult.WIN_DIAG;
				}
				break;
			case WIN_FULL:
				if (checkFullWin(ticket)) {
					return LototronResult.WIN_FULL;
				}
				break;
			}

			if (this.nextNumberIndex == 34) {
				this.gameType = LototronResult.WIN_DIAG;
			}
			else if (this.nextNumberIndex == 39) {
				this.gameType = LototronResult.WIN_FULL;
			}

			return LototronResult.HIT;
		}

		return LototronResult.NONE;
	}

	/**
	 * check corner win
	 * 
	 * @param ticket
	 * @return
	 */
	private boolean checkCornerWin(Ticket ticket) {
		boolean checkCorner= this.nextNumberIndex <= 33 && ticket.Fields[0][0].match && ticket.Fields[0][4].match && ticket.Fields[4][0].match
				&& ticket.Fields[4][4].match;
		return checkCorner;
	}

	/**
	 * check diagonal win
	 * 
	 * @param ticket
	 * @return
	 */
	private boolean checkDiagWin(Ticket ticket) {
		if(nextNumberIndex >38){
			return false;
		}
		boolean checkDiag = true;
		for (int i = 0; i < ticket.Fields.length; i++) {
			for (int j = 0; j < ticket.Fields.length; j++) {
				if (i == j || (i + j) == (Numbers.length - 1)) {
					if (ticket.Fields[i][j].match==false) {
						checkDiag = false;
					}
				}
			}
		}

		return checkDiag;
	}

	/**
	 * check full win
	 * 
	 * @param ticket
	 * @return
	 */
	private boolean checkFullWin(Ticket ticket) {
		boolean checkFull = true;
		for (int i = 0; i < ticket.Fields.length; i++) {
			for (int j = 0; j < ticket.Fields.length; j++) {
				if (ticket.Fields[i][j].match == false) {
					checkFull = false;
				}

			}
		}
		return checkFull;
	}

	/**
	 * Get character from Bingo number
	 * 
	 * @param number Bingo number
	 * @return character
	 */
	public static char getLetter(int number) {
		int index = (int) ((number - 1) / 15);
		return "BINGO".charAt(index);
	}
}