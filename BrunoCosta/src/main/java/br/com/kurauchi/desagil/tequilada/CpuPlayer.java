package br.com.kurauchi.desagil.tequilada;

import java.util.Stack;

public class CpuPlayer extends Player {

	private boolean[][] visitado;
	private int linhas;
	private int colunas;
	private Stack<Crumb> pilha;

	public CpuPlayer(Board board, int row, int col) {
		super(row, col);
		linhas = board.getNumRows();
		colunas = board.getNumCols();
		for (int i = 0; i <= colunas; i++) {
			for (int j = 0; j <= linhas; j++) {

				visitado[j][i] = board.isWall(j, i);

			}
		}

		visitado[row][col] = true;
		pilha = new Stack<>();
		Crumb inicio = new Crumb(row, col);
		pilha.push(inicio);
	}

	public void move() {
		while (!pilha.isEmpty()) {
			Crumb crumb = pilha.peek();
			int x = crumb.getRow();
			int y = crumb.getCol();
			if (x < linhas - 1 && !visitado[x + 1][y]) {
				move(1, 0);
				Crumb crumb1 = new Crumb(row, col);
				visitado[row][col] = true;
				pilha.push(crumb1);
			} else if (y < colunas - 1 && !visitado[x][y + 1]) {
				move(0, 1);
				Crumb crumb1 = new Crumb(row, col);
				visitado[row][col] = true;
				pilha.push(crumb1);
			} else if (y > 0 && !visitado[x][y - 1]) {
				move(0, -1);
				Crumb crumb1 = new Crumb(row, col);
				visitado[row][col] = true;
				pilha.push(crumb1);
			} else if (x > 0 && !visitado[x - 1][y]) {
				move(-1, 0);
				Crumb crumb1 = new Crumb(row, col);
				visitado[row][col] = true;
				pilha.push(crumb1);
			} else {
				pilha.pop();
			}
		}
	}
}