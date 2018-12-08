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
 
public class RenderableHolder {
    private static final RenderableHolder instance = new RenderableHolder();
    private static ArrayList<Obstacle> obstacles;
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
  
    public static ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}


	public static void setObstacles(ArrayList<Obstacle> obstacles) {
		RenderableHolder.obstacles = obstacles;
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
        obstacles = new ArrayList<Obstacle>();
    }
 
    public static RenderableHolder getInstance() {
        return instance;
    }
 
    public static Player getPlayer() {
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
//      for(IRenderable x: entities){
//          if(x instanceof Player) System.out.println("player");
//          if(x instanceof Field) System.out.println("field");
//         
//      }
    }
    public void monsterGen() {
        if(System.currentTimeMillis() - time > 10000 - GenRate ) {
            GenRate += 10 ;
            System.out.println("Monster generated !!,GenRate:"+GenRate);
            time = System.currentTimeMillis() ;
            Slime slime1 = new Slime(550, 70);
            Slime slime2 = new Slime(550, 80);
            Zombie zombie = new Zombie(550, 90);
            RenderableHolder.getInstance().add(slime1);
            RenderableHolder.getInstance().add(slime2);
            RenderableHolder.getInstance().add(zombie);
            if(System.currentTimeMillis() - start_time > 30000) {
                Unicorn unicorn = new Unicorn(550, 70);
                RenderableHolder.getInstance().add(unicorn);
            }
            if(System.currentTimeMillis() - start_time >60000) {
                God god = new God(550, 70) ;
                RenderableHolder.getInstance().add(god);
            }
            if(System.currentTimeMillis() - start_time >120000) {
                // dragon
                Dragon dragon = new Dragon(550, 70) ;
                RenderableHolder.getInstance().add(dragon);
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
                CollidableEntity other = (CollidableEntity) entities.get(i) ;
                if( player.collideWith( other )) CollisionUtility.checkCollisionsPlayer(player , other) ;
            
            if( entities.get(i) instanceof Bullet){
                Bullet bullet = (Bullet)entities.get(i);
                for(int j = 1 ; j < entities.size() ; j++){
                    CollidableEntity other1 = (CollidableEntity)entities.get(j);
                    if(bullet.collideWith(other1)) CollisionUtility.checkCollisionsBullet(bullet, other1);
                }
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
    public void clearList() {
    	this.entities = null;
    	this.entities = new ArrayList<>();
    }
}