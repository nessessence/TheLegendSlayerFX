package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import logic.Bullet; 
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;
import logic.God;
import logic.Monster;
import logic.Player;
import logic.Slime;
import logic.Unicorn;
import logic.Zombie;
import logic.CollidableEntity;
import logic.CollisionUtility;
import logic.Entity;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	public static long time = 0 ;
	public static long start_time ;
	public static int GenRate ;
	public static Player player ;
	public static Field field ;
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

	public static Field getField() {
		return RenderableHolder.field;
	}

	public static void setField(Field field) {
		RenderableHolder.field = field;
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
		time = System.currentTimeMillis() ;
		start_time = System.currentTimeMillis() ;
		GenRate = 0 ;
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
	     RenderableHolder.player = player;
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
//		for(IRenderable x: entities){
//			if(x instanceof Player) System.out.println("player");
//			if(x instanceof Field) System.out.println("field");
//			
//		}
	}
	public void monsterGen() {
		if(System.currentTimeMillis() - time > 10000 - GenRate ) {
			GenRate += 10 ;
			System.out.println("Monster generated !!,GenRate:"+GenRate);
			time = System.currentTimeMillis() ;
            Zombie zombie = new Zombie(300,300);
            
            //Slime slime = new Slime(600,400) ;
            //RenderableHolder.getInstance().add(slime) ;
            RenderableHolder.getInstance().add(zombie);
            if(System.currentTimeMillis() - start_time > 30000) {
            	Unicorn unicorn = new Unicorn(70, 70);
            	RenderableHolder.getInstance().add(unicorn);
            }
            if(System.currentTimeMillis() - start_time >60000) {
                God god = new God(200,200) ;
                RenderableHolder.getInstance().add(god);
            }
            if(System.currentTimeMillis() - start_time >120000) {
            	// dragon 
                God god = new God(200,200) ;
                RenderableHolder.getInstance().add(god);
            }
//            
 
            
            }
		}
	

	public void update() {
		monsterGen() ;
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
		for(int i = 1 ; i < entities.size() ; i++) {  
			if( ! (entities.get(i) instanceof Player && entities.get(i) instanceof CollidableEntity) ) {
				CollidableEntity other = (CollidableEntity) entities.get(i) ;
				if( player.collideWith( other )) CollisionUtility.checkCollisionsPlayer(player , other) ;
			}
		}
		//System.out.println(entities.get(0).getClass()) ; // field
		//System.out.println(entities.get(1).getClass()) ; //Player  don't be repeat 
		
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

