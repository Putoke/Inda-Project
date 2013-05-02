package components;

import game.Game;
import game.InGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class EnemyMovementComponent extends Component{
	
	private float speed;
	
	public EnemyMovementComponent(String id){
		this.id = id;
		speed = 0.05f;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float rotation = owner.getRotation();
		Vector2f position = owner.getPosition();
		
		float dx = position.x - InGameState.playerPosition.x;
		float dy = position.y - InGameState.playerPosition.y;
		float distance = dx * dx + dy * dy;
		dx = position.x - Game.centerWidth;
		dy = position.y - Game.centerHeight;
		float distance2 = dx * dx + dy * dy;
		
		if(distance2 < distance){
			rotation = (float) Math.toDegrees(Math.atan2(position.y - Game.centerHeight, position.x - Game.centerWidth)) + 90;
		} else {
			rotation = (float) Math.toDegrees(Math.atan2(position.y - InGameState.playerPosition.y, position.x - InGameState.playerPosition.x)) + 90;
		}
		
		float hip = -speed * delta;

		position.x += hip * Math.sin(Math.toRadians(rotation));
		position.y -= hip * Math.cos(Math.toRadians(rotation));
		
		owner.setPosition(position);
		owner.setRotation(rotation);
	}

}
