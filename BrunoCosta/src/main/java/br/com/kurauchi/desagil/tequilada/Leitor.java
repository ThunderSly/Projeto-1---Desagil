package br.com.kurauchi.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new FileReader("incremento2.txt"));

		String primeiralinha = br.readLine();

		String[] partes = primeiralinha.split(" ");

		int linhas = Integer.parseInt(partes[0]);
		int colunas = Integer.parseInt(partes[1]);

		String linha_atual;

		while ((linha_atual = br.readLine()) != null) {

			for (int i = 0; i < colunas; i++) {

				if (linha_atual.charAt(i) == '#') {

					sb.append("X");
				}

				else {

					sb.append(" ");
				}
			}

			sb.append(System.lineSeparator());
		}

		String finale = sb.toString();
		br.close();
		System.out.println(finale);

	}
}