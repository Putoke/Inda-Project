package game;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import components.*;

public class Game_bkp extends BasicGame {

	private ArrayList<Entity> entities;
	private static AppGameContainer app;

	public Game_bkp() {
		super("Super Game");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		Controller.init();
		entities = new ArrayList<Entity>();
		
		Entity background = new Entity("background");
		background.AddComponent(new ImageRenderComponent("BackgroundRender",
				new Image("/Sprites/background.png")));
		entities.add(background);
		
		Entity player = new Entity("player");
		player.AddComponent(new ImageRenderComponent("PlayerRender",
				new Image("/Sprites/Character.png")));
		player.AddComponent(new PlayerMovementComponent("PlayerMovement") );
		player.setPosition(new Vector2f(400, 300));
		entities.add(player);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

		for (Entity e : entities) {
			e.update(gc, delta);
		}
		
		// get input to exit game
		Input input = gc.getInput();
		if (Controller.isShortcutPressed("Exit", input))
			System.exit(0);
		if(Controller.isShortcutPressed("Fullscreen", input))
			app.setFullscreen(!app.isFullscreen());
		if(Controller.isShortcutPressed("Pause", input)){
			if(app.isPaused()){
				app.resume();
			} else {
				app.pause();
			}
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (Entity e : entities) {
			e.render(gc, g);
		}
	}

	public static void main(String[] args) throws SlickException {

		app = new AppGameContainer(new Game_bkp());
		app.setDisplayMode(800, 600, false);
		app.setVSync(false);
		app.setTargetFrameRate(60);
		app.start();
	}
}
