import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

/**
 * This class contains methods to create and draw a car. It implements the
 * interface Movable. This code was suggested by StickFigure on Coursework.
 *
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment4 2.1
 */
public class BattleField implements Draggable {

	/**
	 * Constructor that sets coordinate and unit for car.
	 * 
	 * @param x    the x Coordinate of the car
	 * @param y    the y Coordinate of the car
	 * @param unit the unit of size of the acr
	 */
	public BattleField(int x, int y, double unit, String playerMove) {
		//battleFieldArrayList = new ArrayList<Point>();
		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
		this.playerMove = playerMove;
	}

	public BattleField(int x, int y, double unit) {
		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
		this.playerMove = "rock"; // rock by default
	}

	public static void translate(int xChange, int yChange) {
		Point oldPoint = new Point(x, y);
		//for (Point p : battleFieldArrayList) {
		//	if (p == oldPoint) {
		//		int indexToRemove = battleFieldArrayList.indexOf(p);
		//		battleFieldArrayList.remove(indexToRemove);
		//	}
		//}
		x += xChange;
		y += yChange;
//		Point pointToBeAdded = new Point(x, y);
//		battleFieldArrayList.add(pointToBeAdded);
	}

	public static void setMove(String newMove) {
		playerMove = newMove;
	}
	
	
	public String getMove() {
		return playerMove;
	}

	public Point getPoint() {
		int x = this.x;
		int y= this.y;
		Point currentPoint = new Point(x,y);
		return currentPoint;
	}
	
	public int getDraggableX() {
		return draggableX;
	}
	public int getDraggableY() {
		return draggableY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
//	
//
//	public void removePoint(int pointIndex) {
//		for (Point p : battleFieldArrayList) {
//			int indexToRemove = battleFieldArrayList.indexOf(p);
//			battleFieldArrayList.remove(indexToRemove);
//		}
//	}

	/**
	 * This method draws a car components of car, and draw and paint it using
	 * Graphics2D.
	 * 
	 * @param g2D the object referring to Graphics2D.
	 */
	public void draw(Graphics2D g2D) {

		if (playerMove.equals("rock")) {
			int rockXUpLeft = x;
			int rockYUpLeft = y;
			int rockSize = (int) (unit * ROCKDIMENSION);
			Ellipse2D.Double rock = new Ellipse2D.Double(rockXUpLeft, rockYUpLeft, rockSize, rockSize);
			g2D.setPaint(new Color(150, 150, 150)); // paints the rock grey.
			GeneralPath rockGeneralPath = new GeneralPath();
			rockGeneralPath.append(rock, false);
			g2D.fill(rockGeneralPath);
			draggableX = x + rockSize;
			draggableY = y + rockSize;
			
//			Point pointToBeAdded = new Point(x, y);
//			battleFieldArrayList.add(pointToBeAdded);
//			indexCount++;
		}

//Papar - draw white 
		if (playerMove.equals("paper")) {
			int paperXUpLeft = x;
			int paperYUpLeft = y;
			int paperWidth = (int) (unit * PAPERDIMENSION);
			int paperHeight = (int) (unit * PAPERDIMENSION);

			Rectangle2D.Double paper = new Rectangle2D.Double(paperXUpLeft, paperYUpLeft, paperWidth, paperHeight);
			g2D.setColor(Color.WHITE); // paints the paper white.
			GeneralPath paperGeneralPath = new GeneralPath();
			paperGeneralPath.append(paper, false);
			g2D.fill(paperGeneralPath);
			draggableX = x + paperWidth;
			draggableY = y + paperHeight;
		}

//Scissors - draw S
		if (playerMove.equals("scissors")) {
			int startScissorX = x;
			int startScissorY = y;
			int endScissorX = x + (int) (unit * SCISSORLENGTH);
			int endScissorY = y + (int) (unit * SCISSORLENGTH);

			Line2D.Float rightBlade = new Line2D.Float(startScissorX, startScissorY, endScissorX, endScissorY);
			Line2D.Float leftBlade = new Line2D.Float(endScissorX, startScissorY, startScissorX, endScissorY);
			int handleSize = (int) (unit * SCISSORLENGTH / 2);
			Ellipse2D.Double rightHandle = new Ellipse2D.Double(endScissorX, endScissorY, handleSize, handleSize);
			Ellipse2D.Double leftHandle = new Ellipse2D.Double(startScissorX - (int) (unit * SCISSORLENGTH / 2),
					endScissorY, handleSize, handleSize);
			GeneralPath scissorGeneralPath = new GeneralPath();
			scissorGeneralPath.append(rightBlade, false);
			scissorGeneralPath.append(leftBlade, false);
			scissorGeneralPath.append(rightHandle, false);
			scissorGeneralPath.append(leftHandle, false);
			g2D.setColor(Color.BLACK); // paints the rock grey.
			g2D.draw(scissorGeneralPath);
			
			draggableX = x + endScissorX;
			draggableY = y + endScissorY;

		}

//Spock - draw spock's face with his classic hair
		if (playerMove.equals("spock")) {

			int headSize = (int) (unit * HEADDIMENSION);
			int headWidth = (int) (headSize * 0.8);
			Ellipse2D.Double head = new Ellipse2D.Double(x, y, headWidth, headSize);
			// Line2D.Float left eye = new Line2D.Float(startScissorX, startScissorY,
			// endScissorX, endScissorY);

			g2D.setPaint(new Color(255, 234, 219)); // paints the face ivory.
			g2D.fill(head);
			g2D.setColor(Color.BLACK); // paints the hair black
			g2D.fillArc(x, y, headWidth, headWidth, 0, 180);
			
			
			GeneralPath spockGeneralPath = new GeneralPath();
			spockGeneralPath.append(head, false);
			
			g2D.setPaint(new Color(255, 234, 219)); // paints the face ivory.
			g2D.fill(spockGeneralPath);
			g2D.setColor(Color.BLACK); // paints the hair black
			g2D.fillArc(x, y, headWidth, headWidth, 0, 180);
			//generalObject = SGeneralPath;
			
			//g2dObject = spock;
//			Point pointToBeAdded = new Point(x, y);
//			battleFieldArrayList.add(pointToBeAdded);
			draggableX = x + headWidth;
			draggableY = y + headSize;
		}
//Lizad -draw L
		if (playerMove.equals("lizard")) {

			int headSize = (int) (unit * HEADDIMENSION);
			Ellipse2D.Double lizardHead = new Ellipse2D.Double(x, y, headSize, headSize);
			int eyeSize = (int) (unit * HEADDIMENSION / 4);
			Ellipse2D.Double lizardEye = new Ellipse2D.Double((int) (x + LIZARDHEADTOEYERATIO * unit),
					(int) (y + LIZARDHEADTOEYERATIO * unit), eyeSize, eyeSize);
			int startTongueX = x;
			int startTongueY = y + (int) (unit * headSize / 2);
			int endTongueX = x - (int) (unit * headSize);
			int endTongueY = y + (int) (unit * headSize / 2);

			Line2D.Float longTongue = new Line2D.Float(startTongueX, startTongueY, endTongueX, endTongueY);
			Line2D.Float shortTongue = new Line2D.Float(startTongueX - (int) (TONGUEHEIGHT * 3 * unit), startTongueY,
					endTongueX, endTongueY + (int) (TONGUEHEIGHT * unit));

			g2D.setColor(Color.GREEN); // paint the lizard Green
			g2D.fill(lizardHead);
			g2D.setColor(Color.RED); // paint the tongue red
			GeneralPath tongue = new GeneralPath();

			tongue.append(longTongue, false);
			tongue.append(shortTongue, false);
			g2D.draw(tongue);
			g2D.setColor(Color.BLACK); // paint the eye black
			g2D.fill(lizardEye);
			
			draggableX = x + headSize;
			draggableY = y + headSize;
			
			//g2dObject = lizardHead;
//			Point pointToBeAdded = new Point(x, y);
//			battleFieldArrayList.add(pointToBeAdded);
		}

	}

	/**
	 * x the x coordinate of car y the y coordinate of car unit the unit of the size
	 * of the car CARLENGTH the length of car's body CARHEIGHT the height of car
	 * WINDOWHEIGHT the height of window WHEELHEIGHT the height of wheels
	 * BODYVSWHEELX the relative location of Wheel vs body for x coordinate
	 * BODYVSWHEELY the relative location of Wheel vs body for y coordinate
	 */
	private static int x;
	private static int y;
	private double unit;
	private static String playerMove;
	private static int draggableX;
	private static int draggableY;
	private final double PAPERDIMENSION = 60;
	private final double ROCKDIMENSION = 60;
	private final double SCISSORLENGTH = 60;
	private final double HEADDIMENSION = 100;
	private final double TONGUEHEIGHT = 20;
	private final double LIZARDHEADTOEYERATIO = 20;

}
