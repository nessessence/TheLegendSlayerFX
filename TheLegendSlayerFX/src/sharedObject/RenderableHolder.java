package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import logic.Bullet; 
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;
import logic.Mine;
import logic.Monster;
import logic.Player;
import logic.Tank;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public static Image castlePlayerSprite;
	public static Image pondSprite;
	public static Image tree1Sprite; 
	public static Image deadTreeSprite; 
	public static Image barbewireSprite;
	public static Image cannonSprite;
	public static AudioClip  explosionSound;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
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
		for(IRenderable x: entities){
			if(x instanceof Player) System.out.println("player");
			if(x instanceof Field) System.out.println("field");
			
		}
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
		for (int i = 0; i <  entities.size(); i++) {
            IRenderable entity = entities.get(i);
            if(entity instanceof Player) ((Player)entity).update();
            if(entity instanceof Bullet) ((Bullet)entity).update();
            if(entity instanceof Monster) ((Monster)entity).update();
        }
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
