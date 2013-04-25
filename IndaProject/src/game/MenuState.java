package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState {

	public static final int ID = 2;
	private int centerHeight = Game.app.getHeight()/2;
	private int centerWidth = Game.app.getWidth()/2;

	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		
		//g.drawString("MENU", centerWidth-35, centerHeight - 125);
		//g.drawString("New Game", centerWidth-50, centerHeight - 75);
		//g.drawString("Settings", centerWidth-50, centerHeight - 25);
		g.drawString("Exit", centerWidth-50, 100);
		
		g.drawImage(new Image("Sprites/new game.png"), centerWidth-100, centerHeight-125);
		g.drawImage(new Image("Sprites/Settings.png"), centerWidth-100, centerHeight-25);
		g.drawImage(new Image("Sprites/exit.png"), centerWidth-100, centerHeight+75);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {

		Input input = gc.getInput();
		if (Controller.isShortcutPressed("Menu", input)) {
			sb.enterState(InGameState.ID, new FadeOutTransition(Color.black, 250), null);
		}
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if ( (posX > (centerWidth-100) && posX < (centerWidth+100))){ //&& (posY > (centerHeight-125) && posY < (centerHeight-75)) ) {
			if (Mouse.isButtonDown(0)) {
				sb.enterState(InGameState.ID);
			}
		}

	}

	@Override
	public int getID() {
		return ID;
	}

}
