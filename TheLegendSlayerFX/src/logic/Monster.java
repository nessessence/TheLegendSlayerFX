package logic;
 
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.IRenderable;
 
public class Monster extends CollidableEntity implements IRenderable{
    private Image top = new Image("zombie_dance.gif");
    private Image left = new Image("zombie_dance.gif");
    private Image right = new Image("zombie_dance.gif");
    private Image down = new Image("zombie_dance.gif");
    private Image startpic = new Image("zombie_dance.gif");
    private int direction = 2;
    private int health = 1;
    private int attackpower = 2;
    private int speed = 2;
    private double x,y;
    private double dx = 2, dy = 2;
    private int dirTimer = 0, dirTimeInterval = 30;
    private Random rand = new Random();
 
    public Monster(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void randDir(){
        this.direction = rand.nextInt(4);
    }
    public void update(){
        if(dirTimer >= dirTimeInterval){
            randDir();
            dirTimer = 0;
        } else {
            dirTimer++;
        }
        this.move();
    }
    public void move(){
        if(direction == 0){
            startpic = top;
            this.y -= dy;
        }else if(direction == 1) {
            startpic = right;
            this.x += dx;
        }else if(direction == 2){
            startpic = down;
            this.y += dy;
        }else if(direction == 3){
            startpic = left;
            this.x -= dx;
        }
    }
 
    
	@Override
	public void draw(GraphicsContext gc) {
		  gc.drawImage(this.startpic, this.x,this.y);		
	}
 
 
 
 
}
