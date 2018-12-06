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
    public void move(){
       
        if(direction == 0){
            startpic = top;
            this.setY(this.getY()-this.getSpeed());
        }else if(direction == 1) {
            startpic = right;
            this.setX(this.getX()+this.getSpeed());
        }else if(direction == 2){
            startpic = down;
            this.setY(this.getY()+this.getSpeed());
        }else if(direction == 3){
            startpic = left;
            this.setX(this.getX()-this.getSpeed());
        }
        //System.out.println(" x : y " + x+":"+y);
    }
 
   
    @Override
    public void draw(GraphicsContext gc) {
          gc.drawImage(this.startpic, this.x,this.y);      
    }
 
 
 
 
}