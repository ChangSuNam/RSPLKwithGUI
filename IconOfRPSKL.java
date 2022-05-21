import java.awt.*;
import javax.swing.*;

/**
 * This class contains methods related to icon. It implements the interface
 * Icon. This code was suggested by StickFigure on Coursework.
 *
 * @author ChangSu Nam
 * @UNI cn2521
 * @since Assignment6 2.1
 */

public class IconOfRPSKL extends Component implements Icon { 

	/**
	 * This constructor creates with icon of given width, height and draggable object.
	 * 
	 * @param Draggable the object that implement Draggable
	 * @param iconWidth    the width of icon to be created
	 * @param iconHeight   the height of icon to be created
	 */
	public IconOfRPSKL(Draggable draggableObject, int iconWidth, int iconHeight) {
		this.draggableObject =draggableObject;
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;
	}
/**
 * Get method to return the width.
 * @return iconWidth the width of icon
 *
 */
	public int getIconWidth() {
		return iconWidth;
	}
	/**
	 * Get method to return the height.
	 * @return iconWidth the height of icon
	 *
	 */
	public int getIconHeight() {
		return iconHeight;
	}

	
	
	/**
	 * This method draws draggable object with Graphics2D.
	 * 
	 * @param iconComponent the observer component used when icon has no image observer
	 * @param iconGraphics the graphic context
	 * @param x the x coordinate of the top left corner
	 * @param y the y coordinate of the top left corner 
	 */
	public void paintIcon(Component iconComponent, Graphics iconGraphics, int x, int y) {
		Graphics2D g2D = (Graphics2D) iconGraphics;
		draggableObject.draw(g2D);
	}
/**
 * iconWidth the width of icon
 * iconHeight the height of icon
 * draggableObject the draggable object
 */
	private int iconWidth;
	private int iconHeight;
	private Draggable draggableObject;
	}
