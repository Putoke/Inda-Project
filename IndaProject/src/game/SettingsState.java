package game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.ImageRenderComponent;

public class SettingsState extends BasicGameState{
	
	public static final int ID = 3;
	private int centerHeight = Game.app.getHeight()/2;
	private int centerWidth = Game.app.getWidth()/2;

	private ArrayList<Entity> buttons;
	private ArrayList<Image> buttonImages;

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		buttons = new ArrayList<Entity>();
		buttonImages = new ArrayList<Image>();
		
		Entity newGameButton = new Entity("Music");
		buttonImages.add(new Image("res/buttons/music.png"));
		newGameButton.AddComponent(new ImageRenderComponent("Music Button", buttonImages.get(0)));
		newGameButton.setPosition(new Vector2f(centerWidth - 100, centerHeight - 125));
		buttons.add(newGameButton);
		
		Entity settingsButton = new Entity("Fullscreen");
		buttonImages.add(new Image("res/buttons/fullscreen.png"));
		settingsButton.AddComponent(new ImageRenderComponent("Fullscreen Button", buttonImages.get(1)));
		settingsButton.setPosition(new Vector2f(centerWidth - 100, centerHeight));
		buttons.add(settingsButton);
		

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for(Entity e: buttons){
			e.render(gc, sb, g);
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
