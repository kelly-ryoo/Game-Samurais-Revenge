import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PlayerWorld extends World {

	Game game;
	Heart heart1;
	Heart heart2;
	Heart heart3;
	protected int lives = 3;
	protected boolean finishedBreakingHeart;

	public PlayerWorld() {

	}

	public PlayerWorld(double w, double h, Game games) {
		finishedBreakingHeart = true;
		game = games;

		this.setWidth(w);
		this.setHeight(h);

		lives = 3;

		heart1 = new Heart(this);
		heart2 = new Heart(this);
		heart3 = new Heart(this);
		heart1.setX(750);
		heart1.setY(30);
		heart2.setX(690);
		heart2.setY(30);
		heart3.setX(630);
		heart3.setY(30);
		this.getChildren().addAll(heart1, heart2, heart3);
	}

	public void setNinja(Ninja player) {

	}

	public void decrementLives() {
		finishedBreakingHeart = false;
		lives--;
		removeHearts();
	}

	
	public void removeHearts() {

		if (lives == 2) {
			heart1.crackHeart();
		} else if (lives == 0) {
			heart2.crackHeart();
		} else if (lives == 1) {
			heart3.crackHeart();
		}

	}

	public boolean isAlive() {
		if (lives == 0 && game.getWorld().finishedBreakingHeart) {
			return false;
		} else {
			return true;
		}
	}
	
	

	@Override
	public void act(long now) {
		int samuraiL = 0;
		int samuraiH = 0;

		for (int i = 0; i < this.getChildren().size(); i++) {
			if (this.getChildren().get(i) instanceof SamuraiHeavy) {
				samuraiH++;
			}
		}
		for (int i = 0; i < this.getChildren().size(); i++) {
			if (this.getChildren().get(i) instanceof SamuraiLight) {
				samuraiL++;
			}
		}
		
		/*
		if (game.isL1) {
			
			if (SamuraiHeavy.totalDeaths >0 && samuraiH <= 1) {
				game.addH(1);
			} else if (SamuraiLight.totalDeaths >0 &&  samuraiL <= 2) {
				game.addL(1);
			}

		} else if (game.isL2) {
			
			if (SamuraiHeavy.totalDeaths >0 && samuraiH <= 2) {
				game.addH(2);
			} else if (SamuraiLight.totalDeaths >0 && samuraiL <= 2) {
				game.addL(2);
			}

		} else if (game.isL3) {
			
			if (SamuraiHeavy.totalDeaths >0 && samuraiH <= 3) {
				game.addH(2);

			} else if (SamuraiLight.totalDeaths > 0 && samuraiL <= 3) {
				game.addL(3);
			}

		}
		*/
		if (!isAlive()) {
			game.stop(true);
			this.stop();
		} else if(!game.isDojo){
			if (game.started && this.isAlive() && !this.getChildren().contains(SamuraiHeavy.class)
					&& !this.getChildren().contains(SamuraiLight.class)) {
				if (game.rightDeaths()) {
					game.stop(false);
					this.stop();
				}
			}
		}


	}

}
