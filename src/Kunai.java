import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

public class Kunai extends Weapon {
	private int dx = 5;
	private Animation spin;
	private AnimationTimer timer;
	private Player player;
	int counter = 0;
	Image USE_0 = new Image("file:Kunai/-7.png");
	Image USE_1 = new Image("file:Kunai/-6.png");
	Image USE_2 = new Image("file:Kunai/-5.png");
	Image USE_3 = new Image("file:Kunai/-4.png");
	Image USE_4 = new Image("file:Kunai/-3.png");
	Image USE_5 = new Image("file:Kunai/-2.png");
	Image USE_6 = new Image("file:Kunai/-1.png");
	Image USE_7 = new Image("file:Kunai/0.png");
	Image USE_8 = new Image("file:Kunai/1.png");
	Image USE_9 = new Image("file:Kunai/2.png");
	Image USE_10 = new Image("file:Kunai/3.png");
	Image USE_11 = new Image("file:Kunai/4.png");
	Image USE_12 = new Image("file:Kunai/5.png");
	Image USE_13 = new Image("file:Kunai/6.png");
	Image USE_14 = new Image("file:Kunai/7.png");
	Image USE_15 = new Image("file:Kunai/8.png");
	Image USE_16 = new Image("file:Kunai/9.png");
	Image USE_17 = new Image("file:Kunai/10.png");
	Image USE_18 = new Image("file:Kunai/11.png");
	Image USE_19 = new Image("file:Kunai/12.png");
	Image USE_20 = new Image("file:Kunai/13.png");
	Image USE_21 = new Image("file:Kunai/14.png");
	Image USE_22 = new Image("file:Kunai/15.png");
	
	Image RUSE_0 = new Image("file:ReverseKunai/-7.png");
	Image RUSE_1 = new Image("file:ReverseKunai/-6.png");
	Image RUSE_2 = new Image("file:ReverseKunai/-5.png");
	Image RUSE_3 = new Image("file:ReverseKunai/-4.png");
	Image RUSE_4 = new Image("file:ReverseKunai/-3.png");
	Image RUSE_5 = new Image("file:ReverseKunai/-2.png");
	Image RUSE_6 = new Image("file:ReverseKunai/-1.png");
	Image RUSE_7 = new Image("file:ReverseKunai/0.png");
	Image RUSE_8 = new Image("file:ReverseKunai/1.png");
	Image RUSE_9 = new Image("file:ReverseKunai/2.png");
	Image RUSE_10 = new Image("file:ReverseKunai/3.png");
	Image RUSE_11 = new Image("file:ReverseKunai/4.png");
	Image RUSE_12 = new Image("file:ReverseKunai/5.png");
	Image RUSE_13 = new Image("file:ReverseKunai/6.png");
	Image RUSE_14 = new Image("file:ReverseKunai/7.png");
	Image RUSE_15 = new Image("file:ReverseKunai/8.png");
	Image RUSE_16 = new Image("file:ReverseKunai/9.png");
	Image RUSE_17 = new Image("file:ReverseKunai/10.png");
	Image RUSE_18 = new Image("file:ReverseKunai/11.png");
	Image RUSE_19 = new Image("file:ReverseKunai/12.png");
	Image RUSE_20 = new Image("file:ReverseKunai/13.png");
	Image RUSE_21 = new Image("file:ReverseKunai/14.png");
	Image RUSE_22 = new Image("file:ReverseKunai/15.png");
	
	private Animation useKunai;
	private Animation useReverseKunai;
	public Kunai(Player p) {
		useKunai = new Animation(this, 6.5, USE_0, USE_1, USE_2, USE_3, USE_4, USE_5, USE_6, USE_7, USE_8, USE_9, USE_10, USE_11, USE_12, USE_13, USE_14, USE_15);
		useReverseKunai = new Animation(this, 2, RUSE_0, RUSE_2, RUSE_4, RUSE_5, RUSE_6, RUSE_7, RUSE_8,RUSE_9, RUSE_10, RUSE_11, RUSE_12, RUSE_13, RUSE_14, RUSE_15);
		player = p;
		Image i = USE_0;
		setImage(i);
		
		spin = new Animation(p, 6, false, i);
		
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
			    		setKunaiX(getKunaiX() + dx);
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
			    		setKunaiX(getKunaiX() - dx);
			    		move();
			    		checkIsTimerOver();
					}
					
					
				}
			};
		}
		
		
	}

	
	@Override
	public void use() {
		timer.start();
	}

	protected void checkIsTimerOver() {
		if(this.getKunaiX() >= player.getWorld().getWidth()) {
			((Ninja)player).removeWeapon(this);
			timer.stop();
			counter = 0;
		}
	}

	public void move() {
		if (counter == 0)
			if (((Ninja) player).isFacingRight()) {
				useKunai.runAnimation();
			} else {
				useReverseKunai.runAnimation();
			}
	
			counter = 1;
			
		if(this.getKunaiX() < player.getWorld().getWidth()) {
			//spin.runAnimation();
			
			//check whether kunai touches anything before moving off screen
			if(this.getIntersectingObjects(SamuraiHeavy.class).size() > 0) {
				//samurai losing lives and dying
				((Ninja)player).setScore((int)((Ninja)player).getScore() + 10);
				SamuraiHeavy samurai = getOneIntersectingObject(SamuraiHeavy.class);
				//System.out.println("kunai touched sH. will die.");
				samurai.die();
			}

			if(this.getIntersectingObjects(SamuraiLight.class).size() > 0) {
				//samurai losing lives and dying
				((Ninja)player).setScore((int)((Ninja)player).getScore() + 10);
				SamuraiLight samurai = getOneIntersectingObject(SamuraiLight.class);
				samurai.die();
			
			}
		}
	}

	private void setKunaiX(double x) {
		this.setX(x);
	}
	
	private double getKunaiX() {
		return this.getX();
	}
}
