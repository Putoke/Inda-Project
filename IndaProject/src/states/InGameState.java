package states;

import game.Controller;
import game.Entity;
import game.Game;
import game.LevelGenerator;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import components.*;

public class InGameState extends BasicGameState {

	public static final int ID = 2;
	private ArrayList<Entity> entities;
	private static Entity player;
	private static Entity base;
	private static Entity background;
	private static ArrayList<Entity> shots;
	private ArrayList<Entity> enemies;
	private static ArrayList<Entity> enemyShots;
	private LevelGenerator levelGenerator;
	public static Vector2f playerPosition;
	public static float playerRadius;
	public static boolean finished;
	private static final int TRANSITION_DELAY = 0;
	private static final int STARTING_LEVEL = 1;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		levelGenerator = new LevelGenerator(STARTING_LEVEL);
		entities = new ArrayList<Entity>();
		shots = new ArrayList<Entity>();
		enemies = new ArrayList<Entity>();
		enemyShots = new ArrayList<Entity>();
		finished = false;

		//Add a background
		background = new Entity("background");
		background.AddComponent(new ImageRenderComponent("BackgroundRender",
				new Image("res/sprites/background.png")));
		background.setHealth(1);
		entities.add(background);
		
		//add a base
		base = new Entity("base");
		ImageRenderComponent temp = new ImageRenderComponent("house", new Image("res/sprites/house.png"));
		base.AddComponent(temp);
		base.setRadius(temp.getRadius());
		base.setPosition(new Vector2f(Game.centerWidth - base.getRadius(), Game.centerHeight - temp.getRadius()));
		base.setHealth(200);
		base.AddComponent(new HealthBarComponent("BaseHealthBar"));
		entities.add(base);


		//Add a player		
		player = new Entity("player");
		ImageRenderComponent temp2 = new ImageRenderComponent("playerRender", new Image("res/sprites/hero/hero1.png"));
		//temp2 = new AnimationRenderComponent("playerRender", new Image[] {new Image("res/sprites/hero/hero1.png")}, 300);
		player.AddComponent(temp2);
		player.setRadius(temp2.getRadius());
		player.AddComponent(new PlayerMovementComponent("PlayerMovement"));
		player.setPosition(new Vector2f(400, 300));
		player.setHealth(100);
		player.AddComponent(new HealthBarComponent("PlayerHealthBar"));
		entities.add(player);
		playerPosition = player.getPosition();
		playerRadius = player.getRadius();
		
		// get first wave
		enemies = levelGenerator.getNextLevel();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		for (Entity e : entities) {
			e.render(gc, sb, g);
		}
		for (Entity e : enemies){
			e.render(gc, sb, g);
		}
		for (Entity e : shots) {
			e.render(gc, sb, g);
		}
		for(Entity e : enemyShots){
			e.render(gc, sb, g);
		}
		
		drawLevel(g);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		
		updateEntityArray(entities, gc, sb, delta);
		updateEntityArray(shots, gc, sb, delta);
		updateEntityArray(enemies, gc, sb, delta);
		updateEntityArray(enemyShots, gc, sb, delta);
		
		for(Entity e1 : enemies){
			//Check if enemy collides with house
			if(collision(e1, entities.get(1))){
				entities.get(1).damage(e1.getDamage());
				e1.setHealth(0);
				if(entities.get(1).getHealth() <= 0){
					//house dead
					sb.enterState(LoseState.ID);
				}
			}
			//Check if enemy collides with player
			if(collision(e1, entities.get(2))){
				entities.get(2).damage(e1.getDamage());
				e1.setHealth(0);
				if(entities.get(2).getHealth() <= 0){
					//player dead
					sb.enterState(LoseState.ID, new FadeOutTransition(Color.black, 200), new FadeInTransition(Color.black,
							200));
				}
			}
			for(Entity e2 : shots){
				if(collision(e1, e2)){
					e1.damage(2);
					e2.setHealth(0);
					
				}
			}
			
		}
		
		for(Entity e2 : enemyShots){
			if(collision(e2, entities.get(2))){
				entities.get(2).damage(3);
				e2.setHealth(0);
				if(entities.get(2).getHealth() <= 0){
					//player dead
					sb.enterState(LoseState.ID, new FadeOutTransition(Color.black, 200), new FadeInTransition(Color.black,
							200));
				}
			}
		}

		Input input = gc.getInput();
		if (Controller.isShortcutPressed("Menu", input)) {
			sb.enterState(MenuState.ID, new FadeOutTransition(Color.black, TRANSITION_DELAY), new FadeInTransition(Color.black,
					TRANSITION_DELAY));
		}
		if(Controller.isShortcutPressed("Hitbox", input)){
			Game.hitBox = !Game.hitBox;
		}
		
		// get next wave of enemies
		if (levelCleared()) {
			ArrayList<Entity> temp = levelGenerator.getNextLevel();
			if (temp != null) {
				if (temp.isEmpty() != true) {
					sb.enterState(InGameState.ID, null, null);
					enemies = temp;
				}
				
			}
		}
		
		if (levelGenerator.checkCompleted()) {
			finished = true;
		}
		
		checkFinished(sb);
		
	}
	
	private void checkFinished(StateBasedGame sb) {
		if (finished) {
			sb.enterState(WinState.ID, new FadeOutTransition(Color.black, 200), new FadeInTransition(Color.black,
					200));
		}
	}
	
	private boolean levelCleared() {
		return enemies.isEmpty();
	}
	
	private boolean collision(Entity e1, Entity e2){
		float radii = e1.getRadius() + e2.getRadius();
		float dx = e2.getPosition().x + e2.getRadius() - e1.getPosition().x - e1.getRadius();
		float dy = e2.getPosition().y + e2.getRadius() - e1.getPosition().y - e1.getRadius();
		if( dx * dx + dy * dy < radii * radii){
			return true;
		}
		return false;
	}
	
	public static void addShot(float rotation, Vector2f position, int owner){
		Entity newShot = new Entity("Shot");
		try {
			ImageRenderComponent temp = new ImageRenderComponent("Shot Image", new Image("res/sprites/shot.png"));
			newShot.AddComponent(temp);
			newShot.setRotation(rotation - 90);
			newShot.setRadius(temp.getRadius());
		} catch (SlickException e) {
			System.err.println("Couldn't load shot image.");
		}
		newShot.setHealth(1);
		if(owner == 1){
			newShot.AddComponent(new ShotComponent("Shot", rotation, new Vector2f(position.x - newShot.getRadius(), position.y - newShot.getRadius())));
			shots.add(newShot);
		} else if(owner == 2){
			newShot.AddComponent(new ShotComponent("Shot", rotation, new Vector2f(position.x - newShot.getRadius(), position.y - newShot.getRadius()), 0.3f));
			enemyShots.add(newShot);
		}
	}
	
	/**
	 * Loops through the given array and updates every entity. If the entity's health reaches 0 or less it will be removed.
	 * @throws SlickException 
	 */
	private void updateEntityArray(ArrayList<Entity> array, GameContainer gc, StateBasedGame sb, int delta) throws SlickException{
		for(int i=0; i<array.size(); i++){
			array.get(i).update(gc, sb, delta);
			if(array.get(i).getHealth() <= 0){
				array.remove(i);
				i--;
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}
	
	public ArrayList<Entity> getEnemies() {
		return enemies;
	}
	
	private void drawLevel(Graphics g){
		String level = "Level: " +levelGenerator.getCurrentLevel();
		g.drawString(level, 50, 50);
	}
	
	public static Entity getPlayer() {
		return player;
	}
	
	public static Entity getHouse() {
		return base;
	}
	
	public static Entity getBackground() {
		return background;
	}
	
}
