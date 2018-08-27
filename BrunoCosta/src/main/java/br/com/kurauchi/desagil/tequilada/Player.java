package br.com.kurauchi.desagil.tequilada;

public class Player {
	protected int row;
	protected int col;

	public Player(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	void move(int rowShift, int colShift) {
		this.row += rowShift;
		this.col += colShift;
	}
}
