package drawing;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameisOver extends Application {
	private Canvas canvas;
	private GraphicsContext gc;
	private Image background = new Image(ClassLoader.getSystemResource("GameOver_new.gif").toString());
	private int totalScore;
	private Stage primaryStage;
	private final Font SPACE_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("CourierNew.ttf"), 30);

	public GameisOver(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		StackPane root = new StackPane();

		this.canvas = new Canvas(800, 600);
		this.gc = (this.canvas).getGraphicsContext2D();
		draw(gc, this.totalScore);

		root.getChildren().add(this.canvas);
		Scene scene = new Scene(root);
		(scene).setOnKeyPressed(KeyEvent -> {
			if (KeyEvent.getCode() == KeyCode.SPACE) {
				System.out.println("SPACE");
				StartWindow start = new StartWindow(primaryStage);
				start.startAnimation();
			}
		});
		primaryStage.setScene(scene);
		primaryStage.setTitle("Game Over");
		primaryStage.show();
	}

	public void draw(GraphicsContext gc, int totalScore) {
		gc.drawImage(background, 0, 0);
		gc.setFill(Color.DARKGOLDENROD);
		gc.setFont(SPACE_FONT);
		gc.fillText("SCORE: " + totalScore, 497, 320);

	}

}