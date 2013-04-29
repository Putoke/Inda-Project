package game;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TestState extends BasicGameState{
	private static final int ID = 4;

	private MenuButton testButton;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		testButton = new MenuButton("testButton", new Vector2f(500, 100), new Image("res/buttons/play.png"));
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		testButton.render(gc, sb, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		if (testButton.isMousePressed()) {
			sb.enterState(SettingsState.ID);
		}
		
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
