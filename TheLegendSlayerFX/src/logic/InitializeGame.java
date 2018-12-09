package logic;

import java.util.ArrayList;
import java.util.List;

import obstruct.*;
import sharedObject.RenderableHolder_Logic;

public class InitializeGame {
	private List<Entity> gameObjectContainer;
	private Player player;

	public InitializeGame() {
		this.gameObjectContainer = new ArrayList<Entity>();
		System.out.println("new field");
		Field field = new Field();
		System.out.println("new field completed");
		RenderableHolder_Logic.getInstance().add(field);
		player = new Player(200, 500);
		Antena antena = new Antena(50, 100);
		Pond pond = new Pond(450, 200);
		Cannon cannon1 = new Cannon(150, 0);
		Cannon cannon2 = new Cannon(150, 250);
		Castle castle = new Castle(50, 400);
		EnemyCastle ecastle = new EnemyCastle(600, 0);
		Barbewire bar1 = new Barbewire(25, 350);
		Barbewire bar2 = new Barbewire(115, 350);
		Barbewire bar3 = new Barbewire(205, 350);
		bar3.setRadius(10);
		Barbewire bar4 = new Barbewire(295, 515);
		bar4.setRadius(10);
		Barbewire bar5 = new Barbewire(295, 435);
		bar5.setRadius(10);
		Slime slime1 = new Slime(400, 70);
		Slime slime2 = new Slime(300, 80);
		RenderableHolder_Logic.getInstance().add(slime1);
		RenderableHolder_Logic.getInstance().add(slime2);

		RenderableHolder_Logic.getObstacles().add(antena);
		RenderableHolder_Logic.getInstance().add(antena);
		RenderableHolder_Logic.getObstacles().add(pond);
		RenderableHolder_Logic.getInstance().add(pond);
		RenderableHolder_Logic.getObstacles().add(cannon1);
		RenderableHolder_Logic.getInstance().add(cannon1);
		RenderableHolder_Logic.getObstacles().add(cannon2);
		RenderableHolder_Logic.getInstance().add(cannon2);
		RenderableHolder_Logic.getObstacles().add(castle);
		RenderableHolder_Logic.getInstance().add(castle);
		RenderableHolder_Logic.getObstacles().add(ecastle);
		RenderableHolder_Logic.getInstance().add(ecastle);
		RenderableHolder_Logic.getObstacles().add(bar1);
		RenderableHolder_Logic.getInstance().add(bar1);
		RenderableHolder_Logic.getObstacles().add(bar2);
		RenderableHolder_Logic.getInstance().add(bar2);
		RenderableHolder_Logic.getObstacles().add(bar3);
		RenderableHolder_Logic.getInstance().add(bar3);
		RenderableHolder_Logic.getObstacles().add(bar4);
		RenderableHolder_Logic.getInstance().add(bar4);
		RenderableHolder_Logic.getObstacles().add(bar5);
		RenderableHolder_Logic.getInstance().add(bar5);
		addNewObject(player);

	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder_Logic.getInstance().add(entity);
	}

	public void logicUpdate() {
		player.update();

//		
//	
	}
}