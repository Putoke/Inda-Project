package states;

import game.Game;
import game.MenuButton;

import java.util.ArrayList;

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

public class SettingsState extends BasicGameState {

	public static final int ID = 3;
	private ArrayList<MenuButton> buttons;
	private MenuButton musicButton, fullscreenButton, backButton;


	private Image check, cross;

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		buttons = new ArrayList<MenuButton>();
		check = new Image("res/buttons/check.png");
		cross = new Image("res/buttons/cross.png");

		musicButton = new MenuButton("musicButton", new Vector2f(Game.centerWidth - 100,
				Game.centerHeight - 125), new Image("res/buttons/music.png"));
		buttons.add(musicButton);
		
		fullscreenButton = new MenuButton("fullscreenButton", new Vector2f(Game.centerWidth - 100,
				Game.centerHeight), new Image("res/buttons/fullscreen.png"));
		buttons.add(fullscreenButton);
		
		backButton = new MenuButton("backButton", new Vector2f(Game.centerWidth - 100,
				Game.centerHeight + 125), new Image("res/buttons/back.png"));
		buttons.add(backButton);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.render(gc, sb, g);
		}
		
		drawButtonIcons(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.update(gc, sb, delta);
		}

		if (musicButton.isMousePressed()) {
			if (Game.getMusic().paused()) {
				Game.getMusic().resume();
			} else {
				Game.getMusic().pause();
			}
		}
		
		if (fullscreenButton.isMousePressed()) {
			Game.app.setDisplayMode(Game.getDisplayMode().getWidth(), Game.getDisplayMode().getHeight(), !Game.app.isFullscreen());
		}
		
		if (backButton.isMousePressed()) {
			sb.enterState(MenuState.ID, new FadeOutTransition(Color.black, 200), new FadeInTransition(Color.black, 200));
		}
		
	}

	@Override
	public int getID() {
		return ID;
	}
	
	private void drawButtonIcons(Graphics g) {
		if (Game.getMusic().paused()) {
			g.drawImage(cross, musicButton.getPosition().getX()
					+ musicButton.getImage().getWidth() + 50, musicButton
					.getPosition().getY());
		} else {
			g.drawImage(check, musicButton.getPosition().getX()
					+ musicButton.getImage().getWidth() + 50, musicButton
					.getPosition().getY());
		}
		
		if (Game.app.isFullscreen()) {
			g.drawImage(check, fullscreenButton.getPosition().getX()
					+ fullscreenButton.getImage().getWidth() + 50, fullscreenButton
					.getPosition().getY());
		} else {
			g.drawImage(cross, fullscreenButton.getPosition().getX()
					+ fullscreenButton.getImage().getWidth() + 50, fullscreenButton
					.getPosition().getY());
		}
	}

}
