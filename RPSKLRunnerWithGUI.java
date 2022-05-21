import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a Runner class with a main method that creates GUI for RPSKL.
 *
 ** This code was inspired by Assignment 4.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment6 2.1
 */

public class RPSKLRunnerWithGUI {

	public static void main(String[] args) {

		JFrame frameForRPSKL = new JFrame();

		final MovesGenerator movesRecord = new MovesGenerator();

		final BattleField battleFieldForRPSKL = new BattleField(500, 500, 1, "rock");

		movesRecord.addMove(battleFieldForRPSKL);

		final IconOfRPSKL iconForRPSKL = new IconOfRPSKL(movesRecord, ICON_W, ICON_H);
		final JLabel labelForRPSKL = new JLabel(iconForRPSKL);

		MouseMotionManager RPSKLMouseMotionListner = new MouseMotionManager(labelForRPSKL);

		frameForRPSKL.add(labelForRPSKL);
		frameForRPSKL.setLayout(new FlowLayout());
		frameForRPSKL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameForRPSKL.pack();
		frameForRPSKL.setVisible(true);

		RPSKLCreatorButtonSet moveGenerator = new RPSKLCreatorButtonSet(labelForRPSKL);
		moveGenerator.pack();
		moveGenerator.setVisible(true);

	}

	/**
	 * ICON_W the width of icon, ICON_H the height of icon, playerMove the move
	 * player will do, either R P S K or L
	 */
	private static final int ICON_W = 1000;
	private static final int ICON_H = 1000;
	private static String playerMove;
}
