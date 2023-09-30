package me.lpmg.sakura.gamestate;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.lpmg.sakura.mapping.Map;

public abstract class GameState {
	
	protected GameStateManager gameStateManager;
	
	public static double xOffset; 
	public static double yOffset; 
	
	public GameState(GameStateManager gameStateManager) {
		this.gameStateManager=gameStateManager;
		
		xOffset=0;
		yOffset=0;
		
		init();
	}

	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
