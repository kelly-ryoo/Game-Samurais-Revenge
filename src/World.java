import java.util.ArrayList;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public abstract class World extends javafx.scene.layout.Pane {

	private javafx.animation.AnimationTimer timer;
	HashSet<KeyCode> list = new HashSet<KeyCode>();
	
	public World() {

		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				act(now);
				for(int i = getChildren().size() - 1; i >= 0; i--) {
					if (getChildren().get(i) instanceof Player) {
						((Player) getChildren().get(i)).act(now);
					}
				}

			}
		};
	}

	public abstract void act(long now);

	public void add(Player Player) {
		getChildren().add(Player);
	}
	
	
	//DEBUGGING
	public void add(Node obj) {
		getChildren().add(obj);
	}
	
	public <A extends Player> java.util.List<A> getObjects(java.lang.Class<A> cls) {
		ArrayList<A> arr = new ArrayList<A>();

		for (Node a : getChildren()) {
			if (a.getClass().equals(cls)) {
				arr.add((A) a);
			}
		}

		return arr; // updated

	}

	public void remove(Player Player) {
		getChildren().remove(Player);
		System.out.println(this.getChildren().toString());
	}

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();
	}
	
	public void addKeyPressed(KeyCode k) {
		list.add(k);
	}
	
	public void removeKeyPressed(KeyCode k) {
		list.remove(k);
	}
	
	public boolean isKeyDown(KeyCode k) {
		return list.contains(k);
	}
}
