package game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import components.EnemyMovementComponent;
import components.HealthBarComponent;
import components.ImageRenderComponent;

public class LevelGenerator {
	
	private static final int levels = 6;
	private int currentLevel;
	private ArrayList<ArrayList<Entity>> enemies;
	private boolean completed;
	
	
	public LevelGenerator(int startLevel) throws SlickException {
		enemies = new ArrayList<ArrayList<Entity>>();
		currentLevel = startLevel-1;
		completed = false;
		
		// create arrayLists
		for (int i = 0; i < levels; i++) {
			enemies.add(new ArrayList<Entity>());
		}

		createLevels();
		
	}
	
	public boolean checkCompleted() {
		if (currentLevel > levels) {
			completed = true;
		}
		return completed;
	}
	
	public ArrayList<Entity> getLevel(int index) {
		return enemies.get(index);
	}
	
	public ArrayList<Entity> getNextLevel() {
		currentLevel++;
		if (currentLevel <= levels) {
			ArrayList<Entity> temp = enemies.get(currentLevel-1);
			for (Entity e : enemies.get(currentLevel-1)) {
				e = null;
			}
			return temp;
			
		}
		return null;
	}
	
	
	private void createLevels() throws SlickException {
		
		//level 1
		for(int i=0; i<15; i++){
			Entity enemy = new Entity("enemy");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.07f));
			setPosition(enemy, temp);
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(5);
			
			enemies.get(0).add(enemy);
		}
		
		//level 2
		for (int i=0; i<15; i++) {
			Entity enemy = new Entity("enemy2");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy2.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.1f));
			setPosition(enemy, temp);
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(7);
			enemies.get(1).add(enemy);
		}
		
		//level 3
		for (int i=0; i<15; i++) {
			Entity enemy = new Entity("enemy3");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy3.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.07f));
			setPosition(enemy, temp);
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(7);
			enemies.get(2).add(enemy);
		}
		
		//level 4
		for (int i=0; i<15; i++) {
			Entity enemy = new Entity("enemy4");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy4.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.07f));
			setPosition(enemy, temp);
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(7);
			enemies.get(3).add(enemy);
		}
		
		//level 5
		for (int i=0; i<15; i++) {
			Entity enemy = new Entity("enemy5");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/enemy5.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.07f));
			setPosition(enemy, temp);
			enemy.setHealth(10);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(7);
			enemies.get(4).add(enemy);
		}
		
		//level 6 BOSS
		for (int i=0; i<1; i++) {
			Entity enemy = new Entity("enemy6");
			ImageRenderComponent temp = new ImageRenderComponent("EnemyRender", new Image("res/sprites/enemies/boss.png"));
			enemy.AddComponent(temp);
			enemy.setRadius(temp.getRadius());
			enemy.AddComponent(new EnemyMovementComponent("EnemyMovement", 0.09f));
			setPosition(enemy, temp);
			enemy.setHealth(500);
			enemy.AddComponent(new HealthBarComponent("EnemyHealthBar"));
			enemy.setDamage(200);
			enemies.get(5).add(enemy);
		}
	}
	
	private void setPosition(Entity enemy, ImageRenderComponent temp ){
		Random random = new Random();
		int side = random.nextInt(4) + 1;
		//left
		if(side == 1){
			enemy.setPosition(new Vector2f(0-temp.getImage().getWidth() - random.nextInt(Game.app.getWidth()/2), random.nextInt(Game.app.getHeight())));
		}
		//bottom
		if(side == 2){
			enemy.setPosition(new Vector2f(random.nextInt(Game.app.getWidth()), Game.app.getHeight() - temp.getRadius()*2+temp.getImage().getHeight() + random.nextInt(Game.app.getHeight())));
		}
		//right
		if(side == 3){
			enemy.setPosition(new Vector2f(Game.app.getWidth() - temp.getRadius()*2 +temp.getImage().getWidth() + random.nextInt(Game.app.getWidth()/2) , random.nextInt(Game.app.getHeight())));
		}
		//top
		if(side == 4){
			enemy.setPosition(new Vector2f(random.nextInt(Game.app.getWidth()), 0 - temp.getImage().getHeight() - random.nextInt(Game.app.getHeight())));
		}
		
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}

}
