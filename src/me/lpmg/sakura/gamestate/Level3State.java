package me.lpmg.sakura.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import me.lpmg.sakura.entities.EntityManager;
import me.lpmg.sakura.entities.Monster1;
import me.lpmg.sakura.entities.Player;
import me.lpmg.sakura.gfx.GameCamera;
import me.lpmg.sakura.mapping.Map;
import me.lpmg.sakura.objects.Block;
import me.lpmg.sakura.resources.Images;

public class Level3State extends GameState {

	private Player player;
	private EntityManager eM;
	private Map map1,map2,map3,map4;
	private GameCamera gC;
	private Rectangle portal;

	public Level3State(GameStateManager gameStateManager) {
		super(gameStateManager);
	}

	public void init() {
		eM = new EntityManager();
		
		player = new Player(19*3, 29*3, 128, 256);
		map1 = new Map("/maps/map3-1.map");
		map2 = new Map("/maps/map3-2.map");
		map3 = new Map("/maps/map3-3.map");
		map4 = new Map("/maps/map3-4.map");
		gC = new GameCamera(player, map1);
		
		portal=new Rectangle(4423+32, 1321,  1*Block.blockSize-20, 2*Block.blockSize);
		
		eM.addEntity(player);
		eM.setPlayer(player);
		
		eM.addEntity(new Monster1(22*3, 20*3, 810, 1257));
		eM.addEntity(new Monster1(22*3, 20*3, 2300, 1321));
		eM.addEntity(new Monster1(22*3, 20*3, 2800, 1321));
		eM.addEntity(new Monster1(22*3, 20*3, 4722, 907));
		eM.addEntity(new Monster1(22*3, 20*3, 5285, 873));
		
		player.setLevel(3);
	}

	public void tick() {
		if(player!=null) {	
		gC.tick();
		if(!eM.playerAlive()) {
			gameStateManager.states.pop();
			gameStateManager.states.push(new LostState(gameStateManager));
		}
		if(player.getEntityRect().intersects(portal)) {
			levelDone();
		}
		}
		eM.tick(map1.getBlocks(),map2.getBlocks());
	}

	public void draw(Graphics g) {
		drawBackground(g);
		map1.draw(g);
		map2.draw(g);
		eM.draw(g, xOffset, yOffset);
		map3.draw(g);
		map4.draw(g);
		eM.drawEntityGUI(g, xOffset, yOffset);
		g.setColor(Color.red);
		if(portal!=null) {
		g.drawRect((int)(portal.x-xOffset),(int)(portal.y-yOffset),portal.width,portal.height);
//		g.drawRect((int)(player.getPlayerRect().x-xOffset),(int)(player.getPlayerRect().y-yOffset),player.getPlayerRect().width,player.getPlayerRect().height);
		}
	}

	private void drawBackground(Graphics g) {
		g.drawImage(Images.background_underground, (int)((0)),(int)(0),(int)(1024*2),(int)(640*2),null);		
	}
	
	private void levelDone() {
		eM.removeEntity(player);
		player=null;
		gameStateManager.addKills(eM.getDeaths());
		//portal animation
		for (int i = 0; i < map1.getBlocks().length; i++) {
			for (int j = 0; j < map1.getBlocks()[0].length; j++) {
				if(map1.getBlocks()[i][j].getID()==500) {
					map1.getBlocks()[i][j].setID(600);
				}
			}
		}
		//close level after 1 sec
		new java.util.Timer().schedule(
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	gameStateManager.states.pop();
		    			gameStateManager.states.push(new WonState(gameStateManager));	
		            }
		        },
		        1000
		);
	}
	
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ESCAPE) {
			gameStateManager.states.pop();
		}
		if(player!=null) {
		player.keyPressed(k);
		}
	}

	public void keyReleased(int k) {
		if(player!=null) {
		player.keyReleased(k);
		}
	}

}
