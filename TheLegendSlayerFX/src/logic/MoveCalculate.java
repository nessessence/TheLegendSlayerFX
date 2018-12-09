package logic;

import javafx.scene.canvas.GraphicsContext;

public class MoveCalculate extends CollidableEntity {
	public MoveCalculate(double x, double y, CollidableEntity entity) {
		this.setRadius(entity.getRadius());
		this.setX(x);
		this.setY(y);
		this.setWidth(entity.getWidth());
		this.setHeight(entity.getHeight());
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

}
