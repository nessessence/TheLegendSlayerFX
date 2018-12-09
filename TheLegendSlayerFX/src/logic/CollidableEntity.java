package logic;

public abstract class CollidableEntity extends Entity {
	protected int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean collideWith(CollidableEntity other) {
		return Math.hypot((this.x + this.getWidth() / 2) - (other.x + other.getWidth() / 2),
				(this.y + this.getHeight() / 2 - (other.y + other.getHeight() / 2))) <= this.radius + other.radius;
	}
}
