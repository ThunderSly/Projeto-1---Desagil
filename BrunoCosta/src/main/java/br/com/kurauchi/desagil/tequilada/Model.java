package br.com.kurauchi.desagil.tequilada;

public class Model {
	private Board board;
	private CpuPlayer cpuPlayer;
	private HumanPlayer humanPlayer;

	public Model() {
		board = new Board("incremento2.txt");

		cpuPlayer = new CpuPlayer(board, board.getNumRows() - 1, board.getNumCols() - 1);
		humanPlayer = new HumanPlayer(0, 0);
	}

	public void update() {
		cpuPlayer.move(1, 2);
	}

	public Board getBoard() {
		return board;
	}

	public CpuPlayer getCpuPlayer() {
		return cpuPlayer;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}
}
