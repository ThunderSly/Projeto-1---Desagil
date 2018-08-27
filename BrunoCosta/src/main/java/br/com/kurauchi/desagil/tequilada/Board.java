package br.com.kurauchi.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	boolean[][] isWall;
	private int linhas;
	private int colunas;

	public Board(String path) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			String primeiralinha = br.readLine();

			String[] partes = primeiralinha.split(" ");

			linhas = Integer.parseInt(partes[0]);
			colunas = Integer.parseInt(partes[1]);

			isWall = new boolean[linhas][colunas];

			String linha_atual;

			int j = 0;
			while ((linha_atual = br.readLine()) != null) {

				for (int i = 0; i < colunas; i++) {

					if (linha_atual.charAt(i) == '#') {

						isWall[j][i] = true;
					}

					else if (linha_atual.charAt(i) != '#') {

						isWall[j][i] = false;
					}
				}
				j++;

			}

			br.close();
		}

		catch (FileNotFoundException exception) {
			System.out.println(exception);
		}

		catch (IOException exception) {
			System.out.println(exception);
		}
	}

	public int getNumRows() {
		return linhas;
	}

	public int getNumCols() {
		return colunas;
	}
	
	public boolean isWall(int row, int col) {
	     return isWall[row][col];
	 }

}
