package logic;
 
import sharedObject.IRenderable;

import java.util.ArrayList;
import java.util.Random;

import input.InputUtility;
import sharedObject.RenderableHolder;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
 
 
public class Player extends CollidableEntity {
    private int machinegunLevel = 1;
    private int life = 10;
    public Image startpic;
    private int score = 0;
    private int level = 1;
    private Image left;
    private Image right ;
    private Image top;
    private Image down;
    private Random rand;
    private int move_count ;
    private int speed = 1 ;
    private int direction; // top->0,right->1,back->2,left->3
    private long lastShot = 0;
    public String[] soundURL = {"playAd1.mp3","playAd2.mp3","playAd3.mp3","playAd4.mp3","playAd5.mp3","playAd6.mp3","playAd7.mp3","playAd8.mp3","playAd9.mp3","playAd10.mp3","playAd11.mp3","playAd12.mp3","playAd13.mp3","playAd14.mp3","playAd15.mp3","playAd16.mp3","playAd17.mp3","playAd18.mp3","playAd19.mp3"} ;
    public ArrayList<AudioClip>  sounds ;
    public AudioClip sound = new AudioClip(ClassLoader.getSystemResource("playAD1.mp3").toString());
    private long lastSay = System.currentTimeMillis() - 5000 ;
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(startpic, this.x, this.y);
    }
    public Player(double x, double y) {
    	//playSound();
        this.x = x;
        this.y = y;
        this.left = new Image(ClassLoader.getSystemResource("soldier_left.gif").toString()) ;
        this.right = new Image(ClassLoader.getSystemResource("soldier_right.gif").toString()) ;
        this.top = new Image(ClassLoader.getSystemResource("soldier_top.gif").toString()) ;
        this.down = new Image(ClassLoader.getSystemResource("soldier_down.gif").toString()) ;
        move_count = 0 ;
        //for(int i = 0 ; i < 19 ; i++ ) soundURL.add("playAd"+Integer.toString(i+1)+".mp3") ;
        setPlayer();
        this.direction = 2;
//        for(int i = 0 ; i < soundURL.length ; i++) {
//        	sounds.add( new AudioClip(ClassLoader.getSystemResource(soundURL[i]).toString()));
//        }
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
//    	if(System.currentTimeMillis() - lastSay > 10000 ) playSound(); lastSay = System.currentTimeMillis() ;
        if (InputUtility.getKeyPressed(KeyCode.UP)) {
            goUp();
            this.setDirection(0);
            startpic = top;
            move_count += 1 ;
        }
        if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
            goLeft();
            this.setDirection(3);
            startpic = left;
            move_count += 1 ;
        } else if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
            goRight();
            startpic = right;
            this.setDirection(1);
            move_count += 1 ;
        } else if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
            goDown();
            this.setDirection(2);
            startpic = down;
            move_count += 1 ;
        }
        if (InputUtility.getKeyPressed(KeyCode.SPACE)&& 	(System.currentTimeMillis() - lastShot) > 200/machinegunLevel) {
            Bullet bullet = new Bullet(this.x,this.y, this.getDirection());
            lastShot =  System.currentTimeMillis() ;
            RenderableHolder.getInstance().add(bullet);
            move_count += 1  ;
        }
       
        if (InputUtility.isLeftClickTriggered()) {
            this.x = InputUtility.mouseX;
            this.y = InputUtility.mouseY;
            move_count += 1 ;
        }
        if( move_count > 12 & (System.currentTimeMillis() - lastSay) > 4000 ) {
        	System.out.println(move_count);
        	move_count = 0 ;
        	System.out.println(System.currentTimeMillis() + "," + lastSay+ ","+ (System.currentTimeMillis()-lastSay));
        	lastSay = System.currentTimeMillis() ;
        	
        	playSound(); 
        }
        System.out.println(System.currentTimeMillis() + "," + lastSay+ ","+ (System.currentTimeMillis()-lastSay));
       
    }
; 
	public void playSound() {
		if(sound.isPlaying()) return ;
		int x = (int) (Math.random()*19) ;   // fucking important 
		sound  = new AudioClip(ClassLoader.getSystemResource(soundURL[x]).toString());
		sound.play();
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