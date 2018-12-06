package logic;

import javafx.scene.image.Image;

public class God extends Monster {
	public God(double x, double y) {
		setImage();
		setInfo(x,y);
	}
		@Override
		public void setImage() {
			this.top =  new Image(ClassLoader.getSystemResource("god_right.gif").toString()) ;
			this.down = new Image(ClassLoader.getSystemResource("god_left.gif").toString()) ;
			this.right = new Image(ClassLoader.getSystemResource("god_right.gif").toString()) ;
			this.left = new Image(ClassLoader.getSystemResource("god_left.gif").toString()) ;
			this.startpic = this.down;
		}

		@Override
		public void setInfo(double x, double y) {
			this.x = x;
			this.y = y;
			this.health = 10;
			this.speed = 5;
		}
}
