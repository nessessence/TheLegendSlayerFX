package logic;



import exception.LimitedMapException;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected int width, height;
	protected double x, y;
	protected int z;
	protected boolean destroyed = false ;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) throws LimitedMapException{
		if(x > 800 || x < 0) {
			this.destroyed = true;
			throw new  LimitedMapException();
		}
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) throws LimitedMapException{
		if(y > 600 || y < 0) {
			this.destroyed = true;
			throw new LimitedMapException();
		}
		this.y = y;
	}

}
