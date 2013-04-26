package components;

import game.Controller;
import game.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class PlayerMovementComponent extends Component {

	private float direction;
	private float speed;

	public PlayerMovementComponent(String id) {
		this.id = id;
	}

	public float getSpeed() {
		return speed;
	}

	public float getDirection() {
		return direction;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float rotation = owner.getRotation();
		float scale = owner.getScale();
		Vector2f position = owner.getPosition();

		Input input = gc.getInput();
		
		float mouseX = input.getMouseX();
		float mouseY = input.getMouseY();
		
		rotation = (float) Math.toDegrees(Math.atan2(position.y - mouseY, position.x - mouseX)) - 90;

		if (Controller.isP1ButtonPressed("Left", input) || Controller.isP1ButtonPressed("LeftAlt", input)) {
			position.x -= 0.2f * delta;
		}

		if (Controller.isP1ButtonPressed("Right", input) || Controller.isP1ButtonPressed("RightAlt", input)) {
			position.x += 0.2f * delta;
		}

		if (Controller.isP1ButtonPressed("Up", input) || Controller.isP1ButtonPressed("UpAlt", input)){
			position.y -= 0.2f * delta;
		}

		if (Controller.isP1ButtonPressed("Down", input) || Controller.isP1ButtonPressed("DownAlt", input)){
			position.y += 0.2f * delta;
		}

		owner.setPosition(position);
		owner.setRotation(rotation);
		owner.setScale(scale);

	}

}
