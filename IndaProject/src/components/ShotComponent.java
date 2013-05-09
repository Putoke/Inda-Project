package components;

import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class ShotComponent extends Component{

	private float rotation;
	private Vector2f position;
	private float speed;
	
	public ShotComponent(String id, float rotation, Vector2f position){
		this(id, rotation, position, 2.0f);
	}
	
	public ShotComponent(String id, float rotation, Vector2f position, float speed){
		this.id = id;
		this.rotation = rotation + 90;
		this.position = new Vector2f(position.x, position.y);
		this.speed = speed;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float hip = speed * delta;

		position.x += hip * Math.sin(Math.toRadians(rotation - 90));
		position.y -= hip * Math.cos(Math.toRadians(rotation - 90));
		owner.setPosition(position);
		owner.setRotation(rotation);
		
		if(leftScreen()){
			owner.setHealth(0);
		}
	}

	private boolean leftScreen(){
		if(position.x + owner.getRadius()*2 < 0 || position.y + owner.getRadius()*2 < 0 || position.x > Game.app.getWidth() || position.y > Game.app.getHeight()){
			return true;
		}
		return false;
	}
	
}
