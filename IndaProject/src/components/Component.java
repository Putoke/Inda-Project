package components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import game.Entity;

public abstract class Component {

	protected String id;
	protected Entity owner;

	public String getID() {
		return id;
	}

	public void setOwnerEntity(Entity owner) {
		this.owner = owner;
	}

	public abstract void update(GameContainer gc, StateBasedGame sb, int delta);
}
