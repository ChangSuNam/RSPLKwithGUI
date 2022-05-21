import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This Class creates Jbuttons that creates each move of R P S K and L. It
 * utilizes MouseListener to receive user input. This Class was inspired by
 * Observer pattern example provided in Coursework.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Asssignment4 2.2
 *
 */
public class RPSKLCreatorButtonSet extends JFrame {

	/**
	 * Contructor that creates Jbuttons horizontaly, with MouseListeners.
	 * 
	 * @param inputLabel the JLabel used for GUI.
	 */
	public RPSKLCreatorButtonSet(JLabel inputLabel) {
		// g2d = new Graphics2D();

		JPanel buttonPanel = new JPanel();
		JButton rockButton = new JButton("R");
		rockButton.setHorizontalAlignment(SwingConstants.LEFT);
		JButton paperButton = new JButton("P");
		paperButton.setHorizontalAlignment(SwingConstants.LEFT);
		JButton scissorsButton = new JButton("S");
		scissorsButton.setHorizontalAlignment(SwingConstants.LEFT);
		JButton spockButton = new JButton("K");
		spockButton.setHorizontalAlignment(SwingConstants.LEFT);
		JButton lizardButton = new JButton("L");
		lizardButton.setHorizontalAlignment(SwingConstants.LEFT);

		rockButton.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				System.out.println("set move to rock");
				playerMove = "rock";
				BattleField.setMove(playerMove);
				inputLabel.repaint();

			}
		});

		paperButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("set move to paper");
				playerMove = "paper";
				BattleField.setMove(playerMove);
				// inputLabel.update(inputLabel.getGraphics());
				inputLabel.repaint();
			}
		});

		scissorsButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("set move to scissors");
				playerMove = "scissors";
				BattleField.setMove(playerMove);
				inputLabel.repaint();
			}
		});

		spockButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("set move to spock");
				playerMove = "spock";
				BattleField.setMove(playerMove);
				inputLabel.repaint();
			}
		});

		lizardButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("set move to lizard");
				playerMove = "lizard";
				BattleField.setMove(playerMove);
				inputLabel.repaint();
			}
		});

		buttonPanel.add(rockButton);
		buttonPanel.add(paperButton);
		buttonPanel.add(scissorsButton);
		buttonPanel.add(lizardButton);
		buttonPanel.add(spockButton);

		// buttonPanel.add(buttonLabel);

		add(buttonPanel, BorderLayout.NORTH);

	}

	/**
	 * playerMove the value that reflects R,P,S,K or L to be played.
	 */
	private String playerMove;

}
