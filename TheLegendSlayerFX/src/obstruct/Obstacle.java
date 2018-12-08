package obstruct;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.CollidableEntity;
import sharedObject.IRenderable;

public abstract class Obstacle extends CollidableEntity{
	protected Image pic;
	public Obstacle(double x,double y){
		this.setX(x);
		this.setY(y);
		
	}
	public abstract void setImage(Image img);
	
	@Override 
	public void draw(GraphicsContext gc){
		gc.drawImage(pic,this.getX(),this.getY());
	}


}