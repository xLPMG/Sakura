package me.lpmg.sakura.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.lpmg.sakura.objects.Block;

public interface Entity {

	public void tick(Block[][] blocks, Block[][] blocks2);

	public void draw(Graphics g);
	
	public void drawEntityGUI(Graphics g);

	public int getWidth();

	public int getHeight();
	
	public double getX();
	
	public void setX(double x);
	
	public double getY();
	
	public void setY(double y);

	public Rectangle getEntityRect();

	public void setEntityManager(EntityManager eM);

	public void dealDamage(int damage);

	public int getHealth();

	public void setHealth(int health);
}
