package logic;

public abstract class CollidableEntity extends Entity{
	protected int radius;
	
	public boolean collideWith(CollidableEntity other){
		//System.out.println(Math.hypot(this.x-other.x, this.y-other.y)+","+(this.radius+other.radius));
		
		return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
	}
}
