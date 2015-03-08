import java.awt.*;

import javax.swing.*;

public class Tablero {
	protected JPanel[][] squares;
	protected JFrame boardFrame;
	protected static Container container2;
	protected static Container container;
	protected static JPanel p = new JPanel();
	protected static JLabel[][] text;

	/** Creates a new instance of Board */
	public Tablero() {
		boardFrame = new JFrame();
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = boardFrame.getContentPane();
		container.setLayout(new GridLayout(8, 8));
		create_squares();
		boardFrame.setSize(400, 450);
	}

	private void create_squares() {

		squares = new JPanel[8][8];
		text = new JLabel[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JPanel p = new JPanel();
				text[i][j] = new JLabel("");
				text[i][j].setForeground(Color.red);
				// p.setBackground(setColor(i, j));
				squares[i][j] = new JPanel();
				squares[i][j].setBackground(setColor(i, j));
				squares[i][j].add(text[i][j]);
				container.add(squares[i][j]);
			}
		}
	}

	public void setQueen(int i, int j) {
		text[i][j].setText("Q");

	}
	public void show(){
		boardFrame.setVisible(true);
	}
	public void clear() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				text[i][j].setText("");
			}
		}
	}

	private Color setColor(int x, int y) {
		if ((x + y) % 2 == 0)
			return Color.WHITE;
		else
			return Color.BLACK;
	}

	public static void main(String args[]) {
		Tablero A = new Tablero();
		A.setQueen(1, 1);

	}

}