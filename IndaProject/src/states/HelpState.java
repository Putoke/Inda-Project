package states;

import java.util.ArrayList;

import game.Game;
import game.MenuButton;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class HelpState extends BasicGameState{
	private MenuButton backButton;
	private ArrayList<MenuButton> buttons;
	
	public static final int ID = 5;
	private static final int TRANSITION_DELAY = 0;

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		
		buttons = new ArrayList<MenuButton>();
		
		backButton = new MenuButton("backButton", new Vector2f(Game.centerWidth - 100,
				Game.centerHeight + 125), new Image("res/buttons/back.png"));
		buttons.add(backButton);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for(MenuButton button: buttons){
			button.render(gc, sb, g);
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		for(MenuButton button: buttons){
			button.update(gc, sb, delta);
		}
		
		if (backButton.isMousePressed()) {
			sb.enterState(MenuState.ID, new FadeOutTransition(Color.black, TRANSITION_DELAY), new FadeInTransition(Color.black, TRANSITION_DELAY));
		}
	}

	@Override
	public int getID() {
		return ID;
	}

}
