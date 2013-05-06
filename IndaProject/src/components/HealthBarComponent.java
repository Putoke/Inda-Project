package components;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class HealthBarComponent extends RenderComponent{

	private Image damage, health, bar;
	//private TrueTypeFont ttf;
	private String healthState;

	public HealthBarComponent(String id) throws SlickException {
		super(id);
		damage = new Image("res/sprites/damage.png");
		health = new Image("res/sprites/health.png");
		bar = new Image("res/sprites/bar.png");
		//ttf = new TrueTypeFont(new Font("Comic Sans", Font.BOLD, 10), true);
		healthState = "";
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		float posX = pos.x + owner.getRadius();

		damage.draw(posX - damage.getWidth()/2, pos.y - 30, scale);
		health.draw(posX - health.getWidth()/2, pos.y - 30, (float)(owner.getHealth())/(float)(owner.getMaximumHealth()) * health.getWidth(), health.getHeight());
		bar.draw(posX - bar.getWidth()/2, pos.y - 30);
		
		//ttf.drawString(posX -15, pos.y - 32, owner.getHealth() + "/" + owner.getMaximumHealth());
		gr.drawString(healthState, posX - healthState.length() - 25, pos.y - 32);
	}	

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		healthState = owner.getHealth() + "/" + owner.getMaximumHealth();
		
		
	}
}
