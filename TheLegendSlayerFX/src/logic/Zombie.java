package logic;

import javafx.scene.image.Image;

public class Zombie extends Monster {
	public Zombie(double x, double y) {
		super(x,y);
		setImage();
		this.health = 2;
		this.speed = 1;
		this.radius = 15;
		this.score = 20;
		this.setHeight(32);
		this.setWidth(32);
	}
	@Override
	public void setImage() {
		this.top = new Image("zombie_dance.gif");
		this.down = new Image("zombie_dance.gif");
		this.right = new Image("zombie_dance.gif");
		this.left = new Image("zombie_dance.gif");
		this.startpic = this.down;
	}

	

}
