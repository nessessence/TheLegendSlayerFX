package logic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Fireball extends Bullet {
	public static AudioClip soundshot =  new AudioClip(ClassLoader.getSystemResource("dragonFire.mp3").toString()); 
	public Fireball(double x, double y, int direction) {
		super(x, y, direction,soundshot);
		// TODO Auto-generated constructor stub
	}
	   public void setBulletPic(int direction) {
		   
		   this.top = new Image(ClassLoader.getSystemResource("fireball_up.gif").toString()) ;
	       this.down = new Image(ClassLoader.getSystemResource("fireball_down.gif").toString()) ;
	       this.right = new Image(ClassLoader.getSystemResource("fireball_right.gif").toString()) ;
	       this.left = new Image(ClassLoader.getSystemResource("fireball_left.gif").toString()) ;
	       if(direction == 0) this.bulletpic = top ;
	       else if (direction == 1) this.bulletpic = right ;
	       else if (direction == 2) this.bulletpic = down;
	       else if (direction == 3) this.bulletpic = left ;
	       
	      
	   }

}
