package br.com.kurauchi.desagil.tequilada;

public class HumanPlayer extends Player {
	public HumanPlayer(int row, int col) {
		super(row, col);
	}

	public void move(int rowShift, int colShift) {
		row += 2 * rowShift;
		col += 2 * colShift;
	}
}