package logic;
 
import sharedObject.IRenderable;
import input.InputUtility;
import sharedObject.RenderableHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
 
 
public class Player extends CollidableEntity {
    private int machinegunLevel = 0;
    private int life = 10;
    public Image startpic;
    private int score = 0;
    private int level = 1;
    private Image left;
    private Image right ;
    private Image top;
    private Image down;
    private int speed = 1 ;
    private int direction; // top->0,right->1,back->2,left->3
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(startpic, this.x, this.y);
    }
    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        this.left = new Image("soldier_left.gif");
        this.right = new Image("soldier_right.gif");
        this.top = new Image("soldier_top.gif");
        this.down = new Image("soldier_down.gif");
        setPlayer();
        this.direction = 2;
    }
    public void gainHP(){
        this.life += 1;
    }
    public void setMachineGunLevel(int x){
        if(x >= 0) x = 0;
        if(this.getMahcineGunLevel() + x <= 2){
            this.machinegunLevel = this.getMahcineGunLevel() + x;
        }
    }
    public void setSpeed(int x){
       this.speed = x;
    }
    public int getMahcineGunLevel() {
        return this.machinegunLevel;
    }
    public int getSpeed() {
        return this.speed;
    }
    public void reduceLife(){
        this.life -= 1;
    }
    public void setPlayer() {
        this.startpic = down;
    }
    public void goUp() {
       this.y -= this.getSpeed();
    }
    public void goDown() {
       this.y += this.getSpeed();
    }
    public void goRight() {
       this.x += this.getSpeed();
    }
    public void goLeft() {
       this.x -= this.getSpeed();
    }
    public int getDirection() {
        return this.direction;
    }
    public void setDirection(int direction){
        this.direction = direction;
    }
    public void update() {
        if (InputUtility.getKeyPressed(KeyCode.UP)) {
            goUp();
            this.setDirection(0);
            startpic = top;
        }
        if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
            goLeft();
            this.setDirection(3);
            startpic = left;
        } else if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
            goRight();
            startpic = right;
            this.setDirection(1);
        } else if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
            goDown();
            this.setDirection(2);
            startpic = down;
        }
        if (InputUtility.getKeyPressed(KeyCode.SPACE)) {
            Bullet bullet = new Bullet(this.x,this.y, this.getDirection());
            RenderableHolder.getInstance().add(bullet);
           
        }
       
        if (InputUtility.isLeftClickTriggered()) {
            this.x = InputUtility.mouseX;
            this.y = InputUtility.mouseY;
        }
    }
    public int getLife() {
        return this.life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
   public void hitByMine() {
	   
   }
}