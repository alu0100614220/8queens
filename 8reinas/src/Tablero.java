import java.awt.*;

import javax.swing.*;

public class Tablero {
	protected JPanel[][] squares;
	protected JFrame boardFrame;
	protected static Container containerTop;
	protected static Container containerBot;
	protected static Container container;
	protected static JPanel p = new JPanel();
	protected static JLabel[][] text;

	/** Creates a new instance of Board */
	public Tablero() {
		boardFrame = new JFrame();
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = boardFrame.getContentPane();
		container.setLayout(new BorderLayout());
		
		containerTop = new Container();
		containerTop.setLayout(new GridLayout(8, 8));
		container.add(containerTop,BorderLayout.CENTER);
		containerBot = new Container();
		containerBot.setLayout(new GridLayout(1,1));
		containerBot.setSize(50,50);
		
		JLabel chuchu = new JLabel("s \n d\n");
		container.add(chuchu, BorderLayout.EAST);
		create_squares();
		//container.repaint();
		boardFrame.setSize(450, 450);
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
				containerTop.add(squares[i][j]);
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
		A.show();
	}

}