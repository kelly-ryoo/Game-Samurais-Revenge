import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Level {

	boolean levelOne = false;
	boolean levelTwo = false;
	boolean levelThree = false;
	boolean dojo = false;
	Game game;

	int levelNum;

	public Level(int level, Game games) {
		levelNum = level;
		game = games;

		if (level <= 0) {
			dojo = true;

		} else if (level == 1) {

			levelOne = true;

		} else if (level == 2) {

			levelTwo = true;
			
		} else if (level >= 3) {

			levelThree = true;

		}

	}

	public void play() {

		if (dojo) {
			game.levels[0] = true;
			game.levels[1] = false;
			game.levels[2] = false;
			game.levels[3] = false;
			
			BackgroundImage[] images = new BackgroundImage[1];
			images[0] = new BackgroundImage(new Image("file:background_images/dojo.jpg"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			Background background = new Background(images);
			playDojo();
			game.setBackground(background);

		} else if (levelOne) {
			game.levels[0] = false;
			game.levels[1] = true;
			game.levels[2] = false;
			game.levels[3] = false;
			
			BackgroundImage[] images = new BackgroundImage[1];
			images[0] = new BackgroundImage(new Image("file:background_images/forest.png"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			Background background = new Background(images);
			playL1();
			game.setBackground(background);

		} else if (levelTwo) {
			game.levels[0] = false;
			game.levels[1] = false;
			game.levels[2] = true;
			game.levels[3] = false;
			
			BackgroundImage[] images = new BackgroundImage[1];
			images[0] = new BackgroundImage(new Image("file:background_images/temple.jpg"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			Background background = new Background(images);
			playL2();
			game.setBackground(background);

		} else if (levelThree) {
			game.levels[0] = false;
			game.levels[1] = false;
			game.levels[2] = false;
			game.levels[3] = true;
			
			BackgroundImage[] images = new BackgroundImage[1];
			images[0] = new BackgroundImage(new Image("file:background_images/volcano.jpg"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			Background background = new Background(images);
			playL3();
			game.setBackground(background);

		}

		System.out.println(this.toString() + " play");

	}

	public int getLevel() {
		return levelNum;
	}

	private void playDojo() {
		game.play();
	}

	private void playL3() {

		game.play();

	}

	private void playL2() {

		game.play();

	}

	private void playL1() {

		game.play();

	}

}
