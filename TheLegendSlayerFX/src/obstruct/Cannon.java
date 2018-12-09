package obstruct;

import javafx.scene.image.Image;

public class Cannon extends Metal{
	public Cannon(double x, double y){
		super(x,y,"cannon.png");
		this.setWidth(100);
		this.setHeight(100);
		this.radius = 40;
	}
}