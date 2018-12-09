package logic;

import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import obstruct.Metal;
import obstruct.Obstacle;

public class Bullet extends CollidableEntity implements IRenderable{
  
   private int direction; // 0 top , 1 right , 2 down, 3 left
   protected Image bulletpic;
   protected Image top;
   protected Image down;
   protected Image right;
   protected Image left;
   public AudioClip soundshot = new AudioClip(ClassLoader.getSystemResource("AK47GunShot.mp3").toString());   
   private int speed = 10;
   
   
 
   public Bullet(double x, double y ,int direction ) {
       this.x = x;
       this.y = y;
       this.direction = direction;
       setBulletPic(direction);
       playSound() ;
       this.setRadius(15);
       
   }
   public Bullet(double x, double y ,int direction , AudioClip soundshot ) {
       this.x = x;
       this.y = y;
       this.direction = direction;
       setBulletPic(direction);
       this.soundshot = soundshot ;
       playSound() ;
       this.setRadius(20);
       
   }
   public void setBulletPic(int direction) {
  
	   this.top = new Image(ClassLoader.getSystemResource("Bullet_top.png").toString()) ;
       this.down = new Image(ClassLoader.getSystemResource("Bullet_down.png").toString()) ;
       this.right = new Image(ClassLoader.getSystemResource("Bullet_right.png").toString()) ;
       this.left = new Image(ClassLoader.getSystemResource("Bullet_left.png").toString()) ;
       if(direction == 0) this.bulletpic = top ;
       else if (direction == 1) this.bulletpic = right ;
       else if (direction == 2) this.bulletpic = down;
       else if (direction == 3) this.bulletpic = left ;
       
      
   }
   @Override
   public void draw(GraphicsContext gc) {
       gc.drawImage(bulletpic , this.x, this.y);
   }
   public boolean canGo(MoveCalculate future) {
   	for(Obstacle obstacle : RenderableHolder.getObstacles()) {
   		if(obstacle.collideWith(future) && obstacle instanceof Metal)
   			if(CollisionUtility.checkCollisionsMetal(obstacle , this)) return true ;
   	}
   	return false;
   }
   public int getSpeed() {
	   return this.speed;
   }
   public void goUp() {
   	MoveCalculate future = new MoveCalculate(this.getX(), this.getY() - this.getSpeed(),this);
   	if(canGo(future)) return;
      this.setY(this.getY()-this.getSpeed());
  
      bulletpic = top;
     
   }
   public void goDown() {
   	MoveCalculate future = new MoveCalculate(this.getX(), this.getY() + this.getSpeed(),this);
   	if(canGo(future)) return;
      this.setY(this.getY()+this.getSpeed());
      
      bulletpic = down;
 
   }
   public void goRight() {
   	MoveCalculate future = new MoveCalculate(this.getX() + this.getSpeed(), this.getY(),this);
   	if(canGo(future)) return;
      this.setX(this.getX()+this.getSpeed());
      bulletpic = right;
   }
    
   public void goLeft() {
   	MoveCalculate future = new MoveCalculate(this.getX() - this.getSpeed(), this.getY(),this);
   	if(canGo(future)) return;
      this.setX(this.getX()-this.getSpeed());
  
      bulletpic = left;
 
   }
   public void update() {
       if(this.direction == 0) {
           goUp();
       } else if (this.direction == 1) {
          goRight();
       } else if (direction == 2) {
          goDown();
       } else if (direction == 3) {
           goLeft();
       }
   }
   public void playSound() {
	   soundshot.play() ;
	}
  
  
}