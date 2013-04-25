package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static AppGameContainer app;

	public Game() {
		super("Redneck Simulator 2 Super HD Turbo Remix");
		Controller.init();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MenuState());
		addState(new InGameState());
		
		

	}

	public static void main(String[] args) {
		try {
			app = new AppGameContainer(new Game());
			app.setDisplayMode(800, 600, false);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.setSmoothDeltas(true);
			app.start();
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}