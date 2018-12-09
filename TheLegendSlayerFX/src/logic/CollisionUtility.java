package logic;

import obstruct.*;

public class CollisionUtility {
	public static void checkCollisionsBullet(Bullet bullet, Entity other) {
		if (other instanceof Monster && !(bullet instanceof Fireball)) {
			((Monster) other).takeDamage();
			bullet.destroyed = true;
		}
	}

	public static void checkCollisionsFireBall(Fireball fireball, Player player) {
		if (player instanceof Player) {
			player.isHit();
			fireball.destroyed = true;
		}
	}

	public static void checkCollisionsPlayer(Player player, CollidableEntity other) {
		if (other instanceof Monster) {
			System.out.println("Hitttttttt!!!!");
			player.isHit();
		}
	}

	public static boolean checkCollisionsMetal(Obstacle obstacle, CollidableEntity other) {
		if (other instanceof Player || other instanceof Monster || other instanceof Bullet) {
			if (other instanceof Bullet)
				((Bullet) other).destroyed = true;
			return true;
		}
		return false;
	}

	public static boolean checkCollisionsPond(Obstacle obstacle, CollidableEntity other) {
		if (other instanceof Player || other instanceof Monster)
			return true;
		return false;
	}

	public static boolean checkCollisionsObstacle(Obstacle obstacle, CollidableEntity other) {
		if (obstacle instanceof Metal)
			return checkCollisionsMetal(obstacle, other);
		if (obstacle instanceof Pond)
			return checkCollisionsPond(obstacle, other);
		return false;
	}
}