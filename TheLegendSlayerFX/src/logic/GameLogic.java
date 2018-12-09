package logic;

import java.util.ArrayList;
import java.util.List;


import obstruct.*;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private Player player;


	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
		System.out.println("new field");
		Field field = new Field();
		System.out.println("new field completed");
		RenderableHolder.getInstance().add(field);
		player = new Player(200,500);
		Antena antena = new Antena(50,100);
		Pond pond = new Pond(450,200);
		Cannon cannon1 = new Cannon(150,0);
		Cannon cannon2 = new Cannon(150,250);
		Castle castle = new Castle(50,400);
		EnemyCastle ecastle = new EnemyCastle(600,0);
		Barbewire bar1 = new Barbewire(25,350);
		Barbewire bar2 = new Barbewire(115,350);
		Barbewire bar3 = new Barbewire(205,350);
//		Barbewire bar4 = new Barbewire(295,350);
		Barbewire bar5 = new Barbewire(295,515);
		bar5.setRadius(15);
		Barbewire bar6 = new Barbewire(295,435);
		bar6.setRadius(15);
		
		RenderableHolder   .getObstacles().add(antena) ;
		RenderableHolder.getInstance().add(antena);
		RenderableHolder.getObstacles().add(pond) ;
		RenderableHolder.getInstance().add(pond);
		RenderableHolder.getObstacles().add(cannon1) ;
		RenderableHolder.getInstance().add(cannon1);
		RenderableHolder.getObstacles().add(cannon2) ;
		RenderableHolder.getInstance().add(cannon2);
		RenderableHolder.getObstacles().add(castle) ;
		RenderableHolder.getInstance().add(castle);
		RenderableHolder.getObstacles().add(ecastle) ;
		RenderableHolder.getInstance().add(ecastle);
		RenderableHolder.getObstacles().add(bar1) ;
		RenderableHolder.getInstance().add(bar1);
		RenderableHolder.getObstacles().add(bar2) ;
		RenderableHolder.getInstance().add(bar2);
		RenderableHolder.getObstacles().add(bar3) ;
		RenderableHolder.getInstance().add(bar3);
//		RenderableHolder.getObstacles().add(bar4) ;
//		RenderableHolder.getInstance().add(bar4);
		RenderableHolder.getObstacles().add(bar5) ;
		RenderableHolder.getInstance().add(bar5);
		RenderableHolder.getObstacles().add(bar6) ;
		RenderableHolder.getInstance().add(bar6);
		addNewObject(player);
		
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		player.update();
		
//		
//	
	}
}