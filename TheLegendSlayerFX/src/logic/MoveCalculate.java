package logic;

import exception.LimitedMapException;
import javafx.scene.canvas.GraphicsContext;

public class MoveCalculate extends CollidableEntity {
	public MoveCalculate(double x, double y, CollidableEntity entity) {
		try {
			this.setX(x);
			this.setY(y);
		} catch (LimitedMapException e) {
			e.printStackTrace();
		}
		
		this.setRadius(entity.getRadius());
		this.setWidth(entity.getWidth());
		this.setHeight(entity.getHeight());
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

}
