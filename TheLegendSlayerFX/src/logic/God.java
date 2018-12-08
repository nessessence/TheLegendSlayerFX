package logic;

import javafx.scene.image.Image;

public class God extends Monster {
	public God(double x, double y) {
		super(x,y);
		setImage();
		this.health = 10;
		this.speed = 5;
		this.radius = 40 ;
		this.score = 200;
		this.setWidth(80);
		this.setHeight(90);
		
	}
		@Override
		public void setImage() {
			this.top =  new Image(ClassLoader.getSystemResource("god_right.gif").toString()) ;
			this.down = new Image(ClassLoader.getSystemResource("god_left.gif").toString()) ;
			this.right = new Image(ClassLoader.getSystemResource("god_right.gif").toString()) ;
			this.left = new Image(ClassLoader.getSystemResource("god_left.gif").toString()) ;
			this.startpic = this.down;
		}

		
}
