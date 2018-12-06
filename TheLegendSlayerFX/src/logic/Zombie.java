package logic;

import javafx.scene.image.Image;

public class Zombie extends Monster {
	public Zombie(double x, double y) {
		System.out.println("tetst");
		setImage();
		setInfo(x,y);
	}
	@Override
	public void setImage() {
		this.top = new Image("zombie_dance.gif");
		this.down = new Image("zombie_dance.gif");
		this.right = new Image("zombie_dance.gif");
		this.left = new Image("zombie_dance.gif");
		this.startpic = this.down;
	}

	@Override
	public void setInfo(double x, double y) {
		this.x = x;
		this.y = y;
		this.health = 1;
		this.speed = 2;
	}

}
