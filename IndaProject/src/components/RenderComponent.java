package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class RenderComponent extends Component {

	public RenderComponent(String id) {
		this.id = id;
	}

	public abstract void render(GameContainer gc, Graphics gr);
}