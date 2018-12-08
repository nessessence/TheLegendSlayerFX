package logic;


import obstruct.*;
 
public class CollisionUtility {
    public static void checkCollisionsBullet(Bullet bullet, Entity other){ 
        if(other instanceof Monster){
            ((Monster)other).takeDamage();
            bullet.destroyed = true;
        }
    }
//  public static boolean checkCollisionMonster(Monster monster, Entity other){
//      if(other instanceof Metal || other instanceof Pond){
//          return true;
//      }
//     
//      return false;
//  }
    public static void checkCollisionsPlayer(Player player, CollidableEntity other){
   
        if(other instanceof Monster){
            System.out.println("Hitttttttt!!!!");
            player.isHit();
        }
//      } else if(other instanceof Metal || other instanceof Pond){
//          return true;
//      }
    }
    public static boolean checkCollisionsMetal(Obstacle obstacle, CollidableEntity other){
        if(other instanceof Player || other instanceof Monster || other instanceof Bullet) {
        	if(other instanceof Bullet) ((Bullet)other).destroyed = true;
        	return true;
        }
        return false;  
    }
 
    public static boolean checkCollisionsPond(Obstacle obstacle, CollidableEntity other){
        if(other instanceof Player || other instanceof Monster) return true;
        return false;  
    }
    public static boolean checkCollisionsObstacle(Obstacle obstacle, CollidableEntity other){
        if(obstacle instanceof Metal) return checkCollisionsMetal(obstacle,other);
        if(obstacle instanceof Pond) return checkCollisionsPond(obstacle,other);
        return false;
    }
}