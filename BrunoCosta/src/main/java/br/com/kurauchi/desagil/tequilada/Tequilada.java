package br.com.kurauchi.desagil.tequilada;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Tequilada {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Model model = new Model();

				View view = new View(model);

				Controller controller = new Controller(model, view);

				JFrame frame = new JFrame();

				frame.setContentPane(view);

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setResizable(false);

				frame.pack();

				frame.setVisible(true);

				frame.addKeyListener(controller);

				Timer timer = new Timer(100, controller);

				timer.start();
			}
		});
	}
}