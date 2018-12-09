package obstruct ;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Metal extends Obstacle {
	
	public Metal(double x, double y,String img){
		super(x,y);
		setImage(img);
		
	}
	@Override
	public void setImage(String img){
		this.pic = new Image(ClassLoader.getSystemResource(img).toString());
	}
	
	
}