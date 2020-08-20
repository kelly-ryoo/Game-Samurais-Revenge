import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;

public abstract class Weapon extends javafx.scene.image.ImageView{

	
	
	public abstract void use();
	
	public Weapon() {
		
	}
	
	public World getWorld() {
		return (World)this.getParent();
	}
	
	public double getHeight() {
		return this.getImage().getHeight();
	}
	
	public double getWidth() {
		return this.getImage().getWidth();
	}
	
	public <A extends Node> A getOneIntersectingObject(java.lang.Class<A> cls) {
		if (getIntersectingObjects(cls).size() > 0) {
			return getIntersectingObjects(cls).get(0); 
		}
		return null;
	}
	
	public <A extends Node> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){

		ArrayList<A> arr = new ArrayList<A>();

		for(Node a : getWorld().getChildren()) {

			if(a.getClass().equals(cls) && 
					a.intersects(this.getX() + 5, this.getY() + 5, this.getWidth() - 5, this.getHeight() - 5)) {
				arr.add((A)a);
			}
		}
		return arr;
	}
	
}
