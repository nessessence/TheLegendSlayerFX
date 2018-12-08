package logic;
 
import java.util.Random;
 
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import obstruct.Metal;
import obstruct.Obstacle;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
 
public abstract class Monster extends CollidableEntity implements IRenderable{
	protected int score ; 
	protected Image top ;
    protected Image left;
    protected Image right;
    protected Image down;
    protected Image startpic ;
    private int direction = 2;
    protected int health;
    protected int speed;
    private int dirTimer = 0, dirTimeInterval = 30;
    
    
   
//    private Random rand = new Random();
 
    public Monster(double x , double y ) {
    	this.setX(x);
    	this.setY(y);
    	this.setZ(2);
    }
   

	public abstract void setImage();
    
    public void randDir(){
        Random rand = new Random();
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
    public void setX(double total){
        if(total >= 735 || total <= 40){}
        else {
            this.x = total;
        }
    }
    public void setY(double total){
        if(total >= 530 || total <= 40){}
        else {
            this.y = total;
        }
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getScore() {
    	return this.score;
    }
    public boolean canGo(MoveCalculate future) {
    	for(Obstacle obstacle : RenderableHolder.getObstacles()) {
    		if(obstacle.collideWith(future) && obstacle instanceof Metal)
    			if(CollisionUtility.checkCollisionsObstacle(obstacle , this)) return true ;
    	}
    	return false;
    }
    public void goUp() {
    	MoveCalculate future = new MoveCalculate(this.getX(), this.getY() - this.getSpeed());
    	if(canGo(future)) return;
       this.setY(this.getY()-this.getSpeed());
   
       startpic = top;
      
    }
    public void goDown() {
    	MoveCalculate future = new MoveCalculate(this.getX(), this.getY() + this.getSpeed());
    	if(canGo(future)) return;
       this.setY(this.getY()+this.getSpeed());
       
       startpic = down;
  
    }
    public void goRight() {
    	MoveCalculate future = new MoveCalculate(this.getX() + this.getSpeed(), this.y);
    	if(canGo(future)) return;
       this.setX(this.getX()+this.getSpeed());
       startpic = right;
    }
     
    public void goLeft() {
    	MoveCalculate future = new MoveCalculate(this.getX() - this.getSpeed(), this.y);
    	if(canGo(future)) return;
       this.setX(this.getX()-this.getSpeed());
   
       startpic = left;
  
    }
    public void move(){
       
        if(direction == 0){
        	goUp();
        }else if(direction == 1) {
            goRight();
        }else if(direction == 2){
            goDown();
        }else if(direction == 3){
            goLeft();
        }
        //System.out.println(" x : y " + x+":"+y);
    }
 
   
    @Override
    public void draw(GraphicsContext gc) {
          gc.drawImage(this.startpic, this.x,this.y);      
    }
 
    public void takeDamage() {
    	if(--this.health <= 0) die();
    	
    }
    public void die() {
    	this.destroyed = true;
    	Player player = RenderableHolder.getPlayer();
    	player.setScore(player.getScore()+this.getScore());
    	System.out.println("************************************ score: "+player.getScore());
    	
    }
 
 
 
}