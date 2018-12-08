package obstruct;

import javafx.scene.image.Image;

public class EnemyCastle extends Metal{
	public EnemyCastle(double x, double y){
		super(x,y,new Image("enemycastle.png"));
		this.setWidth(150);
		this.setHeight(179);
		this.radius = 75;
	}
}