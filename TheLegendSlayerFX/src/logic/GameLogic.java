package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private Player player;
	private Mine mine;

	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
	
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new Player(320,240);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		player.update();
		if(!mine.isDestroyed() && player.collideWith(mine)){
			mine.onCollision(player);
		}
	}
}
