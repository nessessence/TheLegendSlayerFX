package obstruct;

import javafx.scene.image.Image;

public class  Antena extends Metal{
	public Antena(double x, double y){
		super(x,y,"antena.png");
		this.setWidth(100);
		this.setHeight(135);
		this.radius = 45;
	}
}