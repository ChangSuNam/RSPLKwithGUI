import java.util.ArrayList;
import java.awt.*;

/**
 * This class creates aggregate for BattleField.
 * 
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment6 2.2
 */
public class MovesGenerator implements Draggable {
	/**
	 * Constructor that creates aggregate for BattleField
	 * 
	 */
	public MovesGenerator() {
		battleFieldArrayList = new ArrayList<BattleField>();
	}

	/**
	 * Adds a battleField object to the aggregate
	 * @param moveToBeAdded the BattleField that will be added
	 */
	public void addMove(BattleField moveToBeAdded) {
		battleFieldArrayList.add(moveToBeAdded);

	}

	/**
	 * Get method to get a specific BattleField.
	 *
	 * @param moveIndex the index to be retrieved.
	 * @return the specific BattleField stored at index
	 */
	public Draggable getMove(int moveIndex) {
		return battleFieldArrayList.get(moveIndex);
	}

	/**
	 * This method gets the size of the aggregate.
	 * 
	 * @return the size of aggregate
	 */
	public int getSize() {
		return battleFieldArrayList.size();
	}

	/**
	 * This method draws the moves created in each battlefield in arrayList, with Graphics2D
	 * 
	 * @param g2d reference to Graphics2D
	 */
	public void draw(Graphics2D g2d) {
		for (Draggable battleFieldObject : battleFieldArrayList) {
			battleFieldObject.draw(g2d);
		}

	}

	/**
	 * This method changes the coordinate of the diagram.
	 * 
	 * @param xChange the change to be made in x coordinate
	 * @param yChange the change to be made in y coordinate.
	 */
	public void translate(int xChange, int yChange) {

		for (BattleField move : battleFieldArrayList) {
			move.translate(xChange, yChange);

		}
	}

	/**
	 * battleFieldArrayList the arrayList that holds battleField.
	 */
	static ArrayList<BattleField> battleFieldArrayList;


}
