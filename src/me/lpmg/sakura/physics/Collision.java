package me.lpmg.sakura.physics;

import java.awt.Point;

import me.lpmg.sakura.entities.Entity;
import me.lpmg.sakura.entities.EntityManager;
import me.lpmg.sakura.objects.Block;

public class Collision {
	
	public static boolean playerBlock(Point p, Block b, EntityManager eM) {
		if(b.getCollisionBounds().contains(p)) {
			return true;
		}
		for(Entity e : eM.getEntities()) {
			if(e.getEntityRect().contains(p)) {
				return true;
			}
		}
		return false;
	}
	
//	public static boolean entityBlock(Rectangle playerRect, EntityManager eM) {
//		for(Entity e : eM.getEntities()) {
//			if(playerRect.intersects(e.getEntityRect())) {
//				return true;
//			}
//		}
//		return false;
//	}

}
