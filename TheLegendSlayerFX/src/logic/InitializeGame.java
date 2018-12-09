package logic;

import java.util.ArrayList;
import java.util.List;

import obstruct.*;
import sharedObject.RenderableHolder;

public class InitializeGame {
	private List<Entity> gameObjectContainer;
	private Player player;

	public InitializeGame() {
		this.gameObjectContainer = new ArrayList<Entity>();
		System.out.println("new field");
		Field field = new Field();
		System.out.println("new field completed");
		RenderableHolder.getInstance().add(field);
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
		bar3.setRadius(20);
		Barbewire bar4 = new Barbewire(295, 515);
		bar4.setRadius(15);
		Barbewire bar5 = new Barbewire(295, 435);
		bar5.setRadius(15);
		Slime slime1 = new Slime(400, 70);
		Slime slime2 = new Slime(300, 80);
		Zombie zombie = new Zombie(550, 90);
		RenderableHolder.getInstance().add(slime1);
		RenderableHolder.getInstance().add(slime2);

		RenderableHolder.getObstacles().add(antena);
		RenderableHolder.getInstance().add(antena);
		RenderableHolder.getObstacles().add(pond);
		RenderableHolder.getInstance().add(pond);
		RenderableHolder.getObstacles().add(cannon1);
		RenderableHolder.getInstance().add(cannon1);
		RenderableHolder.getObstacles().add(cannon2);
		RenderableHolder.getInstance().add(cannon2);
		RenderableHolder.getObstacles().add(castle);
		RenderableHolder.getInstance().add(castle);
		RenderableHolder.getObstacles().add(ecastle);
		RenderableHolder.getInstance().add(ecastle);
		RenderableHolder.getObstacles().add(bar1);
		RenderableHolder.getInstance().add(bar1);
		RenderableHolder.getObstacles().add(bar2);
		RenderableHolder.getInstance().add(bar2);
		RenderableHolder.getObstacles().add(bar3);
		RenderableHolder.getInstance().add(bar3);
		RenderableHolder.getObstacles().add(bar4);
		RenderableHolder.getInstance().add(bar4);
		RenderableHolder.getObstacles().add(bar5);
		RenderableHolder.getInstance().add(bar5);
		addNewObject(player);

	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate() {
		player.update();

//		
//	
	}
}