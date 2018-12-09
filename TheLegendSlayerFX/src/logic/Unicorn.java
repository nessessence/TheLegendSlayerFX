package logic;

import javafx.scene.image.Image;

public class Unicorn extends Monster {
	public Unicorn(double x, double y) {
		super(x, y);
		setImage();
		this.health = 5;
		this.speed = 3;
		this.radius = 30;
		this.score = 50;
		this.setWidth(60);
		this.setHeight(40);

	}

	@Override
	public void setImage() {
		this.top = new Image(ClassLoader.getSystemResource("unicorn_right.gif").toString());
		this.down = new Image(ClassLoader.getSystemResource("unicorn_left.gif").toString());
		this.right = new Image(ClassLoader.getSystemResource("unicorn_right.gif").toString());
		this.left = new Image(ClassLoader.getSystemResource("unicorn_left.gif").toString());
		this.startpic = this.down;
	}

}
