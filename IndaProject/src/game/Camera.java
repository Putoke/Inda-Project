package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Camera {
	
	private int transX, transY;
	private int mapWidth, mapHeight;
	private Rectangle viewPort;
	
	public Camera() {
		transX = transY = 0;
		viewPort = new Rectangle(0,0, Game.app.getWidth()/2, Game.app.getHeight()/2);
		this.mapWidth = Game.app.getWidth();
		this.mapHeight = Game.app.getHeight();
	}
	
	public void translate(Graphics g, Entity entity) {
		if(entity.getX()-Game.app.getWidth()/2+16 == 0) {
			transX = 0;
			} else if(entity.getX()+Game.app.getWidth()/2+16 == mapWidth) {
				transX = -mapWidth+Game.app.getWidth();
			} else {
				transX = (int)-entity.getX()+Game.app.getWidth()/2-16;
			}
    		
 
    	if(entity.getY()-Game.app.getHeight()/2+16 == 0){
    		transY = 0; } 
    	else if(entity.getY()+Game.app.getHeight()/2+16 == mapHeight) {
    		transY = -mapHeight+Game.app.getHeight(); }
    	else {transY = (int)-entity.getY()+Game.app.getHeight()/2-16;
    	}
 
    	g.translate(transX, transY);
    	viewPort.setX(-transX);
    	viewPort.setY(-transY);
	}
	

}
