package components;

import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class EnemyMovementComponent extends Component{
	
	private float speed;
	
	public EnemyMovementComponent(String id){
		this.id = id;
		speed = 0.01f;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float rotation = owner.getRotation();
		Vector2f position = owner.getPosition();
		
		rotation = (float) Math.toDegrees(Math.atan2(position.y - Game.app.getHeight()/2, position.x - Game.app.getWidth()/2)) + 90;
		
		float hip = -speed * delta;

		position.x += hip * Math.sin(Math.toRadians(rotation));
		position.y -= hip * Math.cos(Math.toRadians(rotation));
		
		owner.setPosition(position);
		owner.setRotation(rotation);
	}

}
