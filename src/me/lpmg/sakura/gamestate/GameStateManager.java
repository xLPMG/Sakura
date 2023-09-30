package me.lpmg.sakura.gamestate;

import java.awt.Graphics;
import java.util.Stack;

import me.lpmg.sakura.misc.DataHandler;

public class GameStateManager {

	public Stack<GameState> states;
	private DataHandler dataHandler;
	private int currentLevel=1;
	private int kills=0;
	private boolean exit = false;
	
	public GameStateManager(DataHandler dataHandler) {
		states = new Stack<GameState>();
		states.push(new MenuState(this));
		this.dataHandler = dataHandler;
		if(dataHandler.getData().get("level")!=null) currentLevel = Integer.parseInt(dataHandler.getData().get("level"));
		if(dataHandler.getData().get("kills")!=null) kills = Integer.parseInt(dataHandler.getData().get("kills"));
	}

	public void tick() {
		states.peek().tick();
	}

	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	
	public void doExit() {
		exit=true;
	}

	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}

	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}
	
	public void nextLevel() {
		currentLevel++;
		dataHandler.getData().put("level", currentLevel+"");
	};
	
	public int getLevel() {
		if(dataHandler.getData().get("level")!=null) currentLevel = Integer.parseInt(dataHandler.getData().get("level"));
		return currentLevel;
	};
	
	public void addKill() {
		kills++;
		dataHandler.getData().put("kills", kills+"");
	};
	public void addKills(int kills) {
		this.kills+=kills;
		dataHandler.getData().put("kills", this.kills+"");
	};
	
	public int getKills() {
		if(dataHandler.getData().get("kills")!=null) kills = Integer.parseInt(dataHandler.getData().get("kills"));
		return kills;
	};
	
	public boolean getExit() {
		return exit;
	}
}
