package logic;
 
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.IRenderable;
 
public abstract class Monster extends CollidableEntity implements IRenderable{
    protected Image top ;
    protected Image left;
    protected Image right;
    protected Image down;
    protected Image startpic ;
    private int direction = 2;
    protected int health;
    protected int speed;
    protected double x,y;
    private int dirTimer = 0, dirTimeInterval = 30;
//    private Random rand = new Random();
 
    public abstract void setImage();
    public abstract void setInfo(double x,double y);
    public void randDir(){
    	System.out.println("xxx");
    	Random rand = new Random();
        this.direction = rand.nextInt(4);
        System.out.println("direction : "+direction);
    }
    public void update(){
        System.out.println("*************************************************");
    	if(dirTimer >= dirTimeInterval){
            randDir();
            dirTimer = 0;
        } else {
            dirTimer++;
        }
        this.move();
    }
    public void move(){
    	System.out.println("yyyy");
        if(direction == 0){
            startpic = top;
            this.y -= this.speed;
        }else if(direction == 1) {
            startpic = right;
            this.x += this.speed;
        }else if(direction == 2){
            startpic = down;
            this.y += this.speed;
        }else if(direction == 3){
            startpic = left;
            this.x -= this.speed;
        }
        System.out.println(" x : y " + x+":"+y);
    }
 
    
	@Override
	public void draw(GraphicsContext gc) {
		  gc.drawImage(this.startpic, this.x,this.y);		
	}
 
 
 
 
}
