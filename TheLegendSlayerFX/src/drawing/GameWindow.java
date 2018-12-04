package drawing;

import java.util.Random;

import GameLogic.Monster;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.GameLogic;
import logic.Player;
import sharedObject.RenderableHolder;

public class GameWindow extends Canvas{
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.setTitle("The Legend Slayer");
//
//		GameLogic logic = new GameLogic();
//		GameScreen gameScreen = new GameScreen(640, 480);
//		root.getChildren().add(gameScreen);
//		gameScreen.requestFocus();
//		
//		primaryStage.show();
//		
//		AnimationTimer animation = new AnimationTimer() {
//			public void handle(long now) {
//				gameScreen.paintComponent();
//				logic.logicUpdate();
//				RenderableHolder.getInstance().update();
//				InputUtility.updateInputState();
//			}
//		};
//		animation.start();		
//	}
	private Stage primaryStage;
	private GraphicsContext gc;
	private Scene scene;
	private GameLogic logic;
	private GameScreen gameScreen;
	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(450);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane s = new StackPane();
		s.getChildren().add(gc.getCanvas());
		scene = new Scene(s);
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("The Legend Slayer");
		logic = new GameLogic();
		gameScreen = new GameScreen(640, 480);
		s.getChildren().add(gameScreen);
		gameScreen.requestFocus();
//		requestFocus();
	}
	public void drawGameWindow() {
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();	
	}
	
	
}
