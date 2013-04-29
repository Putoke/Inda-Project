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
	private MenuButton testButton, testButton2;
	
	
	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		buttons = new ArrayList<MenuButton>();
		
		testButton = new MenuButton("testButton", new Vector2f(500, 100), new Image("res/buttons/play.png"));
		buttons.add(testButton);
		
		testButton2 = new MenuButton("testButton2", new Vector2f(500, 300), new Image("res/buttons/play.png"));
		buttons.add(testButton2);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.render(gc, sb, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		for (MenuButton button : buttons) {
			button.update(gc, sb, delta);
		}
		
		
		if (testButton.isMousePressed()) {
			sb.enterState(SettingsState.ID);
		}
		
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
