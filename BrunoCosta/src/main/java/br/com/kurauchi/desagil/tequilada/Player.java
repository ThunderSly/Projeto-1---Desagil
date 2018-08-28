package br.com.kurauchi.desagil.tequilada;

public abstract class Player extends Element {
	   protected Player(int row, int col) {
	     super(row, col);
	   }
	 
	  public void move(int rowShift, int colShift) {
	     row += rowShift;
	     col += colShift;
	   }
	 }