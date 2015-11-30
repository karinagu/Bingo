package bingo.game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ticket ticket = new Ticket();
		System.out.println(ticket);

		Lototron loto = new Lototron();

		int nextNumber = loto.getNextNumber();

		while (nextNumber > 0) {
			LototronResult result = loto.checkTicket(ticket);
			PrintNumber(nextNumber, result, ticket);
			nextNumber = loto.getNextNumber();
			
			if(result==LototronResult.WIN_FULL){
				break;
			}
				
		}
	}

	static int counter = 0;

	static void PrintNumber(int number, LototronResult result, Ticket ticket) {
		counter++;
		System.out.print(counter + ": " + Lototron.getLetter(number) + " " + number);
		
		if (result != LototronResult.NONE) {
			System.out.println(" !" + result);
			System.out.println(ticket);
		} else
			System.out.println();
	}
}
