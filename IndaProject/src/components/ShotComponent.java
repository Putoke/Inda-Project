package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class ShotComponent extends Component{

	private float rotation;
	private Vector2f position;
	
	public ShotComponent(String id, float rotation, Vector2f position){
		this.id = id;
		this.rotation = rotation;
		this.position = new Vector2f(position.x, position.y);
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float hip = 0.4f * delta;

		position.x += hip * Math.sin(Math.toRadians(rotation));
		position.y -= hip * Math.cos(Math.toRadians(rotation));
		owner.setPosition(position);
		owner.setRotation(rotation);
	}

}