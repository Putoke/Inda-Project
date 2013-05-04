package states;

import game.Controller;
import game.Game;
import game.MenuButton;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class MenuState extends BasicGameState {

	public static final int ID = 1;
	private static final int TRANSITION_DELAY = 100;

	private ArrayList<MenuButton> buttons;
	private MenuButton playButton, settingsButton, exitButton;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		buttons = new ArrayList<MenuButton>();
		
		playButton = new MenuButton("playButton", new Vector2f(Game.centerWidth - 100, Game.centerHeight - 125), new Image("res/buttons/play.png"));
		buttons.add(playButton);
		
		settingsButton = new MenuButton("settingsButton", new Vector2f(Game.centerWidth - 100, Game.centerHeight), new Image("res/buttons/settings.png"));
		buttons.add(settingsButton);

		exitButton = new MenuButton("playButton", new Vector2f(Game.centerWidth - 100, Game.centerHeight + 125), new Image("res/buttons/exit.png"));
		buttons.add(exitButton);

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
		
		if (playButton.isMousePressed()) {
			sb.enterState(InGameState.ID, new FadeOutTransition(Color.black,
					TRANSITION_DELAY), new FadeInTransition(Color.black,
							TRANSITION_DELAY));
		}
		
		if (settingsButton.isMousePressed()) {
			sb.enterState(SettingsState.ID, new FadeOutTransition(Color.black,
					TRANSITION_DELAY), new FadeInTransition(Color.black,
							TRANSITION_DELAY));
		}
		
		if (exitButton.isMousePressed()) {
			System.exit(0);
		}
		
		Input input = gc.getInput();
		if (Controller.isShortcutPressed("Menu", input)) {
			sb.enterState(InGameState.ID, new FadeOutTransition(Color.black,
					TRANSITION_DELAY), new FadeInTransition(Color.black,
							TRANSITION_DELAY));
		}

	}

	@Override
	public int getID() {
		return ID;
	}

}
