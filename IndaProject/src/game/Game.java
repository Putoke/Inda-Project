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
		addState(new SettingsState());
		
	}

	public static void main(String[] args) {
		try {
			app = new AppGameContainer(new Game());
			app.setDisplayMode(1920, 1080, true);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.setSmoothDeltas(true);
			app.setMusicOn(true);
			app.start();
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
