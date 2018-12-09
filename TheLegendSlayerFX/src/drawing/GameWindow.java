package drawing;

import java.util.Random;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.Field;
import logic.InitializeGame;
import logic.Player;
import sharedObject.RenderableHolder_Logic;

public class GameWindow extends Canvas{
	private Stage primaryStage;
	private GraphicsContext gc;
	private Scene scene;
	private InitializeGame logic;
	private GameScreen gameScreen;
	private AnimationTimer animation;

	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(600);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane s = new StackPane();
		s.getChildren().add(gc.getCanvas());
		scene = new Scene(s);
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("The Legend Slayer");
		logic = new InitializeGame();
		gameScreen = new GameScreen(800, 600);
		s.getChildren().add(gameScreen);
		gameScreen.requestFocus();
	}
	public void drawGameWindow() {     
        this.animation = new AnimationTimer() {
            public void handle(long now) {
                logic.logicUpdate();
                gameScreen.paintComponent();
                RenderableHolder_Logic.getInstance().update();
                InputUtility.updateInputState();
                isGameEnd();
            }
        };
        animation.start(); 
    }
    public void isGameEnd() {
        if(RenderableHolder_Logic.getPlayer().getLife() <= 0 ) {
            RenderableHolder_Logic.getInstance().clearList();
            animation.stop();
            GameisOver gameOver = new GameisOver(RenderableHolder_Logic.getPlayer().getScore());
            try {
                gameOver.start(primaryStage);
            } catch(Exception e) {
                System.out.println("Have some errors at isGameEnd()");
            }
           
        }
    }
}