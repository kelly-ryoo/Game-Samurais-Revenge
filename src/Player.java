import java.util.ArrayList;

import javafx.scene.Node;
/*
 * Work for FRIDAY: Get Player/Ninja class working
 * P1: Animation timer with images to get smooth animation (D)
 * P2: Keyboard movements  - change background after player reaches end of scene(P)
 * P3: action methods - jump attack defend (K)
 * 
 * */
public abstract class Player extends javafx.scene.image.ImageView{
	
	double x;
	double y;

	public abstract void jump();
	public abstract void attack(Weapon w);
	public abstract void defend();
	public abstract void act(long now);
	
	public void move(double dx, double dy) {
		x += dx;
		y += dy;
		this.setX(x);
		this.setY(y);
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

	public <A extends Player> A getOneIntersectingObject(java.lang.Class<A> cls) {
		if (getIntersectingObjects(cls).size() > 0) {
			return getIntersectingObjects(cls).get(0); 
		}
		return null;
	}
	
	public <A extends Player> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){

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