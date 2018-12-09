package logic;

import javafx.scene.image.Image;

public class Slime extends Monster {
	public Slime(double x, double y) {
		super(x, y);
		setImage();
		this.setWidth(32);
		this.setHeight(32);
		this.health = 1;
		this.speed = 1;
		this.radius = 20;
		this.score = 10;

	}

	@Override
	public void setImage() {
		this.top = new Image("slime_left.gif");
		this.down = new Image("slime_right.gif");
		this.right = new Image("slime_right.gif");
		this.left = new Image("slime_left.gif");
		this.startpic = this.down;
	}

}
