package me.lpmg.sakura.gamestate;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.lpmg.sakura.GamePanel;
import me.lpmg.sakura.misc.Util;

public class MenuState extends GameState {
	
	String[] options = { "Start", "Help", "Quit" };
	private int currentSelection = 0;

	Image bg = Util.loadImage("menu_background.png");
	Image bgScaled = bg.getScaledInstance(GamePanel.WIDTH, GamePanel.HEIGHT, Image.SCALE_SMOOTH);
	BufferedImage menu_play;
	BufferedImage menu_help;
	BufferedImage menu_quit;
	

	public MenuState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	public void init() {
		try {
			menu_play = ImageIO.read(getClass().getResourceAsStream("/gui/menu_play.png"));
			menu_help = ImageIO.read(getClass().getResourceAsStream("/gui/menu_help.png"));
			menu_quit = ImageIO.read(getClass().getResourceAsStream("/gui/menu_quit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
	}

	public void draw(Graphics g) {
		g.drawImage(bgScaled, 0, 0, GamePanel.WIDTH+10, GamePanel.HEIGHT+10, null);
		if (currentSelection == 0) {
			g.drawImage(menu_play, (GamePanel.WIDTH / 2) - (GamePanel.WIDTH / 4) / 2, GamePanel.HEIGHT / 6,
					GamePanel.WIDTH / 4, menu_play.getHeight() * (GamePanel.WIDTH / 4) / menu_play.getWidth(), null);
		}else if(currentSelection == 1){
			g.drawImage(menu_help, (GamePanel.WIDTH / 2) - (GamePanel.WIDTH / 4) / 2, GamePanel.HEIGHT / 6,
					GamePanel.WIDTH / 4, menu_help.getHeight() * (GamePanel.WIDTH / 4) / menu_help.getWidth(), null);
		}else if(currentSelection == 2){
			g.drawImage(menu_quit, (GamePanel.WIDTH / 2) - (GamePanel.WIDTH / 4) / 2, GamePanel.HEIGHT / 6,
					GamePanel.WIDTH / 4, menu_quit.getHeight() * (GamePanel.WIDTH / 4) / menu_quit.getWidth(), null);
		}

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN) {
			currentSelection++;
			if (currentSelection >= options.length) {
				currentSelection = 0;
			}
		} else if (k == KeyEvent.VK_UP) {
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		} else if (k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) {
				play();
			} else if (currentSelection == 1) {

			} else if (currentSelection == 2) {
				gameStateManager.doExit();
			}
		}
	}
	
	private void play() {
		int currentLevel = gameStateManager.getLevel();
		System.out.println("Level: "+currentLevel);
		if(currentLevel == 1) {
			gameStateManager.states.push(new Level1State(gameStateManager));
		}else {
			gameStateManager.states.push(new Level3State(gameStateManager));
		}
		
	}

	public void keyReleased(int k) {

	}

}
