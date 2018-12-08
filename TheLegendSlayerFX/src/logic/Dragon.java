package logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class Dragon extends Monster {
	public AudioClip dragonSound = new AudioClip(ClassLoader.getSystemResource("dragonBorn.mp3").toString()); 
	public Dragon(double x, double y) {
		super(x,y);
		setImage();
		this.setWidth(110);
		this.setHeight(89);
		this.health = 20;
		this.speed = 4;
		this.radius = 60 ;
		this.score = 500;
		this.canFire = true ;
		this.lastShot = System.currentTimeMillis() ;
		dragonSound.play() ;
		
		
	}
		@Override
		public void setImage() {
			this.top =  new Image(ClassLoader.getSystemResource("dragon_right.gif").toString()) ;
			this.down = new Image(ClassLoader.getSystemResource("dragon_left.gif").toString()) ;
			this.right = new Image(ClassLoader.getSystemResource("dragon_right.gif").toString()) ;
			this.left = new Image(ClassLoader.getSystemResource("dragon_left.gif").toString()) ;
			this.startpic = this.down;
		}

}
