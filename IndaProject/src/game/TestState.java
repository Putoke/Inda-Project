package game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TestState extends BasicGameState{
	private static final int ID = 4;

	private ArrayList<MenuButton> buttons;
	private MenuButton testButton;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		//MenuButton play = new MenuButton("menubutton", new Vector2f(100, 100))
		testButton = new MenuButton("testButton", new Vector2f(500, 100), new Image("res/buttons/play.png"));
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		/*for (MenuButton button : buttons) {
			button.render(gc, sb, g);
		}*/
		testButton.render(gc, sb, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		if (testButton.isMousePressed()) {
			sb.enterState(SettingsState.ID);
			//System.out.println("poooop");
		}
		
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
