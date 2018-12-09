  
import drawing.GameScreen;
import drawing.StartWindow;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		StartWindow start = new StartWindow(stage);
		start.startAnimation();
		stage.show();
	}
}
