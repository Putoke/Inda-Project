package game;

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
	private int centerHeight = Game.app.getHeight() / 2;
	private int centerWidth = Game.app.getWidth() / 2;
	
	private ArrayList<MenuButton> buttons;
	private MenuButton musicButton, fullscreenButton, backButton;


	private Image check, cross;

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		buttons = new ArrayList<MenuButton>();
		check = new Image("res/buttons/check.png");
		cross = new Image("res/buttons/cross.png");

		musicButton = new MenuButton("musicButton", new Vector2f(centerWidth - 100,
				centerHeight - 125), new Image("res/buttons/music.png"));
		buttons.add(musicButton);
		
		fullscreenButton = new MenuButton("fullscreenButton", new Vector2f(centerWidth - 100,
				centerHeight), new Image("res/buttons/fullscreen.png"));
		buttons.add(fullscreenButton);
		
		backButton = new MenuButton("backButton", new Vector2f(centerWidth - 100,
				centerHeight + 125), new Image("res/buttons/back.png"));
		buttons.add(backButton);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.render(gc, sb, g);
		}

		/*if (Game.app.isMusicOn()) {
			g.drawImage(check, buttons.get(0).getPosition().getX()
					+ buttonImages.get(0).getWidth() + 50, buttons.get(0)
					.getPosition().getY());
		} else {
			g.drawImage(cross, buttons.get(0).getPosition().getX()
					+ buttonImages.get(0).getWidth() + 50, buttons.get(0)
					.getPosition().getY());
		}

		if (Game.app.isFullscreen()) {
			g.drawImage(check, buttons.get(1).getPosition().getX()
					+ buttonImages.get(1).getWidth() + 50, buttons.get(1)
					.getPosition().getY());
		} else {
			g.drawImage(cross, buttons.get(1).getPosition().getX()
					+ buttonImages.get(1).getWidth() + 50, buttons.get(1)
					.getPosition().getY());
		}*/

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.update(gc, sb, delta);
		}

		if (musicButton.isMousePressed()) {
			if (Game.app.isMusicOn()) {
				Game.app.setMusicOn(false);
			} else {
				Game.app.setMusicOn(true);
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

}
