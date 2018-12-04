package logic;

import sharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Bullet extends CollidableEntity implements IRenderable{
  
   private int direction; // 0 top , 1 right , 2 down, 3 left
   private Image bulletpic;
   private Image top;
   private Image down;
   private Image right;
   private Image left;
   public AudioClip soundshot = new AudioClip(ClassLoader.getSystemResource("AK47GunShot.mp3").toString()); ;
   private boolean isEnemy = false;
   public Bullet(double x, double y ,int direction) {
       this.x = x;
       this.y = y;
       this.direction = direction;
       setBulletPic(direction);
       playSound() ;
       
   }
   public void setBulletPic(int direction) {
       if(isEnemy) {
//         this.bulletpic = new Image("bulletEnemy.png");
       } else {
    	   this.top = new Image(ClassLoader.getSystemResource("Bullet_top.png").toString()) ;
           this.down = new Image(ClassLoader.getSystemResource("Bullet_down.png").toString()) ;
           this.right = new Image(ClassLoader.getSystemResource("Bullet_right.png").toString()) ;
           this.left = new Image(ClassLoader.getSystemResource("Bullet_left.png").toString()) ;
           if(direction == 0) this.bulletpic = top ;
           else if (direction == 1) this.bulletpic = right ;
           else if (direction == 2) this.bulletpic = down;
           else if (direction == 3) this.bulletpic = left ;
       }
      
   }
   @Override
   public void draw(GraphicsContext gc) {
       gc.drawImage(bulletpic , this.x, this.y);
   }
   public void update() {
       if(this.direction == 0) {
           this.y -= 10;
       } else if (this.direction == 1) {
           this.x += 10;
       } else if (direction == 2) {
           this.y += 10;
       } else if (direction == 3) {
           this.x -= 10;
       }
   }
   public void playSound() {
	   soundshot.play() ;
	}
  
  
}