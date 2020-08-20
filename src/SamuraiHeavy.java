import java.util.Timer;
import java.util.HashSet;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class SamuraiHeavy extends Enemy {

	Sword sword;
	Timer timer;
	Ninja player;

	// to adjust how fast they move
	int dx;
	int temp;
	double dy;
	static int totalDeaths;

	boolean jumpOver = true;

	double randomY = Math.random() * 200 + 150;
	double randomX = Math.random() * 700;

	// temp lives score keeper (COPIED FROM NINJA)
	int hp = 3;
	boolean dead;

	Image WALK_0 = new Image("file:samurai_images/SamuraiHeavy/Walk/0.png");
	Image WALK_1 = new Image("file:samurai_images/SamuraiHeavy/Walk/1.png");
	Image WALK_2 = new Image("file:samurai_images/SamuraiHeavy/Walk/2.png");
	Image WALK_3 = new Image("file:samurai_images/SamuraiHeavy/Walk/3.png");
	Image WALK_4 = new Image("file:samurai_images/SamuraiHeavy/Walk/4.png");
	Image WALK_5 = new Image("file:samurai_images/SamuraiHeavy/Walk/5.png");
	Image WALK_6 = new Image("file:samurai_images/SamuraiHeavy/Walk/6.png");
	Image WALK_7 = new Image("file:samurai_images/SamuraiHeavy/Walk/7.png");
	Image WALK_8 = new Image("file:samurai_images/SamuraiHeavy/Walk/8.png");
	Image WALK_9 = new Image("file:samurai_images/SamuraiHeavy/Walk/9.png");

	Image RWALK_0 = new Image("file:ReverseSamuraiHeavy/Walk/0.png");
	Image RWALK_1 = new Image("file:ReverseSamuraiHeavy/Walk/1.png");
	Image RWALK_2 = new Image("file:ReverseSamuraiHeavy/Walk/2.png");
	Image RWALK_3 = new Image("file:ReverseSamuraiHeavy/Walk/3.png");
	Image RWALK_4 = new Image("file:ReverseSamuraiHeavy/Walk/4.png");
	Image RWALK_5 = new Image("file:ReverseSamuraiHeavy/Walk/5.png");
	Image RWALK_6 = new Image("file:ReverseSamuraiHeavy/Walk/6.png");
	Image RWALK_7 = new Image("file:ReverseSamuraiHeavy/Walk/7.png");
	Image RWALK_8 = new Image("file:ReverseSamuraiHeavy/Walk/8.png");
	Image RWALK_9 = new Image("file:ReverseSamuraiHeavy/Walk/9.png");

	// FIX TO DEFAULT IMAGES
	Image SWORD_0 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/0.png");
	Image SWORD_1 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/1.png");
	Image SWORD_2 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/2.png");
	Image SWORD_3 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/3.png");
	Image SWORD_4 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/4.png");
	Image SWORD_5 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/5.png");
	Image SWORD_6 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/6.png");
	Image SWORD_7 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/7.png");
	Image SWORD_8 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/8.png");
	Image SWORD_9 = new Image("file:samurai_images/SamuraiHeavy/Attack2H/9.png");

	Image RSWORD_0 = new Image("file:ReverseSamuraiHeavy/Attack2H/0.png");
	Image RSWORD_1 = new Image("file:ReverseSamuraiHeavy/Attack2H/1.png");
	Image RSWORD_2 = new Image("file:ReverseSamuraiHeavy/Attack2H/2.png");
	Image RSWORD_3 = new Image("file:ReverseSamuraiHeavy/Attack2H/3.png");
	Image RSWORD_4 = new Image("file:ReverseSamuraiHeavy/Attack2H/4.png");
	Image RSWORD_5 = new Image("file:ReverseSamuraiHeavy/Attack2H/5.png");
	Image RSWORD_6 = new Image("file:ReverseSamuraiHeavy/Attack2H/6.png");
	Image RSWORD_7 = new Image("file:ReverseSamuraiHeavy/Attack2H/7.png");
	Image RSWORD_8 = new Image("file:ReverseSamuraiHeavy/Attack2H/8.png");
	Image RSWORD_9 = new Image("file:ReverseSamuraiHeavy/Attack2H/9.png");

	Image DIE_0 = new Image("file:samurai_images/SamuraiHeavy/Die/0.png");
	Image DIE_1 = new Image("file:samurai_images/SamuraiHeavy/Die/1.png");
	Image DIE_2 = new Image("file:samurai_images/SamuraiHeavy/Die/2.png");
	Image DIE_3 = new Image("file:samurai_images/SamuraiHeavy/Die/3.png");
	Image DIE_4 = new Image("file:samurai_images/SamuraiHeavy/Die/4.png");
	Image DIE_5 = new Image("file:samurai_images/SamuraiHeavy/Die/5.png");
	Image DIE_6 = new Image("file:samurai_images/SamuraiHeavy/Die/6.png");
	Image DIE_7 = new Image("file:samurai_images/SamuraiHeavy/Die/7.png");
	Image DIE_8 = new Image("file:samurai_images/SamuraiHeavy/Die/8.png");
	Image DIE_9 = new Image("file:samurai_images/SamuraiHeavy/Die/9.png");

	Image RDIE_0 = new Image("file:ReverseSamuraiHeavy/Die/0.png");
	Image RDIE_1 = new Image("file:ReverseSamuraiHeavy/Die/1.png");
	Image RDIE_2 = new Image("file:ReverseSamuraiHeavy/Die/2.png");
	Image RDIE_3 = new Image("file:ReverseSamuraiHeavy/Die/3.png");
	Image RDIE_4 = new Image("file:ReverseSamuraiHeavy/Die/4.png");
	Image RDIE_5 = new Image("file:ReverseSamuraiHeavy/Die/5.png");
	Image RDIE_6 = new Image("file:ReverseSamuraiHeavy/Die/6.png");
	Image RDIE_7 = new Image("file:ReverseSamuraiHeavy/Die/7.png");
	Image RDIE_8 = new Image("file:ReverseSamuraiHeavy/Die/8.png");
	Image RDIE_9 = new Image("file:ReverseSamuraiHeavy/Die/9.png");

	private Animation samuraiWalk;
	private Animation samuraiSword;
	private Animation samuraiDie;
	boolean attacking;

	PlayerWorld world;
	Game game;

	public SamuraiHeavy(PlayerWorld worlds, Game games) {
		world = worlds;
		game = games;

		if(game.isL1) {
			dx = (int) (Math.random() * 6 + 1);
		}else if(game.isL2) {
			dx = (int) (Math.random() * 6 + 3);
		}else if(game.isL3) {
			dx = (int) (Math.random() * 11 + 2);
		}
		
		this.setX(randomX);

		setImage(new Image("file:samurai_images/SamuraiHeavy/Stand/0.png"));
		samuraiWalk = new Animation(this, 4.5, false, WALK_0, WALK_1, WALK_2, WALK_3, WALK_4, WALK_5, WALK_6, WALK_7,
				WALK_8, WALK_9);
		samuraiSword = new Animation(this, 4.5, false, SWORD_0, SWORD_1, SWORD_2, SWORD_3, SWORD_4, SWORD_5, SWORD_6,
				SWORD_7, SWORD_8, SWORD_9);
		samuraiDie = new Animation(this, 10, true, DIE_0, DIE_1, DIE_2, DIE_3, DIE_4, DIE_5, DIE_6, DIE_7, DIE_8,
				DIE_9);

		sword = new Sword();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				if (!dead) {
					attack(sword);

				}
			}

		}, 0000, 4000);
	
		/*
		 * the animation now works so that every 4 seconds the samurai switches between
		 * walking and attacking. we can change the amount of time of either walking or
		 * attacking if we want.
		 * 
		 */
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
	public void attack(Weapon w) {
		attacking = !attacking;
	}

	public void setNinja(Ninja players) {
		player = players;
	}

	public void die() {
		dead = true;
		samuraiWalk.stop();
		samuraiSword.stop();
		samuraiDie.runAnimation();
	}

	public void changeDyDx() {
//		if (this.getY() >= 420 || this.getY() <= 300) {
//			dy = -dy;
//			// 420 - 520
//		}

		if (this.getX() >= 750 || this.getX() <= 0) {
			dx = -dx;

		}
	}

	public void reverseDirections() {

		if (dx > 0) {
			samuraiWalk.resetImages(RWALK_0, RWALK_1, RWALK_2, RWALK_3, RWALK_4, RWALK_5, RWALK_6, RWALK_7, RWALK_8,
					RWALK_9);
			samuraiWalk.setSpeed(4.5);
			samuraiSword.resetImages(RSWORD_0, RSWORD_1, RSWORD_2, RSWORD_3, RSWORD_4, RSWORD_5, RSWORD_6, RSWORD_7,
					RSWORD_8, RSWORD_9);
			samuraiSword.setSpeed(4.5);
			samuraiDie.resetImages(RDIE_0, RDIE_1, RDIE_2, RDIE_3, RDIE_4, RDIE_5, RDIE_6, RDIE_7, RDIE_8, RDIE_9);
		} else {
			samuraiWalk.resetImages(WALK_0, WALK_1, WALK_2, WALK_3, WALK_4, WALK_5, WALK_6, WALK_7, WALK_8, WALK_9);
			//samuraiWalk.setSpeed(5);
			samuraiWalk.setSpeed(2);
			samuraiSword.resetImages(SWORD_0, SWORD_1, SWORD_2, SWORD_3, SWORD_4, SWORD_5, SWORD_6, SWORD_7, SWORD_8,
					SWORD_9);
			samuraiSword.setSpeed(4.5);
			samuraiDie.resetImages(DIE_0, DIE_1, DIE_2, DIE_3, DIE_4, DIE_5, DIE_6, DIE_7, DIE_8, DIE_9);
		}
	}

	@Override
	public void act(long now) {

		if (!dead) {
			this.move(dx, 0);

			this.changeDyDx();

			reverseDirections();
			
			this.setY(410);
			
			if (attacking && !samuraiWalk.isRunning) {
				samuraiSword.runAnimation();
				if (getIntersectingObjects(Ninja.class).size() > 0) {
					if (world.finishedBreakingHeart) {
						world.decrementLives();
					}
				}

			} else if (!samuraiSword.isRunning) {
				if (!samuraiWalk.isRunning) {
					samuraiWalk.runAnimation();
					temp = (int) (Math.random() * 12);

				}
				moveRandom(temp);

			}
			

		}

	}

	private void moveRandom(int temp) {
		
		if (temp < 3) {
			if (this.getX() >= this.getWidth() / 2) {
				this.setX(this.getX() - dx);
			}
			// move left
		} else if (temp >= 3 && temp < 6) {
			// move right
			if (this.getX() <= player.getWorld().getWidth() - this.getWidth() / 2) {
				this.setX(this.getX() + dx);
			}
		} else {
			jump();
		}
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
			int dir = 10;

			@Override
			public void handle(long now) {
				if ((now - previousTime) >= delay) {
					previousTime = now;
					counter++;
					dy += dir;
					setSHY(getSHY() + dy);
				}
				if (counter == 12) {
					dy = 0;
					dir *= -1;

				}
				if (counter == 24) {
					jumpOver = true;
					this.stop();
				}
			}
		};
		timer.start();
	}

	private void setSHY(double d) {
		this.setY(d);
	}

	private double getSHY() {
		return this.getY();
	}
}
