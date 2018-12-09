package obstruct;

import javafx.scene.image.Image;

public class Castle extends Metal{
	public Castle(double x, double y){
		super(x,y,"castle.gif");
		this.setWidth(150);
		this.setHeight(152);
		this.radius = 75;
	}
}