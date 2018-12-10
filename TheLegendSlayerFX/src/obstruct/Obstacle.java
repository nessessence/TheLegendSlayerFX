package obstruct;
import exception.LimitedMapException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.CollidableEntity;
import sharedObject.IRenderable;

public class Obstacle extends CollidableEntity{
	protected Image pic;
	public Obstacle(double x,double y){
		try {
			this.setX(x);
			this.setY(y);
		} catch (LimitedMapException e) {
			e.printStackTrace();
		}
	}
	public  void setImage(String img ) {
		this.pic = new Image(ClassLoader.getSystemResource(img).toString());
	}
	@Override 
	public void draw(GraphicsContext gc){
		gc.drawImage(pic,this.getX(),this.getY());
	}
     

}