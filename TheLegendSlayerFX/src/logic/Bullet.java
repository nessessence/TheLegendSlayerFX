package logic;

import sharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends CollidableEntity implements IRenderable{
  
   private int direction; // 0 top , 1 right , 2 down, 3 left
   private Image bulletpic;
   private Image top;
   private Image down;
   private Image right;
   private Image left;
   private boolean isEnemy = false;
   public Bullet(double x, double y ,int direction) {
       this.x = x;
       this.y = y;
       this.direction = direction;
       setBulletPic(direction);
   }
   public void setBulletPic(int direction) {
       if(isEnemy) {
//         this.bulletpic = new Image("bulletEnemy.png");
       } else {
           this.top = new Image("Bullet_top.png");
           this.down = new Image("Bullet_down.png");
           this.right = new Image("Bullet_right.png");
           this.left = new Image("Bullet_left.png");
//           if(direction == 0) this.bulletpic = new Image("/res/Bullet_top.png");
//           else if (direction == 1) this.bulletpic = new Image("/res/Bullet_right.png");
//           else if (direction == 2) this.bulletpic = new Image("/res/Bullet_down.png");
//           else if (direction == 3) this.bulletpic = new Image("/res/Bullet_left.png");
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
  
  
}