package me.lpmg.sakura.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import me.lpmg.sakura.objects.Block;

public class EntityManager {
	
	private CopyOnWriteArrayList<Entity> entities;
	private Entity player = null;
	private int deaths = 0;

	public EntityManager() {
		entities = new CopyOnWriteArrayList<>();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
		e.setEntityManager(this);
	}
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public boolean playerAlive() {
		for(Entity e : entities) {
			if(e.equals(player)) return true;
		}
		return false;
	}
	
	public CopyOnWriteArrayList<Entity> getEntities(){
		return entities;
	}
	
	public void tick(Block[][] blocks, Block[][] blocks2) {
		for(Entity e : entities) {
			e.tick(blocks, blocks2);
		}
	}
	
	public void draw(Graphics g, double xOffset, double yOffset) {
		for(Entity e : entities) {
			e.draw(g);
//			g.setColor(Color.RED);
//			g.drawRect((int)(e.getEntityRect().x-xOffset),(int)(e.getEntityRect().y-yOffset),e.getEntityRect().width,e.getEntityRect().height);
		}
	}
	
	public void drawEntityGUI(Graphics g, double xOffset, double yOffset) {
		for(Entity e : entities) {
			e.drawEntityGUI(g);
		}
	}
	
	public void setPlayer(Entity player) {
		this.player=player;
	}
	
	public int getDeaths() {
		return deaths;
	}

	public void addDeath() {
		deaths++;
	}

}
