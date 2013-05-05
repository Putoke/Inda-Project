package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import components.Component;
import components.ImageRenderComponent;
import components.RenderComponent;

public class Player extends Entity {

	private Rectangle box;
	private Image image;
	
	public Player(String id) {
		super(id);
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		Vector2f trans = new Vector2f(0, 0);
		Input input = gc.getInput();
		
		for (Component component : getComponents()) {
			component.update(gc, sb, delta);
		}
		
		if (Controller.isShortcutPressed("Up", input)) {
			trans.y = -0.5f * delta;
		}
		
		if (Controller.isShortcutPressed("Down", input)) {
			trans.y = 0.5f * delta;
		}
		
		if (Controller.isShortcutPressed("Right", input)) {
			trans.x = 0.5f * delta;
		}
		
		if (Controller.isShortcutPressed("Left", input)) {
			trans.x = -0.5f * delta;
		}
		
		if (trans.x != 0 && trans.y != 0) { // If both components aren't null, we reduce them to have constant speed on all directions
			trans.set(trans.x / 1.5f, trans.y / 1.5f);
		}
		
		/*if(getPosition().getX()+trans.x == 32 && getPosition().getX()+trans.x == (mapWidth-64)) // Is the player inside the map? (We add (subtract) because of the stone wall) 			pos.x += trans.x; 		 		if(pos.y+trans.y &gt; 32 &amp;&amp; pos.y+trans.y &lt; (mapHeight-64))
			setPosition().setY() += trans.y;*/
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
		ImageRenderComponent renderComponent = (ImageRenderComponent) getRenderComponents().get(0);
		renderComponent.getImage().draw(getPosition().getX(), getPosition().getY());
		
	}
	
	public Rectangle getBox() {
		return box;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}
