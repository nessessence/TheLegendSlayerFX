package logic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import obstruct.Metal;
import obstruct.Obstacle;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder_Logic;

public abstract class Monster extends CollidableEntity implements IRenderable {
	protected boolean canFire = false;
	protected long lastShot;
	protected int score;
	protected Image top;
	protected Image left;
	protected Image right;
	protected Image down;
	protected Image startpic;
	private int direction = 2;
	protected int health;
	protected int speed;
	private int dirTimer = 0, dirTimeInterval = 30;

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}


	

	public Monster(double x, double y) {
		this.setX(x);
		this.setY(y);
		this.setZ(2);
	}

	public abstract void setImage();

	public void randDir() {
		Random rand = new Random();
		this.direction = rand.nextInt(4);
	}

	public void update() {
		if (canFire) {
			if (System.currentTimeMillis() - lastShot > 3000) {
				Fireball bullet = new Fireball(this.x, this.y, this.getDirection());
				lastShot = System.currentTimeMillis();
				RenderableHolder_Logic.getInstance().add(bullet);
			}

		}

		if (dirTimer >= dirTimeInterval) {
			randDir();
			dirTimer = 0;
		} else {
			dirTimer++;
		}
		this.move();
	}

	public void setX(double total) {
		if (total >= 735 || total <= 40) {
		} else {
			this.x = total;
		}
	}

	public void setY(double total) {
		if (total >= 530 || total <= 40) {
		} else {
			this.y = total;
		}
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getScore() {
		return this.score;
	}

	private boolean canGo(MoveCalculate future) {
		for (Obstacle obstacle : RenderableHolder_Logic.getObstacles()) {
			if (obstacle.collideWith(future))
				if (CollisionUtility.checkCollisionsObstacle(obstacle, this))
					return false;

		}
		return true;
	}

	public void goUp() {
		MoveCalculate future = new MoveCalculate(this.getX(), this.getY() - this.getSpeed(), this);
		if (!canGo(future))
			return;
		this.setY(this.getY() - this.getSpeed());
		this.setDirection(0);

		startpic = top;

	}

	public void goDown() {
		MoveCalculate future = new MoveCalculate(this.getX(), this.getY() + this.getSpeed(), this);
		if (!canGo(future))
			return;
		this.setY(this.getY() + this.getSpeed());
		this.setDirection(2);

		startpic = down;

	}

	public void goRight() {
		MoveCalculate future = new MoveCalculate(this.getX() + this.getSpeed(), this.getY(), this);
		if (!canGo(future))
			return;
		this.setX(this.getX() + this.getSpeed());
		startpic = right;
		this.setDirection(1);
	}

	public void goLeft() {
		MoveCalculate future = new MoveCalculate(this.getX() - this.getSpeed(), this.getY(), this);
		if (!canGo(future))
			return;
		this.setX(this.getX() - this.getSpeed());
		this.setDirection(3);

		startpic = left;

	}

	public void move() {

		if (direction == 0) {
			goUp();
		} else if (direction == 1) {
			goRight();
		} else if (direction == 2) {
			goDown();
		} else if (direction == 3) {
			goLeft();
		}

	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(this.startpic, this.x, this.y);
	}

	public void takeDamage() {
		if (--this.health <= 0)
			die();

	}

	public void die() {
		this.destroyed = true;
		Player player = RenderableHolder_Logic.getPlayer();
		player.setScore(player.getScore() + this.getScore());

	}

}