package logic;

import javafx.scene.image.Image;

public class Unicorn extends Monster {
	public Unicorn(double x, double y) {
		setImage();
		setInfo(x,y);
	}
		@Override
		public void setImage() {
			this.top =  new Image(ClassLoader.getSystemResource("unicorn_dance.gif").toString()) ;
			this.down = new Image(ClassLoader.getSystemResource("unicorn_dance.gif").toString()) ;
			this.right = new Image(ClassLoader.getSystemResource("unicorn_dance.gif").toString()) ;
			this.left = new Image(ClassLoader.getSystemResource("unicorn_dance.gif").toString()) ;
			this.startpic = this.down;
		}

		@Override
		public void setInfo(double x, double y) {
			this.x = x;
			this.y = y;
			this.health = 5;
			this.speed = 3;
		}
}
