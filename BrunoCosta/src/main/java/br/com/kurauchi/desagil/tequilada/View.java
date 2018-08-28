package br.com.kurauchi.desagil.tequilada;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class View extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int CELL_SIZE = 50;

	private Model model;
	private Image cpuPlayerImage;
	private Image humanPlayerImage;
	private Image targetImage;

	public View(Model model) {
		this.model = model;

		cpuPlayerImage = loadImage("cpuPlayer");
		humanPlayerImage = loadImage("humanPlayer");
		targetImage = loadImage("target");

		setPreferredSize(
				new Dimension(model.getBoard().getNumCols() * CELL_SIZE, model.getBoard().getNumRows() * CELL_SIZE));
	}

	private Image loadImage(String filename) {
		URL url = getClass().getResource("/" + filename + ".png");
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}

	private void drawImage(Graphics g, Image image, Element element) {
		g.drawImage(image, element.getCol() * CELL_SIZE, element.getRow() * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < model.getBoard().getNumCols(); i++) {
			for (int j = 0; j < model.getBoard().getNumRows(); j++) {
				if (model.getBoard().isWall(j, i)) {
					g.setColor(Color.BLACK);
					g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
		}

		drawImage(g, cpuPlayerImage, model.getCpuPlayer());
		drawImage(g, humanPlayerImage, model.getHumanPlayer());
		drawImage(g, targetImage, model.getTarget());

		getToolkit().sync();
	}
}