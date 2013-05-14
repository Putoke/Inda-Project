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

public class WinState extends BasicGameState {
	public static final int ID = 5;
	private TrueTypeFont ttfItalic, ttfBold, ttfPlain;
	private ArrayList<MenuButton> buttons;
	private MenuButton playButton, exitButton;

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		ttfItalic = new TrueTypeFont(new Font("Comic Sans", Font.ITALIC, 50), true);
		ttfPlain = new TrueTypeFont(new Font("Verdana", Font.PLAIN, 22	), true);
		ttfBold = new TrueTypeFont(new Font("Verdana", Font.BOLD, 30), true);
		
		buttons = new ArrayList<MenuButton>();
		
		playButton = new MenuButton("play", new Vector2f(Game.centerWidth - 300 , Game.centerHeight -150), new Image("res/buttons/newgame.png"));
		buttons.add(playButton);
		
		exitButton = new MenuButton("quit", new Vector2f(Game.centerWidth +150, Game.centerHeight + -150), new Image("res/buttons/exit.png"));
		buttons.add(exitButton);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		ttfItalic.drawString(Game.centerWidth - 150, Game.centerHeight/3, "GAME WON!");
		ttfBold.drawString(Game.centerWidth - 300, Game.centerHeight+ 100, "Player: " + InGameState.getPlayer().getHealth() + "/" + InGameState.getPlayer().getMaximumHealth() + " HP");
		ttfBold.drawString(Game.centerWidth + 50, Game.centerHeight+ 100, "House: " + InGameState.getHouse().getHealth() + "/" + InGameState.getHouse().getMaximumHealth() + " HP");
		
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
			sb.getState(InGameState.ID).init(gc, sb);
			sb.enterState(InGameState.ID);
		}
		
		if (exitButton.isMousePressed()) {
			System.exit(0);
		}
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
