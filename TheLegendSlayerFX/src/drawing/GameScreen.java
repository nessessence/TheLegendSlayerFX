package drawing;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Field;
import logic.Player;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;

public class GameScreen extends Canvas {
	private final Font SPACE_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("CourierNew.ttf"), 15);
	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		addListerner();
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

		this.setOnMousePressed((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY)
				InputUtility.mouseLeftDown();
		});

		this.setOnMouseReleased((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY)
				InputUtility.mouseLeftRelease();
		});

		this.setOnMouseEntered((MouseEvent event) -> {
			InputUtility.mouseOnScreen = true;
		});

		this.setOnMouseExited((MouseEvent event) -> {
			InputUtility.mouseOnScreen = false;
		});

		this.setOnMouseMoved((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
			}
		});

		this.setOnMouseDragged((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
			}
		});
	}
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
//			if(entity instanceof Player) {
//				System.out.println("+++++++++++++++");
//				if(entity.isVisible()) System.out.println("vis");
//				if(!entity.isDestroyed()) System.out.println("des");
//				
//			}
			if (entity.isVisible() && !entity.isDestroyed() ) {
				entity.draw(gc);
			}
		}
		gc.setFont(SPACE_FONT);
		gc.fillText("score:"+Integer.toString(RenderableHolder.getPlayer().getScore()),30,15 );
		gc.fillText("life:"+Integer.toString(RenderableHolder.getPlayer().getLife()),30,33 );
		


	}

}
