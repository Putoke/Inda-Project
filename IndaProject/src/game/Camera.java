package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Camera {

	private int transX, transY;
	private int mapWidth, mapHeight;
	private Rectangle viewPort;
	
	public Camera() {
		transX = 0;
		transY = 0;
		viewPort = new Rectangle(0, 0, Game.app.getWidth(), Game.app.getHeight());
		mapWidth = Game.app.getWidth();
		mapHeight = Game.app.getHeight();
	}
	
}


