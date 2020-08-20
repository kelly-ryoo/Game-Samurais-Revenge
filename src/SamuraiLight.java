import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class SamuraiLight extends Enemy {

	Shuriken shuriken;
	Timer timer;
	Ninja player;
	
	//to adjust how fast it moves
	int dx = 5;
	int temp;
	double dy = 5;
	
	static int totalDeaths;
	
	boolean jumpOver = true;
	boolean dead = false;

	// temp lives score keeper (COPIED FROM NINJA)
	int hp = 3;

	// alert1h is too big, die is too small
	Image WALK_0 = new Image("file:samurai_images/SamuraiLight/Walk/0.png");
	Image WALK_1 = new Image("file:samurai_images/SamuraiLight/Walk/1.png");
	Image WALK_2 = new Image("file:samurai_images/SamuraiLight/Walk/2.png");
	Image WALK_3 = new Image("file:samurai_images/SamuraiLight/Walk/3.png");
	Image WALK_4 = new Image("file:samurai_images/SamuraiLight/Walk/4.png");
	Image WALK_5 = new Image("file:samurai_images/SamuraiLight/Walk/5.png");
	Image WALK_6 = new Image("file:samurai_images/SamuraiLight/Walk/6.png");
	Image WALK_7 = new Image("file:samurai_images/SamuraiLight/Walk/7.png");
	Image WALK_8 = new Image("file:samurai_images/SamuraiLight/Walk/8.png");
	Image WALK_9 = new Image("file:samurai_images/SamuraiLight/Walk/9.png");

	Image SWORD_1 = new Image("file:samurai_images/SamuraiLight/Attack1H/1.png");
	Image SWORD_2 = new Image("file:samurai_images/SamuraiLight/Attack1H/2.png");
	Image SWORD_3 = new Image("file:samurai_images/SamuraiLight/Attack1H/3.png");
	Image SWORD_4 = new Image("file:samurai_images/SamuraiLight/Attack1H/4.png");
	Image SWORD_5 = new Image("file:samurai_images/SamuraiLight/Attack1H/5.png");
	Image SWORD_6 = new Image("file:samurai_images/SamuraiLight/Attack1H/6.png");
	Image SWORD_7 = new Image("file:samurai_images/SamuraiLight/Attack1H/7.png");
	Image SWORD_8 = new Image("file:samurai_images/SamuraiLight/Attack1H/8.png");
	Image SWORD_9 = new Image("file:samurai_images/SamuraiLight/Attack1H/9.png");

	Image DEATH_0 = new Image("file:samurai_images/SamuraiLight/Die/0.png");
	Image DEATH_1 = new Image("file:samurai_images/SamuraiLight/Die/1.png");
	Image DEATH_2 = new Image("file:samurai_images/SamuraiLight/Die/2.png");
	Image DEATH_3 = new Image("file:samurai_images/SamuraiLight/Die/3.png");
	Image DEATH_4 = new Image("file:samurai_images/SamuraiLight/Die/4.png");
	Image DEATH_5 = new Image("file:samurai_images/SamuraiLight/Die/5.png");
	Image DEATH_6 = new Image("file:samurai_images/SamuraiLight/Die/6.png");
	Image DEATH_7 = new Image("file:samurai_images/SamuraiLight/Die/7.png");
	Image DEATH_8 = new Image("file:samurai_images/SamuraiLight/Die/8.png");
	Image DEATH_9 = new Image("file:samurai_images/SamuraiLight/Die/9.png");
	
	Image RWALK_0 = new Image("file:ReverseSamuraiLight/Walk/0.png");
	Image RWALK_1 = new Image("file:ReverseSamuraiLight/Walk/1.png");
	Image RWALK_2 = new Image("file:ReverseSamuraiLight/Walk/2.png");
	Image RWALK_3 = new Image("file:ReverseSamuraiLight/Walk/3.png");
	Image RWALK_4 = new Image("file:ReverseSamuraiLight/Walk/4.png");
	Image RWALK_5 = new Image("file:ReverseSamuraiLight/Walk/5.png");
	Image RWALK_6 = new Image("file:ReverseSamuraiLight/Walk/6.png");
	Image RWALK_7 = new Image("file:ReverseSamuraiLight/Walk/7.png");
	Image RWALK_8 = new Image("file:ReverseSamuraiLight/Walk/8.png");
	Image RWALK_9 = new Image("file:ReverseSamuraiLight/Walk/9.png");

	Image RSWORD_1 = new Image("file:ReverseSamuraiLight/Attack1H/1.png");
	Image RSWORD_2 = new Image("file:ReverseSamuraiLight/Attack1H/2.png");
	Image RSWORD_3 = new Image("file:ReverseSamuraiLight/Attack1H/3.png");
	Image RSWORD_4 = new Image("file:ReverseSamuraiLight/Attack1H/4.png");
	Image RSWORD_5 = new Image("file:ReverseSamuraiLight/Attack1H/5.png");
	Image RSWORD_6 = new Image("file:ReverseSamuraiLight/Attack1H/6.png");
	Image RSWORD_7 = new Image("file:ReverseSamuraiLight/Attack1H/7.png");
	Image RSWORD_8 = new Image("file:ReverseSamuraiLight/Attack1H/8.png");
	Image RSWORD_9 = new Image("file:ReverseSamuraiLight/Attack1H/9.png");

	Image RDEATH_0 = new Image("file:ReverseSamuraiLight/Die/0.png");
	Image RDEATH_1 = new Image("file:ReverseSamuraiLight/Die/1.png");
	Image RDEATH_2 = new Image("file:ReverseSamuraiLight/Die/2.png");
	Image RDEATH_3 = new Image("file:ReverseSamuraiLight/Die/3.png");
	Image RDEATH_4 = new Image("file:ReverseSamuraiLight/Die/4.png");
	Image RDEATH_5 = new Image("file:ReverseSamuraiLight/Die/5.png");
	Image RDEATH_6 = new Image("file:ReverseSamuraiLight/Die/6.png");
	Image RDEATH_7 = new Image("file:ReverseSamuraiLight/Die/7.png");
	Image RDEATH_8 = new Image("file:ReverseSamuraiLight/Die/8.png");
	Image RDEATH_9 = new Image("file:ReverseSamuraiLight/Die/9.png");


	private Animation samuraiWalk;
	AnimationTimer useSword;
	private Animation samuraiSword;
	private Animation samuraiDie;
	boolean attacking = false;
	Score score;

	boolean touch;

	int count;
	int count2;

	PlayerWorld world;
	Game game;

	public SamuraiLight(PlayerWorld worlds, Game games) {
		game = games;
		world = worlds;
		setImage(new Image("file:samurai_images/SamuraiHeavy/Stand/0.png"));
		samuraiWalk = new Animation(this, 7.5, false, WALK_0, WALK_1, WALK_2, WALK_3, WALK_4, WALK_5, WALK_6, WALK_7,
				WALK_8, WALK_9);
		samuraiSword = new Animation(this, 7.5, false, SWORD_1, SWORD_2, SWORD_3, SWORD_4, SWORD_5, SWORD_6, SWORD_7,
				SWORD_8, SWORD_9);
		samuraiDie = new Animation(this, 15, true, DEATH_0, DEATH_1, DEATH_2, DEATH_4, DEATH_5, DEATH_6, DEATH_7,
				DEATH_8, DEATH_9);
		
		if(game.isL1) {
			dy = (int) (Math.random() * 2 + 1);
			dx = (int) (Math.random() * 2 + 1);
		}else if(game.isL2) {
			dy = (int) (Math.random() * 2 + 2);
			dx = (int) (Math.random() * 3 + 3);
		}else if(game.isL3) {
			dy = (int) (Math.random() * 5 + 2);
			dx = (int) (Math.random() * 5 + 3);
		}

		//shuriken = new Shuriken(this);

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				if (!dead) {
					attack(shuriken);
					count++;
				}
			}

		}, (int) (Math.random() * 4000), (int) (Math.random() * 4000));
		

	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

	}

	public int getHP() {
		return hp;
	}

	public void setHP(int s) {
		hp = s;

	}

	@Override
	public void act(long now) {
		
		if (!dead) {
			if (attacking && !samuraiWalk.isRunning) {
				samuraiSword.runAnimation();

				if (getIntersectingObjects(Ninja.class).size() > 0) {

					if (world.finishedBreakingHeart) {
						world.decrementLives();
					}
				}

			} else if (!samuraiSword.isRunning) {
				if(!samuraiWalk.isRunning) {
					samuraiWalk.runAnimation();
					temp = (int)(Math.random() * 12);
					
				}
				moveRandom(temp);
			}

		}


	}

	private void moveRandom(int temp) {
		
			if(temp < 3) {
				if(this.getX() >= this.getWidth() / 2) {
					this.setX(this.getX() - dx);
				}
				//move left
			}else if(temp >= 3 && temp < 6) {
				//move right
				if(this.getX() <= player.getWorld().getWidth() - this.getWidth() / 2) {
					this.setX(this.getX() + dx);
				}
			}else {
				jump();
			}
	}

	public void die() {
		dead = true;
		samuraiWalk = null;
		samuraiSword = null;
		samuraiDie.runAnimation();
	}

	@Override
	public void attack(Weapon w) {
		attacking = !attacking;
	}

	public void setNinja(Ninja players) {
		player = players;
	}

	public void defend() {

	}

	@Override
	public void jump() {
		if (jumpOver) {
			startJumpTimer();
			jumpOver = false;
			dy = 0;
		}

	}
	
	private void startJumpTimer() {

		AnimationTimer timer = new AnimationTimer() {
			long delay = (long) Math.pow(10, 6);
			long previousTime;
			int counter = 0;
			int dir = 2;

			@Override
			public void handle(long now) {
				if ((now - previousTime) >= delay) {
					previousTime = now;
					counter++;
					dy += dir;
				}
				if (counter == 10) {
					dy = 0;
					dir *= -1;

				}
				if (counter == 20) {
					getWorld().removeKeyPressed(KeyCode.UP);
					jumpOver = true;
					this.stop();
				}
			}
		};
		timer.start();
	}
	
	private void setSLY(double d) {
		this.setY(d);
	}
	
	private double getSLY() {
		return this.getY();
	}

}