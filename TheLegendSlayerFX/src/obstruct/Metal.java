package obstruct ;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Metal extends Obstacle {
	
	public Metal(double x, double y,Image img){
		super(x,y);
		setImage(img);
		
	}
	@Override
	public void setImage(Image img){
		this.pic = img;
	}
	
	
}