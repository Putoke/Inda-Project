package states;

import game.Game;
import game.MenuButton;

import java.awt.Font;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LoseState extends BasicGameState {
	public static final int ID = 4;

	private TrueTypeFont ttf;
	private ArrayList<MenuButton> buttons;
	private MenuButton playButton, exitButton;

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		Font f = new Font("Comic Sans", Font.ITALIC, 50);
		ttf = new TrueTypeFont(f, true);
		buttons = new ArrayList<MenuButton>();
		
		playButton = new MenuButton("play", new Vector2f(Game.centerWidth - 300 , Game.centerHeight -150), new Image("res/buttons/play.png"));
		buttons.add(playButton);
		
		exitButton = new MenuButton("quit", new Vector2f(Game.centerWidth +150, Game.centerHeight + -150), new Image("res/buttons/exit.png"));
		buttons.add(exitButton);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		ttf.drawString(Game.centerWidth - 150, Game.centerHeight/3, "GAME LOST!");
		
		for (MenuButton button : buttons) {
			button.render(gc, sb, g);
		}
		
		if (playButton.isMousePressed()) {
			// REINIT GAME
		}
		
		if (exitButton.isMousePressed()) {
			System.exit(0);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		for (MenuButton button : buttons) {
			button.update(gc, sb, delta);
		}
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
