package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

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
	public void update(GameContainer gc, int delta) {
		float rotation = owner.getRotation();
		float scale = owner.getScale();
		Vector2f position = owner.getPosition();

		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
			rotation += -0.2f * delta;
		}

		if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			rotation += 0.2f * delta;
		}

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))

		{
			float hip = 0.4f * delta;

			position.x += hip
					* java.lang.Math.sin(java.lang.Math.toRadians(rotation));
			position.y -= hip
					* java.lang.Math.cos(java.lang.Math.toRadians(rotation));
		}

		if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))

		{
			float hip = -0.4f * delta;

			position.x += hip
					* java.lang.Math.sin(java.lang.Math.toRadians(rotation));
			position.y -= hip
					* java.lang.Math.cos(java.lang.Math.toRadians(rotation));
		}

		owner.setPosition(position);
		owner.setRotation(rotation);
		owner.setScale(scale);

	}

}