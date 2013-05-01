package components;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class AnimationRenderComponent extends RenderComponent{
	
	private Animation animation;
	private Image[] frames;

	public AnimationRenderComponent(String id, Image[] frames, int duration) {
		super(id);
		this.frames = frames;
		//for (Image image : this.frames) {
			//image.rotate(owner.getRotation() - image.getRotation());
		//}
		animation = new Animation(frames, duration);
	}


	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		animation.draw(pos.getX(), pos.getY());
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		for (Image image : frames) {
			image.rotate(owner.getRotation() - image.getRotation());
		}
		
	}
	
	public float getRadius(){
		return frames[0].getWidth()/2;
		//return image.getWidth()/2;
	}
	
	public Image[] getFrames() {
		return frames;
	}
	
	public Animation getAnimation() {
		return animation;
	}

}
