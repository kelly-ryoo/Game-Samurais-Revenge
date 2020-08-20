import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

public class Shuriken extends Weapon{

	private int dx = 5;
	private Animation spin;
	private AnimationTimer timer;
	private Player player;
	Image spin_1 = new Image("file:samurai_images/shuriken.png");
	Image spin_2 = new Image("file:samurai_images/shuriken.png");

	public Shuriken(Player p) { 

		player = p;
		setImage(spin_1);
		
		if (((Ninja) player).isFacingRight()) {
			this.setX(player.getX() + player.getImage().getWidth() - 30);
			this.setY(player.getY() + player.getImage().getHeight() / 2);
			timer = new AnimationTimer() {
				long delay = (long)Math.pow(10, 6); 
		    	long previousTime;

				@Override
				public void handle(long now) {

					if((now - previousTime) >= delay) {
			    		previousTime = now;
			    		setShurikenX(getShurikenX() + dx);
			    		move();
			    		checkIsTimerOver();
					}
					
				}
			};

		} else {
			this.setX(player.getX() + 30);
			this.setY(player.getY() + player.getImage().getHeight() / 2);
			timer = new AnimationTimer() {
				long delay = (long)Math.pow(10, 6); 
		    	long previousTime;

				@Override
				public void handle(long now) {

					if((now - previousTime) >= delay) {
			    		previousTime = now;
			    		setShurikenX(getShurikenX() - dx);
			    		move();
			    		checkIsTimerOver();
					}
					
				}
			};

		}
	

		spin = new Animation(p, 6, false, spin_1, spin_2);

		

	}

	protected void checkIsTimerOver() {
		if(this.getShurikenX() >= player.getWorld().getWidth()) {
//			((Ninja)player).removeWeapon(this);
//			timer.stop();
			removeThis();
		}
	}

	@Override
	public void use() {
		timer.start();
	}

	

	public void move() {
		if(this.getShurikenX() < player.getWorld().getWidth()) {
			//spin.runAnimation();
			
			//check whether shuriken touches anything before moving off screen
			if(this.getIntersectingObjects(SamuraiHeavy.class).size() > 0) {
				//samurai losing lives and dying
				System.out.println("shuriken touching SHeavy");
				SamuraiHeavy samH = this.getIntersectingObjects(SamuraiHeavy.class).get(0);
				samH.setHP(samH.getHP() - 1);
				samH.die();
				
				((Ninja)player).setScore((int)((Ninja)player).getScore() + 10);
				removeThis();
				
			}else if(this.getIntersectingObjects(SamuraiLight.class).size() > 0) {
				//samurai losing lives and dying
				System.out.println("shuriken touching SLight");
				SamuraiLight samL = this.getIntersectingObjects(SamuraiLight.class).get(0);
				samL.setHP(samL.getHP() - 1);
				samL.die();
				
				//System.out.println("kunai touched sH. will die.");
				
				((Ninja)player).setScore((int)((Ninja)player).getScore() + 10);
				removeThis();
			}
		} 
	}

	
	private void setShurikenX(double x) {
		this.setX(x);
	}

	

	private double getShurikenX() {
		return this.getX();
	}

	private void removeThis() {
		timer.stop();
		((Ninja)player).removeWeapon(this);
		
	}
}

