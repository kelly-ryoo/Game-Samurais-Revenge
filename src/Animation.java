import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

public class Animation extends javafx.animation.AnimationTimer{
	private double speed;
	private int frames;

	private int count = 0;
	protected boolean dead;

	public Image[] arr;
	private Heart heart;
	private Player player;
	private Weapon weapon;
	String type = "";
	AnimationTimer run;
	boolean isRunning = false;

	PlayerWorld world;
	boolean isDying;

	public Animation(Player p, double s, boolean die, Image... args) {
		type = "Player";
		isDying = die;
		player = p;
		this.speed = s;
		arr = new Image[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = args[i];
		}
		frames = args.length;
	}

	public Animation(Heart p, double s, Image... args) {
		type = "Heart";
		heart = p;
		this.speed = s;
		arr = new Image[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = args[i];
		}
		frames = args.length;

	}

	public Animation(Weapon p, double s, Image... args) {
		type = "Weapon";
		weapon = p;
		this.speed = s;
		arr = new Image[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = args[i];
		}
		frames = args.length;
	}
	
	public void setSpeed(double speeds) {
		speed = speeds;
	}
	
	public void resetImages(Image... args) {
		this.stop();
		arr = new Image[args.length];
		for (int i = 0; i < args.length; i++) {
			arr[i] = args[i];
		}
		frames = args.length;
	}

	public void setWorld(PlayerWorld worlds) {
		world = worlds;
	}

	public void runAnimation() {
		if(!isRunning && isDying) {
			run = new AnimationTimer() {
				long delay = (long)Math.pow(10, 8); 
		    	long previousTime;
			    @Override
			    public void handle(long now) {
			    	if((now - previousTime) >= delay) {
			    		previousTime = now;
			    		nextFrame(); 
				   	}
			    
			    }
			};
			run.start();
			isRunning = true;
		}else if(type.equals("Heart")) {
			run = new AnimationTimer() {
				long delay = (long)Math.pow(10, 7.9); 
		    	long previousTime;
			    @Override
			    public void handle(long now) {
			    	if((now - previousTime) >= delay) {
			    		previousTime = now;
			    		nextFrame(); 
				   	}
			    
			    }
			};
			run.start();
			isRunning = true;
		}else if(!isRunning) {
			run = new AnimationTimer() {
				long delay = (long)Math.pow(10, speed); 
		    	long previousTime;
			    @Override
			    public void handle(long now) {
			    	if((now - previousTime) >= delay) {
			    		previousTime = now;
			    		nextFrame(); 
					
				   	}
			    
			    }
			};
			run.start();
			isRunning = true;
		}
	}

	public void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i) {
				if (type.equals("Player")) {
					player.setImage(arr[i]);
				}
				if (type.equals("Weapon")) {
					weapon.setImage(arr[i]);
				}
				if (type.equals("Heart")) {
					heart.setImage(arr[i]);
				}
			}
		}
		count++;

		if (count > frames) {
			run.stop();
			isRunning = false;
			count = 0;
			if(type.equals("Heart")) {
				world.finishedBreakingHeart = true;
				world.getChildren().remove(heart);
			}
			if(type.equals("Player") && isDying) {
								
				if(player instanceof SamuraiHeavy) {
					SamuraiHeavy.totalDeaths++;
				}else if(player instanceof SamuraiLight) {
					SamuraiLight.totalDeaths++;
				}
				
				
				player.getWorld().getChildren().remove(player);
			}
		}
	}

	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		
	}
	

}
