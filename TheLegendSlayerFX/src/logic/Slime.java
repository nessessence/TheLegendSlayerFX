package logic;

import javafx.scene.image.Image;

public class Slime extends Monster {
	public Slime(double x, double y) {
		setImage();
		setInfo(x,y);
	}

	@Override
		public void setImage() {
			this.top = new Image("slime_left.gif");
			this.down = new Image("slime_right.gif");
			this.right = new Image("slime_right.gif");
			this.left = new Image("slime_left.gif");
			this.startpic = this.down;
		}


	@Override
	public void setInfo(double x, double y) {
		this.x = x;
		this.y = y;
		this.health = 1;
		this.speed = 1;
		this.radius = 5 ;

	}

}
