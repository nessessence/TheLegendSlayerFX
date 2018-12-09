package logic;



import java.util.ArrayList;
import input.InputUtility;
import sharedObject.RenderableHolder_Logic;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import obstruct.Obstacle;

public class Player extends CollidableEntity {
	private int life;
	public Image startpic;
	private int score = 0;
	private Image left;
	private Image right;
	private Image top;
	private Image down;
	private int move_count;
	private int speed = 2;
	private int direction; // top->0,right->1,back->2,left->3
	private long lastShot = 0;
	public AudioClip scream = new AudioClip(ClassLoader.getSystemResource("scream.mp3").toString());
	public String[] soundURL = { "playAd1.mp3", "playAd2.mp3", "playAd3.mp3", "playAd4.mp3", "playAd5.mp3",
			"playAd6.mp3", "playAd7.mp3", "playAd8.mp3", "playAd9.mp3", "playAd10.mp3", "playAd11.mp3", "playAd12.mp3",
			"playAd13.mp3", "playAd14.mp3", "playAd15.mp3", "playAd16.mp3", "playAd17.mp3", "playAd18.mp3",
			"playAd19.mp3" };
	public ArrayList<AudioClip> sounds;
	public AudioClip sound = new AudioClip(ClassLoader.getSystemResource("playAd1.mp3").toString());
	private long lastSay = System.currentTimeMillis() - 5000;

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(startpic, this.getX(), this.getY());

	}

	public Player(double x, double y) {
		// playSound();
		this.life = 10;
		this.setHeight(30);
		this.setWidth(30);
		this.z = 2;
		this.radius = 10;
		this.x = x;
		this.y = y;
		this.left = new Image(ClassLoader.getSystemResource("soldier_left.gif").toString());
		this.right = new Image(ClassLoader.getSystemResource("soldier_right.gif").toString());
		this.top = new Image(ClassLoader.getSystemResource("soldier_top.gif").toString());
		this.down = new Image(ClassLoader.getSystemResource("soldier_down.gif").toString());
		move_count = 0;

		setPlayer();
		this.direction = 2;
		RenderableHolder_Logic.setPlayer(this);
	}

	public void gainLife() {
		this.life += 1;
	}

	public void setSpeed(int x) {
		this.speed = x;
	}

	public void setScore(int score) {
		if (score <= 0)
			score = 0;
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}


	public int getSpeed() {
		return this.speed;
	}

	public void reduceLife() {
		this.life -= 1;
	}

	public void setPlayer() {
		this.startpic = down;
	}

	public void goUp() {
		MoveCalculate future = new MoveCalculate(this.getX(), this.getY() - this.getSpeed(), this);
		RenderableHolder_Logic.setPlayer(this);
		if (!canGo(future))
			return;
		this.setY(this.getY() - this.getSpeed());
		this.setDirection(0);
		startpic = top;
		move_count += 1;
	}

	public void goDown() {
		MoveCalculate future = new MoveCalculate(this.getX(), this.getY() + this.getSpeed(), this);
		RenderableHolder_Logic.setPlayer(this);
		if (!canGo(future))
			return;
		this.setY(this.getY() + this.getSpeed());
		this.setDirection(2);
		startpic = down;
		move_count += 1;
	}

	public void goRight() {
		MoveCalculate future = new MoveCalculate(this.getX() + this.getSpeed(), this.getY(), this);
		RenderableHolder_Logic.setPlayer(this);
		if (!canGo(future))
			return;
		this.setX(this.getX() + this.getSpeed());
		startpic = right;
		this.setDirection(1);
		move_count += 1;
	}

	public void goLeft() {
		MoveCalculate future = new MoveCalculate(this.getX() - this.getSpeed(), this.getY(), this);
		RenderableHolder_Logic.setPlayer(this);
		if (!canGo(future))
			return;
		this.setX(this.getX() - this.getSpeed());
		this.setDirection(3);
		startpic = left;
		move_count += 1;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setX(double total) {
		if (total >= 735 || total <= 40) {
		} else {
			this.x = total;
		}
	}

	public void setY(double total) {
		if (total >= 530 || total <= 40) {
		} else {
			this.y = total;
		}
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public boolean canGo(MoveCalculate future) {
		for (Obstacle obstacle : RenderableHolder_Logic.getObstacles()) {
			if (obstacle.collideWith(future))
				if (CollisionUtility.checkCollisionsObstacle(obstacle, (CollidableEntity) RenderableHolder_Logic.getPlayer()))
					return false;
		}
		return true;
	}

	public void update() {

		if (InputUtility.getKeyPressed(KeyCode.UP)) {
			goUp();
		}
		if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
			goLeft();

		} else if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
			goRight();

		} else if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
			goDown();

		}

		if (InputUtility.getKeyPressed(KeyCode.SPACE)
				&& (System.currentTimeMillis() - lastShot) > 200 ) {
			Bullet bullet = new Bullet(this.x, this.y, this.getDirection());
			lastShot = System.currentTimeMillis();
			RenderableHolder_Logic.getInstance().add(bullet);

			move_count += 1;
		}

		if (InputUtility.isLeftClickTriggered()) {
			this.x = InputUtility.mouseX;
			this.y = InputUtility.mouseY;
			move_count += 1;
		}
		if (move_count > 12 & (System.currentTimeMillis() - lastSay) > 4000) {
			System.out.println(move_count);
			move_count = 0;
			lastSay = System.currentTimeMillis();

			playSound();
		}

	};

	public void playSound() {
		if (sound.isPlaying())
			return;
		int x = (int) (Math.random() * 19);
		sound = new AudioClip(ClassLoader.getSystemResource(soundURL[x]).toString());
		sound.play();
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void isHit() {
		scream.play();
		RenderableHolder_Logic.getPlayer().life--;
		RenderableHolder_Logic.getPlayer().setX(200);
		RenderableHolder_Logic.getPlayer().setY(500);

	}
}
