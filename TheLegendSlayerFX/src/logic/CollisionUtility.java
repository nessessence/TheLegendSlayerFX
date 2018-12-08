package logic;

import javafx.scene.shape.Rectangle;

public class CollisionUtility {
//	public static boolean checkCollisionsBullet(Bullet bullet, Entity other){	
//		if(other instanceof Monster){
//			((Monster)other).isHit(); 
//			bullet.destroyed = true;
//			return true;
//		} else if(other instanceof Metal){
//			bullet.destroyed = true;
//			return true;
//		}
//		return false;
//	}
//	public static boolean checkCollisionMonster(Monster monster, Entity other){
//		if(other instanceof Metal || other instanceof Pond){
//			return true;
//		}
//		
//		return false;
//	}
	public static void checkCollisionsPlayer(Player player, CollidableEntity other){
	
		if(other instanceof Monster){
			System.out.println("Hitttttttt!!!!");
			player.isHit();
		}
//		} else if(other instanceof Metal || other instanceof Pond){
//			return true;
//		}
	}
}