import java.util.Timer;
import java.util.TimerTask;

//import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {
	long startTime;
	Stage stage;
	Scene scene, scene2;
	BorderPane root, root2;
	PlayerWorld world, menu;
	boolean gameStopped = false;
	
	Score score;

	Button howToPlay, start, backtoMenu, dojoButton, level1Button, level2Button, level3Button;
	Level dojo, level1, level2, level3;
	MyEventHandler meh = new MyEventHandler();
	boolean started;
	private Ninja ninja;

	static int totalSamL;
	static int totalSamH;

	protected boolean isL1, isL2, isL3, isDojo;
	protected boolean[] levels = { isDojo, isL1, isL2, isL3 };

	public static void main(String[] args) {
		launch(args);
	}

	public void stop(boolean lost) {
		if(!gameStopped) {
			gameStopped = true;
			stage.setTitle("Game Over!");
			stage.setResizable(false);
			root2 = new BorderPane();
			scene2 = new Scene(root2, 850, 570);
			stage.setScene(scene2);
			world = new PlayerWorld();
	
			ImageView buttonsMenuImage = new ImageView(new Image("file:button_images/HOME.png"));
			backtoMenu = new Button(null, buttonsMenuImage);
			backtoMenu.setBackground(Background.EMPTY);
			backtoMenu.setOnMouseClicked(meh);
			world.getChildren().add(backtoMenu);
			System.out.println(world.getChildren().toString());
			
			BackgroundImage[] images = new BackgroundImage[1];
			if (!lost) {
				images[0] = new BackgroundImage(new Image("file:message/YOU_WIN.png"), BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			} else {
				images[0] = new BackgroundImage(new Image("file:message/YOU_LOSE.png"), BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
			}
			Background background = new Background(images);
			root2.setBackground(background);
			root2.setCenter(score);
			root2.setLeft(backtoMenu);
			//world.getChildren().addAll(score);
			score.setX(500);
			score.setY(100);
			
			//stage.setScene(scene2);
			stage.show();
		}

	}

	@Override
	public void start(Stage stage) throws Exception {
		dojo = new Level(0, this);
		level1 = new Level(1, this);
		level2 = new Level(2, this);
		level3 = new Level(3, this);

		AudioClip music = new AudioClip("file:music/music.mp3"); // replace /Movies/test.mp3 with your file
		music.play();

		this.stage = stage;
		// calling mainMenu brings the main menu scene with buttons to choose
		// levels/demo/how to play
		mainMenu();

		// calling play brings up the world with all the players
		// for debug purposes, comment mainMenu() and uncomment play()
		// play();
	}

	public void setBackground(Background background) {
		root.setBackground(background);
	}

	

	public Stage getStage() {
		return stage;
	}

	protected void play() {

		stage.setTitle("Game Project");
		stage.setResizable(false);
		root = new BorderPane();
		world = new PlayerWorld(850, 570, this);
		root.getChildren().add(world);
		BorderPane.setAlignment(world, Pos.CENTER);
		scene = new Scene(root, 850, 570);

		score = new Score();


		ninja = new Ninja(world, score, this);
		ninja.setX(50);
		ninja.setY(400);
		world.add(ninja);
		world.setNinja(ninja);

		int numSamuraiLight = 0;
		int numSamuraiHeavy = 0;

		if (levels[0]) {

		} else if (levels[1]) {
			numSamuraiLight = 3;
			numSamuraiHeavy = 5;
		} else if (levels[2]) {
			numSamuraiLight = 10;
			numSamuraiHeavy = 12;
		} else if (levels[3]) {
			numSamuraiLight = 15;
			numSamuraiHeavy = 15;
		}

		for (int i = 0; i < numSamuraiLight; i++) {

			int x = (int) (Math.random() * 600 + 120);
			int y = (int) ((Math.random() * 50 + 350));
			totalSamL++;
			SamuraiLight samuraiLight = new SamuraiLight(world, this);
			samuraiLight.setX(x);
			samuraiLight.setY(y);
			samuraiLight.setNinja(ninja);
			world.add(samuraiLight);
		}

		for (int i = 0; i < numSamuraiHeavy; i++) {
			int x = (int) (Math.random() * 600 + 120);
			int y = (int) (Math.random() * 50 + 350);
			totalSamH++;
			SamuraiHeavy samuraiHeavy = new SamuraiHeavy(world, this);
			samuraiHeavy.setX(x);
			samuraiHeavy.setY(y);
			samuraiHeavy.setNinja(ninja);
			world.add(samuraiHeavy);
		}

		/*
		 * // DEBUGGING javafx.scene.shape.Rectangle r1 = new
		 * javafx.scene.shape.Rectangle((int) samuraiLight.getX(), (int)
		 * samuraiLight.getY(), (int) samuraiLight.getWidth(), (int)
		 * samuraiLight.getHeight()); // world.add(r1); javafx.scene.shape.Rectangle r2
		 * = new javafx.scene.shape.Rectangle((int) samuraiHeavy.getX(), (int)
		 * samuraiHeavy.getY(), (int) samuraiHeavy.getWidth(), (int)
		 * samuraiHeavy.getHeight()); // world.add(r2);
		 *
		 */

		ImageView buttonsMenuImage = new ImageView(new Image("file:button_images/HOME.png"));
		backtoMenu = new Button(null, buttonsMenuImage);
		backtoMenu.setBackground(Background.EMPTY);
		backtoMenu.setOnMouseClicked(meh);
		world.getChildren().add(backtoMenu);
		world.requestFocus();
		world.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					world.addKeyPressed(KeyCode.LEFT);
				} else if (event.getCode() == KeyCode.RIGHT) {
					world.addKeyPressed(KeyCode.RIGHT);
				} else if (event.getCode() == KeyCode.UP) {
					world.addKeyPressed(KeyCode.UP);
				}
				if (event.getCode() == KeyCode.A) {
					world.addKeyPressed(KeyCode.A);
				} else if (event.getCode() == KeyCode.S) {
					world.addKeyPressed(KeyCode.S);
				} else if (event.getCode() == KeyCode.D) {
					world.addKeyPressed(KeyCode.D);
				}
			}
		});
		world.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					world.removeKeyPressed(KeyCode.LEFT);
				} else if (event.getCode() == KeyCode.RIGHT) {
					world.removeKeyPressed(KeyCode.RIGHT);
				} else if (event.getCode() == KeyCode.UP) {
					world.removeKeyPressed(KeyCode.UP);
				}
				if (event.getCode() == KeyCode.A) {
					world.removeKeyPressed(KeyCode.A);
				} else if (event.getCode() == KeyCode.S) {
					world.removeKeyPressed(KeyCode.S);
				} else if (event.getCode() == KeyCode.D) {
					world.removeKeyPressed(KeyCode.D);
				}

			}
		});

		score.setX(500);
		score.setY(100);
		world.add(score);
		world.start();
		stage.setScene(scene);
		stage.show();

		started = true;

	}

	public void addL(int h) {
		
		for (int i = 0; i < h; i++) {

			int x = (int) (Math.random() * 600 + 120);
			int y = 400;
			totalSamL++;
			SamuraiLight samuraiLight = new SamuraiLight(world, this);
			samuraiLight.setX(x);
			samuraiLight.setY(y);
			samuraiLight.setNinja(ninja);
			world.add(samuraiLight);
		}

	}

	public void addH(int h) {

		for (int i = 0; i < h; i++) {

			int x = (int) (Math.random() * 600 + 120);
			int y = 400;
			totalSamH++;
			SamuraiHeavy samH = new SamuraiHeavy(world, this);
			samH.setX(x);
			samH.setY(y);
			samH.setNinja(ninja);
			// samH.setNinja((Ninja)world.getChildren().get(world.getChildren().indexOf(Ninja.class)));
			world.add(samH);
		}
	}

	public PlayerWorld getWorld() {
		return world;
	}

	private void mainMenu() {

		stage.setTitle("Main Menu");
		stage.setResizable(false);
		root2 = new BorderPane();
		scene2 = new Scene(root2, 850, 570);
		stage.setScene(scene2);
		menu = new PlayerWorld();
		root2.getChildren().add(menu);

		BackgroundImage[] images = new BackgroundImage[1];
		images[0] = new BackgroundImage(new Image("file:background_images/mainmenu.png"), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(images);
		root2.setBackground(background);

		howToPlay = new Button(null);
		start = new Button(null);
		dojoButton = new Button(null);
		level1Button = new Button(null);
		level2Button = new Button(null);
		level3Button = new Button(null);

		dojoButton.setOnMouseClicked(new MyEventHandler());
		level1Button.setOnMouseClicked(new MyEventHandler());
		level2Button.setOnMouseClicked(new MyEventHandler());
		level3Button.setOnMouseClicked(new MyEventHandler());

		// TEMPORARY BOX FOR BUTTONS
		VBox buttons = new VBox();
		buttons.getChildren().addAll(howToPlay, start, dojoButton, level1Button, level2Button, level3Button);
		menu.getChildren().add(buttons);

		howToPlay.setBackground(Background.EMPTY);
		howToPlay.setTranslateX(197);
		howToPlay.setTranslateY(275);
		howToPlay.setPrefWidth(130);
		howToPlay.setPrefHeight(28);

		start.setBackground(Background.EMPTY);
		start.setTranslateX(197);
		start.setTranslateY(285);
		start.setPrefWidth(90);
		start.setPrefHeight(28);

		dojoButton.setBackground(Background.EMPTY);
		dojoButton.setTranslateX(197);
		dojoButton.setTranslateY(295);
		dojoButton.setPrefWidth(175);
		dojoButton.setPrefHeight(28);

		level1Button.setBackground(Background.EMPTY);
		level1Button.setTranslateX(197);
		level1Button.setTranslateY(305);
		level1Button.setPrefWidth(140);
		level1Button.setPrefHeight(28);

		level2Button.setBackground(Background.EMPTY);
		level2Button.setTranslateX(197);
		level2Button.setTranslateY(315);
		level2Button.setPrefWidth(140);
		level2Button.setPrefHeight(28);

		level3Button.setBackground(Background.EMPTY);
		level3Button.setTranslateX(197);
		level3Button.setTranslateY(325);
		level3Button.setPrefWidth(140);
		level3Button.setPrefHeight(28);

		howToPlay.setOnMouseClicked(meh);
		start.setOnMouseClicked(meh);

		stage.setScene(scene2);
		stage.show();
	}

	public boolean isDojo() {
		return isDojo;
	}

	public boolean isLevel2() {
		if (isL2) {
			return true;
		}
		return false;
	}

	public boolean isLevel3() {
		if (isL3) {
			return true;
		}

		return false;
	}

	private class MyEventHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {

			if (event.getSource() == howToPlay) {

				Group root = new Group();
				Stage stage = new Stage();
				stage.setTitle("How To Play");
				stage.setResizable(false);
				stage.setScene(new Scene(root, 600, 600));

				ScrollPane scrollPane = new ScrollPane();
				scrollPane.setPrefSize(600, 600);

				scrollPane.setPannable(true);
				ImageView instructions = new ImageView(new Image("file:background_images/instructions.png"));
				scrollPane.setContent(instructions);

				root.getChildren().add(scrollPane);

				stage.show();
			} else if (event.getSource() == start) {
				isDojo = true;
				isL1 = false;
				isL2 = false;
				isL3 = false;
				dojo.play();
			} else if (event.getSource() == backtoMenu) {
				gameStopped = false;
				world.stop();
				mainMenu();
			} else if (event.getSource() == dojoButton) {
				isDojo = true;
				isL1 = false;
				isL2 = false;
				isL3 = false;
				dojo.play();
			} else if (event.getSource() == level1Button) {
				isDojo = false;
				isL1 = true;
				isL2 = false;
				isL3 = false;
				level1.play();
			} else if (event.getSource() == level2Button) {
				isDojo = false;
				isL1 = false;
				isL2 = true;
				isL3 = false;
				level2.play();
			} else if (event.getSource() == level3Button) {
				isDojo = false;
				isL1 = false;
				isL2 = false;
				isL3 = true;
				level3.play();
			}
		}
	}

	public long getStart() {
		return startTime;
	}

	public boolean rightDeaths() {

		if (SamuraiLight.totalDeaths == totalSamL) {
			if (SamuraiHeavy.totalDeaths == totalSamH) {
				return true;
			}
		}
		return false;
	}

}