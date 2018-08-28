package br.com.kurauchi.desagil.tequilada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		model.update();
		view.repaint();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("pressionei cima!");

			if (!model.getBoard().isWall(model.getHumanPlayer().getRow() - 1, model.getHumanPlayer().getCol())) {
				if (model.getHumanPlayer().getRow() > 0) {
					this.model.getHumanPlayer().move(-1, 0);
					System.out.println(model.getHumanPlayer().getRow());
				}

			}

		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("pressionei direita!");

			if (!model.getBoard().isWall(model.getHumanPlayer().getRow(), model.getHumanPlayer().getCol() + 1)
					&& model.getHumanPlayer().getCol() < model.getBoard().getNumCols()) {
				this.model.getHumanPlayer().move(0, 1);
				System.out.println(model.getHumanPlayer().getCol());
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("pressionei esquerda!");

			if (!model.getBoard().isWall(model.getHumanPlayer().getRow(), model.getHumanPlayer().getCol() - 1)
					&& model.getHumanPlayer().getCol() > 0) {
				this.model.getHumanPlayer().move(0, -1);
				System.out.println(model.getHumanPlayer().getCol());
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("pressionei baixo!");

			if (!model.getBoard().isWall(model.getHumanPlayer().getRow() + 1, model.getHumanPlayer().getCol())
					&& model.getHumanPlayer().getRow() < model.getBoard().getNumRows()) {
				this.model.getHumanPlayer().move(1, 0);
				System.out.println(model.getHumanPlayer().getRow());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}