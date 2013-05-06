package components;



import game.Controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import states.InGameState;

public class PlayerMovementComponent extends Component {

	private float direction;
	private float speed;
	private int shotDelay, shotCounter;
	private Sound laserSound;

	public PlayerMovementComponent(String id) throws SlickException {
		this.id = id;
		shotDelay = 100;
		laserSound = new Sound("res/sounds/laser.ogg");
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
		
		if(Controller.isP1ButtonPressed("Shoot", input) && shotCounter >= shotDelay){
			laserSound.play(1, 0.15f);
			InGameState.addShot(rotation, new Vector2f(position.x, position.y));
			shotCounter = 0;
		}
		
		owner.setPosition(position);
		owner.setRotation(rotation);
		owner.setScale(scale);
		shotCounter += delta;
	}

}
