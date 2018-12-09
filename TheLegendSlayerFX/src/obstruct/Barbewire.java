package obstruct;

import javafx.scene.image.Image;

public class Barbewire extends Metal{
	public Barbewire(double x, double y){
		super(x,y,"barbewire.png");
		this.setWidth(86);
		this.setHeight(50);
		this.radius = 35;
	}
}