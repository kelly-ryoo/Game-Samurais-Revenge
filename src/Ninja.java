import java.util.ArrayList;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Ninja extends Player {
	// Main Player
	int hp = 3;
	int dx = 5;
	double dy = 0;
	boolean jumpOver = true;
	boolean facingRight = true;
	Score score;

	Image WALK_0 = new Image("file:samurai_images/Ninja/Walk/0.png");
	Image WALK_1 = new Image("file:samurai_images/Ninja/Walk/1.png");
	Image WALK_2 = new Image("file:samurai_images/Ninja/Walk/2.png");
	Image WALK_3 = new Image("file:samurai_images/Ninja/Walk/3.png");
	Image WALK_4 = new Image("file:samurai_images/Ninja/Walk/4.png");
	Image WALK_5 = new Image("file:samurai_images/Ninja/Walk/5.png");
	Image WALK_6 = new Image("file:samurai_images/Ninja/Walk/6.png");
	Image WALK_7 = new Image("file:samurai_images/Ninja/Walk/7.png");
	Image WALK_8 = new Image("file:samurai_images/Ninja/Walk/8.png");
	Image WALK_9 = new Image("file:samurai_images/Ninja/Walk/9.png");

	Image RWALK_0 = new Image("file:samurai_images/Ninja/ReverseWalk/0.png");
	Image RWALK_1 = new Image("file:samurai_images/Ninja/ReverseWalk/1.png");
	Image RWALK_2 = new Image("file:samurai_images/Ninja/ReverseWalk/2.png");
	Image RWALK_3 = new Image("file:samurai_images/Ninja/ReverseWalk/3.png");
	Image RWALK_4 = new Image("file:samurai_images/Ninja/ReverseWalk/4.png");
	Image RWALK_5 = new Image("file:samurai_images/Ninja/ReverseWalk/5.png");
	Image RWALK_6 = new Image("file:samurai_images/Ninja/ReverseWalk/6.png");
	Image RWALK_7 = new Image("file:samurai_images/Ninja/ReverseWalk/7.png");
	Image RWALK_8 = new Image("file:samurai_images/Ninja/ReverseWalk/8.png");
	Image RWALK_9 = new Image("file:samurai_images/Ninja/ReverseWalk/9.png");

	Image SWORD_0 = new Image("file:samurai_images/Ninja/AttackTween/0.png");
	Image SWORD_1 = new Image("file:samurai_images/Ninja/AttackTween/1.png");
	Image SWORD_2 = new Image("file:samurai_images/Ninja/AttackTween/2.png");
	Image SWORD_3 = new Image("file:samurai_images/Ninja/AttackTween/3.png");
	Image SWORD_4 = new Image("file:samurai_images/Ninja/AttackTween/4.png");
	Image SWORD_5 = new Image("file:samurai_images/Ninja/AttackTween/5.png");
	Image SWORD_6 = new Image("file:samurai_images/Ninja/AttackTween/6.png");
	Image SWORD_7 = new Image("file:samurai_images/Ninja/AttackTween/7.png");
	Image SWORD_8 = new Image("file:samurai_images/Ninja/AttackTween/8.png");
	Image SWORD_9 = new Image("file:samurai_images/Ninja/AttackTween/9.png");

	Image RSWORD_0 = new Image("file:samurai_images/Ninja/ReverseAttack/0.png");
	Image RSWORD_1 = new Image("file:samurai_images/Ninja/ReverseAttack/1.png");
	Image RSWORD_2 = new Image("file:samurai_images/Ninja/ReverseAttack/2.png");
	Image RSWORD_3 = new Image("file:samurai_images/Ninja/ReverseAttack/3.png");
	Image RSWORD_4 = new Image("file:samurai_images/Ninja/ReverseAttack/4.png");
	Image RSWORD_5 = new Image("file:samurai_images/Ninja/ReverseAttack/5.png");
	Image RSWORD_6 = new Image("file:samurai_images/Ninja/ReverseAttack/6.png");
	Image RSWORD_7 = new Image("file:samurai_images/Ninja/ReverseAttack/7.png");
	Image RSWORD_8 = new Image("file:samurai_images/Ninja/ReverseAttack/8.png");
	Image RSWORD_9 = new Image("file:samurai_images/Ninja/ReverseAttack/9.png");

	Image THROW_0 = new Image("file:samurai_images/Ninja/Run/0.png");
	Image THROW_1 = new Image("file:samurai_images/Ninja/Run/1.png");
	Image THROW_2 = new Image("file:samurai_images/Ninja/Run/2.png");
	Image THROW_3 = new Image("file:samurai_images/Ninja/Run/3.png");
	Image THROW_4 = new Image("file:samurai_images/Ninja/Run/4.png");
	Image THROW_5 = new Image("file:samurai_images/Ninja/Run/5.png");
	Image THROW_6 = new Image("file:samurai_images/Ninja/Run/6.png");
	Image THROW_7 = new Image("file:samurai_images/Ninja/Run/7.png");
	Image THROW_8 = new Image("file:samurai_images/Ninja/Run/8.png");
	Image THROW_9 = new Image("file:samurai_images/Ninja/Run/9.png");

	Image STAND_0 = new Image("file:samurai_images/Ninja/Stand/0.png");
	Image STAND_1 = new Image("file:samurai_images/Ninja/Stand/1.png");
	Image STAND_2 = new Image("file:samurai_images/Ninja/Stand/2.png");
	Image STAND_3 = new Image("file:samurai_images/Ninja/Stand/3.png");
	Image STAND_4 = new Image("file:samurai_images/Ninja/Stand/4.png");
	Image STAND_5 = new Image("file:samurai_images/Ninja/Stand/5.png");
	Image STAND_6 = new Image("file:samurai_images/Ninja/Stand/6.png");
	Image STAND_7 = new Image("file:samurai_images/Ninja/Stand/7.png");
	Image STAND_8 = new Image("file:samurai_images/Ninja/Stand/8.png");
	Image STAND_9 = new Image("file:samurai_images/Ninja/Stand/9.png");

	Image DIE_0 = new Image("file:samurai_images/Ninja/Die2/0.png");
	Image DIE_1 = new Image("file:samurai_images/Ninja/Die2/1.png");
	Image DIE_2 = new Image("file:samurai_images/Ninja/Die2/2.png");
	Image DIE_3 = new Image("file:samurai_images/Ninja/Die2/3.png");
	Image DIE_4 = new Image("file:samurai_images/Ninja/Die2/4.png");
	Image DIE_5 = new Image("file:samurai_images/Ninja/Die2/5.png");
	Image DIE_6 = new Image("file:samurai_images/Ninja/Die2/6.png");
	Image DIE_7 = new Image("file:samurai_images/Ninja/Die2/7.png");
	Image DIE_8 = new Image("file:samurai_images/Ninja/Die2/8.png");
	Image DIE_9 = new Image("file:samurai_images/Ninja/Die2/9.png");

	Image RDIE_0 = new Image("file:samurai_images/Ninja/ReverseDie/0.png");
	Image RDIE_1 = new Image("file:samurai_images/Ninja/ReverseDie/1.png");
	Image RDIE_2 = new Image("file:samurai_images/Ninja/ReverseDie/2.png");
	Image RDIE_3 = new Image("file:samurai_images/Ninja/ReverseDie/3.png");
	Image RDIE_4 = new Image("file:samurai_images/Ninja/ReverseDie/4.png");
	Image RDIE_5 = new Image("file:samurai_images/Ninja/ReverseDie/5.png");
	Image RDIE_6 = new Image("file:samurai_images/Ninja/ReverseDie/6.png");
	Image RDIE_7 = new Image("file:samurai_images/Ninja/ReverseDie/7.png");
	Image RDIE_8 = new Image("file:samurai_images/Ninja/ReverseDie/8.png");
	Image RDIE_9 = new Image("file:samurai_images/Ninja/ReverseDie/9.png");

	PlayerWorld world;

	private Animation playerWalk;
	private Animation playerSword;
	private Animation playerReverseSword;
	private Animation playerShuriken;
	private Animation playerIdle;
	private Animation playerReverseWalk;
	private Animation playerDie;
	private Animation reverseDie;
	AnimationTimer useSword;

	ArrayList<Weapon> allWeapons;
	boolean canThrow = true;

	Game game;

	public Ninja(PlayerWorld worlds, Score scores, Game games) {
		game = games;
		world = worlds;
		setImage(WALK_0);
		score = scores;

		allWeapons = new ArrayList<Weapon>();

		playerWalk = new Animation(this, 7.5, false, WALK_0, WALK_1, WALK_2, WALK_3, WALK_4, WALK_5, WALK_6, WALK_7,
				WALK_8, WALK_9);
		playerReverseWalk = new Animation(this, 7.5, false, RWALK_0, RWALK_1, RWALK_2, RWALK_3, RWALK_4, RWALK_5,
				RWALK_6, RWALK_7, RWALK_8, RWALK_9);
		playerReverseSword = new Animation(this, 7.5, false, RSWORD_0, RSWORD_1, RSWORD_2, RSWORD_3, RSWORD_4, RSWORD_5,
				RSWORD_6, RSWORD_7, RSWORD_8, RSWORD_9);
		playerSword = new Animation(this, 7.5, false, SWORD_0, SWORD_1, SWORD_2, SWORD_3, SWORD_4, SWORD_5, SWORD_6,
				SWORD_7, SWORD_8, SWORD_9);
		playerShuriken = new Animation(this, 1, false, WALK_0, WALK_1, WALK_2, WALK_3, WALK_4, WALK_5, WALK_6, WALK_7,
				WALK_8, WALK_9);
		playerIdle = new Animation(this, 7.5, false, STAND_2, STAND_3, STAND_4, STAND_5, STAND_6, STAND_7);
		playerIdle = new Animation(this, 7.5, false, STAND_2, STAND_3, STAND_4, STAND_5, STAND_6, STAND_7);
		playerDie = new Animation(this, 10, true, DIE_0, DIE_1, DIE_2, DIE_3, DIE_4, DIE_5, DIE_6, DIE_7, DIE_8, DIE_9);
		reverseDie = new Animation(this, 10, true, RDIE_0, RDIE_1, RDIE_2, RDIE_3, RDIE_4, RDIE_5, RDIE_6, RDIE_7, RDIE_8, RDIE_9);

		// playerDie = new Animation(this, 10, true, DIE_0, DIE_0, DIE_0, DIE_0, DIE_0,
		// DIE_0, DIE_0, DIE_0, DIE_0, DIE_0);
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void decrementLife() {
		world.lives--;
	}

	public void setScore(int s) {
		score.setScore(s);
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int s) {
		hp = s;
	}

	@Override
	public void jump() {
		if (jumpOver) {
			startJumpTimer();
			jumpOver = false;
			dy = 0;
		}

	}

	@Override
	public void attack(Weapon w) {
		if (w instanceof Shuriken) {
			if (facingRight) {
				playerWalk.runAnimation();
			} else {
				playerReverseWalk.runAnimation();
			}
			allWeapons.add(w);
			getWorld().getChildren().add((Shuriken) w);

		} else if (w instanceof Kunai) {
			if (facingRight) {
				playerWalk.runAnimation();
			} else {
				playerReverseWalk.runAnimation();
			}
			allWeapons.add(w);
			getWorld().getChildren().add((Kunai) w);

		} else if (w instanceof Sword) {
			if (facingRight) {
				playerSword.runAnimation();
			} else {
				playerReverseSword.runAnimation();
			}

		}

		w.use();

		// ninja touching samurai while attacking
		if (this.getIntersectingObjects(SamuraiHeavy.class).size() > 0) {
			// samurai losing lives and dying
			SamuraiHeavy samH = this.getIntersectingObjects(SamuraiHeavy.class).get(0);
			samH.setHP(samH.getHP() - 1);

			// System.out.println("kunai touched sH. will die.");
			samH.die();

			score.incrementTen();

		}
		if (this.getIntersectingObjects(SamuraiLight.class).size() > 0) {
			// samurai losing lives and dying
			SamuraiLight samL = this.getIntersectingObjects(SamuraiLight.class).get(0);
			samL.setHP(samL.getHP() - 1);

			// System.out.println("kunai touched sH. will die.");
			samL.die();

			score.incrementFive();
		}
		score.updateDisplay();
	}

	public int getScore() {
		return score.getScore();
	}

	@Override
	public void defend() {
		// TODO Auto-generated method stub

	}

	@Override
	public void act(long now) {
		
		if (world.isAlive()) {
			
			
			if (getWorld().isKeyDown(KeyCode.UP)) {
				jump();
			}
			if (getWorld().isKeyDown(KeyCode.LEFT)) {
				facingRight = false;
				if (this.getImage().equals(WALK_0))
					this.setImage(RWALK_0);
				playerReverseWalk.runAnimation();
				if (this.getX() > 0) {
					this.setX(this.getX() - dx);
				}
			} else if (getWorld().isKeyDown(KeyCode.RIGHT)) {
				facingRight = true;
				playerWalk.runAnimation();
				if (this.getX() < getScene().getWidth() - this.getImage().getWidth()) {
					this.setX(this.getX() + dx);
				}
			}

			if (getWorld().isKeyDown(KeyCode.A)) {
				Sword s = new Sword();
				attack(s);

			} else if (canThrow) {
				if (getWorld().isKeyDown(KeyCode.S)) {
					if (!game.isLevel3()) {

						Shuriken s = new Shuriken(this);
						attack(s);
						reloadWeapon();
					}

				} else if (getWorld().isKeyDown(KeyCode.D)) {
					if (game.isLevel3() || game.isDojo()) {
						Kunai k = new Kunai(this);
						attack(k);
						reloadWeapon();
					}
				}
			}

		}

		if (!world.isAlive()) {
			if (!facingRight) {
				reverseDie.runAnimation();
			} else {
				playerDie.runAnimation();
			}
		}

	}

	private void setNinjaY(double y) {
		this.setY(y);
	}

	private double getNinjaY() {
		return this.getY();
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
					setNinjaY(getNinjaY() - dy);
				}
				if (counter == 13) {
					dy = 0;
					dir *= -1;

				}
				if (counter == 26) {
					getWorld().removeKeyPressed(KeyCode.UP);
					jumpOver = true;
					this.stop();
				}
			}
		};
		timer.start();
	}

	public void reloadWeapon() {
		canThrow = false;
		int limit = 20;
		AnimationTimer reload = new AnimationTimer() {
			long delay = (long) Math.pow(10, 6);
			long previousTime;
			int counter = 0;

			@Override
			public void handle(long now) {
				if ((now - previousTime) >= delay) {
					previousTime = now;
					counter++;
				}

				if (counter == limit) {
					counter = 0;
					canThrow = true;
					this.stop();
				}
			}

		};
		reload.start();
	}

	public void removeWeapon(Weapon w) {
		allWeapons.remove(w);
		getWorld().getChildren().remove(w);
	}

	public void updateDisplay() {
		score.updateDisplay();
	}

}
