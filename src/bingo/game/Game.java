package bingo.game;

import bingo.external.TextIO;

/**
 * 
 * The Bingo Game
 */
public class Game {

	public static void main(String[] args) {
		System.out.print("Hello player, please input your name and group: ");
		String nameAndGroup = TextIO.getlnString();

		Ticket ticket = new Ticket();
		System.out.println(ticket);

		Lototron loto = new Lototron();

		int nextNumber = loto.getNextNumber();

		while (nextNumber > 0) {
			LototronResult result = loto.checkTicket(ticket);
			PrintNumber(nextNumber, result, ticket, nameAndGroup);

			if (result == LototronResult.WIN_FULL) {
				break;
			}

			nextNumber = loto.getNextNumber();
		}
	}

	static int counter = 0;

	/**
	 * Formating lototron number for showing in console
	 * 
	 * @param number
	 *            lototron number
	 * @param result
	 *            ticket check result
	 * @param ticket
	 *            ticket
	 */
	static void PrintNumber(int number, LototronResult result, Ticket ticket, String nameAndGroup) {
		counter++;
		System.out.print(counter + ": " + Lototron.getLetter(number) + " " + number);

		if (result == LototronResult.NONE) {
			System.out.println();
		} else {
			System.out.println(" !" + result);
			
			if (result == LototronResult.WIN_CORNER || result == LototronResult.WIN_DIAG
					|| result == LototronResult.WIN_FULL) {

				System.out.println("Congratulations, " + nameAndGroup + " ,you are the winner of the game " + result);
			}
			System.out.println(ticket);			
		}
	}
}
