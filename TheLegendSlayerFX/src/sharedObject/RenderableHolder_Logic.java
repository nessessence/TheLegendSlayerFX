package sharedObject;

import obstruct.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import logic.Bullet;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;
import logic.Fireball;
import logic.God;
import logic.Monster;
import logic.Player;
import logic.Slime;
import logic.Unicorn;
import logic.Zombie;
import logic.CollidableEntity;
import logic.CollisionUtility;
import logic.Dragon;
import logic.Entity;

public class RenderableHolder_Logic {
	private static final RenderableHolder_Logic instance = new RenderableHolder_Logic();
	private static ArrayList<Obstacle> obstacles;
	private static long time = 0;
	private static long start_time;
	private static int GenRate;
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Player player;
	public static Field field;
	public static Image mapSprite;
	public static Image castlePlayerSprite;
	public static Image pondSprite;
	public static Image tree1Sprite;
	public static Image deadTreeSprite;
	public static Image barbewireSprite;
	public static Image cannonSprite;
	public static AudioClip explosionSound;
	static {
		loadResource();
	}
	public static long getTime() {
		return time;
	}

	public static void setTime(long time) {
		RenderableHolder_Logic.time = time;
	}
	public static long getStart_time() {
		return start_time;
	}

	public static void setStart_time(long start_time) {
		RenderableHolder_Logic.start_time = start_time;
	}

	public static ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public static void setObstacles(ArrayList<Obstacle> obstacles) {
		RenderableHolder_Logic.obstacles = obstacles;
	}

	public static Field getField() {
		return RenderableHolder_Logic.field;
	}

	public static void setField(Field field) {
		RenderableHolder_Logic.field = field;
	}

	public RenderableHolder_Logic() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
		time = System.currentTimeMillis();
		start_time = System.currentTimeMillis();
		GenRate = 0;
		obstacles = new ArrayList<Obstacle>();
	}

	public static RenderableHolder_Logic getInstance() {
		return instance;
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		RenderableHolder_Logic.player = player;
	}

	public static void loadResource() {
		cannonSprite = new Image(ClassLoader.getSystemResource("cannon.png").toString());
		barbewireSprite = new Image(ClassLoader.getSystemResource("barbewire.png").toString());
		deadTreeSprite = new Image(ClassLoader.getSystemResource("deadtree.png").toString());
		pondSprite = new Image(ClassLoader.getSystemResource("pond.png").toString());
		castlePlayerSprite = new Image(ClassLoader.getSystemResource("castle.gif").toString());
		tree1Sprite = new Image(ClassLoader.getSystemResource("tree1.png").toString());
		mapSprite = new Image(ClassLoader.getSystemResource("brown.png").toString());
		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void monsterGen() {
		if (System.currentTimeMillis() - time > 10000 - GenRate) {
			GenRate += 10;
			System.out.println("Monster generated !!,GenRate:" + GenRate);
			time = System.currentTimeMillis();
			Slime slime1 = new Slime(400, 70);
			Slime slime2 = new Slime(300, 80);
			Zombie zombie = new Zombie(550, 90);
			RenderableHolder_Logic.getInstance().add(slime1);
			RenderableHolder_Logic.getInstance().add(slime2);
			RenderableHolder_Logic.getInstance().add(zombie);
			if (System.currentTimeMillis() - start_time > 30000) {
				Unicorn unicorn = new Unicorn(700, 200);
				RenderableHolder_Logic.getInstance().add(unicorn);
			}
			if (System.currentTimeMillis() - start_time > 60000) {
				God god = new God(250, 70);
				RenderableHolder_Logic.getInstance().add(god);
			}
			if (System.currentTimeMillis() - start_time > 120000) {

				Dragon dragon = new Dragon(400, 70);
				RenderableHolder_Logic.getInstance().add(dragon);
			}

		}
	}

	public void update() {
		monsterGen();
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
		for (int i = 1; i < entities.size(); i++) {
			CollidableEntity other = (CollidableEntity) entities.get(i);
			if (player.collideWith(other))
				CollisionUtility.checkCollisionsPlayer(player, other);

			if (entities.get(i) instanceof Bullet && !(entities.get(i) instanceof Fireball)) {
				Bullet bullet = (Bullet) entities.get(i);
				for (int j = 1; j < entities.size(); j++) {
					CollidableEntity other1 = (CollidableEntity) entities.get(j);
					if (bullet.collideWith(other1))
						CollisionUtility.checkCollisionsBullet(bullet, other1);
				}
			} else if (entities.get(i) instanceof Fireball) {
				Fireball fireball = (Fireball) entities.get(i);
				if (player.collideWith(fireball))
					CollisionUtility.checkCollisionsFireBall(fireball, player);

			}
		}
		// System.out.println(entities.get(0).getClass()) ; // field
		// System.out.println(entities.get(1).getClass()) ; //Player don't be repeat

		for (int i = 0; i < entities.size(); i++) {
			IRenderable entity = entities.get(i);
			if (entity instanceof Player)
				((Player) entity).update();
			if (entity instanceof Bullet)
				((Bullet) entity).update();
			if (entity instanceof Monster)
				((Monster) entity).update();
		}

	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	public void clearList() {
		this.entities = null;
		this.entities = new ArrayList<>();
		this.GenRate = 0;
	}
}