package obstruct;

import javafx.scene.image.Image;

public class Pond extends Obstacle {
	
	public Pond(double x, double y){
		super(x,y);
		setImage("pond.png");
		this.setWidth(210);
		this.setHeight(200);
		this.radius = 100;
		this.setZ(-888) ;
	}
	@Override
	public void setImage(String img){
		this.pic  = new Image(ClassLoader.getSystemResource(img).toString());
	}
	

}