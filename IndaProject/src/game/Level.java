package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import components.EnemyMovementComponent;
import components.HealthBarComponent;
import components.ImageRenderComponent;

public class Level {
	
	private static final int levels = 2;
	private int currentLevel;
	private ArrayList<ArrayList<Entity>> enemies;
	
	public Level() throws SlickException {
		enemies = new ArrayList<ArrayList<Entity>>();
		currentLevel = 0;
		
		// create arrayLists
		for (int i = 0; i < levels; i++) {
			enemies.add(new ArrayList<Entity>());
		}

		createLevels();
		
	}
	
	public ArrayList<Entity> getLevel(int index) {
		return enemies.get(index);
	}
	
	public ArrayList<Entity> getNextLevel() {
		currentLevel++;
		if (currentLevel <= levels) {
			return enemies.get(currentLevel-1);
		}
		return null;
	}
	
	
	private void createLevels() throws SlickException {
		Random random = new Random();
		
		//level 0
		for(int i=0; i<5; i++){
			Entity enemy = new Entity("enemy");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.05f));
			enemy.setPosition(new Vector2f(random.nextInt(Game.app.getWidth()), random.nextInt(Game.app.getHeight())));
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(5);
			
			enemies.get(0).add(enemy);
		}
		
		//level 1
		for (int i=0; i<5; i++) {
			Entity enemy = new Entity("enemy2");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy2.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.1f));
			enemy.setPosition(new Vector2f(random.nextInt(Game.app.getWidth()), random.nextInt(Game.app.getHeight())));
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(7);
			enemies.get(1).add(enemy);
		}
	}
	
	

}
