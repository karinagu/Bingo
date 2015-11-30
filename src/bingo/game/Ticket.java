package bingo.game;

public class Ticket {

	public Field[][] Fields;

	public Ticket() {
		this.Fields = new Field[5][5];
		boolean[] unique = new boolean[75];

		for (int i = 0; i < this.Fields.length; i++) {

			int min = 15 * i + 1;

			for (int j = 0; j < this.Fields.length; j++) {
				int number;
				do {
					number = (int) (Math.random() * 15) + min;
				} while (unique[number - 1]);

				unique[number - 1] = true;
				this.Fields[i][j] = new Field(number);

			}

		}
	}

	public String toString() {
		String print = "+---+---+---+---+---+\n| B | I | N | G | O |\n";
		String separatorLine = "+---+---+---+---+---+\n";
		for (int i = 0; i < this.Fields.length; i++) {
			print = print + separatorLine;

			for (int j = 0; j < this.Fields.length; j++) {
				print = String.format("%s|%3s", print, this.Fields[j][i]);
			}

			print = print + "|\n";
		}
		print = print + "+---+---+---+---+---+\n";
		return print;

	}

	public Field findField(int i) {
		// TODO Auto-generated method stub
		for (Field field : this.Fields[(i-1)/15]) {
			if(field.getNumber()==i){
				return field;
			}
		}
		return null;
	}

}
