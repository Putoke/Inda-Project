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
import org.newdawn.slick.state.transition.FadeOutTransition;


public class MenuState extends BasicGameState {

	public static final int ID = 2;
	private int centerHeight = Game.app.getHeight() / 2;
	private int centerWidth = Game.app.getWidth() / 2;

	private ArrayList<MenuButton> buttons;
	private MenuButton playButton, settingsButton, exitButton;

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		buttons = new ArrayList<MenuButton>();
		
		playButton = new MenuButton("playButton", new Vector2f(centerWidth - 100, centerHeight - 125), new Image("res/buttons/play.png"));
		buttons.add(playButton);
		
		settingsButton = new MenuButton("settingsButton", new Vector2f(centerWidth - 100, centerHeight), new Image("res/buttons/settings.png"));
		buttons.add(settingsButton);

		exitButton = new MenuButton("playButton", new Vector2f(centerWidth - 100, centerHeight + 125), new Image("res/buttons/exit.png"));
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
					200), null);
		}
		
		if (settingsButton.isMousePressed()) {
			sb.enterState(SettingsState.ID, new FadeOutTransition(Color.black,
					200), null);
		}
		
		if (exitButton.isMousePressed()) {
			Game.stopMusic();
			System.exit(0);
		}

		// Play
		/*if (posX > buttons.get(0).getPosition().getX()
				&& posX < buttons.get(0).getPosition().getX()
						+ buttonImages.get(0).getWidth()
				&& posY > buttons.get(0).getPosition().getY()
				&& posY < buttons.get(0).getPosition().getY()
						+ buttonImages.get(0).getHeight()) {
			if (input.isMousePressed(0)) {
				sb.enterState(InGameState.ID, new FadeOutTransition(Color.black,
						200), new FadeInTransition(Color.black,
								200));
			}
		}

		// Settings
		if (posX > buttons.get(1).getPosition().getX()
				&& posX < buttons.get(1).getPosition().getX()
						+ buttonImages.get(1).getWidth()
				&& posY > buttons.get(1).getPosition().getY()
				&& posY < buttons.get(1).getPosition().getY()
						+ buttonImages.get(1).getHeight()) {
			if (input.isMousePressed(0)) {
				sb.enterState(SettingsState.ID, new FadeOutTransition(Color.black,
						200), new FadeInTransition(Color.black,
								200));
			}
		}

		// Exit
		if (posX > buttons.get(2).getPosition().getX()
				&& posX < buttons.get(2).getPosition().getX()
						+ buttonImages.get(2).getWidth()
				&& posY > buttons.get(2).getPosition().getY()
				&& posY < buttons.get(2).getPosition().getY()
						+ buttonImages.get(2).getHeight()) {
			if (input.isMousePressed(0)) {
				Game.stopMusic();
				System.exit(0);
			}
		}*/
	}

	@Override
	public int getID() {
		return ID;
	}

}
