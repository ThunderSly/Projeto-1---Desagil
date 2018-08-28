package br.com.kurauchi.desagil.tequilada;

public class Crumb {
	private int col;
	private int row;
	
	public Crumb(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
}
