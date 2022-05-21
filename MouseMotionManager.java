import java.awt.*;
import java.util.HashMap;
import java.awt.event.*;
import javax.swing.*;

/**
 * This Class utilizes MouseListner and MouseMotionListner to retrieve the
 * player's input. This Class was inspired by car component example provided in
 * Coursework.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Asssignment6 2.2
 *
 */
public class MouseMotionManager {
	/**
	 * Contructor that created MouseListener and MouseMotionListener, and specify
	 * what to do when mouse is pressed or dragged.
	 * 
	 * @param inputLabel the Jlabel that MouseMotionListener will refer to
	 */
	public MouseMotionManager(JLabel inputLabel) {
		locationOfShapes = new HashMap<Point, String>();

		inputLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse Pressed");
				mousePoint = e.getPoint();
				if (!inputLabel.contains(mousePoint)) {
					mousePoint = null;
				}
			}
		});

		inputLabel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				System.out.println("Mouse dragged");
				if (mousePoint != null) {
					Point lastMousePoint = mousePoint;
					mousePoint = e.getPoint();
					int mouseX = e.getX();
					int mouseY = e.getY();

					for (BattleField battleFieldObject : MovesGenerator.battleFieldArrayList) {
						Point currentPoint = battleFieldObject.getPoint();
						int dragBoundaryMaxX = battleFieldObject.getDraggableX();
						int dragBoundaryMaxY = battleFieldObject.getDraggableY();
						int dragBoundaryMinX = battleFieldObject.getX();
						int dragBoundaryMinY = battleFieldObject.getY();

						if (dragBoundaryMinX <= mouseX && dragBoundaryMaxX >= mouseX && dragBoundaryMinY <= mouseY
								&& dragBoundaryMaxY >= mouseY) { // if approximately clicking the created diagram

							double dx = mousePoint.getX() - lastMousePoint.getX();
							double dy = mousePoint.getY() - lastMousePoint.getY();
							BattleField.translate((int) dx, (int) dy);

							inputLabel.repaint();
						}
						locationOfShapes.put(lastMousePoint, "PLAYERMOVE");

					}
				}
			}
		});

	}

	/**
	 * mousePoint the point where mouse is.
	 */
	private Point mousePoint;
	private HashMap<Point, String> locationOfShapes;

}